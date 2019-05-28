/*
 *
 */
package mobile;

import java.awt.Image;

import entity.AnimateGif;

public class Rock extends MobileEntity {

    private static char SPRITE = 'O';

    private static String FOLDER = "sprites\\Mobile\\Rock";

    private AnimateGif animateGif;

    public Rock() {
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

}