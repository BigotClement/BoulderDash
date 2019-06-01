/*
 *
 */
package entity;

import static org.junit.Assert.*;

import java.awt.Image;
import java.util.Observer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EntityTest {

    private Entity entity = null;
    private char letter;

    @Before
    public void setUp() throws Exception {
        this.entity = new Entity('e', null) {

            @Override
            public Image getImage() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void setImage(String image) {
                // TODO Auto-generated method stub

            }

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
            public void setHasMoved() {
                // TODO Auto-generated method stub

            }

            @Override
            public void setSpriteFolder(String string) {
                // TODO Auto-generated method stub

            }

            @Override
            public boolean isVerified() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public void setVerified(boolean b) {
                // TODO Auto-generated method stub

            }

            @Override
            public void setObserver(Observer observer) {
                // TODO Auto-generated method stub

            }

            @Override
            public void die() {
                // TODO Auto-generated method stub

            }

            @Override
            public boolean isAlive() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean getCanKill() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public void setCanKill(boolean b) {
                // TODO Auto-generated method stub

            }
        };
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSetSprite() {
        this.entity.setSprite('x');
        assertEquals('x', this.entity.getSprite());
    }

    @Test
    public void testGetSprite() {
        assertEquals('e', this.entity.getSprite());
    }

    @Test
    public void TestEntity() {
        assertNotNull(this.letter);
    }

}
