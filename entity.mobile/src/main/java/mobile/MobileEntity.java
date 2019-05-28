/*
 *
 */
package mobile;

import java.awt.Point;

import entity.Entity;

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

    public final int getY() {
        return this.getPosition().y;
    }

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