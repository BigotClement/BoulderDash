/*
 *
 */
package entity;

import static org.junit.Assert.*;

import java.awt.Image;
import java.awt.Point;
import java.util.Observer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class EntityTest.
 */
public class EntityTest {

    /** The entity. */
    private Entity entity = null;
    
    /** The letter. */
    private char letter;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        this.entity = new Entity('e', Permeability.BLOCKING) {

            @Override
            public void setVerified(boolean b) {
                // TODO Auto-generated method stub

            }

            @Override
            public void setSpriteFolder(String string) {
                // TODO Auto-generated method stub

            }

            @Override
            public void setObserver(Observer observer) {
                // TODO Auto-generated method stub

            }

            @Override
            public void setImage(String image) {
                // TODO Auto-generated method stub

            }

            @Override
            public void setFolder(String folder) {
                // TODO Auto-generated method stub

            }

            @Override
            public void setCanKill(boolean b) {
                // TODO Auto-generated method stub

            }

            @Override
            public boolean isVerified() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean isAlive() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public Image getImage() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public String getFolder() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public boolean getCanKill() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public void die() {
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
     * Test set sprite.
     */
    @Test
    public void testSetSprite() {
        this.entity.setSprite('x');
        assertEquals('x', this.entity.getSprite());
    }

    /**
     * Test get sprite.
     */
    @Test
    public void testGetSprite() {
        assertEquals('e', this.entity.getSprite());
    }

    /**
     * Test entity.
     */
    @Test
    public void TestEntity() {
        assertNotNull(this.letter);
    }

    /**
     * Test entity.
     */
    @Test
    public void testEntity() {
        assertNotNull(this.entity);
    }

    /**
     * Test get permeability.
     */
    @Test
    public void testGetPermeability() {
        assertEquals(Permeability.BLOCKING, this.entity.getPermeability());
    }

    /**
     * Test set permeability.
     */
    @Test
    public void testSetPermeability() {
        this.entity.setPermeability(Permeability.PENETRABLE);
        assertEquals(Permeability.PENETRABLE, this.entity.getPermeability());
    }

    /**
     * Test get position.
     */
    @Test
    public void testGetPosition() {
        assertNotNull(this.entity.getPosition());
    }

    /**
     * Test set position.
     */
    @Test
    public void testSetPosition() {
        this.entity.setPosition(new Point(1, 1));
        assertEquals(new Point(1, 1), this.entity.getPosition());
    }

    /**
     * Test get X.
     */
    @Test
    public void testGetX() {
        assertEquals(0, this.entity.getX());
    }

    /**
     * Test set X.
     */
    @Test
    public void testSetX() {
        this.entity.setX(1);
        assertEquals(1, this.entity.getX());
    }

    /**
     * Test get Y.
     */
    @Test
    public void testGetY() {
        assertEquals(0, this.entity.getY());
    }

    /**
     * Test set Y.
     */
    @Test
    public void testSetY() {
        this.entity.setY(1);
        assertEquals(1, this.entity.getY());
    }

}
