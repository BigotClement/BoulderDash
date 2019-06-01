/*
 *
 */
package motionless;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class StarTest.
 */
public class StarTest {

    /** The star. */
    private Star star = null;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        this.star = new Star();
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
     * Test star.
     */
    @Test
    public void testStar() {
        assertEquals(Star.class, this.star.getClass());
    }

}
