/*
 *
 */
package contract;

/**
 * The Interface IModel.
 */
public interface IModel {

    /**
     * Gets the map ID.
     *
     * @return the map ID
     */
    int getMapID();

    /**
     * Sets the map ID.
     *
     * @param mapID the new map ID
     */
    void setMapID(int mapID);

    /**
     * Gets the map.
     *
     * @return the map
     */
    IMap getMap();

    /**
     * Sets the map.
     *
     * @param map the new map
     */
    void setMap(IMap map);

}
