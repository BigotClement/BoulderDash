/*
 *
 */
package mobile;

public class Character extends MobileEntity {

    private static char SPRITE = 'H';

    private static String FOLDER = "sprites\\Mobile\\Character\\Stand";

    public Character() {
        super(SPRITE, FOLDER);
    }

    @Override
    public String getImage() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setImage(String image) {
        // TODO Auto-generated method stub

    }

}