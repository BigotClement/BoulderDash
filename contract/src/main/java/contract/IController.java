/*
 *
 */
package contract;

import java.awt.event.KeyEvent;

/**
 * The Interface IController.
 */
public interface IController {

    /**
     * Gets the model.
     *
     * @return the model
     */
    IModel getModel();

    /**
     * Gets the view.
     *
     * @return the view
     */
    IView getView();

    /**
     * Move set.
     *
     * @param key the key
     */
    void moveSet(KeyEvent key);

    /**
     * Gets the diamond count.
     *
     * @return the diamond count
     */
    int getDiamondCount();

    /**
     * Gets the diamond limit.
     *
     * @return the diamond limit
     */
    int getDiamondLimit();

    /**
     * Sets the diamond limit.
     *
     * @param diamondLimit the new diamond limit
     */
    void setDiamondLimit(int diamondLimit);
}
