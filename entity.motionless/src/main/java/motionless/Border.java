/*
 *
 */
package motionless;

import entity.Permeability;

public class Border extends MotionlessEntity {

    private static String IMAGE = "sprites\\Motionless\\border.png";
    private static char SPRITE = '#';
    private static Permeability PERMEABILITY = Permeability.BLOCKING;

    public Border() {
        super(SPRITE, IMAGE, PERMEABILITY);
        this.setPermeability(this.getPermeability());
    }

    @Override
    public String getFolder() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setFolder(String folder) {
        // TODO Auto-generated method stub

    }
}