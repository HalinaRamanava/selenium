package org.artezio.lesson1;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class FirefoxTest extends BaseTest {
    @Before
    public void init() throws IOException {
        super.init("FIREFOX");
    }

    @Test
    public void browserTest() {
        navigate("https://www.google.com");
    }
}
