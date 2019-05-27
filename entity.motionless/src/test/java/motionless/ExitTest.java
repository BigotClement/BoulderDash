/*
 * 
 */
package motionless;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExitTest {

    private Exit exit = null;

    @Before
    public void setUp() throws Exception {
        this.exit = new Exit();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testExit() {
        assertEquals(Exit.class, this.exit.getClass());
    }

}
