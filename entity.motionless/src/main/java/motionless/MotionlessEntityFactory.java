/*
 *
 */
package motionless;

public class MotionlessEntityFactory {

    private static Border BORDER = new Border();
    private static DestructibleBlock DESTRUCTIBLEBLOCK = new DestructibleBlock();
    private static Dirt DIRT = new Dirt();
    private static Exit EXIT = new Exit();
    private static Star STAR = new Star();

    public static MotionlessEntity createBorder() {
        return BORDER;
    }

    public static MotionlessEntity createDestructibleBlock() {
        return DESTRUCTIBLEBLOCK;
    }

    public static MotionlessEntity createDirt() {
        return DIRT;
    }

    /**
     * @param sprite
     */
    public static MotionlessEntity createEntity(char sprite) {
        return BORDER;

    }

    public static MotionlessEntity createExit() {
        return EXIT;
    }

    public static MotionlessEntity createStar() {
        return STAR;
    }

}