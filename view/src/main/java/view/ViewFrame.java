/*
 *
 */
package view;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import contract.IControllerMain;
import contract.IModel;
import entity.IEntity;

public class ViewFrame extends JFrame implements KeyListener {

    private static final int FRAMEWIDTH = 1000;

    private static final int FRAMEHEIGHT = 1000;

    private int diamondCount = 0;

    /** The model. */
    private IModel model;

    /** The controller. */
    IControllerMain controller;

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -697358409737458175L;

    /**
     * Instantiates a new view frame.
     *
     * @param model
     *                  the model
     * @param title
     *                  the title
     * @throws HeadlessException
     *                               the headless exception
     */
    public ViewFrame(final IModel model, final String title) throws HeadlessException {
        super(title);
        this.buildViewFrame(model);
        this.playMusic();
    }

    public void playMusic() {
        String filePath = "sounds\\OST Boulder Dash - Boulder World.wav";
        AudioInputStream audioInputStream;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * Gets the controller.
     *
     * @return the controller
     */
    IControllerMain getController() {
        return this.controller;
    }

    /**
     * Sets the controller.
     *
     * @param controller
     *                       the new controller
     */
    public void setController(final IControllerMain controller) {
        this.controller = controller;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }

    /**
     * Sets the model.
     *
     * @param model
     *                  the new model
     */
    void setModel(final IModel model) {
        this.model = model;
    }

    /**
     * Builds the view frame.
     *
     * @param model
     *                  the model
     */
    private void buildViewFrame(final IModel model) {
        this.setModel(model);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.addKeyListener(this);
        this.setContentPane(new ViewPanel(this));
        this.setSize(FRAMEWIDTH, FRAMEHEIGHT);
        this.setLocationRelativeTo(null);
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
     */
    @Override
    public void keyTyped(final KeyEvent key) {
        this.getController().getControllerCharacter().moveSet(key);
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
     */
    @Override
    public void keyPressed(final KeyEvent key) {
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
     */
    @Override
    public void keyReleased(final KeyEvent key) {
        IEntity character = this.getModel().getMap().findCharacter();
        if (character.isAlive()) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            character.setSpriteFolder("sprites\\Mobile\\Character\\Stand");
        }
    }

    public int getDiamondCount() {
        return this.diamondCount;
    }

    public void setDiamondCount(int diamondCount) {
        this.diamondCount = diamondCount;
    }
}
