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

    @Test
    public void testGetDiamondCounterImage() {
        assertNull(this.viewPanel.getDiamondCounterImage());
    }

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

    @Test
    public void testGetTimerImage() {
        assertNull(this.viewPanel.getTimerImage());
    }

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
