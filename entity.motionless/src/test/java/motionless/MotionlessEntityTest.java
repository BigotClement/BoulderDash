/*
 *
 */
package motionless;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MotionlessEntityTest {

    private MotionlessEntity motionlessEntity = null;

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

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetImage() {
        assertNotNull(this.motionlessEntity.getImage());
    }

    @Test
    public void testSetImage() {
        this.motionlessEntity.setImage("gif-nyan.gif");
        assertNotNull(this.motionlessEntity.getImage());
    }

    @Test
    public void testIsVerified() {
        assertFalse(this.motionlessEntity.isVerified());
    }

    @Test
    public void testSetVerified() {
        this.motionlessEntity.setVerified(false);
        assertFalse(this.motionlessEntity.isVerified());
    }

    @Test
    public void testDie() {

    }

    @Test
    public void testIsAlive() {
        assertFalse(this.motionlessEntity.isAlive());
    }

    @Test
    public void testGetCanKill() {
        assertFalse(this.motionlessEntity.getCanKill());
    }

    @Test
    public void testSetCanKill() {
        this.motionlessEntity.setCanKill(false);
        assertFalse(this.motionlessEntity.getCanKill());
    }

}
