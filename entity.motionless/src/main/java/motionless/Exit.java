/*
 *
 */
package motionless;

import java.awt.Image;
import java.util.Observer;

import entity.AnimateGif;
import entity.Permeability;

public class Exit extends MotionlessEntity {

    private static String FOLDER = "sprites\\Motionless\\Exit";
    private static String IMAGE = "sprites\\Motionless\\Exit\\exit1.png";
    private static Permeability PERMEABILITY = Permeability.BLOCKING;
    private static char SPRITE = '|';

    private AnimateGif animateGif;

    public Exit() {
        super(SPRITE, IMAGE, PERMEABILITY);
        this.setPermeability(this.getPermeability());
        this.setImage(IMAGE);
        this.setFolder(FOLDER);
    }

    @Override
    public Image getImage() {
        return this.animateGif.getImage();
    }

    @Override
    public void setFolder(String folder) {
        this.animateGif = new AnimateGif(folder, 200);
    }

    @Override
    public String getFolder() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setObserver(Observer observer) {
        this.animateGif.addObserver(observer);
    }
}