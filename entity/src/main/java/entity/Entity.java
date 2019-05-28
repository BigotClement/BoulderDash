/*
 *
 */
package entity;

public abstract class Entity implements IEntity {
    private char sprite;
    private Permeability permeability;

    /**
     * @param sprite
     */
    public Entity(char sprite, final Permeability permeability) {
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

}