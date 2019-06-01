/*
 *
 */
package main;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

import controller.ControllerMain;
import model.Model;
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
        int mapID = 0;
        try {
            mapID = Integer.parseInt(JOptionPane.showInputDialog("Choose a mapID (currently implemented : 1,2,3,4,5)"));
        } catch (NumberFormatException e) {
        } catch (HeadlessException e) {
        }
        final Model model = new Model(mapID);
        final View view = new View(model);
        final ControllerMain controller = new ControllerMain(view, model);
        controller.getControllerCharacter().setDiamondLimit(DIAMONDLIMIT);
        controller.setTimeLeft(TIMELIMIT);
        view.setController(controller);
    }
}
