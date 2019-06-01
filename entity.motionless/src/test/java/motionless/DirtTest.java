/*
 * 
 */
package motionless;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class DirtTest.
 */
public class DirtTest {

    /** The dirt. */
    private Dirt dirt = null;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        this.dirt = new Dirt();
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
     * Test dirt.
     */
    @Test
    public void testDirt() {
        assertEquals(Dirt.class, this.dirt.getClass());
    }

}
