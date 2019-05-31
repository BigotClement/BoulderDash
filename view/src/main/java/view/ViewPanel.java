/*
 *
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
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
        String str = "Diamonds: " + this.getViewFrame().getController().getControllerCharacter().getDiamondCount()
                + "/10";
        int startX = 10;
        int startY = 50;
        int size = 30;
        int border1 = 7;
        int border2 = border1 / 2;
        Color textColor = Color.WHITE;
        Color rectColor = Color.BLACK;
        Color border1Color = Color.BLUE;
        Color border2Color = Color.WHITE;
        graphics.setFont(new Font("Verdana", 0, size));
        FontMetrics fm = graphics.getFontMetrics();
        Rectangle2D rect = fm.getStringBounds(str, graphics);
        this.getViewFrame().getContentPane().setLayout(new BorderLayout(4, 4));
        graphics.setColor(border1Color);
        graphics.fillRect(startX - border1, ((size - fm.getAscent()) + startY) - border1,
                (int) rect.getWidth() + (border1 * 2), (int) rect.getHeight() + (border1 * 2));
        graphics.setColor(border2Color);
        graphics.fillRect(startX - border2, ((size - fm.getAscent()) + startY) - border2,
                (int) rect.getWidth() + (border2 * 2), (int) rect.getHeight() + (border2 * 2));
        graphics.setColor(rectColor);
        graphics.fillRect(startX, (size - fm.getAscent()) + startY, (int) rect.getWidth(), (int) rect.getHeight());
        graphics.setColor(textColor);
        graphics.drawString(str, startX, size + startY);
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
