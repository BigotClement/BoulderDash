/*
 *
 */
package mobile;

import java.awt.Image;
import java.util.Observer;
import java.util.Random;

import entity.AnimateGif;
import entity.Permeability;

public class Enemy extends MobileEntity {

    private static char SPRITE = 'X';
    private static String[] folderArray = { "sprites\\Mobile\\Butterfly", "sprites\\Mobile\\Blob" };
    private static Permeability PERMEABILITY = Permeability.BLOCKING;
    private static Random ran = new Random();
    private static String s_ran = folderArray[ran.nextInt(folderArray.length)];

    private AnimateGif animateGif;

    public Enemy() {
        super(SPRITE, s_ran, PERMEABILITY);
        this.setImage(s_ran);
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
    public boolean isVerified() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setVerified(boolean b) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setObserver(Observer observer) {
        this.animateGif.addObserver(observer);
    }

}