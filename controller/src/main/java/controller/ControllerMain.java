/*
 *
 */
package controller;

import contract.IControllerMain;
import contract.IModel;
import contract.IView;
import entity.IEntity;

public class ControllerMain implements IControllerMain {

    private ControllerCharacter controllerCharacter;
    private ControllerRock controllerRock;
    private ControllerDiamond controllerDiamond;
    private ControllerEnemy controllerEnemy;
    private IView view;
    private IModel model;
    private int timeLeft = 120;

    /**
     * @param view
     * @param model
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
                        Thread.sleep(150);
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
     * @param view
     */
    public void setView(IView view) {
        this.view = view;
    }

    /**
     * @param model
     */
    public void setModel(IModel model) {
        this.model = model;
    }

    @Override
    public ControllerCharacter getControllerCharacter() {
        return this.controllerCharacter;
    }

    public void setControllerCharacter(ControllerCharacter controllerCharacter) {
        this.controllerCharacter = controllerCharacter;
    }

    @Override
    public IModel getModel() {
        // TODO Auto-generated method stub
        return this.model;
    }

    @Override
    public IView getView() {
        // TODO Auto-generated method stub
        return this.view;
    }

    public ControllerRock getControllerRock() {
        return this.controllerRock;
    }

    public void setControllerRock(ControllerRock controllerRock) {
        this.controllerRock = controllerRock;
    }

    public ControllerDiamond getControllerDiamond() {
        return this.controllerDiamond;
    }

    public void setControllerDiamond(ControllerDiamond controllerDiamond) {
        this.controllerDiamond = controllerDiamond;
    }

    public ControllerEnemy getControllerEnemy() {
        return this.controllerEnemy;
    }

    public void setControllerEnemy(ControllerEnemy controllerEnemy) {
        this.controllerEnemy = controllerEnemy;
    }

    @Override
    public int getTimeLeft() {
        return this.timeLeft;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

}