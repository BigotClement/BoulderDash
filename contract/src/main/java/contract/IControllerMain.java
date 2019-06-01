/*
 *
 */
package contract;

/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 */
public interface IControllerMain {

    IController getControllerCharacter();

    IModel getModel();

    IView getView();

    int getTimeLeft();

}
