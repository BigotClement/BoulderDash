/*
 *
 */
package motionless;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;

public abstract class MotionlessEntity extends Entity {

    private Image image;

    /**
     * @param sprite
     */
    public MotionlessEntity(char sprite, String image) {
        super(sprite);
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

}