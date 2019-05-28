/*
 *
 */
package mobile;

import java.awt.Image;

import entity.AnimateGif;

public class Diamond extends MobileEntity {

    private static char SPRITE = 'D';

    private static String FOLDER = "sprites\\Mobile\\Diamond";

    private AnimateGif animateGif;

    public Diamond() {
        super(SPRITE, FOLDER);
        this.setImage(FOLDER);
    }

    @Override
    public Image getImage() {
        return this.animateGif.getImage();
    }

    @Override
    public void setImage(String folder) {
        this.animateGif = new AnimateGif(folder, 200);
    }

    @Override
    public void setHasMoved() {
        // TODO Auto-generated method stub

    }

}