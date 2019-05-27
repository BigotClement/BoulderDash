/*
 *
 */
package entity;

import java.awt.Image;

public interface IEntity {

    Image getImage();

    /**
     * @param image
     */
    void setImage(Image image);

    char getSprite();

    /**
     * @param sprite
     */
    void setSprite(char sprite);

}