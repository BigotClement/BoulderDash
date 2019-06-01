/*
 * 
 */
package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class ControllerEnemyTest.
 */
public class ControllerEnemyTest {

    /** The controller enemy. */
    private ControllerEnemy controllerEnemy;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        this.controllerEnemy = new ControllerEnemy(null, null);
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
     * Test controller enemy.
     */
    @Test
    public void testControllerEnemy() {
        assertNotNull(this.controllerEnemy);
    }

}
