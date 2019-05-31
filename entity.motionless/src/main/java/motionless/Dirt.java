/*
 *
 */
package motionless;

import entity.Permeability;

public class Dirt extends MotionlessEntity {

    private static String IMAGE = "sprites\\Motionless\\dirt.png";
    private static char SPRITE = '-';
    private static Permeability PERMEABILITY = Permeability.PENETRABLE;

    public Dirt() {
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