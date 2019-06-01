/*
 *
 */
package motionless;

/**
 * A factory for creating MotionlessEntity objects.
 */
public class MotionlessEntityFactory {

    /** The star. */
    private static Star STAR = new Star();
    
    /** The dirt. */
    private static Dirt DIRT = new Dirt();
    
    /** The destructibleblock. */
    private static DestructibleBlock DESTRUCTIBLEBLOCK = new DestructibleBlock();
    
    /** The border. */
    private static Border BORDER = new Border();
    
    /** The exit. */
    private static Exit EXIT = new Exit();

    /**
     * Creates a new MotionlessEntity object.
     *
     * @return the motionless entity
     */
    public static MotionlessEntity createStar() {
        return STAR;
    }

    /**
     * Creates a new MotionlessEntity object.
     *
     * @return the motionless entity
     */
    public static MotionlessEntity createDirt() {
        return DIRT;
    }

    /**
     * Creates a new MotionlessEntity object.
     *
     * @return the motionless entity
     */
    public static MotionlessEntity createDestructibleBlock() {
        return DESTRUCTIBLEBLOCK;
    }

    /**
     * Creates a new MotionlessEntity object.
     *
     * @return the motionless entity
     */
    public static MotionlessEntity createBorder() {
        return BORDER;
    }

    /**
     * Creates a new MotionlessEntity object.
     *
     * @return the motionless entity
     */
    public static MotionlessEntity createExit() {
        return EXIT;
    }

    /**
     * Creates a new MotionlessEntity object.
     *
     * @param sprite the sprite
     * @return the motionless entity
     */
    public static MotionlessEntity createEntity(char sprite) {
        MotionlessEntity motionlessEntity;
        switch (sprite) {
            case '*':
                motionlessEntity = createStar();
                return motionlessEntity;
            case '-':
                motionlessEntity = createDirt();
                return motionlessEntity;
            case '+':
                motionlessEntity = createDestructibleBlock();
                return motionlessEntity;
            case '#':
                motionlessEntity = createBorder();
                return motionlessEntity;
            case '|':
                motionlessEntity = createExit();
                return motionlessEntity;
            default:
                return null;
        }

    }

}