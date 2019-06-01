/*
 *
 */
package controller;

import contract.IModel;
import contract.IView;
import mobile.MobileEntityFactory;

public class ControllerRock extends Controller {

    public ControllerRock(IView view, IModel model) {
        super(view, model);
        // TODO Auto-generated constructor stub
    }

    public void move(int x, int y) {

        if (this.getModel().getMap().getOnTheMapXY(x, y).getClass() == MobileEntityFactory.createRock().getClass()) {
            if ((this.checkMove(this.getModel().getMap().getOnTheMapXY(x, y),
                    this.getModel().getMap().getOnTheMapXY(x, y).getX(),
                    this.getModel().getMap().getOnTheMapXY(x, y).getY() + 1))) {
                this.getModel().getMap().getOnTheMapXY(x, y).setVerified(true);
                this.moveDown(this.getModel().getMap().getOnTheMapXY(x, y));
                this.getModel().getMap().getOnTheMapXY(x, y + 1).canKillTrue();
                this.kill(x, y + 1);

            }

            else if (this.checkMove(this.getModel().getMap().getOnTheMapXY(x, y),
                    this.getModel().getMap().getOnTheMapXY(x, y).getX() + 1,
                    this.getModel().getMap().getOnTheMapXY(x, y).getY() + 1)) {
                if (this.getModel().getMap().getMap()[y + 1][x].getClass() == MobileEntityFactory.createRock()
                        .getClass()) {
                    this.getModel().getMap().getOnTheMapXY(x, y).setVerified(true);
                    this.moveRightDown(this.getModel().getMap().getOnTheMapXY(x, y));
                    this.getModel().getMap().getOnTheMapXY(x, y + 1).canKillTrue();
                    this.kill(x, y + 1);
                }
            }

            else if (this.checkMove(this.getModel().getMap().getOnTheMapXY(x, y),
                    this.getModel().getMap().getOnTheMapXY(x, y).getX() - 1,
                    this.getModel().getMap().getOnTheMapXY(x, y).getY() + 1)) {
                if (this.getModel().getMap().getMap()[y + 1][x].getClass() == MobileEntityFactory.createRock()
                        .getClass()) {
                    this.getModel().getMap().getOnTheMapXY(x, y).setVerified(true);
                    this.moveLeftDown(this.getModel().getMap().getOnTheMapXY(x, y));
                    this.getModel().getMap().getOnTheMapXY(x, y + 1).canKillTrue();
                    this.kill(x, y + 1);
                }
            }
        }
    }

}