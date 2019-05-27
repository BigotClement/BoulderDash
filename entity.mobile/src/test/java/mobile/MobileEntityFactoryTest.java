/*
 *
 */
package mobile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MobileEntityFactoryTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCreateCharacter() {
        assertEquals(Character.class, MobileEntityFactory.createCharacter().getClass());
    }

    @Test
    public void testCreateDiamond() {
        assertEquals(Diamond.class, MobileEntityFactory.createDiamond().getClass());
    }

    @Test
    public void testCreateEnemy() {
        assertEquals(Enemy.class, MobileEntityFactory.createEnemy().getClass());
    }

    @Test
    public void testCreateRock() {
        assertEquals(Rock.class, MobileEntityFactory.createRock().getClass());
    }

    @Test
    public void testCreateEntity() {
        assertEquals(Character.class, MobileEntityFactory.createEntity('H').getClass());
        assertEquals(Diamond.class, MobileEntityFactory.createEntity('D').getClass());
        assertEquals(Enemy.class, MobileEntityFactory.createEntity('X').getClass());
        assertEquals(Rock.class, MobileEntityFactory.createEntity('O').getClass());
    }

}
