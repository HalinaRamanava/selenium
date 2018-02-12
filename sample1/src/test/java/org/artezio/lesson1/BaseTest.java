package org.artezio.lesson1;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

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
        wait = new WebDriverWait(driver, 5);
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

    protected WebDriverWait getWait() {
        return wait;
    }

    public void navigate(String url) {
        driver.navigate().to(url);
    }
}
