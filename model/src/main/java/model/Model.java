/*
 *
 */
package model;

import contract.IMap;
import contract.IModel;

/**
 * The Class Model.
 */
public final class Model implements IModel {

    /** The map ID. */
    private int mapID;

    /** The map. */
    private IMap map;

    /** The read file. */
    private ReadFile readFile;

    /**
     * Instantiates a new model.
     *
     * @param mapid the mapid
     */
    public Model(int mapid) {
        this.setMapID(mapid);
        this.readFile = new ReadFile(this.getMapID());
        // this.readFile.deleteMapID(this.getMapID());
        // this.readFile.loadFile();
        this.readFile.selectMapID(this.getMapID());
        this.setMap(new Map(this.readFile.getMap()));
        this.getMap().setWidth(this.readFile.getWidth());
        this.getMap().setHeight(this.readFile.getHeight());
    }

    /**
     * Gets the map ID.
     *
     * @return the map ID
     */
    @Override
    public int getMapID() {
        return this.mapID;
    }

    /**
     * Sets the map ID.
     *
     * @param mapID the new map ID
     */
    @Override
    public void setMapID(int mapID) {
        this.mapID = mapID;
    }

    /**
     * Gets the map.
     *
     * @return the map
     */
    @Override
    public IMap getMap() {
        return this.map;
    }

    /**
     * Sets the map.
     *
     * @param map the new map
     */
    @Override
    public void setMap(IMap map) {
        this.map = map;
    }

}
