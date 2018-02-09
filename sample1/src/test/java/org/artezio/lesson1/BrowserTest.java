package org.artezio.lesson1;

import org.junit.Test;

public class BrowserTest extends AbstractTest {

    @Test
    public void openBrowserTest() {
        navigate("http://www.google.com");
    }

}
