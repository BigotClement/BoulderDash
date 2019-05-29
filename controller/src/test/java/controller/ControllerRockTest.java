/*
 *
 */
package controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControllerRockTest {

    private ControllerRock controllerRock;

    @Before
    public void setUp() throws Exception {
        this.controllerRock = new ControllerRock(null, null);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testControllerRock() {
        assertNotNull(this.controllerRock);
    }

}
