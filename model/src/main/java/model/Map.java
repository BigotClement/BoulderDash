/*
 *
 */
package model;

import java.util.Observable;

import entity.Entity;
import entity.IEntity;
import mobile.MobileEntityFactory;
import motionless.MotionlessEntityFactory;

public class Map implements IMap {

    private int width;
    private int height;
    private int viewWidth = 15, viewHeight = 15;
    private IEntity[][] map, viewMap = new Entity[this.getViewHeight()][this.getViewWidth()];

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
    public int getWidth() {
        return this.width;
    }

    /**
     * @param width
     */
    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    /**
     * @param height
     */
    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @param x
     * @param y
     */
    @Override
    public IEntity getOnTheMapXY(int x, int y) {

        return null;
    }

    @Override
    public void setOnTheMapXY(char c, int x, int y) {
        if (MotionlessEntityFactory.createEntity(c) != null) {
            this.getMap()[y][x] = MotionlessEntityFactory.createEntity(c);
        } else if (MobileEntityFactory.createEntity(c) != null) {
            this.getMap()[y][x] = MobileEntityFactory.createEntity(c);
        } else {
            NullPointerException e = new NullPointerException();
            e.printStackTrace();
        }
    }

    private IEntity[][] getMap() {
        return this.map;
    }

    private void setMap(IEntity[][] map) {
        this.map = map;
    }

    /**
     * @param entity
     * @param x
     * @param y
     */
    @Override
    public void setOnTheMapXY(IEntity entity, int x, int y) {

    }

    @Override
    public void setMobileHasChanged() {

    }

    @Override
    public Observable getObservable() {

        return null;
    }

    @Override
    public void fillView() {
        for (int y = 0; y < this.getViewMap().length; y++) {
            for (int x = 0; x < this.getViewMap()[y].length; x++) {
                this.getViewMap()[y][x] = MotionlessEntityFactory.createDestructibleBlock();
                System.out.print(this.getViewMap()[y][x].getSprite());
            }
            System.out.println();
        }
    }

    @Override
    public void moveUp() {

    }

    @Override
    public void moveDown() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public void moveLeft() {

    }

    public int getViewWidth() {
        return this.viewWidth;
    }

    public void setViewWidth(int viewWidth) {
        this.viewWidth = viewWidth;
    }

    public int getViewHeight() {
        return this.viewHeight;
    }

    public void setViewHeight(int viewHeight) {
        this.viewHeight = viewHeight;
    }

    public IEntity[][] getViewMap() {
        return this.viewMap;
    }

    public void setViewMap(IEntity[][] viewMap) {
        this.viewMap = viewMap;
    }

}