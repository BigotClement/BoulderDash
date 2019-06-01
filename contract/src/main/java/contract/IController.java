/*
 *
 */
package contract;

import java.awt.event.KeyEvent;

/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 */
public interface IController {

    IModel getModel();

    IView getView();

    void moveSet(KeyEvent key);

    int getDiamondCount();

    int getDiamondLimit();

    void setDiamondLimit(int diamondLimit);
}
