/*
 *
 */
package entity;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

import javax.imageio.ImageIO;

/**
 * The Class AnimateGif.
 */
public class AnimateGif extends Observable implements Runnable {

    /** The gif. */
    private Image[] gif = null;

    /** The image. */
    private Image image = null;

    /** The folder. */
    private String folder;

    /** The milliseconds. */
    private int milliseconds;

    private Thread thread;

    /**
     * Instantiates a new animate gif.
     *
     * @param folder
     *                         the folder
     * @param milliseconds
     *                         the milliseconds
     */
    public AnimateGif(String folder, int milliseconds) {
        this.setFolder(folder);// defini le dossier
        this.setMilliseconds(milliseconds);
        this.thread = new Thread(this);
        this.thread.setDaemon(true);
        this.thread.start();
    }

    /**
     * Load sprites.
     */
    public void loadSprites() {
        File[] f = new File(this.getFolder()).listFiles();// charge le contenu du dossier voulu sans avoir besoin du
                                                          // nombre de fichiers
        this.setGif(new Image[f.length]);// cree le tableau gif en fonction du nombre de fichiers dans le dossier

        for (int j = 0; j < f.length; j++) {
            try {
                this.getGif()[j] = ImageIO.read(f[j]);// rempli le tableau gif avec des images
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Run.
     */
    @Override
    public void run() {// boucle pour afficher le gif anime
        while (true) {
            for (Image element : this.getGif()) {// for en fonction de la taille du tableau gif
                this.setImage(element);// defini l'image pour l'image suivante
                this.setChanged();
                this.notifyObservers();
                try {
                    Thread.currentThread();
                    Thread.sleep(this.getMilliseconds());// attente de x millisecondes
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = this.getGif().length - 2; i > 0; i--) {
                this.setImage(this.getGif()[i]);
                this.setChanged();
                this.notifyObservers();
                try {
                    Thread.currentThread();
                    Thread.sleep(this.getMilliseconds());// attente de x millisecondes
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Gets the gif.
     *
     * @return the gif
     */
    public Image[] getGif() {
        return this.gif;
    }

    /**
     * Sets the gif.
     *
     * @param gif
     *                the new gif
     */
    public void setGif(Image[] gif) {
        this.gif = gif;
    }

    /**
     * Gets the image.
     *
     * @return the image
     */
    public final Image getImage() {
        return this.image;
    }

    /**
     * Sets the image.
     *
     * @param image
     *                  the new image
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Gets the folder.
     *
     * @return the folder
     */
    public String getFolder() {
        return this.folder;
    }

    /**
     * Sets the folder.
     *
     * @param folder
     *                   the new folder
     */
    public void setFolder(String folder) {
        this.folder = folder;
        this.loadSprites();
    }

    /**
     * Gets the milliseconds.
     *
     * @return the milliseconds
     */
    public int getMilliseconds() {
        return this.milliseconds;
    }

    /**
     * Sets the milliseconds.
     *
     * @param milliseconds
     *                         the new milliseconds
     */
    public void setMilliseconds(int milliseconds) {
        this.milliseconds = milliseconds;
    }

}
