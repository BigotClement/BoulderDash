/*
 *
 */
package view;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ViewPanelTest {

    private ViewPanel viewPanel;

    @Before
    public void setUp() throws Exception {
        this.viewPanel = new ViewPanel(null);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSetViewFrame() {
        this.viewPanel.setViewFrame(null);
        assertNull(this.viewPanel.getViewFrame());
    }

    @Test
    public void testViewPanel() {
        assertNotNull(this.viewPanel);
    }

}
