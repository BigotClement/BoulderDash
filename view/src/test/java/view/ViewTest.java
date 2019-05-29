/*
 *
 */
package view;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ViewTest {

    private View view;

    @Before
    public void setUp() throws Exception {
        this.view = new View(null);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSetController() {
        this.view.setController(null);
        assertNull(this.view.getController());
    }

    @Test
    public void testView() {
        assertNotNull(this.view);
    }

    @Test
    public void testGetViewFrame() {
        assertNull(this.view.getController());
    }

}
