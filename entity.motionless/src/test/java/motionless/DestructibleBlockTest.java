/*
 * 
 */
package motionless;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DestructibleBlockTest {

    private DestructibleBlock destructibleBlock = null;

    @Before
    public void setUp() throws Exception {
        this.destructibleBlock = new DestructibleBlock();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testDestructibleBlock() {
        assertEquals(DestructibleBlock.class, this.destructibleBlock.getClass());
    }

}
