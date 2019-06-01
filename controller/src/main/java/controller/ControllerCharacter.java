/*
 *
 */
package controller;

import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import contract.IModel;
import contract.IView;
import entity.IEntity;
import entity.Permeability;
import mobile.MobileEntityFactory;
import motionless.MotionlessEntityFactory;

/**
 * The Class ControllerCharacter.
 */
public class ControllerCharacter extends Controller {

    /** The diamond count. */
    private int diamondCount = 0;

    /** The exit X. */
    private int exitX = 0;

    /** The exit Y. */
    private int exitY = 0;

    /**
     * Gets the diamond count.
     *
     * @return the diamond count
     */
    @Override
    public int getDiamondCount() {
        return this.diamondCount;
    }

    /**
     * Sets the diamond count.
     *
     * @param diamondCount
     *                         the new diamond count
     */
    public void setDiamondCount(int diamondCount) {
        this.diamondCount = diamondCount;
    }

    /**
     * Instantiates a new controller character.
     *
     * @param view
     *                  the view
     * @param model
     *                  the model
     */
    public ControllerCharacter(IView view, IModel model) {
        super(view, model);
        this.setDiamondLimit(10);
        try {
            this.exitX = this.getModel().getMap().findExit().getX();
            this.exitY = this.getModel().getMap().findExit().getY();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Move set.
     *
     * @param key
     *                the key
     */
    @Override
    public void moveSet(KeyEvent key) {

        IEntity character = this.getModel().getMap().findCharacter();
        this.checkDie(character.getX(), character.getY());
        if (character.isAlive()) {
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
    }

    /**
     * Can increment diamond.
     *
     * @param character
     *                      the character
     * @param x
     *                      the x
     * @param y
     *                      the y
     */
    private void canIncrementDiamond(IEntity character, int x, int y) {
        if (this.getModel().getMap().getOnTheMapXY(x, y).getClass() == MobileEntityFactory.createDiamond().getClass()) {
            this.incrementDiamond();
        }
    }

    /**
     * Increment diamond.
     *
     * @return the int
     */
    private int incrementDiamond() {
        this.setDiamondCount(this.getDiamondCount() + 1);
        this.openExit();
        return this.getDiamondCount();
    }

    /**
     * Open exit.
     */
    private void openExit() {
        if (this.getDiamondCount() >= this.getDiamondLimit()) {
            this.getModel().getMap().findExit().setPermeability(Permeability.SEMIPENETRABLE);
        }
    }

    /**
     * Can win.
     *
     * @return true, if successful
     */
    public boolean canWin() {
        try {
            if ((this.getModel().getMap().findCharacter().getY() == this.exitY)
                    && (this.getModel().getMap().findCharacter().getX() == this.exitX)) {
                return true;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Victory animation character.
     *
     * @param x
     *              the x
     * @param y
     *              the y
     */
    public void victoryAnimationCharacter(int x, int y) {
        if (this.canWin()) {
            this.getModel().getMap().getOnTheMapXY(x, y).die();
            this.getModel().getMap().getOnTheMapXY(x, y)
                    .setSpriteFolder("sprites\\Mobile\\Character\\Victory\\VictoryHey");
            Thread wait = new Thread() {
                @Override
                public void run() {
                    Thread.currentThread();
                    try {
                        Thread.sleep(2000);
                        JOptionPane.showMessageDialog(null, "You win ! ", "Victory !", JOptionPane.INFORMATION_MESSAGE);
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

    /**
     * Check die.
     *
     * @param x
     *              the x
     * @param y
     *              the y
     */
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