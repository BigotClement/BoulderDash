/*
 *
 */
package entity;

import java.awt.Point;

public abstract class Entity implements IEntity {
    private char sprite;
    private Permeability permeability;
    protected Point position = new Point();

    /**
     * @param sprite
     */
    public Entity(char sprite, Permeability permeability) {
        this.setSprite(sprite);
        this.setPermeability(permeability);
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

    @Override
    public Permeability getPermeability() {
        return this.permeability;
    }

    @Override
    public void setPermeability(Permeability permeability) {
        this.permeability = permeability;
    }

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(final Point position) {
        this.position = position;
    }

    @Override
    public final int getX() {
        return this.getPosition().x;
    }

    @Override
    public final void setX(int x) {
        this.getPosition().x = x;
    }

    @Override
    public final int getY() {
        return this.getPosition().y;
    }

    @Override
    public final void setY(int y) {
        this.getPosition().y = y;
    }

}