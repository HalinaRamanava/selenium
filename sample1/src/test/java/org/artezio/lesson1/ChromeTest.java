package org.artezio.lesson1;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeTest extends BaseTest {

    @Before
    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("options", chromeOptions);
        super.init("chrome", desiredCapabilities);
    }

    @Test
    public void openBrowserTest() {
        navigate("http://www.google.com");
    }

}
