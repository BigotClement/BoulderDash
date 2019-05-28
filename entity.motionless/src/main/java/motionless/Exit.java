/*
 *
 */
package motionless;

public class Exit extends MotionlessEntity {

    private static String IMAGE = "sprites\\Motionless\\Exit\\exit1.png";
    private static char SPRITE = '|';

    public Exit() {
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