/*
 *
 */
package controller;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class ControllerRockTest.
 */
public class ControllerRockTest {

    /** The controller rock. */
    private ControllerRock controllerRock;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        this.controllerRock = new ControllerRock(null, null);
    }

    /**
     * Tear down.
     *
     * @throws Exception the exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test controller rock.
     */
    @Test
    public void testControllerRock() {
        assertNotNull(this.controllerRock);
    }

}
