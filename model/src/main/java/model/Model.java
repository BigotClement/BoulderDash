/*
 *
 */
package model;

import java.util.Observable;

import contract.IMap;
import contract.IModel;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model implements IModel {

    private int mapID;

    private IMap map;

    private ReadFile readFile = new ReadFile(this.getMapID());

    /**
     * Instantiates a new model.
     *
     * @param mapid
     */
    public Model(int mapid) {
        this.setMapID(mapid);
        // this.readFile.deleteMapID(this.getMapID());
        // this.readFile.loadFile();
        this.readFile.selectMapID(this.getMapID());
        this.setMap(new Map(this.readFile.getMap()));
        this.getMap().setWidth(this.readFile.getWidth());
        this.getMap().setHeight(this.readFile.getHeight());
    }

    @Override
    public int getMapID() {
        return this.mapID;
    }

    @Override
    public void setMapID(int mapID) {
        this.mapID = mapID;
    }

    @Override
    public IMap getMap() {
        return this.map;
    }

    @Override
    public void setMap(IMap map) {
        this.map = map;
    }

    @Override
    public Observable getObservable() {
        // TODO Auto-generated method stub
        return null;
    }

}
