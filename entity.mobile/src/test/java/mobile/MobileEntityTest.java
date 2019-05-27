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
    public void testSetSprite() {
        this.mobileEntity.setSprite('e');
        assertEquals('e', this.mobileEntity.getSprite());
    }

    @Test
    public void testGetSprite() {
        assertEquals('f', this.mobileEntity.getSprite());
    }

}
