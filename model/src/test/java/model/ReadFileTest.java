/*
 *
 */
package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class ReadFileTest.
 */
public class ReadFileTest {
    
    /** The read file. */
    private ReadFile readFile;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        this.readFile = new ReadFile(1);
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
     * Test get map ID.
     */
    @Test
    public void testGetMapID() {
        assertEquals(1, this.readFile.getMapID());
    }

    /**
     * Test set map ID.
     */
    @Test
    public void testSetMapID() {
        assertEquals(1, this.readFile.getMapID());
    }

    /**
     * Test get height.
     */
    @Test
    public void testGetHeight() {
        this.readFile.deleteMapID(1);
        this.readFile.loadFile();
        this.readFile.selectMapID(1);
        assertEquals(10, this.readFile.getHeight());
    }

    /**
     * Test get width.
     */
    @Test
    public void testGetWidth() {
        this.readFile.deleteMapID(1);
        this.readFile.loadFile();
        this.readFile.selectMapID(1);
        assertEquals(10, this.readFile.getWidth());
    }

    /**
     * Test select map ID.
     */
    @Test
    public void testSelectMapID() {
        this.readFile.selectMapID(1);
        assertNotNull(this.readFile.getMap());
    }

    /**
     * Test get filename.
     */
    @Test
    public void testGetFilename() {
        assertEquals("Map1.txt", this.readFile.getFilename());
    }

    /**
     * Test set filename.
     */
    @Test
    public void testSetFilename() {
        assertEquals("Map1.txt", this.readFile.getFilename());
    }

    /**
     * Test get map.
     */
    @SuppressWarnings("deprecation")
    @Test
    public void testGetMap() {
        char[][] map = { { 'a', 'z' }, { 'e', 'r' }, { 't', 'y' } };
        this.readFile.setMap(map);
        assertEquals(map, this.readFile.getMap());
    }

    /**
     * Test set map.
     */
    @SuppressWarnings("deprecation")
    @Test
    public void testSetMap() {
        char[][] map = { { 'a', 'z' }, { 'e', 'r' }, { 't', 'y' } };
        this.readFile.setMap(map);
        assertEquals(map, this.readFile.getMap());
    }
}
