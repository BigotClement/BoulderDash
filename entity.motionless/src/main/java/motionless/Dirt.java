/*
 *
 */
package motionless;

public class Dirt extends MotionlessEntity {

    private static String IMAGE = "sprites\\Motionless\\dirt.png";
    private static char SPRITE = '-';

    public Dirt() {
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

    @Override
    public int getY() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setY(int i) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setHasMoved() {
        // TODO Auto-generated method stub

    }

}