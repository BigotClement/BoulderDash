/*
 *
 */
package mobile;

public class MobileEntityFactory {

    private static Character CHARACTER = new Character();
    private static Diamond DIAMOND = new Diamond();
    private static Enemy ENEMY = new Enemy();
    private static Rock ROCK = new Rock();

    public static MobileEntity createCharacter() {
        return CHARACTER;
    }

    public static MobileEntity createDiamond() {
        return DIAMOND;
    }

    public static MobileEntity createEnemy() {
        return ENEMY;
    }

    public static MobileEntity createRock() {
        return ROCK;
    }

    /**
     * @param sprite
     */
    public static MobileEntity createEntity(char sprite) {
        // TODO - implement MotionlessEntityFactory.createEntity
        throw new UnsupportedOperationException();
    }

}