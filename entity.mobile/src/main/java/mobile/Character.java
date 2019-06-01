/*
 *
 */
package mobile;

import java.awt.Image;
import java.util.Observer;

import entity.AnimateGif;
import entity.Permeability;

public class Character extends MobileEntity {

    private static char SPRITE = 'H';

    private static String FOLDER = "sprites\\Mobile\\Character\\Stand";

    private static Permeability PERMEABILITY = Permeability.BLOCKING;

    private AnimateGif animateGif;

    private boolean alive = true;

    public Character() {
        super(SPRITE, FOLDER, PERMEABILITY);
        this.setPermeability(this.getPermeability());
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
    public void setObserver(Observer observer) {
        this.animateGif.addObserver(observer);
    }

    @Override
    public void setSpriteFolder(String folder) {
        this.animateGif.setFolder(folder);
    }

    @Override
    public void die() {
        this.alive = false;

    }

    @Override
    public boolean isAlive() {
        return this.alive;
    }

}