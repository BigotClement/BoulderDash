/*
 *
 */
package entity;

import java.awt.Image;

public abstract class Entity implements IEntity {

    private Image image;
    private char sprite;

    /**
     * @param sprite
     */
    public Entity(char sprite) {
        // TODO - implement Entity.Entity
        throw new UnsupportedOperationException();
    }

    @Override
    public Image getImage() {
        return this.image;
    }

    /**
     * @param image
     */
    @Override
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * @param sprite
     */
    @Override
    public void setSprite(char sprite) {
        this.sprite = sprite;
    }

    @Override
    public char getSprite() {
        return this.sprite;
    }

}