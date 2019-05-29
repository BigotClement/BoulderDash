/*
 *
 */
package controller;

import static org.junit.Assert.assertNotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControllerEnemyTest {

    private ControllerEnemy controllerEnemy;

    @Before
    public void setUp() throws Exception {
        this.controllerEnemy = new ControllerEnemy(null, null);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testControllerEnemy() {
        assertNotNull(this.controllerEnemy);
    }

}
