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

    /**
     * Control.
     */
    void control();

    void moveSet(KeyEvent key);

    IControllerMain getControllerCharacter();

}
