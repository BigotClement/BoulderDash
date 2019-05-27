/*
 *
 */
package mobile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiamondTest {
    private Diamond diamond = null;

    @Before
    public void setUp() throws Exception {
        this.diamond = new Diamond();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testDiamond() {
        assertEquals(Diamond.class, this.diamond.getClass());
    }

}
