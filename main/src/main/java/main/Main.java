/*
 *
 */
package main;

import controller.ControllerMain;
import model.Model;
import view.Menu;
import view.View;

/**
 * The Class Main.
 */
public abstract class Main {

    /** The Constant DIAMONDLIMIT. */
    private static final int DIAMONDLIMIT = 10;

    /** The Constant TIMELIMIT. */
    private static final int TIMELIMIT = 120;

    /**
     * The main method.
     *
     * @param args
     *                 the arguments
     */
    public static void main(final String[] args) {

        Menu frame = new Menu();
        frame.setVisible(true);

        while (frame.getMapID() == 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        if (frame.getMapID() != 0) {
            final Model model = new Model(frame.getMapID());
            frame.dispose();
            final View view = new View(model);
            final ControllerMain controller = new ControllerMain(view, model);
            controller.getControllerCharacter().setDiamondLimit(DIAMONDLIMIT);
            controller.setTimeLeft(TIMELIMIT);
            view.setController(controller);
        }
    }
}
