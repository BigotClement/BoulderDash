/*
 *
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -998294702363713521L;
    /** The view frame. */
    private ViewFrame viewFrame;

    /**
     * Instantiates a new view panel.
     *
     * @param viewFrame
     *                      the view frame
     */
    public ViewPanel(final ViewFrame viewFrame) {
        this.setViewFrame(viewFrame);
        try {
            viewFrame.getModel().getMap().getObservable().addObserver(this);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the view frame.
     *
     * @return the view frame
     */
    public ViewFrame getViewFrame() {
        return this.viewFrame;
    }

    @Override
    protected void paintComponent(final Graphics graphics) {

        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
        for (int y = 0; y < this.getViewFrame().getModel().getMap().getViewMap().length; y++) {
            for (int x = 0; x < this.getViewFrame().getModel().getMap().getViewMap()[y].length; x++) {
                Image image = null;
                image = this.getViewFrame().getModel().getMap().getOnTheViewMapXY(x, y).getImage();
                graphics.drawImage(image,
                        x * (this.getViewFrame().getWidth()
                                / this.getViewFrame().getModel().getMap().getViewMap()[y].length),
                        y * (this.getViewFrame().getHeight()
                                / this.getViewFrame().getModel().getMap().getViewMap().length),
                        this.getViewFrame().getWidth() / this.getViewFrame().getModel().getMap().getViewMap()[y].length,
                        this.getViewFrame().getHeight() / this.getViewFrame().getModel().getMap().getViewMap().length,
                        this);
            }
        }
        this.writeScoreExit(graphics);
    }

    protected void writeScoreExit(final Graphics graphics) {
        int size = 30;
        this.getViewFrame().getContentPane().setLayout(new BorderLayout(4, 4));
        graphics.setFont(new Font("Verdana", 1, size));
        graphics.setColor(Color.GREEN);
        graphics.drawString(
                "BoulderDash " + this.getViewFrame().getController().getControllerCharacter().getDiamondCount() + "/10",
                0, size);
        /*
         * JLabel titleDiamondExit = new JLabel("BoulderDash " +
         * this.getViewFrame().getController().getControllerCharacter().getDiamondCount(
         * ) + "/10"); titleDiamondExit.setFont(new Font("Verdana", 1, 30));
         * this.getViewFrame().add(titleDiamondExit);
         * titleDiamondExit.setForeground(Color.GREEN);
         * titleDiamondExit.setHorizontalAlignment(JLabel.LEFT);
         * this.getViewFrame().add(titleDiamondExit, BorderLayout.NORTH);
         */

    }

    /**
     * Sets the view frame.
     *
     * @param viewFrame
     *                      the new view frame
     */
    void setViewFrame(final ViewFrame viewFrame) {
        this.viewFrame = viewFrame;
    }

    /*
     * (non-Javadoc)
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    @Override
    public void update(final Observable arg0, final Object arg1) {
        this.repaint();
    }
}
