/*
 *
 */
package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;

import model.database.DBConnection;

// TODO: Auto-generated Javadoc
/**
 * The Class ReadFile.
 */
public class ReadFile {

    /** The lines. */
    private List<String> lines;

    /** The path. */
    private Path path;

    /** The map. */
    private char[][] map;

    /** The height. */
    private int width, height;

    /** The filename. */
    private String filename;

    /** The map ID. */
    private int mapID;

    /**
     * Instantiates a new read file.
     *
     * @param mapID
     *                  the map ID
     */
    public ReadFile(int mapID) {
        this.setFilename("Map" + mapID + ".txt");
        this.setMapID(mapID);
    }

    /**
     * Load file.
     */
    public void loadFile() {
        this.path = Paths.get(this.filename);// definition du chemin d'acces
        try {
            this.lines = Files.readAllLines(this.path);
        } catch (IOException e) {
            e.printStackTrace();
        }// ajout dans une liste de chaque ligne du fichier
        this.setWidth(Integer.parseInt(this.lines.get(0))); // recuperation de la premiere ligne
        this.setHeight(Integer.parseInt(this.lines.get(1))); // recuperation de la deuxieme ligne
        this.lines.remove(0);// suppression de la premiere ligne
        this.lines.remove(0);

        for (int i = 0; i < this.getHeight(); i++) {
            char[] tmp = this.lines.get(i).toCharArray(); // on ajoute dans un tableau temporaire la ligne suivante
            for (int j = 0; j < this.getWidth(); j++) {
                System.out.print(tmp[j]);
                this.insertIntoDB(this.getMapID(), "" + tmp[j], i, j, this.getWidth(), this.getHeight());
            }
            System.out.println();
        }
    }

    /**
     * Insert into DB.
     *
     * @param p_MapID
     *                        the p map ID
     * @param p_Sprite
     *                        the p sprite
     * @param p_posY
     *                        the p pos Y
     * @param p_posX
     *                        the p pos X
     * @param p_MapWidth
     *                        the p map width
     * @param p_MapHeight
     *                        the p map height
     */
    public void insertIntoDB(int p_MapID, String p_Sprite, int p_posY, int p_posX, int p_MapWidth, int p_MapHeight) {
        try {
            final String sql = "{call Insert_Map(?,?,?,?,?,?)}";
            CallableStatement call = DBConnection.getInstance().getConnection().prepareCall(sql);
            call.setInt(1, p_MapID);
            call.setString(2, p_Sprite);
            call.setInt(3, p_posY);
            call.setInt(4, p_posX);
            call.setInt(5, p_MapWidth);
            call.setInt(6, p_MapHeight);
            call.execute();
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the map ID.
     *
     * @return the map ID
     */
    public int getMapID() {
        return this.mapID;
    }

    /**
     * Sets the map ID.
     *
     * @param mapID
     *                  the new map ID
     */
    public void setMapID(int mapID) {
        this.mapID = mapID;
    }

    /**
     * Sets the width.
     *
     * @param width
     *                  the new width
     */
    private void setWidth(int width) {
        this.width = width;
    }

    /**
     * Sets the height.
     *
     * @param height
     *                   the new height
     */
    private void setHeight(int height) {
        this.height = height;
    }

    /**
     * Gets the height.
     *
     * @return the height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Gets the width.
     *
     * @return the width
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Select map ID.
     *
     * @param p_MapID
     *                    the p map ID
     */
    public void selectMapID(int p_MapID) {
        try {
            final String sql = "{call Select_Map(?)}";
            CallableStatement call = DBConnection.getInstance().getConnection().prepareCall(sql);
            call.setInt(1, p_MapID);
            call.execute();
            final ResultSet resultSet = call.getResultSet();
            if (resultSet.first()) {
                this.setWidth(resultSet.getInt("MapWidth"));
                this.setHeight(resultSet.getInt("MapHeight"));
                this.setMap(new char[this.getHeight()][this.getWidth()]);
                this.getMap()[resultSet.getInt("posY")][resultSet.getInt("posX")] = resultSet.getString("Sprite")
                        .charAt(0);
            }
            while (resultSet.next()) {
                this.getMap()[resultSet.getInt("posY")][resultSet.getInt("posX")] = resultSet.getString("Sprite")
                        .charAt(0);
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete map ID.
     *
     * @param p_MapID
     *                    the p map ID
     */
    public void deleteMapID(int p_MapID) {
        try {
            final String sql = "{call Delete_Map(?)}";
            CallableStatement call = DBConnection.getInstance().getConnection().prepareCall(sql);
            call.setInt(1, p_MapID);
            call.execute();
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the filename.
     *
     * @return the filename
     */
    public String getFilename() {
        return this.filename;
    }

    /**
     * Sets the filename.
     *
     * @param filename
     *                     the new filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Gets the map.
     *
     * @return the map
     */
    public char[][] getMap() {
        return this.map;
    }

    /**
     * Sets the map.
     *
     * @param map
     *                the new map
     */
    public void setMap(char[][] map) {
        this.map = map;
    }

}