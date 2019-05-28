/*
 *
 */
package mobile;

import java.awt.Point;

import entity.Entity;
import entity.IEntity;

public abstract class MobileEntity extends Entity {

    private String folder;

    private int x, y;

    private Point position;

    /**
     * @param sprite
     */
    public MobileEntity(char sprite, String folder) {
        super(sprite);
        this.setFolder(folder);
        this.position = new Point();
    }

    public void moveDown(IEntity mobileEntity) {
        mobileEntity.setY(mobileEntity.getY() - 1);
        mobileEntity.setHasMoved();
    }

    public void moveLeft(IEntity mobileEntity) {
        mobileEntity.setY(mobileEntity.getY() - 1);
        mobileEntity.setHasMoved();
    }

    public void moveRight(IEntity mobileEntity) {
        mobileEntity.setY(mobileEntity.getY() + 1);
        mobileEntity.setHasMoved();
    }

    public void moveUp(IEntity mobileEntity) {
        mobileEntity.setY(mobileEntity.getY() + 1);
        mobileEntity.setHasMoved();
    }

    @Override
    public String getFolder() {
        return this.folder;
    }

    @Override
    public void setFolder(String folder) {
        this.folder = folder;
    }

    public final int getX() {
        return this.getPosition().x;
    }

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

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(final Point position) {
        this.position = position;
    }

}