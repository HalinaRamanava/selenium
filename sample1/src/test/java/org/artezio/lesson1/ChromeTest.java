package org.artezio.lesson1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeTest extends BaseTest {

    @Before
    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("chromeOptions", chromeOptions);
        super.init("chrome", desiredCapabilities);
    }

    @Test
    public void openBrowserTest() {
        navigate("http://www.google.com");
    }

    @Test
    public void onlinerSearchStringTest() {
        navigate("https://www.onliner.by/");
        WebElement searchInput = getDriver().findElement(By.cssSelector("div.g-top-i input.fast-search__input"));
        System.out.println(searchInput.getText());
    }

    @Test
    public void onlinerLogoTest() {
        navigate("https://www.onliner.by/");
        WebElement header = getWait().until(webDriver -> webDriver.findElement(By.cssSelector("div.b-top-actions div.g-top-i")));
        WebElement logo = header.findElement(By.className("b-top-logo"));
        Assert.assertNotNull(logo);
    }

}
