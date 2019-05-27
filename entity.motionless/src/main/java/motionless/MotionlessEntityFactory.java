/*
 *
 */
package motionless;

public class MotionlessEntityFactory {

    private static Star STAR = new Star();
    private static Dirt DIRT = new Dirt();
    private static DestructibleBlock DESTRUCTIBLEBLOCK = new DestructibleBlock();
    private static Border BORDER = new Border();
    private static Exit EXIT = new Exit();

    public static MotionlessEntity createStar() {
        return STAR;
    }

    public static MotionlessEntity createDirt() {
        return DIRT;
    }

    public static MotionlessEntity createDestructibleBlock() {
        return DESTRUCTIBLEBLOCK;
    }

    public static MotionlessEntity createBorder() {
        return BORDER;
    }

    public static MotionlessEntity createExit() {
        return EXIT;
    }

    /**
     * @param sprite
     */
    public static MotionlessEntity createEntity(char sprite) {
        switch (sprite) {
            case '*':
                return STAR;
            case '-':
                return DIRT;
            case '+':
                return DESTRUCTIBLEBLOCK;
            case '#':
                return BORDER;
            case '|':
                return EXIT;
            default:
                return null;
        }

    }
        
}