package org.artezio.lesson1;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Properties;

public class AbstractTest {

    private Properties properties = new Properties();
    private WebDriver chromeDriver;
    private WebDriverWait webDriverWait;

    private static final String PROP_FILE = "/drivers.properties";

    @Before
    public void init() throws IOException {
        properties.load(BrowserTest.class.getResourceAsStream(PROP_FILE));
        properties.stringPropertyNames().forEach(propName -> System.setProperty(propName, properties.getProperty(propName)));
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeDriver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(chromeDriver, 10);
    }

    @After
    public void finish() {
        chromeDriver.quit();
        chromeDriver = null;
    }

    public WebDriver getChromeDriver() {
        return chromeDriver;
    }

    public void navigate(String url) {
        chromeDriver.navigate().to(url);
    }
}
