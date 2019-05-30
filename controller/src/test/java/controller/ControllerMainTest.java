/*
 *
 */
package controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import contract.IControllerMain;
import contract.IMap;
import contract.IModel;
import contract.IView;

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
            public void setMapID(int mapID) {
                // TODO Auto-generated method stub

            }

            @Override
            public void setMap(IMap map) {
                // TODO Auto-generated method stub

            }

            @Override
            public int getMapID() {
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public IMap getMap() {
                // TODO Auto-generated method stub
                return null;
            }
        });
        assertNotNull(this.controllerMain.getModel());
    }

    @Test
    public void testGetModel() {
        assertNull(this.controllerMain.getModel());
    }

    @Test
    public void testSetView() {
        this.controllerMain.setView(new IView() {

            @Override
            public void setController(IControllerMain controller) {
                // TODO Auto-generated method stub

            }

        });
        assertNotNull(this.controllerMain.getView());
    }

    @Test
    public void testGetView() {
        assertNull(this.controllerMain.getView());
    }

}
