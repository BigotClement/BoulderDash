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

    @Override
    public void moveSet(KeyEvent key) {
        switch (key.getKeyChar()) {
            case 'z':
                this.getModel().getMap().moveUp(this.getModel().getMap().findCharacter());
                break;
            case 'q':
                this.getModel().getMap().moveLeft(this.getModel().getMap().findCharacter());
                break;
            case 's':
                this.getModel().getMap().moveDown(this.getModel().getMap().findCharacter());
                break;
            case 'd':
                this.getModel().getMap().moveRight(this.getModel().getMap().findCharacter());
                break;
            default:
                break;
        }
    }
}