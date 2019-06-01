/*
 *
 */
package contract;

import java.util.Observable;

import entity.IEntity;

/**
 * The Interface IMap.
 */
public interface IMap {

    /**
     * Fill view.
     */
    void fillView();

    /**
     * Gets the height.
     *
     * @return the height
     */
    int getHeight();

    /**
     * Gets the observable.
     *
     * @return the observable
     */
    Observable getObservable();

    /**
     * Gets the on the map XY.
     *
     * @param x
     *              the x
     * @param y
     *              the y
     * @return the on the map XY
     */
    IEntity getOnTheMapXY(int x, int y);

    /**
     * Gets the view map.
     *
     * @return the view map
     */
    IEntity[][] getViewMap();

    /**
     * Gets the map.
     *
     * @return the map
     */
    IEntity[][] getMap();

    /**
     * Gets the width.
     *
     * @return the width
     */
    int getWidth();

    /**
     * Sets the height.
     *
     * @param height
     *                   the new height
     */
    void setHeight(int height);

    /**
     * Sets the on the map XY.
     *
     * @param c
     *              the c
     * @param x
     *              the x
     * @param y
     *              the y
     */
    void setOnTheMapXY(char c, int x, int y);

    /**
     * Sets the width.
     *
     * @param width
     *                  the new width
     */
    void setWidth(int width);

    /**
     * Find character.
     *
     * @return the i entity
     */
    IEntity findCharacter();

    /**
     * Sets the on the map XY.
     *
     * @param entity
     *                   the entity
     * @param x
     *                   the x
     * @param y
     *                   the y
     */
    void setOnTheMapXY(IEntity entity, int x, int y);

    /**
     * Gets the on the view map XY.
     *
     * @param x
     *              the x
     * @param y
     *              the y
     * @return the on the view map XY
     */
    IEntity getOnTheViewMapXY(int x, int y);

    /**
     * Sets the on the view map XY.
     *
     * @param entity
     *                   the entity
     * @param x
     *                   the x
     * @param y
     *                   the y
     */
    void setOnTheViewMapXY(IEntity entity, int x, int y);

    /**
     * Find exit.
     *
     * @return the i entity
     */
    IEntity findExit();

}