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
public interface IControllerMain {

    void moveSet(KeyEvent key);

    IControllerMain getControllerCharacter();

    IModel getModel();

    IView getView();

    int getDiamondCount();

    int getTimeLeft();

}
