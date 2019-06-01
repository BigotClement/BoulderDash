/*
 *
 */
package entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.awt.Image;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.AnimateGif;

/**
 * The Class AnimateGifTest.
 */
public class AnimateGifTest {

    /** The animate gif. */
    private AnimateGif animateGif;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        this.animateGif = new AnimateGif("frames_gif", 150);
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
     * Test animate gif.
     */
    @Test
    public void testAnimateGif() {
        assertNotNull(this.animateGif);
    }

    /**
     * Test get folder.
     */
    @Test
    public void testGetFolder() {
        assertEquals("frames_gif", this.animateGif.getFolder());
    }

    /**
     * Test get gif.
     */
    @Test
    public void testGetGif() {
        assertEquals(Image[].class, this.animateGif.getGif().getClass());
    }

    /**
     * Test get image.
     */
    @Test
    public void testGetImage() {
        assertNull(this.animateGif.getImage());
    }

    /**
     * Test get milliseconds.
     */
    @Test
    public void testGetMilliseconds() {
        assertEquals(150, this.animateGif.getMilliseconds());
    }

    /**
     * Test load sprites.
     */
    @Test
    public void testLoadSprites() {
        assertNotNull(this.animateGif.getGif());
    }

    /**
     * Test set folder.
     */
    @Test
    public void testSetFolder() {
        this.animateGif.setFolder("frames_gif");
        assertEquals("frames_gif", this.animateGif.getFolder());
    }

    /**
     * Test set gif.
     */
    @Test
    public void testSetGif() {
        this.animateGif.setGif(null);
        assertNull(this.animateGif.getGif());
    }

    /**
     * Test set image.
     */
    @Test
    public void testSetImage() {
        this.animateGif.setImage(null);
        assertNull(this.animateGif.getImage());
    }

    /**
     * Test set milliseconds.
     */
    @Test
    public void testSetMilliseconds() {
        this.animateGif.setMilliseconds(150);
        assertEquals(150, this.animateGif.getMilliseconds());
    }

}
