/*
 *
 */
package model;

import java.util.Observable;
import java.util.Observer;

import contract.IMap;
import entity.Entity;
import entity.IEntity;
import mobile.MobileEntityFactory;
import motionless.MotionlessEntityFactory;

public class Map extends Observable implements IMap, Observer {

    private static final int VIEWWIDTH = 16;
    private static final int VIEWHEIGHT = 16;

    private int height;
    private int width;
    private volatile IEntity[][] map;
    private volatile IEntity[][] viewMap = new Entity[VIEWHEIGHT][VIEWWIDTH];

    /**
     * @param map
     */
    public Map(char[][] map) {
        try {
            this.setMap(new Entity[map.length][map[0].length]);
            for (int y = 0; y < map.length; y++) {
                for (int x = 0; x < map[y].length; x++) {
                    this.setOnTheMapXY(map[y][x], x, y);
                }
            }
            this.fillView();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void fillView() {
        IEntity character = this.findCharacter();
        for (int y = character.getY() - (VIEWHEIGHT / 2); y < (character.getY() + (VIEWHEIGHT / 2)); y++) {
            for (int x = character.getX() - (VIEWWIDTH / 2); x < (character.getX() + (VIEWWIDTH / 2)); x++) {
                try {
                    if (((y < this.getMap().length) && (x < this.getMap()[0].length) && (y >= 0) && (x >= 0)
                            && (this.getOnTheMapXY(x, y) != null))
                            || ((y < this.getMap().length) && (x < this.getMap()[0].length) && (y >= 0) && (x >= 0)
                                    && (this.getOnTheMapXY(x, y) != null))) {
                        this.setOnTheViewMapXY(this.getOnTheMapXY(x, y), x - (character.getX() - (VIEWWIDTH / 2)),
                                y - (character.getY() - (VIEWHEIGHT / 2)));
                    } else {
                        this.setOnTheViewMapXY(MotionlessEntityFactory.createDestructibleBlock(),
                                x - (character.getX() - (VIEWWIDTH / 2)), y - (character.getY() - (VIEWHEIGHT / 2)));
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
                if (this.getOnTheMapXY(x, y).getClass() == MobileEntityFactory.createCharacter().getClass()) {
                    return this.getOnTheMapXY(x, y);
                }
            }
        }
        return null;
    }

    @Override
    public IEntity findExit() {
        int x = 0, y = 0;
        for (y = 0; y < this.getMap().length; y++) {
            for (x = 0; x < this.getMap()[y].length; x++) {
                if (this.getOnTheMapXY(x, y).getClass() == MotionlessEntityFactory.createExit().getClass()) {
                    return this.getOnTheMapXY(x, y);
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

        return this.getMap()[y][x];
    }

    @Override
    public IEntity getOnTheViewMapXY(int x, int y) {

        return this.getViewMap()[y][x];
    }

    @Override
    public IEntity[][] getViewMap() {
        return this.viewMap;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    void setMap(IEntity[][] map) {
        this.map = map;
    }

    @Override
    public void setOnTheMapXY(IEntity entity, int x, int y) {
        this.getMap()[y][x] = entity;
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public void setOnTheViewMapXY(IEntity entity, int x, int y) {
        this.getViewMap()[y][x] = entity;
    }

    @Override
    public void setOnTheMapXY(char c, int x, int y) {
        if (MotionlessEntityFactory.createEntity(c) != null) {
            this.setOnTheMapXY(MotionlessEntityFactory.createEntity(c), x, y);
            this.getOnTheMapXY(x, y).setY(y);
            this.getOnTheMapXY(x, y).setX(x);
            this.getOnTheMapXY(x, y).setObserver(this);
        } else if (MobileEntityFactory.createEntity(c) != null) {
            this.setOnTheMapXY(MobileEntityFactory.createEntity(c), x, y);
            this.getOnTheMapXY(x, y).setY(y);
            this.getOnTheMapXY(x, y).setX(x);
            this.getOnTheMapXY(x, y).setObserver(this);
        } else {
            NullPointerException e = new NullPointerException();
            e.printStackTrace();
        }
        this.setChanged();
        this.notifyObservers();
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
        this.setChanged();
        this.notifyObservers();
    }

}