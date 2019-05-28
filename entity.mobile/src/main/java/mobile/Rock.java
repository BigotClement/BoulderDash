/*
 *
 */
package mobile;

public class Rock extends MobileEntity {

    private static char SPRITE = 'O';

    private static String FOLDER = "sprites\\Mobile\\Rock";

    public Rock() {
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