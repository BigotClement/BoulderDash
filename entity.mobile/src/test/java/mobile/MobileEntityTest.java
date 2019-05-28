/*
 *
 */
package mobile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MobileEntityTest {
    private MobileEntity mobileEntity;

    @Before
    public void setUp() throws Exception {
        this.mobileEntity = new MobileEntity('f', "sprites\\") {

            @Override
            public String getImage() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void setImage(String image) {
                // TODO Auto-generated method stub

            }
        };
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetFolder() {
        assertEquals("sprites\\", this.mobileEntity.getFolder());
    }

    @Test
    public void testSetFolder() {
        this.mobileEntity.setFolder("");
        assertEquals("", this.mobileEntity.getFolder());
    }

}
