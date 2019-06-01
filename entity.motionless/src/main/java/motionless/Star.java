/*
 *
 */
package motionless;

import java.awt.Image;
import java.util.Observer;

import entity.AnimateGif;
import entity.Permeability;

/**
 * The Class Star.
 */
public class Star extends MotionlessEntity {

    /** The folder. */
    private static String FOLDER = "sprites\\Motionless\\Star";
    
    /** The image. */
    private static String IMAGE = "sprites\\Motionless\\Star\\star1.png";
    
    /** The sprite. */
    private static char SPRITE = '*';
    
    /** The permeability. */
    private static Permeability PERMEABILITY = Permeability.BLOCKING;

    /** The animate gif. */
    private AnimateGif animateGif;

    /**
     * Instantiates a new star.
     */
    public Star() {
        super(SPRITE, IMAGE, PERMEABILITY);
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
        this.animateGif = new AnimateGif(FOLDER, 200);
    }

    /**
     * Gets the folder.
     *
     * @return the folder
     */
    @Override
    public String getFolder() {
        // TODO Auto-generated method stub
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