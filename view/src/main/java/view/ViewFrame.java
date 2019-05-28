/*
 *
 */
package view;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import contract.IControllerMain;
import contract.IModel;

/**
 * The Class ViewFrame.
 *
 * @author Jean-Aymeric Diet
 */
class ViewFrame extends JFrame implements KeyListener {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -697358409737458175L;

    /** The controller. */
    private IControllerMain controller;
    /** The model. */
    private IModel model;

    /**
     * Instantiates a new view frame.
     *
     * @param model
     *                  the model
     * @throws HeadlessException
     *                               the headless exception
     */
    public ViewFrame(final IModel model) throws HeadlessException {
        this.buildViewFrame(model);
    }

    /**
     * Instantiates a new view frame.
     *
     * @param model
     *                  the model
     * @param gc
     *                  the gc
     */
    public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
        super(gc);
        this.buildViewFrame(model);
    }

    /**
     * Instantiates a new view frame.
     *
     * @param model
     *                  the model
     * @param title
     *                  the title
     * @throws HeadlessException
     *                               the headless exception
     */
    public ViewFrame(final IModel model, final String title) throws HeadlessException {
        super(title);
        this.buildViewFrame(model);
    }

    /**
     * Instantiates a new view frame.
     *
     * @param model
     *                  the model
     * @param title
     *                  the title
     * @param gc
     *                  the gc
     */
    public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
        super(title, gc);
        this.buildViewFrame(model);
    }

    /**
     * Builds the view frame.
     *
     * @param model
     *                  the model
     */
    private void buildViewFrame(final IModel model) {
        this.setModel(model);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addKeyListener(this);
        this.setContentPane(new ViewPanel(this));
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
    }

    /**
     * Gets the controller.
     *
     * @return the controller
     */
    private IControllerMain getController() {
        return this.controller;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    protected IModel getModel() {
        return this.model;
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
     */
    @Override
    public void keyPressed(final KeyEvent e) {

    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
     */
    @Override
    public void keyReleased(final KeyEvent e) {

    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
     */
    @Override
    public void keyTyped(final KeyEvent e) {

    }

    /**
     * Sets the controller.
     *
     * @param controller
     *                       the new controller
     */
    protected void setController(final IControllerMain controller) {
        this.controller = controller;
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
}
