/*
 *
 */
package mobile;

import java.awt.Point;
import entity.Entity;

public abstract class MobileEntity extends Entity {

    private String folder;

    private Point position;

    /**
     * @param sprite
     */
    public MobileEntity(char sprite, String folder) {
        super(sprite);
        this.setFolder(folder);
        this.position = new Point();
    }

    public void moveDown() {
        this.setY(this.getY() - 1);
        this.setHasMoved();
    }

    public void moveLeft() {
        this.setY(this.getY() - 1);
        this.setHasMoved();
    }

    public void moveRight() {
        this.setY(this.getY() + 1);
        this.setHasMoved();
    }

    public void moveUp() {
        this.setY(this.getY() + 1);
        this.setHasMoved();
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