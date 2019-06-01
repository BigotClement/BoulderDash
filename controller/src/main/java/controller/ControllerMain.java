/*
 *
 */
package controller;

import contract.IControllerMain;
import contract.IModel;
import contract.IView;
import entity.IEntity;

/**
 * The Class ControllerMain.
 */
public class ControllerMain implements IControllerMain {

    /** The controller character. */
    private ControllerCharacter controllerCharacter;
    
    /** The controller rock. */
    private ControllerRock controllerRock;
    
    /** The controller diamond. */
    private ControllerDiamond controllerDiamond;
    
    /** The controller enemy. */
    private ControllerEnemy controllerEnemy;
    
    /** The view. */
    private IView view;
    
    /** The model. */
    private IModel model;
    
    /** The time left. */
    private int timeLeft = 120;

    /**
     * Instantiates a new controller main.
     *
     * @param view the view
     * @param model the model
     */
    public ControllerMain(IView view, IModel model) {
        this.setModel(model);
        this.setView(view);
        this.setControllerCharacter(new ControllerCharacter(view, model));
        this.setControllerRock(new ControllerRock(view, model));
        this.setControllerDiamond(new ControllerDiamond(view, model));
        this.setControllerEnemy(new ControllerEnemy(view, model));
        Thread lookMap = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        ControllerMain.this.lookTheMap();
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            }
        };
        Thread timeRunning = new Thread() {
            @Override
            public void run() {
                boolean canRun = true;
                while (canRun) {
                    try {
                        ControllerMain.this.setTimeLeft(ControllerMain.this.getTimeLeft() - 1);
                        Thread.sleep(1000);
                        if (ControllerMain.this.getTimeLeft() == 0) {
                            IEntity character = ControllerMain.this.getModel().getMap().findCharacter();
                            canRun = false;
                            character.die();
                            ControllerMain.this.getControllerCharacter().dieAnimationCharacter(character.getX(),
                                    character.getY());
                        }
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            }
        };
        lookMap.setDaemon(true);
        lookMap.start();
        timeRunning.setDaemon(true);
        timeRunning.start();
    }

    /**
     * Look the map.
     */
    public void lookTheMap() {
        for (int y = 0; y < this.getModel().getMap().getMap().length; y++) {
            for (int x = 0; x < this.getModel().getMap().getMap()[y].length; x++) {
                this.getModel().getMap().getOnTheMapXY(x, y).setVerified(false);
            }
        }
        for (int y = 0; y < this.getModel().getMap().getMap().length; y++) {
            for (int x = 0; x < this.getModel().getMap().getMap()[y].length; x++) {
                if ((!this.getModel().getMap().getOnTheMapXY(x, y).isVerified())) {
                    this.getControllerRock().move(x, y);
                    this.getControllerDiamond().move(x, y);
                    this.getControllerEnemy().move(x, y);
                    this.getControllerCharacter().checkDie(x, y);
                }
            }
        }
    }

    /**
     * Sets the view.
     *
     * @param view the new view
     */
    public void setView(IView view) {
        this.view = view;
    }

    /**
     * Sets the model.
     *
     * @param model the new model
     */
    public void setModel(IModel model) {
        this.model = model;
    }

    /**
     * Gets the controller character.
     *
     * @return the controller character
     */
    @Override
    public ControllerCharacter getControllerCharacter() {
        return this.controllerCharacter;
    }

    /**
     * Sets the controller character.
     *
     * @param controllerCharacter the new controller character
     */
    public void setControllerCharacter(ControllerCharacter controllerCharacter) {
        this.controllerCharacter = controllerCharacter;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    @Override
    public IModel getModel() {
        // TODO Auto-generated method stub
        return this.model;
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    @Override
    public IView getView() {
        // TODO Auto-generated method stub
        return this.view;
    }

    /**
     * Gets the controller rock.
     *
     * @return the controller rock
     */
    public ControllerRock getControllerRock() {
        return this.controllerRock;
    }

    /**
     * Sets the controller rock.
     *
     * @param controllerRock the new controller rock
     */
    public void setControllerRock(ControllerRock controllerRock) {
        this.controllerRock = controllerRock;
    }

    /**
     * Gets the controller diamond.
     *
     * @return the controller diamond
     */
    public ControllerDiamond getControllerDiamond() {
        return this.controllerDiamond;
    }

    /**
     * Sets the controller diamond.
     *
     * @param controllerDiamond the new controller diamond
     */
    public void setControllerDiamond(ControllerDiamond controllerDiamond) {
        this.controllerDiamond = controllerDiamond;
    }

    /**
     * Gets the controller enemy.
     *
     * @return the controller enemy
     */
    public ControllerEnemy getControllerEnemy() {
        return this.controllerEnemy;
    }

    /**
     * Sets the controller enemy.
     *
     * @param controllerEnemy the new controller enemy
     */
    public void setControllerEnemy(ControllerEnemy controllerEnemy) {
        this.controllerEnemy = controllerEnemy;
    }

    /**
     * Gets the time left.
     *
     * @return the time left
     */
    @Override
    public int getTimeLeft() {
        return this.timeLeft;
    }

    /**
     * Sets the time left.
     *
     * @param timeLeft the new time left
     */
    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

}