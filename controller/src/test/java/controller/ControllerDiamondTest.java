/*
 *
 */
package controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControllerDiamondTest {

    private ControllerDiamond controllerDiamond;

    @Before
    public void setUp() throws Exception {
        this.controllerDiamond = new ControllerDiamond(null, null);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testControllerDiamond() {
        assertNotNull(this.controllerDiamond);
    }

}
