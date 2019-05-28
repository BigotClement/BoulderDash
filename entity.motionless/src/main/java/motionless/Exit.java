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

}