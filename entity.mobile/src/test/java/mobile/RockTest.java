/*
 *
 */
package mobile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RockTest {
    private Rock rock = null;

    @Before
    public void setUp() throws Exception {
        this.rock = new Rock();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testRock() {
        assertEquals(Rock.class, this.rock.getClass());
    }

}
