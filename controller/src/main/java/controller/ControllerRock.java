/*
 *
 */
package controller;

import contract.IModel;
import contract.IView;
import mobile.MobileEntityFactory;
import motionless.MotionlessEntityFactory;

public class ControllerRock extends Controller {

    public ControllerRock(IView view, IModel model) {
        super(view, model);
        // TODO Auto-generated constructor stub
    }

    public void move(int x, int y) {

        if (this.getModel().getMap().getMap()[y][x].getClass() == MobileEntityFactory.createRock().getClass()) {
            if ((this.checkMove(this.getModel().getMap().getMap()[y][x], this.getModel().getMap().getMap()[y][x].getX(),
                    this.getModel().getMap().getMap()[y][x].getY() + 1))) {
                this.getModel().getMap().getMap()[y][x].setVerified(true);
                this.moveDown(this.getModel().getMap().getMap()[y][x]);
                this.getModel().getMap().getOnTheMapXY(x, y + 1).canKillTrue();
                this.kill(x, y + 1);

            }

            else if (this.checkMove(this.getModel().getMap().getMap()[y][x],
                    this.getModel().getMap().getMap()[y][x].getX() + 1,
                    this.getModel().getMap().getMap()[y][x].getY() + 1)) {
                if (this.getModel().getMap().getMap()[y + 1][x].getClass() == MobileEntityFactory.createRock()
                        .getClass()) {
                    this.getModel().getMap().getMap()[y][x].setVerified(true);
                    this.moveRightDown(this.getModel().getMap().getMap()[y][x]);
                    this.getModel().getMap().getOnTheMapXY(x, y + 1).canKillTrue();
                    this.kill(x, y + 1);
                }
            }

            else if (this.checkMove(this.getModel().getMap().getMap()[y][x],
                    this.getModel().getMap().getMap()[y][x].getX() - 1,
                    this.getModel().getMap().getMap()[y][x].getY() + 1)) {
                if (this.getModel().getMap().getMap()[y + 1][x].getClass() == MobileEntityFactory.createRock()
                        .getClass()) {
                    this.getModel().getMap().getMap()[y][x].setVerified(true);
                    this.moveLeftDown(this.getModel().getMap().getMap()[y][x]);
                    this.getModel().getMap().getOnTheMapXY(x, y + 1).canKillTrue();
                    this.kill(x, y + 1);
                }
            }
        }
    }

    public void kill(int x, int y) {
        if (this.getModel().getMap().getOnTheMapXY(x, y).getCanKill() == true) {
            if ((this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() == MobileEntityFactory.createCharacter()
                    .getClass())
                    || (this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() == MobileEntityFactory.createEnemy()
                            .getClass())) {
                this.getModel().getMap().getOnTheMapXY(x, y + 1).die();
                this.dieAnimation(x, y + 1);
            }
            if ((this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() != MobileEntityFactory.createCharacter()
                    .getClass())
                    && (this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() != MobileEntityFactory.createEnemy()
                            .getClass())
                    && (this.getModel().getMap().getOnTheMapXY(x, y + 1).getClass() != MotionlessEntityFactory
                            .createDirt().getClass())) {
                this.getModel().getMap().getOnTheMapXY(x, y).canKillFalse();
            }
        }
    }

}