/*
 *
 */
package entity;

import static org.junit.Assert.*;

import java.awt.Image;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EntityTest {

    private Entity entity = null;

    @Before
    public void setUp() throws Exception {
        this.entity = new Entity('e') {

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
    public void testSetSprite() {
        this.entity.setSprite('x');
        assertEquals('x', this.entity.getSprite());
    }

    @Test
    public void testGetSprite() {
        assertEquals('e', this.entity.getSprite());
    }

}
