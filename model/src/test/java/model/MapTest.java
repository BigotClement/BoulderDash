/*
 *
 */
package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MapTest {

    private Map map;

    @Before
    public void setUp() throws Exception {
        char[][] map = { { 'a' } };
        this.map = new Map(map);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testMap() {
        Map map = new Map(null);
        assertEquals(Map.class, map.getClass());
    }

    @Test
    public void testGetMap() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetMap() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetWidth() {
        assertNotNull(this.map.getWidth());
    }

    @Test
    public void testSetWidth() {
        this.map.setWidth(10);
        assertEquals(10, this.map.getWidth());
    }

    @Test
    public void testGetHeight() {
        assertNotNull(this.map.getWidth());
    }

    @Test
    public void testSetHeight() {
        this.map.setHeight(10);
        assertEquals(10, this.map.getHeight());
    }

    @Test
    public void testGetOnTheMapXY() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetOnTheMapXYCharIntInt() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetOnTheMapXYIEntityIntInt() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetMobileHasChanged() {
        fail("Not yet implemented");
    }

    @Test
    public void testFillView() {
        fail("Not yet implemented");
    }

    @Test
    public void testMoveUp() {
        fail("Not yet implemented");
    }

    @Test
    public void testMoveDown() {
        fail("Not yet implemented");
    }

    @Test
    public void testMoveRight() {
        fail("Not yet implemented");
    }

    @Test
    public void testMoveLeft() {
        fail("Not yet implemented");
    }

}
