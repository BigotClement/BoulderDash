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

    /** The road. */
    private char[][] map;

    /** The height. */
    private int width, height;

    private String filename;

    private int mapID;

    /**
     * Instantiates a new read file.
     *
     * @throws IOException
     *                         Signals that an I/O exception has occurred.
     */
    public ReadFile(int mapID) {
        this.setFilename("Map" + mapID + ".txt");
        this.setMapID(mapID);
    }

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

    public int getMapID() {
        return this.mapID;
    }

    public void setMapID(int mapID) {
        this.mapID = mapID;
    }

    private void setWidth(int width) {
        this.width = width;
    }

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

    public void selectMapID(int p_MapID) {
        try {
            final String sql = "{call Select_Map(?)}";
            CallableStatement call = DBConnection.getInstance().getConnection().prepareCall(sql);
            call.setInt(1, p_MapID);
            call.execute();
            final ResultSet resultSet = call.getResultSet();
            if (!resultSet.first()) {
                this.setWidth(resultSet.getInt("MapWidth"));
                this.setHeight(resultSet.getInt("MapHeight"));
                this.setMap(new char[this.getHeight()][this.getWidth()]);
                this.getMap()[resultSet.getInt("posY")][resultSet.getInt("posX")] = resultSet.getString("Sprite")
                        .charAt(0);
                while (resultSet.next()) {
                    this.getMap()[resultSet.getInt("posY")][resultSet.getInt("posX")] = resultSet.getString("Sprite")
                            .charAt(0);
                }
            } else {
                System.out.println("Map not found ! Program is closing....");
                // System.exit(0);
            }
            resultSet.close();
            call.close();
            DBConnection.getInstance().getConnection().close();
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

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

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public char[][] getMap() {
        return this.map;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }

}