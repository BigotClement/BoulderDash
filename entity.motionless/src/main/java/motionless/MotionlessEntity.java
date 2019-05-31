/*
 *
 */
package motionless;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observer;

import javax.imageio.ImageIO;

import entity.Entity;
import entity.Permeability;

public abstract class MotionlessEntity extends Entity {

    private Image image;

    /**
     * @param sprite
     */
    public MotionlessEntity(char sprite, String image, Permeability permeability) {
        super(sprite, permeability);
        this.setImage(image);
    }

    @Override
    public Image getImage() {
        return this.image;
    }

    @Override
    public void setImage(String image) {
        try {
            this.image = ImageIO.read(new File(image));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void setSpriteFolder(String folder) {

    }

    @Override
    public boolean isVerified() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setVerified(boolean b) {

    }

    @Override
    public void setObserver(Observer observer) {

    }

    @Override
    public void die() {

    }

    @Override
    public boolean isAlive() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getY() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setY(int y) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getX() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setX(int x) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setHasMoved() {
        // TODO Auto-generated method stub

    }

}