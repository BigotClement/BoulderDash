/*
 *
 */
package mobile;

import java.awt.Image;
import java.util.Random;

import entity.AnimateGif;

public class Enemy extends MobileEntity {

    private static char SPRITE = 'X';
    private static String[] folderArray = { "sprites\\Mobile\\Butterfly", "sprites\\Mobile\\Blob" };
    private static Random ran = new Random();
    private static String s_ran = folderArray[ran.nextInt(folderArray.length)];

    private AnimateGif animateGif;

    public Enemy() {
        super(SPRITE, s_ran);
    }

    @Override
    public Image getImage() {
        return this.animateGif.getImage();
    }

    @Override
    public void setImage(String image) {
        this.animateGif = new AnimateGif(s_ran, 200);
    }

}