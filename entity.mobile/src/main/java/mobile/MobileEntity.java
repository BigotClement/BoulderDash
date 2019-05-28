/*
 *
 */
package mobile;

import java.awt.Point;
import entity.Entity;

public abstract class MobileEntity extends Entity {

    private String folder;

    protected Point position;

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

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(final Point position) {
        this.position = position;
    }

}