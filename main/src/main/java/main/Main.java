/*
 *
 */
package main;

import controller.ControllerMain;
import model.Model;
import view.View;

public abstract class Main {

    private static final int MAPID = 3;

    private static final int DIAMONDLIMIT = 10;

    private static final int TIMELIMIT = 120;

    /**
     * The main method.
     *
     * @param args
     *                 the arguments
     */
    public static void main(final String[] args) {
        final Model model = new Model(MAPID);
        final View view = new View(model);
        final ControllerMain controller = new ControllerMain(view, model);
        controller.getControllerCharacter().setDiamondLimit(DIAMONDLIMIT);
        controller.setTimeLeft(TIMELIMIT);
        view.setController(controller);
    }
}
