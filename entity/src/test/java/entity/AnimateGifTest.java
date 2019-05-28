/*
 *
 */
package entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.AnimateGif;

public class AnimateGifTest {

    private AnimateGif animateGif;

    @Before
    public void setUp() throws Exception {
        this.animateGif = new AnimateGif("", 150);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAnimateGif() {
        assertNotNull(this.animateGif);
    }

    @Test
    public void testGetFolder() {
        assertEquals("", this.animateGif.getFolder());
    }

    @Test
    public void testGetGif() {
        assertNull(this.animateGif.getGif());
    }

    @Test
    public void testGetImage() {
        assertNull(this.animateGif.getImage());
    }

    @Test
    public void testGetMilliseconds() {
        assertEquals(150, this.animateGif.getMilliseconds());
    }

    @Test
    public void testLoadSprites() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetFolder() {
        this.animateGif.setFolder("");
        assertEquals("", this.animateGif.getFolder());
    }

    @Test
    public void testSetGif() {
        this.animateGif.setGif(null);
        assertNull(this.animateGif.getGif());
    }

    @Test
    public void testSetImage() {
        this.animateGif.setImage(null);
        assertNull(this.animateGif.getImage());
    }

    @Test
    public void testSetMilliseconds() {
        this.animateGif.setMilliseconds(150);
        assertEquals(150, this.animateGif.getMilliseconds());
    }

}
