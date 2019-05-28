/*
 *
 */
package motionless;

public class DestructibleBlock extends MotionlessEntity {

    private static String IMAGE = "sprites\\Motionless\\destructiblebloc.png";
    private static char SPRITE = '+';

    public DestructibleBlock() {
        super(SPRITE, IMAGE);

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

}