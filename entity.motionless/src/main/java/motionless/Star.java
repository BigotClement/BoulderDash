/*
 *
 */
package motionless;

import java.awt.Image;
import java.util.Observer;

import entity.AnimateGif;
import entity.Permeability;

public class Star extends MotionlessEntity {

    private static String FOLDER = "sprites\\Motionless\\Star";
    private static String IMAGE = "sprites\\Motionless\\Star\\star1.png";
    private static char SPRITE = '*';
    private static Permeability PERMEABILITY = Permeability.BLOCKING;

    private AnimateGif animateGif;

    public Star() {
        super(SPRITE, IMAGE, PERMEABILITY);
    }

    @Override
    public Image getImage() {
        return this.animateGif.getImage();
    }

    @Override
    public void setFolder(String folder) {
        this.animateGif = new AnimateGif(FOLDER, 200);
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