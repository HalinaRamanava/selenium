package org.artezio.lesson1;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class IETest extends BaseTest {

    @Before
    public void init() throws IOException {
        super.init("ie");
    }

    @Test
    public void browserTest() {
        navigate("https://www.google.com");
    }
}
