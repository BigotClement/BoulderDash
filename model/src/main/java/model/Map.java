/*
 *
 */
package model;

import java.util.Observable;

import entity.Entity;
import entity.IEntity;
import mobile.MobileEntityFactory;
import motionless.MotionlessEntity;
import motionless.MotionlessEntityFactory;

public class Map implements IMap {

    private int width;
    private int height;
    private IEntity[][] map;

    /**
     * @param map
     */
    public Map(char[][] map) {
        this.setMap(new Entity[map.length][map[0].length]);
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                this.setOnTheMapXY(map[y][x], x, y);
                System.out.print(map[y][x]);
            }
            System.out.println();
        }
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

}