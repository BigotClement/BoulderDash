/*
 *
 */
package mobile;

import java.awt.Image;

import entity.AnimateGif;

public class Character extends MobileEntity {

    private static char SPRITE = 'H';

    private static String FOLDER = "sprites\\Mobile\\Character\\Stand";

    private AnimateGif animateGif;

    public Character() {
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