/*
 *
 */
package mobile;

import java.awt.Image;

import entity.AnimateGif;
import entity.Permeability;

public class Diamond extends MobileEntity {

    private static char SPRITE = 'D';

    private static String FOLDER = "sprites\\Mobile\\Diamond";

    private static Permeability PERMEABILITY = Permeability.SEMIPENETRABLE;

    private AnimateGif animateGif;

    private boolean verified = false;

    public Diamond() {
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
        // TODO Auto-generated method stub

    }

    public boolean isVerified() {
        return this.verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

}