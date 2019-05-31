/*
 *
 */
package view;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import contract.IControllerMain;
import contract.IModel;

public class ViewFrame extends JFrame implements KeyListener {

    private static final int FRAMEWIDTH = 1000;

    private static final int FRAMEHEIGHT = 1000;

    /** The model. */
    private IModel model;

    /** The controller. */
    IControllerMain controller;

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -697358409737458175L;

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
     * Gets the controller.
     *
     * @return the controller
     */
    IControllerMain getController() {
        return this.controller;
    }

    /**
     * Sets the controller.
     *
     * @param controller
     *                       the new controller
     */
    public void setController(final IControllerMain controller) {
        this.controller = controller;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }

    /**
     * Sets the model.
     *
     * @param model
     *                  the new model
     */
    void setModel(final IModel model) {
        this.model = model;
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
        this.setResizable(true);
        this.addKeyListener(this);
        this.setContentPane(new ViewPanel(this));
        this.setSize(FRAMEWIDTH, FRAMEHEIGHT);
        this.setLocationRelativeTo(null);
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
     */
    @Override
    public void keyTyped(final KeyEvent key) {
        this.getController().getControllerCharacter().moveSet(key);
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
     */
    @Override
    public void keyPressed(final KeyEvent key) {
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
     */
    @Override
    public void keyReleased(final KeyEvent key) {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.getModel().getMap().findCharacter().setSpriteFolder("sprites\\Mobile\\Character\\Stand");
    }
}
