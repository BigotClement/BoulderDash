/*
 *
 */
package mobile;

import entity.Entity;

public abstract class MobileEntity extends Entity {

    private String folder;

    /**
     * @param sprite
     */
    public MobileEntity(char sprite, String folder) {
        super(sprite);
        this.setFolder(folder);
    }

    public String getFolder() {
        return this.folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

}