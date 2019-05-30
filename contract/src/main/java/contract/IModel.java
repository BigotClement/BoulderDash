/*
 *
 */
package contract;

import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

    int getMapID();

    void setMapID(int mapID);

    IMap getMap();

    void setMap(IMap map);

    Observable getObservable();
}
