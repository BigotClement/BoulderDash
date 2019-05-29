/*
 *
 */
package controller;

import static org.junit.Assert.assertNotNull;

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

}
