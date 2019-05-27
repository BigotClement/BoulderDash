/*
 *
 */
package entity;

public abstract class Entity implements IEntity {
    private char sprite;

    /**
     * @param sprite
     */
    public Entity(char sprite) {
        this.setSprite(sprite);
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