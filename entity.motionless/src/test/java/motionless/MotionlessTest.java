/*
 *
 */
package motionless;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MotionlessTest {

    private Border border = null;
    private DestructibleBlock destructibleBlock = null;
    private Dirt dirt = null;
    private Exit exit = null;
    private Star star = null;

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
    public void testBorder() {
        assertEquals(Border.class, this.border.getClass());
    }

    @Test
    public void testCreateBorder() {
        assertEquals(this.border.getClass(), MotionlessEntityFactory.createBorder().getClass());
    }

    @Test
    public void testCreateDestructibleBlock() {
        assertEquals(this.destructibleBlock.getClass(), MotionlessEntityFactory.createDestructibleBlock().getClass());
    }

    @Test
    public void testCreateDirt() {
        assertEquals(this.dirt.getClass(), MotionlessEntityFactory.createDirt().getClass());
    }

    @Test
    public void testCreateEntity() {
        assertEquals(Star.class, MotionlessEntityFactory.createEntity('*').getClass());
    }

    @Test
    public void testCreateExit() {
        assertEquals(this.exit.getClass(), MotionlessEntityFactory.createExit().getClass());
    }

    @Test
    public void testCreateStar() {
        assertEquals(this.star.getClass(), MotionlessEntityFactory.createStar().getClass());
    }

    @Test
    public void testDestructibleBlock() {
        assertEquals(DestructibleBlock.class, this.destructibleBlock.getClass());
    }

    @Test
    public void testDirt() {
        assertEquals(Dirt.class, this.dirt.getClass());
    }

    @Test
    public void testExit() {
        assertEquals(Exit.class, this.exit.getClass());
    }

    @Test
    public void testGetImage() {
        assertEquals("sprites\\Motionless\\border.png", this.border.getImage());
    }

    @Test
    public void testGetSprite() {
        assertEquals('#', this.border.getSprite());
    }

    @Test
    public void testSetImage() {
        this.border.setImage("");
        assertEquals("", this.border.getImage());
    }

    @Test
    public void testSetSprite() {
        this.border.setSprite('a');
        assertEquals('a', this.border.getSprite());
    }

    @Test
    public void testStar() {
        assertEquals(Star.class, this.star.getClass());
    }

}
