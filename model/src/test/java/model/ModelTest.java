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
    public void testGetObservable() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetMapID() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetMapID() {
        fail("Not yet implemented");
    }

}
