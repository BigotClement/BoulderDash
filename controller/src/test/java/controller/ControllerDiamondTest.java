/*
 * 
 */
package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class ControllerDiamondTest.
 */
public class ControllerDiamondTest {

    /** The controller diamond. */
    private ControllerDiamond controllerDiamond;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        this.controllerDiamond = new ControllerDiamond(null, null);
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
     * Test controller diamond.
     */
    @Test
    public void testControllerDiamond() {
        assertNotNull(this.controllerDiamond);
    }

}
