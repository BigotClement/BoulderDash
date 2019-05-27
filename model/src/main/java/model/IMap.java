/*
 *
 */
package model;

import java.util.Observable;

import entity.IEntity;

public interface IMap {

    int getWidth();

    int getHeight();

    /**
     * @param x
     * @param y
     */
    IEntity getOnTheMapXY(int x, int y);

    void setMobileHasChanged();

    Observable getObservable();

    /**
     * @param width
     */
    void setWidth(int width);

    /**
     * @param height
     */
    void setHeight(int height);

    /**
     * @param entity
     * @param x
     * @param y
     */
    void setOnTheMapXY(IEntity entity, int x, int y);

    void fillView();

    void moveUp();

    void moveDown();

    void moveRight();

    void moveLeft();

    void setOnTheMapXY(char c, int x, int y);

}