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
        this.motionlessEntity = new MotionlessEntity('e', "string") {

            @Override
            public String getFolder() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void setFolder(String folder) {
                // TODO Auto-generated method stub

            }

            @Override
            public int getY() {
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public void setY(int i) {
                // TODO Auto-generated method stub

            }

            @Override
            public void setHasMoved() {
                // TODO Auto-generated method stub

            }
        };
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetImage() {
        assertEquals("string", this.motionlessEntity.getImage());
    }

    @Test
    public void testSetImage() {
        this.motionlessEntity.setImage("");
        assertEquals("", this.motionlessEntity.getImage());
    }
}
