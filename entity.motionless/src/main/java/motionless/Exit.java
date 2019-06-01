/*
 *
 */
package motionless;

import java.awt.Image;
import java.util.Observer;

import entity.AnimateGif;
import entity.Permeability;

/**
 * The Class Exit.
 */
public class Exit extends MotionlessEntity {

    /** The folder. */
    private static String FOLDER = "sprites\\Motionless\\Exit";
    
    /** The image. */
    private static String IMAGE = "sprites\\Motionless\\Exit\\exit1.png";
    
    /** The permeability. */
    private static Permeability PERMEABILITY = Permeability.BLOCKING;
    
    /** The sprite. */
    private static char SPRITE = '|';

    /** The animate gif. */
    private AnimateGif animateGif;

    /**
     * Instantiates a new exit.
     */
    public Exit() {
        super(SPRITE, IMAGE, PERMEABILITY);
        this.setPermeability(this.getPermeability());
        this.setImage(IMAGE);
        this.setFolder(FOLDER);
    }

    /**
     * Gets the image.
     *
     * @return the image
     */
    @Override
    public Image getImage() {
        return this.animateGif.getImage();
    }

    /**
     * Sets the folder.
     *
     * @param folder the new folder
     */
    @Override
    public void setFolder(String folder) {
        this.animateGif = new AnimateGif(folder, 200);
    }

    /**
     * Gets the folder.
     *
     * @return the folder
     */
    @Override
    public String getFolder() {
        return null;
    }

    /**
     * Sets the observer.
     *
     * @param observer the new observer
     */
    @Override
    public void setObserver(Observer observer) {
        this.animateGif.addObserver(observer);
    }
}