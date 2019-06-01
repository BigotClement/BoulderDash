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
        this.setFolder(folder);
        this.setMilliseconds(milliseconds);
        this.thread = new Thread(this);
        this.thread.setDaemon(true);
        this.thread.start();
    }

    /**
     * Load sprites.
     */
    public void loadSprites() {
        try {
            File[] f = new File(this.getFolder()).listFiles();
            this.setGif(new Image[f.length]);

            for (int j = 0; j < f.length; j++) {
                try {
                    this.getGif()[j] = ImageIO.read(f[j]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Run.
     */
    @Override
    public void run() {
        while (true) {
            for (Image element : this.getGif()) {
                this.setImage(element);
                this.setChanged();
                this.notifyObservers();
                try {
                    Thread.currentThread();
                    Thread.sleep(this.getMilliseconds());
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
                    Thread.sleep(this.getMilliseconds());
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
