/*
 *
 */
package mobile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MobileTest {

    private Character character = null;
    private Diamond diamond = null;
    private Enemy enemy = null;
    private Rock rock = null;

    @Before
    public void setUp() throws Exception {
        this.character = new Character();
        this.diamond = new Diamond();
        this.enemy = new Enemy();
        this.rock = new Rock();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCharacter() {
        assertEquals(Character.class, this.character.getClass());
    }

    @Test
    public void testDiamond() {
        assertEquals(Diamond.class, this.diamond.getClass());
    }

    @Test
    public void testEnemy() {
        assertEquals(Enemy.class, this.enemy.getClass());
    }

    @Test
    public void testRock() {
        assertEquals(Rock.class, this.rock.getClass());
    }

    @Test
    public void testGetFolder() {
        assertEquals("sprites\\Mobile\\Character\\Stand", this.character.getFolder());
    }

    @Test
    public void testSetFolder() {
        this.character.setFolder("");
        assertEquals("", this.character.getFolder());
    }

    @Test
    public void testSetSprite() {
        this.character.setSprite('e');
        assertEquals('e', this.character.getSprite());
    }

    @Test
    public void testGetSprite() {
        assertEquals('H', this.character.getSprite());
    }

    @Test
    public void testCreateCharacter() {
        assertEquals(this.character.getClass(), MobileEntityFactory.createCharacter().getClass());
    }

    @Test
    public void testCreateDiamond() {
        assertEquals(this.diamond.getClass(), MobileEntityFactory.createDiamond().getClass());
    }

    @Test
    public void testCreateEnemy() {
        assertEquals(this.enemy.getClass(), MobileEntityFactory.createEnemy().getClass());
    }

    @Test
    public void testCreateRock() {
        assertEquals(this.rock.getClass(), MobileEntityFactory.createRock().getClass());
    }

    @Test
    public void testCreateEntity() {
        assertEquals(Character.class, MobileEntityFactory.createEntity('H').getClass());
    }

}
