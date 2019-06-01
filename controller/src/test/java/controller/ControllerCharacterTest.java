/*
 *
 */
package controller;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class ControllerCharacterTest.
 */
public class ControllerCharacterTest {

    /** The controller character. */
    private ControllerCharacter controllerCharacter;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        this.controllerCharacter = new ControllerCharacter(null, null);
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
     * Test controller character.
     */
    @Test
    public void testControllerCharacter() {
        assertNotNull(this.controllerCharacter);
    }

    /**
     * Test get diamond count.
     */
    @Test
    public void testGetDiamondCount() {
        assertEquals(0, this.controllerCharacter.getDiamondCount());
    }

    /**
     * Test set diamond count.
     */
    @Test
    public void testSetDiamondCount() {
        this.controllerCharacter.setDiamondCount(5);
        assertEquals(5, this.controllerCharacter.getDiamondCount());
    }

    /**
     * Test can win.
     */
    @Test
    public void testCanWin() {
        assertFalse(this.controllerCharacter.canWin());
    }

}
