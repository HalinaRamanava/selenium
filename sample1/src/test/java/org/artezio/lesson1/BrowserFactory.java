package org.artezio.lesson1;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

    public static WebDriver createDriver(String browserName, DesiredCapabilities desiredCapabilities) {
        if (StringUtils.isEmpty(browserName)) throw new IllegalArgumentException("Не указано имя браузера!");
        WebDriver webDriver;
        switch (browserName.toLowerCase().trim()) {
            case "chrome":
            case "google chrome": {
                webDriver = new ChromeDriver(desiredCapabilities);
                break;
            }
            case "ie":
            case "internet explorer": {
                webDriver = new InternetExplorerDriver(desiredCapabilities);
                break;
            }
            case "mozilla":
            case "firefox": {
                webDriver = new FirefoxDriver(desiredCapabilities);
                break;
            }
            default: {
                throw new IllegalArgumentException("Указано некорректное имя браузера!");
            }
        }
        return webDriver;
    }
}
