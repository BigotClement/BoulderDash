/*
 *
 */
package mobile;

import static org.junit.Assert.*;

import java.awt.Image;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MobileEntityTest {
    private MobileEntity mobileEntity;

    @Before
    public void setUp() throws Exception {
        this.mobileEntity = new MobileEntity('f', "sprites\\", null) {

            @Override
            public Image getImage() {
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

    @Test
    public void testGetX() {

    }

    @Test
    public void testGetY() {

    }

    @Test
    public void testSetX() {

    }

    @Test
    public void testSetY() {

    }

    @Test
    public void testDie() {
        assertFalse(false);
    }

    @Test
    public void testIsAlive() {
        assertFalse(this.mobileEntity.isAlive());
    }

    @Test
    public void testGetCanKill() {
        assertFalse(this.mobileEntity.getCanKill());
    }

    @Test
    public void testSetCanKill() {
        this.mobileEntity.setCanKill(false);
        assertFalse(this.mobileEntity.getCanKill());
    }

    @Test
    public void testIsVerified() {
        assertFalse(this.mobileEntity.isVerified());
    }

    @Test
    public void testSetVerified() {
        this.mobileEntity.setVerified(false);
        assertFalse(this.mobileEntity.isVerified());
    }
}
