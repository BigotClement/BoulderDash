/*
 *
 */
package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class ModelTest.
 */
public class ModelTest {

    /** The model. */
    private Model model;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        this.model = new Model(0);
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
     * Test model.
     */
    @Test
    public void testModel() {
        Model model1 = new Model(0);
        assertEquals(Model.class, model1.getClass());
    }

    /**
     * Test get map ID.
     */
    @Test
    public void testGetMapID() {
        this.model.setMapID(1);
        assertEquals(1, this.model.getMapID());
    }

    /**
     * Test set map ID.
     */
    @Test
    public void testSetMapID() {
        this.model.setMapID(2);
        assertEquals(2, this.model.getMapID());
    }

    /**
     * Test get map.
     */
    @Test
    public void testGetMap() {
        assertEquals(Map.class, this.model.getMap().getClass());
    }

    /**
     * Test set map.
     */
    @Test
    public void testSetMap() {
        char[][] map = { { 'D' } };
        this.model.setMap(new Map(map));
        assertEquals(Map.class, this.model.getMap().getClass());
    }

}
