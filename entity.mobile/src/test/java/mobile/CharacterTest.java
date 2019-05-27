/*
 *
 */
package mobile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CharacterTest {
    private Character character = null;

    @Before
    public void setUp() throws Exception {
        this.character = new Character();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCharacter() {
        assertEquals(Character.class, this.character.getClass());
    }
}
