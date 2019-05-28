/*
 *
 */
package motionless;

import java.awt.Image;

import entity.AnimateGif;

public class Exit extends MotionlessEntity {

    private static String FOLDER = "sprites\\Motionless\\Exit";
    private static String IMAGE = "sprites\\Motionless\\Exit\\exit1.png";
    private static char SPRITE = '|';

    private AnimateGif animateGif;

    public Exit() {
        super(SPRITE, IMAGE);
        this.setImage(IMAGE);
        this.setFolder(FOLDER);
    }

    @Override
    public Image getImage() {
        return this.animateGif.getImage();
    }

    @Override
    public void setFolder(String folder) {
        this.animateGif = new AnimateGif(folder, 200);
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