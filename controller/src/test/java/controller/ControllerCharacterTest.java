/*
 *
 */
package controller;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControllerCharacterTest {

    private ControllerCharacter controllerCharacter;

    @Before
    public void setUp() throws Exception {
        this.controllerCharacter = new ControllerCharacter(null, null);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testControllerCharacter() {
        assertNotNull(this.controllerCharacter);
    }

    @Test
    public void testGetDiamondCount() {
        assertEquals(0, this.controllerCharacter.getDiamondCount());
    }

    @Test
    public void testSetDiamondCount() {
        this.controllerCharacter.setDiamondCount(5);
        assertEquals(5, this.controllerCharacter.getDiamondCount());
    }

    @Test
    public void testCanWin() {
        assertFalse(this.controllerCharacter.canWin());
    }

}
