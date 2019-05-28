/*
 *
 */
package motionless;

public class Star extends MotionlessEntity {

    private static String IMAGE = "sprites\\Motionless\\Star\\star1.png";
    private static char SPRITE = '*';

    public Star() {
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