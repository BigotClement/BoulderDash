/*
 *
 */
package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.IEntity;
import mobile.MobileEntityFactory;

public class ControllerTest {
    private Controller controller;

    @Before
    public void setUp() throws Exception {
        this.controller = new Controller(null, null);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testController() {
        assertNotNull(this.controller);
    }

    @Test
    public void testSetView() {
        this.controller.setView(null);
        assertNull(this.controller.getView());
    }

    @Test
    public void testGetView() {
        assertNull(this.controller.getView());
    }

    @Test
    public void testGetModel() {
        assertNull(this.controller.getModel());
    }

    @Test
    public void testCheckMove() {
        assertEquals(false, this.controller.checkMove(MobileEntityFactory.createCharacter(), 1, 0));
    }

    @Test
    public void testMoveDown() {
        IEntity test = MobileEntityFactory.createCharacter();
        this.controller.moveDown(test);
        assertNotNull(MobileEntityFactory.createCharacter().getY());
    }

    @Test
    public void testMoveLeft() {
        IEntity test = MobileEntityFactory.createCharacter();
        this.controller.moveLeft(test);
        assertNotNull(MobileEntityFactory.createCharacter().getX());
    }

    @Test
    public void testMoveRight() {
        IEntity test = MobileEntityFactory.createCharacter();
        this.controller.moveRight(test);
        assertNotNull(MobileEntityFactory.createCharacter().getX());
    }

    @Test
    public void testMoveUp() {
        IEntity test = MobileEntityFactory.createCharacter();
        this.controller.moveUp(test);
        assertNotNull(MobileEntityFactory.createCharacter().getY());
    }

    @Test
    public void testMoveLeftDown() {
        IEntity test = MobileEntityFactory.createCharacter();
        this.controller.moveLeftDown(test);
        assertNotNull(MobileEntityFactory.createCharacter().getY());
        assertNotNull(MobileEntityFactory.createCharacter().getX());
    }

    @Test
    public void testMoveRightDown() {
        IEntity test = MobileEntityFactory.createCharacter();
        this.controller.moveRightDown(test);
        assertNotNull(MobileEntityFactory.createCharacter().getY());
        assertNotNull(MobileEntityFactory.createCharacter().getX());
    }

    @Test
    public void testGetDiamondCount() {
        assertEquals(0, this.controller.getDiamondCount());
    }

    @Test
    public void testGetDiamondLimit() {
        assertEquals(0, this.controller.getDiamondLimit());
    }

    @Test
    public void testSetDiamondLimit() {
        this.controller.setDiamondLimit(5);
        assertEquals(5, this.controller.getDiamondLimit());
    }

}
