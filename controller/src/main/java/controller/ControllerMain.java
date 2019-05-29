/*
 *
 */
package controller;

import java.awt.event.KeyEvent;

import contract.IControllerMain;
import contract.IModel;
import contract.IView;
import mobile.MobileEntityFactory;
import motionless.MotionlessEntityFactory;

public class ControllerMain implements IControllerMain {

    private ControllerCharacter controllerCharacter;
    private IView view;
    private IModel model;

    /**
     * @param view
     * @param model
     */
    public ControllerMain(IView view, IModel model) {
        this.setModel(model);
        this.setView(view);
        this.setControllerCharacter(new ControllerCharacter(view, model));
        Thread lookMap = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        ControllerMain.this.lookTheMap();
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (ArrayIndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        lookMap.setDaemon(true);
        lookMap.start();
    }

    public void lookTheMap() {
        for (int y = 0; y < this.getModel().getMap().getMap().length; y++) {
            for (int x = 0; x < this.getModel().getMap().getMap()[y].length; x++) {
                this.getModel().getMap().getMap()[y][x].setVerified(false);
            }
        }
        for (int y = 0; y < this.getModel().getMap().getMap().length; y++) {
            for (int x = 0; x < this.getModel().getMap().getMap()[y].length; x++) {
                if ((!this.getModel().getMap().getMap()[y][x].isVerified())) {
                    if ((this.getModel().getMap().getMap()[y][x].getClass() == MobileEntityFactory.createRock()
                            .getClass())
                            || (this.getModel().getMap().getMap()[y][x].getClass() == MobileEntityFactory
                                    .createDiamond().getClass())) {
                        if ((this.getModel().getMap().checkMove(this.getModel().getMap().getMap()[y][x],
                                this.getModel().getMap().getMap()[y][x].getX(),
                                this.getModel().getMap().getMap()[y][x].getY() + 1))) {
                            this.getModel().getMap().getMap()[y][x].setVerified(true);
                            this.getModel().getMap().moveDown(this.getModel().getMap().getMap()[y][x]);
                        }

                        else if (this.getModel().getMap().checkMove(this.getModel().getMap().getMap()[y][x],
                                this.getModel().getMap().getMap()[y][x].getX() + 1,
                                this.getModel().getMap().getMap()[y][x].getY() + 1)) {
                            if ((this.getModel().getMap().getMap()[y + 1][x].getClass() == MobileEntityFactory
                                    .createRock().getClass())
                                    || (this.getModel().getMap().getMap()[y + 1][x].getClass() == MobileEntityFactory
                                            .createDiamond().getClass())) {
                                this.getModel().getMap().getMap()[y][x].setVerified(true);
                                this.getModel().getMap().moveRightDown(this.getModel().getMap().getMap()[y][x]);
                            }
                        }

                        else if (this.getModel().getMap().checkMove(this.getModel().getMap().getMap()[y][x],
                                this.getModel().getMap().getMap()[y][x].getX() - 1,
                                this.getModel().getMap().getMap()[y][x].getY() + 1)) {
                            if ((this.getModel().getMap().getMap()[y + 1][x].getClass() == MobileEntityFactory
                                    .createRock().getClass())
                                    || (this.getModel().getMap().getMap()[y + 1][x].getClass() == MobileEntityFactory
                                            .createDiamond().getClass())) {
                                this.getModel().getMap().getMap()[y][x].setVerified(true);
                                this.getModel().getMap().moveLeftDown(this.getModel().getMap().getMap()[y][x]);
                            }
                        }
                    }
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
    public void moveSet(KeyEvent key) {
        // TODO Auto-generated method stub

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

}