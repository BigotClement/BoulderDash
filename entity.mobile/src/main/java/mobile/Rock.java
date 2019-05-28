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