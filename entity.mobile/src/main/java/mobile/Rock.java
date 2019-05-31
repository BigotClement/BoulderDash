/*
 *
 */
package mobile;

import java.awt.Image;
import java.util.Observer;

import entity.AnimateGif;
import entity.Permeability;

public class Rock extends MobileEntity {

    private static char SPRITE = 'O';

    private static String FOLDER = "sprites\\Mobile\\Rock";
    private static Permeability PERMEABILITY = Permeability.BLOCKING;
    private AnimateGif animateGif;
    private boolean canKill = false;

    public Rock() {
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
    public void setHasMoved() {

    }

    @Override
    public void setObserver(Observer observer) {
        this.animateGif.addObserver(observer);
    }

    @Override
    public boolean getCanKill() {
        return this.canKill;
    }

    @Override
    public void canKillTrue() {
        System.out.println("yes");
        this.canKill = true;
    }

    @Override
    public void canKillFalse() {
        System.out.println("no");
        this.canKill = false;
    }

}