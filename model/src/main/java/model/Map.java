/*
 *
 */
package model;

import java.util.Observable;

import entity.IEntity;

public class Map implements IMap {

    private int width;
    private int height;

    /**
     * @param map
     */
    public Map(char[][] map) {
        // TODO - implement Map.Map
        throw new UnsupportedOperationException();
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
        // TODO - implement Map.getOnTheMapXY
        throw new UnsupportedOperationException();
    }

    /**
     * @param entity
     * @param x
     * @param y
     */
    public void setOnTheMapXY(IEntity entity, int x, int y) {
        // TODO - implement Map.setOnTheMapXY
        throw new UnsupportedOperationException();
    }

    @Override
    public void setMobileHasChanged() {
        // TODO - implement Map.setMobileHasChanged
        throw new UnsupportedOperationException();
    }

    @Override
    public Observable getObservable() {
        // TODO - implement Map.getObservable
        throw new UnsupportedOperationException();
    }

    @Override
    public void fillView() {
        // TODO - implement Map.fillView
        throw new UnsupportedOperationException();
    }

    @Override
    public void moveUp() {
        // TODO - implement Map.moveUp
        throw new UnsupportedOperationException();
    }

    @Override
    public void moveDown() {
        // TODO - implement Map.moveDown
        throw new UnsupportedOperationException();
    }

    @Override
    public void moveRight() {
        // TODO - implement Map.moveRight
        throw new UnsupportedOperationException();
    }

    @Override
    public void moveLeft() {
        // TODO - implement Map.moveLeft
        throw new UnsupportedOperationException();
    }

}