/*
 *
 */
package mobile;

import java.awt.Image;

import entity.AnimateGif;
import entity.Permeability;

public class Rock extends MobileEntity {

    private static char SPRITE = 'O';

    private static String FOLDER = "sprites\\Mobile\\Rock";

    private static Permeability PERMEABILITY = Permeability.BLOCKING;

    private AnimateGif animateGif;

    private boolean verified = false;

    public Rock() {
        super(SPRITE, FOLDER, PERMEABILITY);
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

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

}