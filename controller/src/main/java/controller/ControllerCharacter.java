/*
 *
 */
package controller;

import java.awt.event.KeyEvent;

import contract.IModel;
import contract.IView;
import mobile.MobileEntityFactory;
import motionless.Exit;

public class ControllerCharacter extends Controller {

    private int diamondCount = 0;

    public int getDiamondCount() {
        return this.diamondCount;
    }

    public void setDiamondCount(int diamondCount) {
        this.diamondCount = diamondCount;
    }

    public ControllerCharacter(IView view, IModel model) {
        super(view, model);
    }

    public void checkMove() {

    }

    @Override
    public void moveSet(KeyEvent key) {

        switch (key.getKeyChar()) {
            case 'z':
                if (this.getModel().getMap().getMap()[this.getModel().getMap().findCharacter().getY() - 1][this
                        .getModel().getMap().findCharacter().getX()].getClass() == MobileEntityFactory.createDiamond()
                                .getClass()) {
                    this.incrementDiamond();
                }
                this.moveUp(this.getModel().getMap().findCharacter());
                this.getModel().getMap().findCharacter().setSpriteFolder("sprites\\Mobile\\Character\\Up");
                break;
            case 'q':
                if (this.getModel().getMap().getMap()[this.getModel().getMap().findCharacter().getY()][this.getModel()
                        .getMap().findCharacter().getX() - 1].getClass() == MobileEntityFactory.createDiamond()
                                .getClass()) {
                    this.incrementDiamond();
                }
                this.moveLeft(this.getModel().getMap().findCharacter());
                this.getModel().getMap().findCharacter().setSpriteFolder("sprites\\Mobile\\Character\\Left");
                break;
            case 's':
                if (this.getModel().getMap().getMap()[this.getModel().getMap().findCharacter().getY() + 1][this
                        .getModel().getMap().findCharacter().getX()].getClass() == MobileEntityFactory.createDiamond()
                                .getClass()) {
                    this.incrementDiamond();
                }
                this.moveDown(this.getModel().getMap().findCharacter());
                this.getModel().getMap().findCharacter().setSpriteFolder("sprites\\Mobile\\Character\\Down");
                break;
            case 'd':
                if (this.getModel().getMap().getMap()[this.getModel().getMap().findCharacter().getY()][this.getModel()
                        .getMap().findCharacter().getX() + 1].getClass() == MobileEntityFactory.createDiamond()
                                .getClass()) {
                    this.incrementDiamond();
                }
                this.moveRight(this.getModel().getMap().findCharacter());
                this.getModel().getMap().findCharacter().setSpriteFolder("sprites\\Mobile\\Character\\Right");
                break;
            default:
                break;
        }
    }

    private void incrementDiamond() {
        this.setDiamondCount(this.getDiamondCount() + 1);
        System.out.println(this.getDiamondCount());
        this.openExit();
    }

    private void openExit() {
        if (this.getDiamondCount() >= 10) {
            // Exit.setPermeability(Permeability.PENETRABLE);
        }
    }
}