/*
 *
 */
package view;

import javax.swing.SwingUtilities;
import contract.IControllerMain;
import contract.IModel;
import contract.IView;
import contract.IViewFrame;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public final class View implements IView, Runnable {

    /** The frame. */
    private final ViewFrame viewFrame;

    /**
     * Instantiates a new view.
     *
     * @param model
     *                  the model
     */
    public View(final IModel model) {
        this.viewFrame = new ViewFrame(model);
        SwingUtilities.invokeLater(this);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        this.viewFrame.setVisible(true);
    }

    /**
     * Sets the controller.
     *
     * @param controller
     *                       the new controller
     */
    @Override
    public void setController(final IControllerMain controller) {
        this.viewFrame.setController(controller);
    }

    public Object getController() {
        return null;
    }

    @Override
    public IViewFrame getViewFrame() {
        return this.viewFrame;
    }
}
