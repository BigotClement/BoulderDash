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

}