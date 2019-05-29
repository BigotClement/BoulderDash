/*
 *
 */
package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ModelTest {

    private Model model;

    @Before
    public void setUp() throws Exception {
        this.model = new Model();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testModel() {
        Model model1 = new Model();
        assertEquals(Model.class, model1.getClass());
    }

    @Test
    public void testGetMapID() {
        this.model.setMapID(1);
        assertEquals(1, this.model.getMapID());
    }

    @Test
    public void testSetMapID() {
        this.model.setMapID(2);
        assertEquals(2, this.model.getMapID());
    }

    @Test
    public void testGetMap() {
        assertEquals(Map.class, this.model.getMap().getClass());
    }

    @Test
    public void testSetMap() {
        char[][] map = { { 'D' } };
        this.model.setMap(new Map(map));
        assertEquals(Map.class, this.model.getMap().getClass());
    }

}
