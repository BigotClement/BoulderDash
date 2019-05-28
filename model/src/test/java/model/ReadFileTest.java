/*
 *
 */
package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReadFileTest {
    private ReadFile readFile;

    @Before
    public void setUp() throws Exception {
        this.readFile = new ReadFile(1);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetMapID() {
        assertEquals(1, this.readFile.getMapID());
    }

    @Test
    public void testSetMapID() {
        assertEquals(1, this.readFile.getMapID());
    }

    @Test
    public void testGetHeight() {
        this.readFile.deleteMapID(1);
        this.readFile.loadFile();
        this.readFile.selectMapID(1);
        assertEquals(10, this.readFile.getHeight());
    }

    @Test
    public void testGetWidth() {
        this.readFile.deleteMapID(1);
        this.readFile.loadFile();
        this.readFile.selectMapID(1);
        assertEquals(10, this.readFile.getWidth());
    }

    @Test
    public void testSelectMapID() {
        this.readFile.selectMapID(1);
        assertNotNull(this.readFile.getMap());
    }

    @Test
    public void testGetFilename() {
        assertEquals("Map1.txt", this.readFile.getFilename());
    }

    @Test
    public void testSetFilename() {
        assertEquals("Map1.txt", this.readFile.getFilename());
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testGetMap() {
        char[][] map = { { 'a', 'z' }, { 'e', 'r' }, { 't', 'y' } };
        this.readFile.setMap(map);
        assertEquals(map, this.readFile.getMap());
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testSetMap() {
        char[][] map = { { 'a', 'z' }, { 'e', 'r' }, { 't', 'y' } };
        this.readFile.setMap(map);
        assertEquals(map, this.readFile.getMap());
    }
}
