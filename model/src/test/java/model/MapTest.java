/*
 *
 */
package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Entity;
import entity.IEntity;
import mobile.MobileEntityFactory;
import motionless.MotionlessEntityFactory;

public class MapTest {

    private Map map;

    @Before
    public void setUp() throws Exception {
        char[][] map = { { 'H' } };
        this.map = new Map(map);
    }

    @After
    public void tearDown() throws Exception {
    }

    @SuppressWarnings("unused")
    @Test
    public void testMap() {
        char[][] map1 = new char[16][16];
        for (char[] c : map1) {
            for (char cc : c) {
                cc = 'X';
            }
        }
        map1[0][0] = 'H';
        Map map = new Map(map1);
        assertEquals(Map.class, map.getClass());
    }

    @Test
    public void testGetMap() {
        assertNotNull(this.map.getMap());
    }

    @Test
    public void testSetMap() {
        IEntity[][] map = { { MotionlessEntityFactory.createBorder() } };
        this.map.setMap(map);
        assertEquals(MotionlessEntityFactory.createBorder().getClass(), this.map.getMap()[0][0].getClass());
    }

    @Test
    public void testGetViewMap() {
        assertEquals(Entity[][].class, this.map.getViewMap().getClass());
    }

    @Test
    public void testSetViewMap() {
        assertNotNull(this.map.getViewMap());
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

    /*
     * @Test public void testGetViewWidth() {
     * assertNotNull(this.map.getViewWidth()); }
     * @Test public void testSetViewWidth() { this.map.setViewWidth(10);
     * assertEquals(10, this.map.getViewWidth()); }
     */

    /*
     * @Test public void testGetViewHeight() {
     * assertNotNull(this.map.getViewHeight()); }
     * @Test public void testSetViewHeight() { this.map.setViewHeight(10);
     * assertEquals(10, this.map.getViewHeight()); }
     */
    @Test
    public void testGetOnTheMapXY() {
        assertNotNull(this.map.getOnTheMapXY(0, 0));
    }

    @Test
    public void testSetOnTheMapXYCharIntInt() {
        this.map.setOnTheMapXY('O', 0, 0);
        this.map.getOnTheMapXY(0, 0).getClass();
        assertEquals(MobileEntityFactory.createRock().getClass(), this.map.getOnTheMapXY(0, 0).getClass());
    }

    @Test
    public void testFillView() {
        assertNotNull(this.map.getViewMap());
    }

}
