/*
 *
 */
package controller;

import contract.IModel;
import contract.IView;
import mobile.MobileEntityFactory;

public class ControllerEnemy extends Controller {

    public ControllerEnemy(IView view, IModel model) {
        super(view, model);
        // TODO Auto-generated constructor stub
    }

    public void move(int x, int y) {

        if (this.getModel().getMap().getMap()[y][x].getClass() == MobileEntityFactory.createEnemy().getClass()) {
            if ((this.checkMove(this.getModel().getMap().getMap()[y][x],
                    this.getModel().getMap().getMap()[y][x].getX() + 1,
                    this.getModel().getMap().getMap()[y][x].getY()))) {
                this.getModel().getMap().getMap()[y][x].setVerified(true);
                this.moveRight(this.getModel().getMap().getMap()[y][x]);
            }

            else if (this.getModel().getMap().getMap()[y][x].getClass() == MobileEntityFactory.createEnemy()
                    .getClass()) {
                if ((this.checkMove(this.getModel().getMap().getMap()[y][x],
                        this.getModel().getMap().getMap()[y][x].getX(),
                        this.getModel().getMap().getMap()[y][x].getY() - 1))) {
                    this.getModel().getMap().getMap()[y][x].setVerified(true);
                    this.moveUp(this.getModel().getMap().getMap()[y][x]);
                }
            }

            else if (this.getModel().getMap().getMap()[y][x].getClass() == MobileEntityFactory.createEnemy()
                    .getClass()) {
                if ((this.checkMove(this.getModel().getMap().getMap()[y][x],
                        this.getModel().getMap().getMap()[y][x].getX() - 1,
                        this.getModel().getMap().getMap()[y][x].getY()))) {
                    this.getModel().getMap().getMap()[y][x].setVerified(true);
                    this.moveLeft(this.getModel().getMap().getMap()[y][x]);
                }
            }

            else if (this.getModel().getMap().getMap()[y][x].getClass() == MobileEntityFactory.createEnemy()
                    .getClass()) {
                if ((this.checkMove(this.getModel().getMap().getMap()[y][x],
                        this.getModel().getMap().getMap()[y][x].getX(),
                        this.getModel().getMap().getMap()[y][x].getY() + 1))) {
                    this.getModel().getMap().getMap()[y][x].setVerified(true);
                    this.moveDown(this.getModel().getMap().getMap()[y][x]);
                }
            }
        }

    }

}