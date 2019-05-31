/*
 *
 */
package controller;

import contract.IModel;
import contract.IView;
import mobile.MobileEntityFactory;
import java.util.Random;

public class ControllerEnemy extends Controller {

    public ControllerEnemy(IView view, IModel model) {
        super(view, model);
        // TODO Auto-generated constructor stub
    }

    public void move(int x, int y) {

        try {
            if (this.getModel().getMap().getOnTheMapXY(x, y).getClass() == MobileEntityFactory.createEnemy()
                    .getClass()) {
                Random rand = new Random();

                int RandomNumber = rand.nextInt(4);

                switch (RandomNumber) {
                    case 0:
                        if ((this.checkMove(this.getModel().getMap().getOnTheMapXY(x, y),
                                this.getModel().getMap().getOnTheMapXY(x, y).getX() + 1,
                                this.getModel().getMap().getOnTheMapXY(x, y).getY()))) {
                            this.getModel().getMap().getOnTheMapXY(x, y).setVerified(true);
                            this.moveRight(this.getModel().getMap().getOnTheMapXY(x, y));
                            Thread.sleep(300);
                        }
                        break;
                    case 1:
                        if ((this.checkMove(this.getModel().getMap().getOnTheMapXY(x, y),
                                this.getModel().getMap().getOnTheMapXY(x, y).getX(),
                                this.getModel().getMap().getOnTheMapXY(x, y).getY() - 1))) {
                            this.getModel().getMap().getOnTheMapXY(x, y).setVerified(true);
                            this.moveUp(this.getModel().getMap().getOnTheMapXY(x, y));
                            Thread.sleep(300);
                        }
                        break;
                    case 2:
                        if ((this.checkMove(this.getModel().getMap().getOnTheMapXY(x, y),
                                this.getModel().getMap().getOnTheMapXY(x, y).getX() - 1,
                                this.getModel().getMap().getOnTheMapXY(x, y).getY()))) {
                            this.getModel().getMap().getOnTheMapXY(x, y).setVerified(true);
                            this.moveLeft(this.getModel().getMap().getOnTheMapXY(x, y));
                            Thread.sleep(300);
                        }
                        break;
                    case 3:
                        if ((this.checkMove(this.getModel().getMap().getOnTheMapXY(x, y),
                                this.getModel().getMap().getOnTheMapXY(x, y).getX(),
                                this.getModel().getMap().getOnTheMapXY(x, y).getY() + 1))) {
                            this.getModel().getMap().getOnTheMapXY(x, y).setVerified(true);
                            this.moveDown(this.getModel().getMap().getOnTheMapXY(x, y));
                            Thread.sleep(300);
                        }
                        break;
                }
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}