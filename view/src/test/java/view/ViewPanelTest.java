/*
 *
 */
package view;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class ViewPanelTest.
 */
public class ViewPanelTest {

    /** The view panel. */
    private ViewPanel viewPanel;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        this.viewPanel = new ViewPanel(null);
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
     * Test set view frame.
     */
    @Test
    public void testSetViewFrame() {
        this.viewPanel.setViewFrame(null);
        assertNull(this.viewPanel.getViewFrame());
    }

    /**
     * Test view panel.
     */
    @Test
    public void testViewPanel() {
        assertNotNull(this.viewPanel);
    }

    /**
     * Test get diamond counter image.
     */
    @Test
    public void testGetDiamondCounterImage() {
        assertNull(this.viewPanel.getDiamondCounterImage());
    }

    /**
     * Test set diamond counter image.
     */
    @Test
    public void testSetDiamondCounterImage() {
        try {
            this.viewPanel.setDiamondCounterImage(ImageIO.read(new File("diamondcounter.png")));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertNotNull(this.viewPanel.getDiamondCounterImage());
    }

    /**
     * Test get timer image.
     */
    @Test
    public void testGetTimerImage() {
        assertNull(this.viewPanel.getTimerImage());
    }

    /**
     * Test set timer image.
     */
    @Test
    public void testSetTimerImage() {
        try {
            this.viewPanel.setTimerImage(ImageIO.read(new File("timer.png")));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertNotNull(this.viewPanel.getTimerImage());
    }

}
