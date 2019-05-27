/*
 *
 */
package motionless;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MotionlessEntityFactoryTest {

    private Star star = null;
    private Dirt dirt = null;
    private DestructibleBlock destructibleBlock = null;
    private Border border = null;
    private Exit exit = null;

    @Before
    public void setUp() throws Exception {
        this.star = new Star();
        this.dirt = new Dirt();
        this.destructibleBlock = new DestructibleBlock();
        this.border = new Border();
        this.exit = new Exit();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCreateStar() {
        assertEquals(this.star.getClass(), MotionlessEntityFactory.createStar().getClass());
    }

    @Test
    public void testCreateDirt() {
        assertEquals(this.dirt.getClass(), MotionlessEntityFactory.createDirt().getClass());
    }

    @Test
    public void testCreateDestructibleBlock() {
        assertEquals(this.destructibleBlock.getClass(), MotionlessEntityFactory.createDestructibleBlock().getClass());
    }

    @Test
    public void testCreateBorder() {
        assertEquals(this.border.getClass(), MotionlessEntityFactory.createBorder().getClass());
    }

    @Test
    public void testCreateExit() {
        assertEquals(this.exit.getClass(), MotionlessEntityFactory.createExit().getClass());
    }

    @Test
    public void testCreateEntity() {
        assertEquals(Star.class, MotionlessEntityFactory.createEntity('*').getClass());
        assertEquals(Dirt.class, MotionlessEntityFactory.createEntity('-').getClass());
        assertEquals(DestructibleBlock.class, MotionlessEntityFactory.createEntity('+').getClass());
        assertEquals(Border.class, MotionlessEntityFactory.createEntity('#').getClass());
        assertEquals(Exit.class, MotionlessEntityFactory.createEntity('|').getClass());
    }

}
