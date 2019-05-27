/*
 * 
 */
package motionless;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BorderTest {

    private Border border = null;

    @Before
    public void setUp() throws Exception {
        this.border = new Border();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testBorder() {
        assertEquals(Border.class, this.border.getClass());
    }

}
