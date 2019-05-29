/*
 *
 */
package entity;

import java.awt.Image;

public interface IEntity {

    char getSprite();

    /**
     * @param sprite
     */
    void setSprite(char sprite);

    Image getImage();

    void setImage(String image);

    String getFolder();

    void setFolder(String folder);

    int getY();

    void setY(int y);

    int getX();

    void setX(int x);

    void setHasMoved();

    Permeability getPermeability();

    void setPermeability(Permeability permeability);

    void setSpriteFolder(String string);

}