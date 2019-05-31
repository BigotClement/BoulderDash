/*
 *
 */
package controller;

import java.awt.event.KeyEvent;

import contract.IControllerMain;
import contract.IModel;
import contract.IView;
import entity.IEntity;
import entity.Permeability;
import mobile.MobileEntityFactory;
import motionless.MotionlessEntityFactory;

/**
 * The Class Controller.
 */
public class Controller implements IControllerMain {

    /** The view. */
    protected IView view;

    /** The model. */
    protected IModel model;

    /**
     * Instantiates a new controller.
     *
     * @param view
     *                  the view
     * @param model
     *                  the model
     */
    public Controller(final IView view, final IModel model) {
        this.setView(view);
        this.setModel(model);

    }

    /**
     * Sets the view.
     *
     * @param pview
     *                  the new view
     */
    void setView(final IView pview) {
        this.view = pview;
    }

    /**
     * Sets the model.
     *
     * @param model
     *                  the new model
     */
    private void setModel(final IModel model) {
        this.model = model;
    }

    @Override
    public IModel getModel() {
        return this.model;
    }

    @Override
    public IView getView() {
        return this.view;
    }

    @Override
    public void moveSet(KeyEvent key) {
        // TODO Auto-generated method stub

    }

    @Override
    public IControllerMain getControllerCharacter() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean checkMove(IEntity mobile, int x, int y) {
        if (mobile.getClass() == MobileEntityFactory.createCharacter().getClass()) {
            if (this.getModel().getMap().getMap()[y][x].getPermeability() != Permeability.BLOCKING) {
                return true;
            }
        } else if (mobile.getClass() == MobileEntityFactory.createRock().getClass()) {
            if (this.getModel().getMap().getMap()[y][x].getPermeability() == Permeability.PENETRABLE) {
                return true;
            }
        } else if (mobile.getClass() == MobileEntityFactory.createDiamond().getClass()) {
            if (this.getModel().getMap().getMap()[y][x].getPermeability() == Permeability.PENETRABLE) {
                return true;
            }
        } else if (mobile.getClass() == MobileEntityFactory.createEnemy().getClass()) {
            if (this.getModel().getMap().getMap()[y][x].getPermeability() == Permeability.PENETRABLE) {
                return true;
            }
        }
        return false;
    }

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

    public void moveLeft(IEntity mobile) {
        if (this.checkMove(mobile, mobile.getX() - 1, mobile.getY()) && ((mobile.getX() - 1) >= 0)) {
            this.getModel().getMap().getMap()[mobile.getY()][mobile.getX()
                    - 1] = this.getModel().getMap().getMap()[mobile.getY()][mobile.getX()];
            this.getModel().getMap().getMap()[mobile.getY()][mobile.getX()] = MotionlessEntityFactory.createDirt();
            mobile.setX(mobile.getX() - 1);
            this.getModel().getMap().fillView();
        }
    }

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

    public void moveUp(IEntity mobile) {
        if (this.checkMove(mobile, mobile.getX(), mobile.getY() - 1) && ((mobile.getY() - 1) >= 0)) {
            this.getModel().getMap().getMap()[mobile.getY() - 1][mobile
                    .getX()] = this.getModel().getMap().getMap()[mobile.getY()][mobile.getX()];
            this.getModel().getMap().getMap()[mobile.getY()][mobile.getX()] = MotionlessEntityFactory.createDirt();
            mobile.setY(mobile.getY() - 1);
            this.getModel().getMap().fillView();
        }
    }

    public void moveLeftDown(IEntity mobile) {
        this.moveLeft(mobile);
        this.moveDown(mobile);
    }

    public void moveRightDown(IEntity mobile) {
        this.moveRight(mobile);
        this.moveDown(mobile);
    }

    public void dieAnimation(int x, int y) {
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

    public void kill(int x, int y) {
        if (this.getModel().getMap().getOnTheMapXY(x, y).getCanKill() == true) {
            if ((this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() == MobileEntityFactory.createCharacter()
                    .getClass())
                    || (this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() == MobileEntityFactory.createEnemy()
                            .getClass())) {
                this.getModel().getMap().getOnTheMapXY(x, y + 1).die();
                this.dieAnimation(x, y + 1);
            }
            if ((this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() != MobileEntityFactory.createCharacter()
                    .getClass())
                    && (this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() != MobileEntityFactory.createEnemy()
                            .getClass())
                    && (this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() != MotionlessEntityFactory
                            .createDirt().getClass())) {
                this.getModel().getMap().getOnTheMapXY(x, y).canKillFalse();
            }
        }
    }

    @Override
    public int getDiamondCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getTimeLeft() {
        // TODO Auto-generated method stub
        return 0;
    }
}
