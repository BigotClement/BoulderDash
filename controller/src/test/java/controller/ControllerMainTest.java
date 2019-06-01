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

public class ControllerMainTest {

    private ControllerMain controllerMain;

    @Before
    public void setUp() throws Exception {
        this.controllerMain = new ControllerMain(null, null);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetControllerCharacter() {
        assertNotNull(this.controllerMain.getControllerCharacter());
    }

    @Test
    public void testSetControllerCharacter() {
        this.controllerMain.setControllerCharacter(null);
        assertNull(this.controllerMain.getControllerCharacter());
    }

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

    @Test
    public void testGetModel() {
        assertNull(this.controllerMain.getModel());
    }

    @Test
    public void testGetView() {
        assertNull(this.controllerMain.getView());
    }

    @Test
    public void testControllerMain() {
        assertNotNull(this.controllerMain);
    }

    @Test
    public void testGetControllerRock() {
        assertNotNull(this.controllerMain.getControllerRock());
    }

    @Test
    public void testSetControllerRock() {
        this.controllerMain.setControllerRock(null);
        assertNull(this.controllerMain.getControllerRock());
    }

    @Test
    public void testGetControllerDiamond() {
        assertNotNull(this.controllerMain.getControllerDiamond());
    }

    @Test
    public void testSetControllerDiamond() {
        this.controllerMain.setControllerDiamond(null);
        assertNull(this.controllerMain.getControllerDiamond());
    }

    @Test
    public void testGetControllerEnemy() {
        assertNotNull(this.controllerMain.getControllerEnemy());
    }

    @Test
    public void testSetControllerEnemy() {
        this.controllerMain.setControllerEnemy(null);
        assertNull(this.controllerMain.getControllerEnemy());
    }

    @Test
    public void testGetTimeLeft() {
        assertEquals(120, this.controllerMain.getTimeLeft());
    }

    @Test
    public void testSetTimeLeft() {
        this.controllerMain.setTimeLeft(5);
        assertEquals(5, this.controllerMain.getTimeLeft());
    }

}
