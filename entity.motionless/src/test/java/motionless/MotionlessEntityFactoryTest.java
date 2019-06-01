/*
 *
 */
package motionless;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class MotionlessEntityFactoryTest.
 */
public class MotionlessEntityFactoryTest {

    /** The star. */
    private Star star = null;
    
    /** The dirt. */
    private Dirt dirt = null;
    
    /** The destructible block. */
    private DestructibleBlock destructibleBlock = null;
    
    /** The border. */
    private Border border = null;
    
    /** The exit. */
    private Exit exit = null;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        this.star = new Star();
        this.dirt = new Dirt();
        this.destructibleBlock = new DestructibleBlock();
        this.border = new Border();
        this.exit = new Exit();
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
     * Test create star.
     */
    @Test
    public void testCreateStar() {
        assertEquals(this.star.getClass(), MotionlessEntityFactory.createStar().getClass());
    }

    /**
     * Test create dirt.
     */
    @Test
    public void testCreateDirt() {
        assertEquals(this.dirt.getClass(), MotionlessEntityFactory.createDirt().getClass());
    }

    /**
     * Test create destructible block.
     */
    @Test
    public void testCreateDestructibleBlock() {
        assertEquals(this.destructibleBlock.getClass(), MotionlessEntityFactory.createDestructibleBlock().getClass());
    }

    /**
     * Test create border.
     */
    @Test
    public void testCreateBorder() {
        assertEquals(this.border.getClass(), MotionlessEntityFactory.createBorder().getClass());
    }

    /**
     * Test create exit.
     */
    @Test
    public void testCreateExit() {
        assertEquals(this.exit.getClass(), MotionlessEntityFactory.createExit().getClass());
    }

    /**
     * Test create entity.
     */
    @Test
    public void testCreateEntity() {
        assertEquals(Star.class, MotionlessEntityFactory.createEntity('*').getClass());
        assertEquals(Dirt.class, MotionlessEntityFactory.createEntity('-').getClass());
        assertEquals(DestructibleBlock.class, MotionlessEntityFactory.createEntity('+').getClass());
        assertEquals(Border.class, MotionlessEntityFactory.createEntity('#').getClass());
        assertEquals(Exit.class, MotionlessEntityFactory.createEntity('|').getClass());
    }

}
