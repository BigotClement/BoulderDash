/*
 *
 */
package controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
}
