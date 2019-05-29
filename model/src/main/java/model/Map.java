/*
 *
 */
package model;

import java.util.Observable;
import java.util.Observer;

import contract.IMap;
import entity.Entity;
import entity.IEntity;
import entity.Permeability;
import mobile.MobileEntityFactory;
import motionless.MotionlessEntityFactory;

public class Map extends Observable implements IMap, Observer {

    private int height;
    private int viewWidth = 16, viewHeight = 16;
    private volatile IEntity[][] map;
    private volatile IEntity[][] viewMap = new Entity[this.getViewHeight()][this.getViewWidth()];
    private int width;

    /**
     * @param map
     */
    public Map(char[][] map) {
        this.setMap(new Entity[map.length][map[0].length]);
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                this.setOnTheMapXY(map[y][x], x, y);
            }
        }
        this.fillView();
    }

    @Override
    public void fillView() {
        IEntity character = this.findCharacter();
        for (int y = character.getY() - (this.viewHeight / 2); y < (character.getY() + (this.viewHeight / 2)); y++) {
            for (int x = character.getX() - (this.viewWidth / 2); x < (character.getX() + (this.viewWidth / 2)); x++) {
                try {
                    if ((y < this.getMap().length) && (x < this.getMap()[0].length) && (y >= 0) && (x >= 0)
                            && (MotionlessEntityFactory.createEntity(this.getMap()[y][x].getSprite()) != null)) {
                        this.getViewMap()[y - (character.getY() - (this.getViewHeight() / 2))][x
                                - (character.getX() - (this.getViewWidth() / 2))] = MotionlessEntityFactory
                                        .createEntity(this.getMap()[y][x].getSprite());
                    } else if ((y < this.getMap().length) && (x < this.getMap()[0].length) && (y >= 0) && (x >= 0)
                            && (MobileEntityFactory.createEntity(this.getMap()[y][x].getSprite()) != null)) {
                        this.getViewMap()[y - (character.getY() - (this.getViewHeight() / 2))][x
                                - (character.getX() - (this.getViewWidth() / 2))] = MobileEntityFactory
                                        .createEntity(this.getMap()[y][x].getSprite());
                    } else {
                        this.getViewMap()[y - (character.getY() - (this.getViewHeight() / 2))][x
                                - (character.getX() - (this.getViewWidth() / 2))] = MotionlessEntityFactory
                                        .createDestructibleBlock();
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public boolean checkMove(IEntity mobile, int x, int y) {
        if (mobile.getClass() == MobileEntityFactory.createCharacter().getClass()) {
            if (this.getMap()[y][x].getPermeability() != Permeability.BLOCKING) {
                return true;
            }
        } else if (mobile.getClass() == MobileEntityFactory.createRock().getClass()) {
            if (this.getMap()[y][x].getPermeability() == Permeability.PENETRABLE) {
                return true;
            }
        } else if (mobile.getClass() == MobileEntityFactory.createDiamond().getClass()) {
            if (this.getMap()[y][x].getPermeability() == Permeability.PENETRABLE) {
                return true;
            }
        } else if (mobile.getClass() == MobileEntityFactory.createEnemy().getClass()) {
            if (this.getMap()[y][x].getPermeability() == Permeability.PENETRABLE) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void moveDown(IEntity mobile) {
        if (this.checkMove(mobile, mobile.getX(), mobile.getY() + 1) && ((mobile.getY() + 1) < this.getMap().length)) {
            this.getMap()[mobile.getY() + 1][mobile.getX()] = this.getMap()[mobile.getY()][mobile.getX()];
            this.getMap()[mobile.getY()][mobile.getX()] = MotionlessEntityFactory.createDirt();
            mobile.setY(mobile.getY() + 1);
            this.fillView();
        }
    }

    @Override
    public void moveLeft(IEntity mobile) {
        if (this.checkMove(mobile, mobile.getX() - 1, mobile.getY()) && ((mobile.getX() - 1) >= 0)) {
            this.getMap()[mobile.getY()][mobile.getX() - 1] = this.getMap()[mobile.getY()][mobile.getX()];
            this.getMap()[mobile.getY()][mobile.getX()] = MotionlessEntityFactory.createDirt();
            mobile.setX(mobile.getX() - 1);
            this.fillView();
        }
    }

    @Override
    public void moveRight(IEntity mobile) {
        if (this.checkMove(mobile, mobile.getX() + 1, mobile.getY())
                && ((mobile.getX() + 1) < this.getMap()[0].length)) {
            this.getMap()[mobile.getY()][mobile.getX() + 1] = this.getMap()[mobile.getY()][mobile.getX()];
            this.getMap()[mobile.getY()][mobile.getX()] = MotionlessEntityFactory.createDirt();
            mobile.setX(mobile.getX() + 1);
            this.fillView();
        }
    }

    @Override
    public void moveUp(IEntity mobile) {
        if (this.checkMove(mobile, mobile.getX(), mobile.getY() - 1) && ((mobile.getY() - 1) >= 0)) {
            this.getMap()[mobile.getY() - 1][mobile.getX()] = this.getMap()[mobile.getY()][mobile.getX()];
            this.getMap()[mobile.getY()][mobile.getX()] = MotionlessEntityFactory.createDirt();
            mobile.setY(mobile.getY() - 1);
            this.fillView();
        }
    }

    @Override
    public void moveLeftDown(IEntity mobile) {
        this.moveLeft(mobile);
        this.moveDown(mobile);
    }

    @Override
    public void moveRightDown(IEntity mobile) {
        this.moveRight(mobile);
        this.moveDown(mobile);
    }

    @Override
    public IEntity[][] getMap() {
        return this.map;
    }

    @Override
    public Observable getObservable() {

        return this;
    }

    @Override
    public IEntity findCharacter() {
        int x = 0, y = 0;
        for (y = 0; y < this.getMap().length; y++) {
            for (x = 0; x < this.getMap()[y].length; x++) {
                if (this.getMap()[y][x].getClass() == MobileEntityFactory.createCharacter().getClass()) {
                    return this.getMap()[y][x];
                }
            }
        }
        return null;
    }

    /**
     * @param x
     * @param y
     */
    @Override
    public IEntity getOnTheMapXY(int x, int y) {

        return null;
    }

    public int getViewHeight() {
        return this.viewHeight;
    }

    @Override
    public IEntity[][] getViewMap() {
        return this.viewMap;
    }

    public int getViewWidth() {
        return this.viewWidth;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    /**
     * @param height
     */
    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    private void setMap(IEntity[][] map) {
        this.map = map;
    }

    @Override
    public void setOnTheMapXY(char c, int x, int y) {
        if (MotionlessEntityFactory.createEntity(c) != null) {
            this.getMap()[y][x] = MotionlessEntityFactory.createEntity(c);
            this.getMap()[y][x].setY(y);
            this.getMap()[y][x].setX(x);
            this.getMap()[y][x].setObserver(this);
        } else if (MobileEntityFactory.createEntity(c) != null) {
            this.getMap()[y][x] = MobileEntityFactory.createEntity(c);
            this.getMap()[y][x].setY(y);
            this.getMap()[y][x].setX(x);
            this.getMap()[y][x].setObserver(this);
        } else {
            NullPointerException e = new NullPointerException();
            e.printStackTrace();
        }
    }

    public void setViewHeight(int viewHeight) {
        this.viewHeight = viewHeight;
    }

    @Override
    public void setViewMap(IEntity[][] viewMap) {
        this.viewMap = viewMap;
    }

    public void setViewWidth(int viewWidth) {
        this.viewWidth = viewWidth;
    }

    /**
     * @param width
     */
    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        this.setChanged();
        this.notifyObservers();
    }

}