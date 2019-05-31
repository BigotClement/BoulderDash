/*
 *
 */
package controller;

import java.awt.event.KeyEvent;
import contract.IModel;
import contract.IView;
import entity.IEntity;
import entity.Permeability;
import mobile.MobileEntityFactory;
import motionless.MotionlessEntityFactory;

public class ControllerCharacter extends Controller {

    private int diamondCount = 0;

    @Override
    public int getDiamondCount() {
        return this.diamondCount;
    }

    public void setDiamondCount(int diamondCount) {
        this.diamondCount = diamondCount;
    }

    public ControllerCharacter(IView view, IModel model) {
        super(view, model);
    }

    @Override
    public void moveSet(KeyEvent key) {

        IEntity character = this.getModel().getMap().findCharacter();
        this.checkDie(character.getX(), character.getY());
        switch (key.getKeyChar()) {
            case 'z':
                this.canIncrementDiamond(character, character.getX(), character.getY() - 1);
                this.moveUp(character);
                character.setSpriteFolder("sprites\\Mobile\\Character\\Up");
                this.CharacterOnExit(character, character.getX(), character.getY());
                break;
            case 'q':
                this.canIncrementDiamond(character, character.getX() - 1, character.getY());
                if ((this.getModel().getMap().getMap()[character.getY()][character.getX() - 1]
                        .getClass() == MobileEntityFactory.createRock().getClass())
                        && (this.getModel().getMap().getMap()[character.getY()][character.getX() - 2]
                                .getClass() == MotionlessEntityFactory.createDirt().getClass())) {
                    this.moveLeft(this.getModel().getMap().getMap()[character.getY()][character.getX() - 1]);
                    this.moveLeft(character);
                }
                this.moveLeft(character);
                character.setSpriteFolder("sprites\\Mobile\\Character\\Left");
                this.CharacterOnExit(character, character.getX(), character.getY());
                break;
            case 's':
                this.canIncrementDiamond(character, character.getX(), character.getY() + 1);
                this.moveDown(character);
                character.setSpriteFolder("sprites\\Mobile\\Character\\Down");
                this.CharacterOnExit(character, character.getX(), character.getY());
                break;
            case 'd':
                this.canIncrementDiamond(character, character.getX() + 1, character.getY());
                if ((this.getModel().getMap().getMap()[character.getY()][character.getX() + 1]
                        .getClass() == MobileEntityFactory.createRock().getClass())
                        && (this.getModel().getMap().getMap()[character.getY()][character.getX() + 2]
                                .getClass() == MotionlessEntityFactory.createDirt().getClass())) {
                    this.moveRight(this.getModel().getMap().getMap()[character.getY()][character.getX() + 1]);
                    this.moveRight(character);
                }
                this.moveRight(character);
                character.setSpriteFolder("sprites\\Mobile\\Character\\Right");
                this.CharacterOnExit(character, character.getX(), character.getY());
                break;
            default:
                break;
        }
    }

    private void canIncrementDiamond(IEntity character, int x, int y) {
        if (this.getModel().getMap().getOnTheMapXY(x, y).getClass() == MobileEntityFactory.createDiamond().getClass()) {
            this.incrementDiamond();
        }
    }

    private int incrementDiamond() {
        this.setDiamondCount(this.getDiamondCount() + 1);
        this.openExit();
        return this.getDiamondCount();
    }

    private String openExit() {
        if (this.getDiamondCount() >= 10) {
            this.getModel().getMap().findExit().setPermeability(Permeability.PENETRABLE);
            return "Go to EXIT !";
        }
        return null;
    }

    public void CharacterOnExit(IEntity character, int x, int y) {
        if ((this.getModel().getMap().findExit().getPermeability() == Permeability.PENETRABLE) && (this.getModel()
                .getMap().getOnTheMapXY(x, y).getClass() == MotionlessEntityFactory.createExit().getClass())) {
            character.setSpriteFolder("sprites\\Mobile\\Character\\Victory\\Victory2");
            System.out.println("test");
        }
    }

    public void checkDie(int x, int y) {

        if (this.getModel().getMap().getOnTheMapXY(x, y).getClass() == MobileEntityFactory.createCharacter()
                .getClass()) {
            if ((this.getModel().getMap().getOnTheMapXY(x - 1, y).getClass() == MobileEntityFactory.createEnemy()
                    .getClass())
                    || (this.getModel().getMap().getOnTheMapXY(x + 1, y).getClass() == MobileEntityFactory.createEnemy()
                            .getClass())
                    || (this.getModel().getMap().getOnTheMapXY(x, y - 1).getClass() == MobileEntityFactory.createEnemy()
                            .getClass())
                    || (this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() == MobileEntityFactory.createEnemy()
                            .getClass())) {
                this.getModel().getMap().getOnTheMapXY(x, y).die();
                this.dieAnimationCharacter(x, y);
            }
        }
    }
}