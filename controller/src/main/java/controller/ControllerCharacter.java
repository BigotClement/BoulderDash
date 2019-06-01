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

    final private int exitX = this.getModel().getMap().findExit().getX();

    final private int exitY = this.getModel().getMap().findExit().getY();

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
                this.victoryAnimationCharacter(character.getX(), character.getY());

                break;
            case 'q':
                this.canIncrementDiamond(character, character.getX() - 1, character.getY());
                if ((this.getModel().getMap().getOnTheMapXY(character.getX() - 1, character.getY())
                        .getClass() == MobileEntityFactory.createRock().getClass())
                        && (this.getModel().getMap().getOnTheMapXY(character.getX() - 2, character.getY())
                                .getClass() == MotionlessEntityFactory.createDirt().getClass())) {
                    this.moveLeft(this.getModel().getMap().getMap()[character.getY()][character.getX() - 1]);
                    this.moveLeft(character);
                }
                this.moveLeft(character);
                character.setSpriteFolder("sprites\\Mobile\\Character\\Left");
                this.victoryAnimationCharacter(character.getX(), character.getY());
                break;
            case 's':
                this.canIncrementDiamond(character, character.getX(), character.getY() + 1);
                this.moveDown(character);
                character.setSpriteFolder("sprites\\Mobile\\Character\\Down");
                this.victoryAnimationCharacter(character.getX(), character.getY());
                break;
            case 'd':
                this.canIncrementDiamond(character, character.getX() + 1, character.getY());
                if ((this.getModel().getMap().getOnTheMapXY(character.getX() + 1, character.getY())
                        .getClass() == MobileEntityFactory.createRock().getClass())
                        && (this.getModel().getMap().getOnTheMapXY(character.getX() + 2, character.getY())
                                .getClass() == MotionlessEntityFactory.createDirt().getClass())) {
                    this.moveRight(this.getModel().getMap().getMap()[character.getY()][character.getX() + 1]);
                    this.moveRight(character);
                }
                this.moveRight(character);
                character.setSpriteFolder("sprites\\Mobile\\Character\\Right");
                this.victoryAnimationCharacter(character.getX(), character.getY());
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

    private void openExit() {
        if (this.getDiamondCount() >= 1) {
            this.getModel().getMap().findExit().setPermeability(Permeability.SEMIPENETRABLE);
        }
    }

    public boolean canWin() {
        if ((this.getModel().getMap().findCharacter().getY() == this.exitY)
                && (this.getModel().getMap().findCharacter().getX() == this.exitX)) {
            return true;
        }
        return false;
    }

    public void victoryAnimationCharacter(int x, int y) {
        // System.out.println(this.getModel().getMap().findExit().getX() + "" +
        // this.getModel().getMap().findExit().getY());

        if (this.canWin()) {
            this.getModel().getMap().getOnTheMapXY(x, y)
                    .setSpriteFolder("sprites\\Mobile\\Character\\Victory\\VictoryHey");
            Thread wait = new Thread() {
                @Override
                public void run() {
                    Thread.currentThread();
                    try {
                        Thread.sleep(2000);
                        System.exit(0);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };

            wait.start();
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