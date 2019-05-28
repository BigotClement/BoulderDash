/*
 *
 */
package controller;

import java.awt.event.KeyEvent;

import contract.IControllerMain;
import contract.IModel;
import contract.IView;

public class ControllerMain implements IControllerMain {

    private ControllerCharacter controllerCharacter;

    /**
     * @param view
     * @param model
     */
    public ControllerMain(IView view, IModel model) {
        this.setControllerCharacter(new ControllerCharacter(view, model));
    }

    @Override
    public void control() {

    }

    /**
     * @param view
     */
    public void setView(IView view) {

    }

    /**
     * @param model
     */
    public void setModel(IModel model) {

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

}