/*
 *
 */
package contract;

import java.util.Observable;
import entity.IEntity;

public interface IMap {

    void fillView();

    int getHeight();

    Observable getObservable();

    /**
     * @param x
     * @param y
     */
    IEntity getOnTheMapXY(int x, int y);

    IEntity[][] getViewMap();

    int getWidth();

    /**
     * @param height
     */
    void setHeight(int height);

    void setMobileHasChanged();

    void setOnTheMapXY(char c, int x, int y);

    /**
     * @param entity
     * @param x
     * @param y
     */
    void setOnTheMapXY(IEntity entity, int x, int y);

    void setViewMap(IEntity[][] viewMap);

    /**
     * @param width
     */
    void setWidth(int width);

    void moveDown(IEntity mobile);

    void moveLeft(IEntity mobile);

    void moveRight(IEntity mobile);

    void moveUp(IEntity mobile);

    IEntity findCharacter();

}