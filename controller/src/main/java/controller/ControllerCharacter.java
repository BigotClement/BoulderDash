/*
 *
 */
package controller;

import java.awt.event.KeyEvent;

import contract.IModel;
import contract.IView;

public class ControllerCharacter extends Controller {

    public ControllerCharacter(IView view, IModel model) {
        super(view, model);
    }

    public void checkMove() {

    }

    @Override
    public void moveSet(KeyEvent key) {
        switch (key.getKeyChar()) {
            case 'z':
                System.out.println(key.getKeyChar());
                this.getModel().getMap().moveUp();
                break;
            case 'q':
                // this.getModel().getMap().moveRight(this.character);
                break;
            case 's':
                // this.getModel().getMap().moveDown(this.character);
                break;
            case 'd':
                // this.getModel().getMap().moveLeft(this.character);
                break;
            default:
                break;
        }
    }
}