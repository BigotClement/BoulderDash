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

    @Test
    public void testFindCharcter() {
        assertNotNull(this.map.findCharacter());
    }

    @Test
    public void testFindExit() {
        assertNull(this.map.findExit());
    }

    @Test
    public void testGetOnTheViewMapXY() {
        assertNotNull(this.map.getOnTheViewMapXY(0, 0));
    }

    @Test
    public void testSetOnTheViewMapXY() {
        this.map.setOnTheViewMapXY(null, 0, 0);
        assertNull(this.map.getOnTheViewMapXY(0, 0));
    }

    @Test
    public void testSetOnTheMapXY() {
        this.map.setOnTheMapXY(null, 0, 0);
        assertNotNull(this.map.getMap());
    }

}
