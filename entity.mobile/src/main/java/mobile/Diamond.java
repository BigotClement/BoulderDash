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
    }

    @Override
    public Image getImage() {
        return this.animateGif.getImage();
    }

    @Override
    public void setImage(String image) {
        this.animateGif = new AnimateGif(FOLDER, 200);
    }

}