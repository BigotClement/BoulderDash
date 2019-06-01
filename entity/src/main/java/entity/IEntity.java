/*
 *
 */
package entity;

import java.awt.Image;
import java.util.Observer;

/**
 * The Interface IEntity.
 */
public interface IEntity {

    /**
     * Gets the sprite.
     *
     * @return the sprite
     */
    char getSprite();

    /**
     * Sets the sprite.
     *
     * @param sprite the new sprite
     */
    void setSprite(char sprite);

    /**
     * Gets the image.
     *
     * @return the image
     */
    Image getImage();

    /**
     * Sets the image.
     *
     * @param image the new image
     */
    void setImage(String image);

    /**
     * Gets the folder.
     *
     * @return the folder
     */
    String getFolder();

    /**
     * Sets the folder.
     *
     * @param folder the new folder
     */
    void setFolder(String folder);

    /**
     * Gets the y.
     *
     * @return the y
     */
    int getY();

    /**
     * Sets the y.
     *
     * @param y the new y
     */
    void setY(int y);

    /**
     * Gets the x.
     *
     * @return the x
     */
    int getX();

    /**
     * Sets the x.
     *
     * @param x the new x
     */
    void setX(int x);

    /**
     * Gets the permeability.
     *
     * @return the permeability
     */
    Permeability getPermeability();

    /**
     * Sets the permeability.
     *
     * @param permeability the new permeability
     */
    void setPermeability(Permeability permeability);

    /**
     * Sets the sprite folder.
     *
     * @param string the new sprite folder
     */
    void setSpriteFolder(String string);

    /**
     * Checks if is verified.
     *
     * @return true, if is verified
     */
    boolean isVerified();

    /**
     * Sets the verified.
     *
     * @param b the new verified
     */
    void setVerified(boolean b);

    /**
     * Sets the observer.
     *
     * @param observer the new observer
     */
    void setObserver(Observer observer);

    /**
     * Die.
     */
    void die();

    /**
     * Checks if is alive.
     *
     * @return true, if is alive
     */
    boolean isAlive();

    /**
     * Gets the can kill.
     *
     * @return the can kill
     */
    boolean getCanKill();

    /**
     * Sets the can kill.
     *
     * @param b the new can kill
     */
    void setCanKill(boolean b);

}