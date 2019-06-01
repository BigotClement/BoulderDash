/*
 * 
 */
package motionless;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class BorderTest.
 */
public class BorderTest {

    /** The border. */
    private Border border = null;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        this.border = new Border();
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
     * Test border.
     */
    @Test
    public void testBorder() {
        assertEquals(Border.class, this.border.getClass());
    }

}
