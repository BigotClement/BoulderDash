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

    IEntity[][] getMap();

    int getWidth();

    /**
     * @param height
     */
    void setHeight(int height);

    void setOnTheMapXY(char c, int x, int y);

    void setViewMap(IEntity[][] viewMap);

    /**
     * @param width
     */
    void setWidth(int width);

    IEntity findCharacter();

    void setOnTheMapXY(IEntity entity, int x, int y);

    IEntity getOnTheViewMapXY(int x, int y);

    void setOnTheViewMapXY(IEntity entity, int x, int y);

}