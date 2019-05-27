/*
 *
 */
package motionless;

import entity.Entity;

public abstract class MotionlessEntity extends Entity {

    private String image;

    /**
     * @param sprite
     */
    public MotionlessEntity(char sprite, String image) {
        super(sprite);
        this.setImage(image);
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}