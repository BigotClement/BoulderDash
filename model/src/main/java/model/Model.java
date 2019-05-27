/*
 *
 */
package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

    private int mapID = 1;

    private ReadFile readFile = new ReadFile(this.getMapID());

    /**
     * Instantiates a new model.
     */
    public Model() {
        this.readFile.deleteMapID(this.getMapID());
        this.readFile.loadFile();
        this.readFile.selectMapID(this.getMapID());
        for (char[] c : this.readFile.getMap()) {
            for (char c2 : c) {
                System.out.print(c2);
            }
            System.out.println();
        }
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

}
