/*
 * 
 */
package motionless;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class DestructibleBlockTest.
 */
public class DestructibleBlockTest {

    /** The destructible block. */
    private DestructibleBlock destructibleBlock = null;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        this.destructibleBlock = new DestructibleBlock();
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
     * Test destructible block.
     */
    @Test
    public void testDestructibleBlock() {
        assertEquals(DestructibleBlock.class, this.destructibleBlock.getClass());
    }

}
