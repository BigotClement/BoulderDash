/*
 *
 */
package entity;

import java.awt.Point;

/**
 * The Class Entity.
 */
public abstract class Entity implements IEntity {
    
    /** The sprite. */
    private char sprite;
    
    /** The permeability. */
    private Permeability permeability;
    
    /** The position. */
    protected Point position = new Point();

    /**
     * Instantiates a new entity.
     *
     * @param sprite the sprite
     * @param permeability the permeability
     */
    public Entity(char sprite, Permeability permeability) {
        this.setSprite(sprite);
        this.setPermeability(permeability);
    }

    /**
     * Sets the sprite.
     *
     * @param sprite the new sprite
     */
    @Override
    public void setSprite(char sprite) {
        this.sprite = sprite;
    }

    /**
     * Gets the sprite.
     *
     * @return the sprite
     */
    @Override
    public char getSprite() {
        return this.sprite;
    }

    /**
     * Gets the permeability.
     *
     * @return the permeability
     */
    @Override
    public Permeability getPermeability() {
        return this.permeability;
    }

    /**
     * Sets the permeability.
     *
     * @param permeability the new permeability
     */
    @Override
    public void setPermeability(Permeability permeability) {
        this.permeability = permeability;
    }

    /**
     * Gets the position.
     *
     * @return the position
     */
    public Point getPosition() {
        return this.position;
    }

    /**
     * Sets the position.
     *
     * @param position the new position
     */
    public void setPosition(final Point position) {
        this.position = position;
    }

    /**
     * Gets the x.
     *
     * @return the x
     */
    @Override
    public final int getX() {
        return this.getPosition().x;
    }

    /**
     * Sets the x.
     *
     * @param x the new x
     */
    @Override
    public final void setX(int x) {
        this.getPosition().x = x;
    }

    /**
     * Gets the y.
     *
     * @return the y
     */
    @Override
    public final int getY() {
        return this.getPosition().y;
    }

    /**
     * Sets the y.
     *
     * @param y the new y
     */
    @Override
    public final void setY(int y) {
        this.getPosition().y = y;
    }

}