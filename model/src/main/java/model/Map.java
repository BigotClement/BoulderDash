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

/**
 * The Class Map.
 */
public class Map extends Observable implements IMap, Observer {

    /** The Constant VIEWWIDTH. */
    private static final int VIEWWIDTH = 16;
    
    /** The Constant VIEWHEIGHT. */
    private static final int VIEWHEIGHT = 16;

    /** The height. */
    private int height;
    
    /** The width. */
    private int width;
    
    /** The map. */
    private volatile IEntity[][] map;
    
    /** The view map. */
    private volatile IEntity[][] viewMap = new Entity[VIEWHEIGHT][VIEWWIDTH];

    /**
     * Instantiates a new map.
     *
     * @param map the map
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

    /**
     * Fill view.
     */
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

    /**
     * Gets the height.
     *
     * @return the height
     */
    @Override
    public int getHeight() {
        return this.height;
    }

    /**
     * Gets the map.
     *
     * @return the map
     */
    @Override
    public IEntity[][] getMap() {
        return this.map;
    }

    /**
     * Gets the observable.
     *
     * @return the observable
     */
    @Override
    public Observable getObservable() {
        return this;
    }

    /**
     * Find character.
     *
     * @return the i entity
     */
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

    /**
     * Find exit.
     *
     * @return the i entity
     */
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
     * Gets the on the map XY.
     *
     * @param x the x
     * @param y the y
     * @return the on the map XY
     */
    @Override
    public IEntity getOnTheMapXY(int x, int y) {

        return this.getMap()[y][x];
    }

    /**
     * Gets the on the view map XY.
     *
     * @param x the x
     * @param y the y
     * @return the on the view map XY
     */
    @Override
    public IEntity getOnTheViewMapXY(int x, int y) {

        return this.getViewMap()[y][x];
    }

    /**
     * Gets the view map.
     *
     * @return the view map
     */
    @Override
    public IEntity[][] getViewMap() {
        return this.viewMap;
    }

    /**
     * Gets the width.
     *
     * @return the width
     */
    @Override
    public int getWidth() {
        return this.width;
    }

    /**
     * Sets the height.
     *
     * @param height the new height
     */
    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Sets the map.
     *
     * @param map the new map
     */
    void setMap(IEntity[][] map) {
        this.map = map;
    }

    /**
     * Sets the on the map XY.
     *
     * @param entity the entity
     * @param x the x
     * @param y the y
     */
    @Override
    public void setOnTheMapXY(IEntity entity, int x, int y) {
        this.getMap()[y][x] = entity;
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Sets the on the view map XY.
     *
     * @param entity the entity
     * @param x the x
     * @param y the y
     */
    @Override
    public void setOnTheViewMapXY(IEntity entity, int x, int y) {
        this.getViewMap()[y][x] = entity;
    }

    /**
     * Sets the on the map XY.
     *
     * @param c the c
     * @param x the x
     * @param y the y
     */
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
     * Sets the width.
     *
     * @param width the new width
     */
    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Update.
     *
     * @param o the o
     * @param arg the arg
     */
    @Override
    public void update(Observable o, Object arg) {
        this.setChanged();
        this.notifyObservers();
    }

}