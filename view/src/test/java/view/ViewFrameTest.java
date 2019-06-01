/*
 *
 */
package view;

import java.awt.Component;
import java.awt.event.KeyEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contract.IController;
import contract.IControllerMain;
import contract.IMap;
import contract.IModel;
import contract.IView;
import junit.framework.TestCase;

public class ViewFrameTest extends TestCase {

    private IModel model;
    private ViewFrame viewFrame;

    @Override
    @Before
    public void setUp() throws Exception {
        this.model = new IModel() {

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
        };
        this.viewFrame = new ViewFrame(this.model, "test");
    }

    @Override
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetModel() {
        // fail("Not yet implemented");
        assertEquals(this.model.getClass(), this.viewFrame.getModel().getClass());
    }

    public void testSetModel() {
        // fail("Not yet implemented");
        IModel model = new IModel() {

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

        };

        this.viewFrame.setModel(model);
        assertEquals(model.getClass(), this.viewFrame.getModel().getClass());
    }

    @Test
    public void testKeyPressed() {
        KeyEvent key = new KeyEvent(new Component() {

            /**
             *
             */
            private static final long serialVersionUID = -6634727246253104738L;
        }, 0, 0, 0, 0, 'z');
        assertEquals('z', key.getKeyChar());
    }

    @Test
    public void testKeyReleased() {
        KeyEvent key = new KeyEvent(new Component() {

            /**
             *
             */
            private static final long serialVersionUID = -2862155375209402760L;
        }, 0, 0, 0, 0, 'z');
        assertEquals('z', key.getKeyChar());
    }

    @Test
    public void testKeyTyped() {
        KeyEvent key = new KeyEvent(new Component() {

            /**
             *
             */
            private static final long serialVersionUID = -374023924530956150L;
        }, 0, 0, 0, 0, 'z');
        assertEquals('z', key.getKeyChar());
    }

    @Test
    public void testSetController() {
        IControllerMain controller = new IControllerMain() {

            @Override
            public IController getControllerCharacter() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public IModel getModel() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public IView getView() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public int getTimeLeft() {
                // TODO Auto-generated method stub
                return 0;
            }
        };
        this.viewFrame.setController(controller);
        assertEquals(controller.getClass(), this.viewFrame.getController().getClass());
    }

    @Test
    public void testViewFrameIModelString() {
        assertNotNull(new ViewFrame(this.model, "test"));
    }

    @Test
    public void testGetDiamondCount() {
        assertNotNull(this.viewFrame.getDiamondCount());
    }

    @Test
    public void testSetDiamondCount() {
        this.viewFrame.getDiamondCount();
        assertNotNull(this.viewFrame.getDiamondCount());
    }

}
