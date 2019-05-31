/*
 *
 */
package mobile;

import java.awt.Point;
import java.util.Observer;

import entity.Entity;
import entity.Permeability;

public abstract class MobileEntity extends Entity {

    private String folder;

    protected Point position;

    private boolean verified = false;

    /**
     * @param sprite
     * @param pERMEABILITY
     */
    public MobileEntity(char sprite, String folder, Permeability permeability) {
        super(sprite, permeability);
        this.setFolder(folder);
        this.position = new Point();
    }

    @Override
    public String getFolder() {
        return this.folder;
    }

    @Override
    public void setSpriteFolder(String folder) {

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

    @Override
    public void setHasMoved() {
        // TODO Auto-generated method stub

    }

    @Override
    public void setObserver(Observer observer) {

    }

    @Override
    public boolean isVerified() {
        return this.verified;
    }

    @Override
    public void setVerified(boolean b) {
        this.verified = b;
    }

    @Override
    public void die() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isAlive() {
        // TODO Auto-generated method stub
        return false;
    }

}