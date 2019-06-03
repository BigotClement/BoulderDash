/*
 *
 */
package view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MenuTest {

    private Menu menu = null;
    private int mapID;

    @Before
    public void setUp() throws Exception {
        this.menu = new Menu();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testMenu() {
        assertNotNull(this.menu);
    }

    @Test
    public void testGetMapID() {
        assertEquals(0, this.menu.getMapID());
    }

    @Test
    public void testSetMapID() {
        this.menu.setMapID(1);
        assertEquals(1, this.menu.getMapID());
    }

}
