package org.artezio.lesson1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class ChromeTest extends BaseTest {

    private static final String ONLINER_BY = "https://www.onliner.by/";
    private static final String HELLO_WORLD = "Hello motherfucker";

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
        navigate(ONLINER_BY);
        WebElement searchInput = getDriver().findElement(By.cssSelector("div.g-top-i input.fast-search__input"));
        System.out.println(searchInput.getText());
    }

    @Test
    public void onlinerLogoTest() {
        navigate(ONLINER_BY);
        WebElement header = getWait().until(webDriver -> webDriver.findElement(By.cssSelector("div.b-top-actions div.g-top-i")));
        WebElement logo = header.findElement(By.className("b-top-logo"));
        Assert.assertNotNull(logo);
    }

    @Test
    public void onlinerButtonTest() {
        navigate(ONLINER_BY);
        WebElement button = getDriver().findElement(By.cssSelector("div#userbar .auth-bar__item--text"));
        assertString("Вход", button.getAttribute("textContent"));
    }

    @Test
    public void onlinerInputTextTest() {
        navigate(ONLINER_BY);
        WebElement searchString = getWait().until(webDriver -> webDriver.findElement(By.cssSelector("div.g-top-i input.fast-search__input")));
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchString.sendKeys(HELLO_WORLD);
        assertString(HELLO_WORLD, searchString.getAttribute("value"));
    }

}
