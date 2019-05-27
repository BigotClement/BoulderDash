/*
 * 
 */
package motionless;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DirtTest {

    private Dirt dirt = null;

    @Before
    public void setUp() throws Exception {
        this.dirt = new Dirt();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testDirt() {
        assertEquals(Dirt.class, this.dirt.getClass());
    }

}
