/*
 * 
 */
package motionless;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StarTest {

    private Star star = null;

    @Before
    public void setUp() throws Exception {
        this.star = new Star();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testStar() {
        assertEquals(Star.class, this.star.getClass());
    }

}
