/*
 *
 */
package motionless;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class MotionlessEntityTest.
 */
public class MotionlessEntityTest {

    /** The motionless entity. */
    private MotionlessEntity motionlessEntity = null;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        this.motionlessEntity = new MotionlessEntity('e', "tenor.gif", null) {

            @Override
            public String getFolder() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void setFolder(String folder) {
                // TODO Auto-generated method stub

            }
        };
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
     * Test get image.
     */
    @Test
    public void testGetImage() {
        assertNotNull(this.motionlessEntity.getImage());
    }

    /**
     * Test set image.
     */
    @Test
    public void testSetImage() {
        this.motionlessEntity.setImage("gif-nyan.gif");
        assertNotNull(this.motionlessEntity.getImage());
    }

    /**
     * Test is verified.
     */
    @Test
    public void testIsVerified() {
        assertFalse(this.motionlessEntity.isVerified());
    }

    /**
     * Test set verified.
     */
    @Test
    public void testSetVerified() {
        this.motionlessEntity.setVerified(false);
        assertFalse(this.motionlessEntity.isVerified());
    }

    /**
     * Test die.
     */
    @Test
    public void testDie() {

    }

    /**
     * Test is alive.
     */
    @Test
    public void testIsAlive() {
        assertFalse(this.motionlessEntity.isAlive());
    }

    /**
     * Test get can kill.
     */
    @Test
    public void testGetCanKill() {
        assertFalse(this.motionlessEntity.getCanKill());
    }

    /**
     * Test set can kill.
     */
    @Test
    public void testSetCanKill() {
        this.motionlessEntity.setCanKill(false);
        assertFalse(this.motionlessEntity.getCanKill());
    }

}
