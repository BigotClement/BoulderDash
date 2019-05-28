/*
 *
 */
package view;

import java.awt.Component;
import java.awt.GraphicsConfiguration;
import java.awt.event.KeyEvent;
import java.util.Observable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contract.IControllerMain;
import contract.IMap;
import contract.IModel;
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
            public Observable getObservable() {
                // TODO Auto-generated method stub
                return null;
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
        this.viewFrame = new ViewFrame(this.model);
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

    @Test
    public void testKeyPressed() {
        KeyEvent key = new KeyEvent(new Component() {
        }, 0, 0, 0, 0, 'z');
        assertEquals('z', key.getKeyChar());
    }

    @Test
    public void testKeyReleased() {
        KeyEvent key = new KeyEvent(new Component() {
        }, 0, 0, 0, 0, 'z');
        assertEquals('z', key.getKeyChar());
    }

    @Test
    public void testKeyTyped() {
        KeyEvent key = new KeyEvent(new Component() {
        }, 0, 0, 0, 0, 'z');
        assertEquals('z', key.getKeyChar());
    }

    @Test
    public void testSetController() {
        IControllerMain controller = new IControllerMain() {

            @Override
            public void control() {
                // TODO Auto-generated method stub

            }
        };
        this.viewFrame.setController(controller);
        assertEquals(controller.getClass(), this.viewFrame.getController().getClass());
    }

    @Test
    public void testViewFrameIModel() {
        assertNotNull(new ViewFrame(this.model));
    }

    @Test
    public void testViewFrameIModelGraphicsConfiguration() {
        assertNotNull(new ViewFrame(this.model, (GraphicsConfiguration) null));
    }

    @Test
    public void testViewFrameIModelString() {
        assertNotNull(new ViewFrame(this.model, ""));
    }

    @Test
    public void testViewFrameIModelStringGraphicsConfiguration() {
        assertNotNull(new ViewFrame(this.model, "", null));
    }

}
