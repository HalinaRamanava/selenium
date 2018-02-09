package org.artezio.lesson1;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    private static final String PROP_FILE = "/drivers.properties";

    protected void init(String browserName, DesiredCapabilities desiredCapabilities) {
        try {
            Properties properties = new Properties();
            properties.load(ChromeTest.class.getResourceAsStream(PROP_FILE));
            properties.stringPropertyNames().forEach(propName -> System.setProperty(propName, properties.getProperty(propName)));
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при загрузке системных опций");
        }
        driver = BrowserFactory.createDriver(browserName, desiredCapabilities);
        webDriverWait = new WebDriverWait(driver, 10);
    }

    protected void init(String browserName) {
        this.init(browserName, null);
    }

    @After
    public void finish() {
        driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }

    public void navigate(String url) {
        driver.navigate().to(url);
    }
}
