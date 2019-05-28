/*
 *
 */
package controller;

import java.awt.event.KeyEvent;

import contract.IControllerMain;
import contract.IModel;
import contract.IView;

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

    @Override
    public void control() {

    }

    /**
     * Sets the view.
     *
     * @param pview
     *                  the new view
     */
    private void setView(final IView pview) {
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

    protected IModel getModel() {
        return this.model;
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
}
