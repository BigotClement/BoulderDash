/*
 *
 */
package entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EntityTest {

    private Entity entity = null;

    @Before
    public void setUp() throws Exception {
        this.entity = new Entity('e') {
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
