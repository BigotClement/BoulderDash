/*
 *
 */
package view;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class ViewTest.
 */
public class ViewTest {

    /** The view. */
    private View view;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        this.view = new View(null);
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
     * Test set controller.
     */
    @Test
    public void testSetController() {
        this.view.setController(null);
        assertNull(this.view.getController());
    }

    /**
     * Test view.
     */
    @Test
    public void testView() {
        assertNotNull(this.view);
    }

    /**
     * Test get view frame.
     */
    @Test
    public void testGetViewFrame() {
        assertNull(this.view.getController());
    }

}
