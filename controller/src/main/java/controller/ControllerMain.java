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