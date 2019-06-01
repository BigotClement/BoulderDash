/*
 *
 */
package contract;

/**
 * The Interface IControllerMain.
 */
public interface IControllerMain {

    /**
     * Gets the controller character.
     *
     * @return the controller character
     */
    IController getControllerCharacter();

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
     * Gets the time left.
     *
     * @return the time left
     */
    int getTimeLeft();

}
