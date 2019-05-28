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
public final class Model extends Observable implements IModel {

    private int mapID = 1;

    private IMap map;

    private ReadFile readFile = new ReadFile(this.getMapID());

    /**
     * Instantiates a new model.
     */
    public Model() {
        // this.readFile.deleteMapID(this.getMapID());
        // this.readFile.loadFile();
        this.readFile.selectMapID(this.getMapID());
        this.setMap(new Map(this.readFile.getMap()));
        this.getMap().setWidth(this.readFile.getWidth());
        this.getMap().setHeight(this.readFile.getHeight());
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    Model.this.notifyObservers();
                    Model.this.setChanged();
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * Gets the observable.
     *
     * @return the observable
     */
    /*
     * (non-Javadoc)
     * @see contract.IModel#getObservable()
     */
    @Override
    public Observable getObservable() {
        return this;
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

}
