/*
 * 
 */
package motionless;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class ExitTest.
 */
public class ExitTest {

    /** The exit. */
    private Exit exit = null;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        this.exit = new Exit();
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
     * Test exit.
     */
    @Test
    public void testExit() {
        assertEquals(Exit.class, this.exit.getClass());
    }

}
