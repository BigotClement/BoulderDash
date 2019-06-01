/*
 *
 */
package motionless;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observer;

import javax.imageio.ImageIO;

import entity.Entity;
import entity.Permeability;

/**
 * The Class MotionlessEntity.
 */
public abstract class MotionlessEntity extends Entity {

    /** The image. */
    protected Image image;
    
    /** The can kill. */
    private boolean canKill = false;

    /**
     * Instantiates a new motionless entity.
     *
     * @param sprite the sprite
     * @param image the image
     * @param permeability the permeability
     */
    public MotionlessEntity(char sprite, String image, Permeability permeability) {
        super(sprite, permeability);
        this.setImage(image);
    }

    /**
     * Gets the image.
     *
     * @return the image
     */
    @Override
    public Image getImage() {
        return this.image;
    }

    /**
     * Sets the image.
     *
     * @param image the new image
     */
    @Override
    public void setImage(String image) {
        try {
            this.image = ImageIO.read(new File(image));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Sets the sprite folder.
     *
     * @param folder the new sprite folder
     */
    @Override
    public void setSpriteFolder(String folder) {

    }

    /**
     * Checks if is verified.
     *
     * @return true, if is verified
     */
    @Override
    public boolean isVerified() {
        return false;
    }

    /**
     * Sets the verified.
     *
     * @param b the new verified
     */
    @Override
    public void setVerified(boolean b) {

    }

    /**
     * Sets the observer.
     *
     * @param observer the new observer
     */
    @Override
    public void setObserver(Observer observer) {

    }

    /**
     * Die.
     */
    @Override
    public void die() {

    }

    /**
     * Checks if is alive.
     *
     * @return true, if is alive
     */
    @Override
    public boolean isAlive() {
        return false;
    }

    /**
     * Gets the can kill.
     *
     * @return the can kill
     */
    @Override
    public boolean getCanKill() {
        return this.canKill;
    }

    /**
     * Sets the can kill.
     *
     * @param b the new can kill
     */
    @Override
    public void setCanKill(boolean b) {
        this.canKill = b;
    }

}