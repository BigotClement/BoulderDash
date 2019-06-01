/*
 *
 */
package motionless;

import entity.Permeability;

/**
 * The Class DestructibleBlock.
 */
public class DestructibleBlock extends MotionlessEntity {

    /** The image. */
    private static String IMAGE = "sprites\\Motionless\\destructiblebloc.png";
    
    /** The sprite. */
    private static char SPRITE = '+';
    
    /** The permeability. */
    private static Permeability PERMEABILITY = Permeability.SEMIPENETRABLE;

    /**
     * Instantiates a new destructible block.
     */
    public DestructibleBlock() {
        super(SPRITE, IMAGE, PERMEABILITY);
        this.setPermeability(this.getPermeability());
    }

    /**
     * Gets the folder.
     *
     * @return the folder
     */
    @Override
    public String getFolder() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Sets the folder.
     *
     * @param folder the new folder
     */
    @Override
    public void setFolder(String folder) {
        // TODO Auto-generated method stub

    }
}