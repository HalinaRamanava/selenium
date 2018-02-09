package org.artezio;

import org.artezio.lesson1.ChromeTest;
import org.artezio.lesson1.FirefoxTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ChromeTest.class,
        FirefoxTest.class
})
public class BrowsersTestSuite {
}
