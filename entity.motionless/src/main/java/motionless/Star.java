/*
 *
 */
package motionless;

import java.awt.Image;

import entity.AnimateGif;

public class Star extends MotionlessEntity {

    private static String FOLDER = "sprites\\Motionless\\Star";
    private static String IMAGE = "sprites\\Motionless\\Star\\star1.png";
    private static char SPRITE = '*';

    private AnimateGif animateGif;

    public Star() {
        super(SPRITE, IMAGE);

    }

    @Override
    public Image getImage() {
        return this.animateGif.getImage();
    }

    @Override
    public void setFolder(String folder) {
        this.animateGif = new AnimateGif(FOLDER, 200);
    }

    @Override
    public String getFolder() {
        // TODO Auto-generated method stub
        return null;
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