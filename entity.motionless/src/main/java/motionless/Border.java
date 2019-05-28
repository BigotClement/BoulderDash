/*
 *
 */
package motionless;

public class Border extends MotionlessEntity {

    private static String IMAGE = "sprites\\Motionless\\border.png";
    private static char SPRITE = '#';

    public Border() {
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