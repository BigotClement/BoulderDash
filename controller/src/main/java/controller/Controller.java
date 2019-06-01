/*
 *
 */
package controller;

import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import contract.IController;
import contract.IModel;
import contract.IView;
import entity.IEntity;
import entity.Permeability;
import mobile.MobileEntityFactory;
import motionless.MotionlessEntityFactory;

/**
 * The Class Controller.
 */
public class Controller implements IController {

    /** The view. */
    protected IView view;

    /** The model. */
    protected IModel model;

    /** The diamond limit. */
    private int diamondLimit = 0;

    /**
     * Instantiates a new controller.
     *
     * @param view the view
     * @param model the model
     */
    public Controller(final IView view, final IModel model) {
        this.setView(view);
        this.setModel(model);

    }

    /**
     * Sets the view.
     *
     * @param pview the new view
     */
    void setView(final IView pview) {
        this.view = pview;
    }

    /**
     * Sets the model.
     *
     * @param model the new model
     */
    private void setModel(final IModel model) {
        this.model = model;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    @Override
    public IModel getModel() {
        return this.model;
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    @Override
    public IView getView() {
        return this.view;
    }

    /**
     * Check move.
     *
     * @param mobile the mobile
     * @param x the x
     * @param y the y
     * @return true, if successful
     */
    public boolean checkMove(IEntity mobile, int x, int y) {
        try {
            if ((y >= 0) && (y < this.getModel().getMap().getMap().length) && (x >= 0)
                    && (x < this.getModel().getMap().getMap()[y].length)) {
                if (mobile.getClass() == MobileEntityFactory.createCharacter().getClass()) {
                    if (this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() != Permeability.BLOCKING) {
                        return true;
                    }
                } else if (mobile.getClass() == MobileEntityFactory.createRock().getClass()) {
                    if (this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == Permeability.PENETRABLE) {
                        return true;
                    }
                } else if (mobile.getClass() == MobileEntityFactory.createDiamond().getClass()) {
                    if (this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == Permeability.PENETRABLE) {
                        return true;
                    }
                } else if (mobile.getClass() == MobileEntityFactory.createEnemy().getClass()) {
                    if (this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == Permeability.PENETRABLE) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Move down.
     *
     * @param mobile the mobile
     */
    public void moveDown(IEntity mobile) {
        if (this.checkMove(mobile, mobile.getX(), mobile.getY() + 1)
                && ((mobile.getY() + 1) < this.getModel().getMap().getMap().length)) {
            this.getModel().getMap().getMap()[mobile.getY() + 1][mobile
                    .getX()] = this.getModel().getMap().getMap()[mobile.getY()][mobile.getX()];
            this.getModel().getMap().getMap()[mobile.getY()][mobile.getX()] = MotionlessEntityFactory.createDirt();
            mobile.setY(mobile.getY() + 1);
            this.getModel().getMap().fillView();
        }
    }

    /**
     * Move left.
     *
     * @param mobile the mobile
     */
    public void moveLeft(IEntity mobile) {
        if (this.checkMove(mobile, mobile.getX() - 1, mobile.getY()) && ((mobile.getX() - 1) >= 0)) {
            this.getModel().getMap().getMap()[mobile.getY()][mobile.getX()
                    - 1] = this.getModel().getMap().getMap()[mobile.getY()][mobile.getX()];
            this.getModel().getMap().getMap()[mobile.getY()][mobile.getX()] = MotionlessEntityFactory.createDirt();
            mobile.setX(mobile.getX() - 1);
            this.getModel().getMap().fillView();
        }
    }

    /**
     * Move right.
     *
     * @param mobile the mobile
     */
    public void moveRight(IEntity mobile) {
        if (this.checkMove(mobile, mobile.getX() + 1, mobile.getY())
                && ((mobile.getX() + 1) < this.getModel().getMap().getMap()[0].length)) {
            this.getModel().getMap().getMap()[mobile.getY()][mobile.getX()
                    + 1] = this.getModel().getMap().getMap()[mobile.getY()][mobile.getX()];
            this.getModel().getMap().getMap()[mobile.getY()][mobile.getX()] = MotionlessEntityFactory.createDirt();
            mobile.setX(mobile.getX() + 1);
            this.getModel().getMap().fillView();
        }
    }

    /**
     * Move up.
     *
     * @param mobile the mobile
     */
    public void moveUp(IEntity mobile) {
        if (this.checkMove(mobile, mobile.getX(), mobile.getY() - 1) && ((mobile.getY() - 1) >= 0)) {
            this.getModel().getMap().getMap()[mobile.getY() - 1][mobile
                    .getX()] = this.getModel().getMap().getMap()[mobile.getY()][mobile.getX()];
            this.getModel().getMap().getMap()[mobile.getY()][mobile.getX()] = MotionlessEntityFactory.createDirt();
            mobile.setY(mobile.getY() - 1);
            this.getModel().getMap().fillView();
        }
    }

    /**
     * Move left down.
     *
     * @param mobile the mobile
     */
    public void moveLeftDown(IEntity mobile) {
        this.moveLeft(mobile);
        this.moveDown(mobile);
    }

    /**
     * Move right down.
     *
     * @param mobile the mobile
     */
    public void moveRightDown(IEntity mobile) {
        this.moveRight(mobile);
        this.moveDown(mobile);
    }

    /**
     * Die animation character.
     *
     * @param x the x
     * @param y the y
     */
    public void dieAnimationCharacter(int x, int y) {
        if (this.getModel().getMap().getOnTheMapXY(x, y).isAlive() == false) {
            this.getModel().getMap().getOnTheMapXY(x, y)
                    .setSpriteFolder("sprites\\Mobile\\Character\\Death\\DeathHard");
            this.getModel().getMap().setOnTheMapXY(MotionlessEntityFactory.createStar(), x - 1, y - 1);
            this.getModel().getMap().setOnTheMapXY(MotionlessEntityFactory.createStar(), x - 1, y);
            this.getModel().getMap().setOnTheMapXY(MotionlessEntityFactory.createStar(), x - 1, y + 1);
            this.getModel().getMap().setOnTheMapXY(MotionlessEntityFactory.createStar(), x, y + 1);
            this.getModel().getMap().setOnTheMapXY(MotionlessEntityFactory.createStar(), x + 1, y + 1);
            this.getModel().getMap().setOnTheMapXY(MotionlessEntityFactory.createStar(), x + 1, y);
            this.getModel().getMap().setOnTheMapXY(MotionlessEntityFactory.createStar(), x + 1, y - 1);
            this.getModel().getMap().setOnTheMapXY(MotionlessEntityFactory.createStar(), x, y - 1);
            Thread wait = new Thread() {
                @Override
                public void run() {
                    Thread.currentThread();
                    try {
                        Thread.sleep(2000);
                        JOptionPane.showMessageDialog(null, "You die ! ", "Game Over...", JOptionPane.ERROR_MESSAGE);
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
     * Die animation enemy.
     *
     * @param x the x
     * @param y the y
     */
    public void dieAnimationEnemy(int x, int y) {
        if (this.getModel().getMap().getOnTheMapXY(x, y).isAlive() == false) {

            for (int i = y - 1; i <= (y + 1); i++) {
                for (int j = x - 1; j <= (x + 1); j++) {
                    this.getModel().getMap().setOnTheMapXY(MobileEntityFactory.createDiamond().getSprite(), j, i);
                }
            }
        }
    }

    /**
     * Kill.
     *
     * @param x the x
     * @param y the y
     */
    public void kill(int x, int y) {
        if (this.getModel().getMap().getOnTheMapXY(x, y).getCanKill() == true) {
            if (this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() == MobileEntityFactory.createCharacter()
                    .getClass()) {
                this.getModel().getMap().getOnTheMapXY(x, y + 1).die();
                this.dieAnimationCharacter(x, y + 1);
            } else if (this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() == MobileEntityFactory.createEnemy()
                    .getClass()) {
                this.getModel().getMap().getOnTheMapXY(x, y + 1).die();
                this.dieAnimationEnemy(x, y + 1);
            }
            if ((this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() != MobileEntityFactory.createCharacter()
                    .getClass())
                    && (this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() != MobileEntityFactory.createEnemy()
                            .getClass())
                    && (this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() != MotionlessEntityFactory
                            .createDirt().getClass())) {
                this.getModel().getMap().getOnTheMapXY(x, y).setCanKill(false);
            }
        }
    }

    /**
     * Move set.
     *
     * @param key the key
     */
    @Override
    public void moveSet(KeyEvent key) {
        // TODO Auto-generated method stub

    }

    /**
     * Gets the diamond count.
     *
     * @return the diamond count
     */
    @Override
    public int getDiamondCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Gets the diamond limit.
     *
     * @return the diamond limit
     */
    @Override
    public int getDiamondLimit() {
        return this.diamondLimit;
    }

    /**
     * Sets the diamond limit.
     *
     * @param diamondLimit the new diamond limit
     */
    @Override
    public void setDiamondLimit(int diamondLimit) {
        this.diamondLimit = diamondLimit;
    }
}
