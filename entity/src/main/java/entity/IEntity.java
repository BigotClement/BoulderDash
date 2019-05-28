/*
 *
 */
package entity;

public interface IEntity {

    char getSprite();

    /**
     * @param sprite
     */
    void setSprite(char sprite);

    String getImage();

    void setImage(String image);

    String getFolder();

    void setFolder(String folder);

}