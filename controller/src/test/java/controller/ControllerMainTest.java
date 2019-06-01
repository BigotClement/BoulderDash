/*
 *
 */
package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import contract.IMap;
import contract.IModel;

/**
 * The Class ControllerMainTest.
 */
public class ControllerMainTest {

    /** The controller main. */
    private ControllerMain controllerMain;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        this.controllerMain = new ControllerMain(null, null);
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
     * Test get controller character.
     */
    @Test
    public void testGetControllerCharacter() {
        assertNotNull(this.controllerMain.getControllerCharacter());
    }

    /**
     * Test set controller character.
     */
    @Test
    public void testSetControllerCharacter() {
        this.controllerMain.setControllerCharacter(null);
        assertNull(this.controllerMain.getControllerCharacter());
    }

    /**
     * Test set model.
     */
    @Test
    public void testSetModel() {
        this.controllerMain.setModel(new IModel() {

            @Override
            public int getMapID() {
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public void setMapID(int mapID) {
                // TODO Auto-generated method stub

            }

            @Override
            public IMap getMap() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void setMap(IMap map) {
                // TODO Auto-generated method stub

            }
        });
        assertNotNull(this.controllerMain.getModel());
    }

    /**
     * Test get model.
     */
    @Test
    public void testGetModel() {
        assertNull(this.controllerMain.getModel());
    }

    /**
     * Test get view.
     */
    @Test
    public void testGetView() {
        assertNull(this.controllerMain.getView());
    }

    /**
     * Test controller main.
     */
    @Test
    public void testControllerMain() {
        assertNotNull(this.controllerMain);
    }

    /**
     * Test get controller rock.
     */
    @Test
    public void testGetControllerRock() {
        assertNotNull(this.controllerMain.getControllerRock());
    }

    /**
     * Test set controller rock.
     */
    @Test
    public void testSetControllerRock() {
        this.controllerMain.setControllerRock(null);
        assertNull(this.controllerMain.getControllerRock());
    }

    /**
     * Test get controller diamond.
     */
    @Test
    public void testGetControllerDiamond() {
        assertNotNull(this.controllerMain.getControllerDiamond());
    }

    /**
     * Test set controller diamond.
     */
    @Test
    public void testSetControllerDiamond() {
        this.controllerMain.setControllerDiamond(null);
        assertNull(this.controllerMain.getControllerDiamond());
    }

    /**
     * Test get controller enemy.
     */
    @Test
    public void testGetControllerEnemy() {
        assertNotNull(this.controllerMain.getControllerEnemy());
    }

    /**
     * Test set controller enemy.
     */
    @Test
    public void testSetControllerEnemy() {
        this.controllerMain.setControllerEnemy(null);
        assertNull(this.controllerMain.getControllerEnemy());
    }

    /**
     * Test get time left.
     */
    @Test
    public void testGetTimeLeft() {
        assertEquals(120, this.controllerMain.getTimeLeft());
    }

    /**
     * Test set time left.
     */
    @Test
    public void testSetTimeLeft() {
        this.controllerMain.setTimeLeft(5);
        assertEquals(5, this.controllerMain.getTimeLeft());
    }

}
