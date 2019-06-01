/*
 *
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * The Class ViewPanel.
 */
class ViewPanel extends JPanel implements Observer {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -998294702363713521L;
    
    /** The view frame. */
    private ViewFrame viewFrame;

    /** The diamond counter image. */
    private Image diamondCounterImage = null;
    
    /** The timer image. */
    private Image timerImage = null;

    /**
     * Instantiates a new view panel.
     *
     * @param viewFrame the view frame
     */
    public ViewPanel(final ViewFrame viewFrame) {
        this.setViewFrame(viewFrame);
        try {
            viewFrame.getModel().getMap().getObservable().addObserver(this);
            this.setDiamondCounterImage(ImageIO.read(new File("sprites\\diamondcounter.png")));
            this.setTimerImage(ImageIO.read(new File("sprites\\timer.png")));
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
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

    /**
     * Paint component.
     *
     * @param graphics the graphics
     */
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
        this.writeTimerExit(graphics, this.writeScoreExit(graphics));
    }

    /**
     * Write panel.
     *
     * @param graphics the graphics
     * @param str the str
     * @param startX the start X
     * @param startY the start Y
     * @param size the size
     * @param border1 the border 1
     * @param border2 the border 2
     * @param border3 the border 3
     * @param textColor the text color
     * @param rectColor the rect color
     * @param border1Color the border 1 color
     * @param border2Color the border 2 color
     * @param border3Color the border 3 color
     */
    public void writePanel(final Graphics graphics, String str, int startX, int startY, int size, int border1,
            int border2, int border3, Color textColor, Color rectColor, Color border1Color, Color border2Color,
            Color border3Color) {
        FontMetrics fm = graphics.getFontMetrics();
        Rectangle2D rect = fm.getStringBounds(str, graphics);
        graphics.setColor(border1Color);
        graphics.fillRect(startX - border1, ((size - fm.getAscent()) + startY) - border1,
                (int) rect.getWidth() + (border1 * 2), (int) rect.getHeight() + (border1 * 2));
        graphics.setColor(border2Color);
        graphics.fillRect(startX - border2, ((size - fm.getAscent()) + startY) - border2,
                (int) rect.getWidth() + (border2 * 2), (int) rect.getHeight() + (border2 * 2));
        graphics.setColor(border3Color);
        graphics.fillRect(startX - border3, ((size - fm.getAscent()) + startY) - border3,
                (int) rect.getWidth() + (border3 * 2), (int) rect.getHeight() + (border3 * 2));
        graphics.setColor(rectColor);
        graphics.fillRect(startX, (size - fm.getAscent()) + startY, (int) rect.getWidth(), (int) rect.getHeight());
        graphics.setColor(textColor);
        graphics.drawString(str, startX, size + startY);
    }

    /**
     * Write panel.
     *
     * @param graphics the graphics
     * @param str the str
     * @param str2 the str 2
     * @param startX the start X
     * @param startY the start Y
     * @param size the size
     * @param border1 the border 1
     * @param border2 the border 2
     * @param border3 the border 3
     * @param textColor the text color
     * @param rectColor the rect color
     * @param border1Color the border 1 color
     * @param border2Color the border 2 color
     * @param border3Color the border 3 color
     */
    public void writePanel(final Graphics graphics, String str, String str2, int startX, int startY, int size,
            int border1, int border2, int border3, Color textColor, Color rectColor, Color border1Color,
            Color border2Color, Color border3Color) {
        FontMetrics fm = graphics.getFontMetrics();
        Rectangle2D rect = fm.getStringBounds(str2, graphics);
        graphics.setColor(border1Color);
        graphics.fillRect(startX - border1, ((size - fm.getAscent()) + startY) - border1,
                (int) rect.getWidth() + (border1 * 2), (int) rect.getHeight() + (border1 * 2));
        graphics.setColor(border2Color);
        graphics.fillRect(startX - border2, ((size - fm.getAscent()) + startY) - border2,
                (int) rect.getWidth() + (border2 * 2), (int) rect.getHeight() + (border2 * 2));
        graphics.setColor(border3Color);
        graphics.fillRect(startX - border3, ((size - fm.getAscent()) + startY) - border3,
                (int) rect.getWidth() + (border3 * 2), (int) rect.getHeight() + (border3 * 2));
        graphics.setColor(rectColor);
        graphics.fillRect(startX, (size - fm.getAscent()) + startY, (int) rect.getWidth(), (int) rect.getHeight());
        graphics.setColor(textColor);
        Rectangle2D rect2 = fm.getStringBounds(str, graphics);
        graphics.drawString(str, (startX + (int) rect.getWidth()) - (int) rect2.getWidth(), size + startY);
    }

    /**
     * Write score exit.
     *
     * @param graphics the graphics
     * @return the int
     */
    protected int writeScoreExit(final Graphics graphics) {
        String str = "     " + this.getViewFrame().getController().getControllerCharacter().getDiamondCount() + "/"
                + this.getViewFrame().getController().getControllerCharacter().getDiamondLimit();
        int size = 30;
        int startX = 10;
        int startY = 50;
        int border1 = 10;
        int border2 = (border1 / 3) * 2;
        int border3 = (border1 / 3);
        Color textColor = Color.WHITE;
        Color rectColor = Color.BLACK;
        Color border1Color = Color.BLACK;
        Color border2Color = Color.BLUE;
        Color border3Color = Color.WHITE;
        graphics.setFont(new Font("Verdana", 1, size));
        this.writePanel(graphics, str, startX, startY, size, border1, border2, border3, textColor, rectColor,
                border1Color, border2Color, border3Color);
        graphics.drawImage(this.getDiamondCounterImage(), startX + 10, startY, size + 5, size + 5, this);
        return startY;
    }

    /**
     * Write timer exit.
     *
     * @param graphics the graphics
     * @param exit the exit
     */
    protected void writeTimerExit(final Graphics graphics, int exit) {
        String str = "" + this.getViewFrame().getController().getTimeLeft();
        String sizeTimer = "     " + this.getViewFrame().getController().getControllerCharacter().getDiamondCount()
                + "/" + this.getViewFrame().getController().getControllerCharacter().getDiamondLimit();
        int size = 30;
        int border1 = 10;
        int border2 = (border1 / 3) * 2;
        int border3 = (border1 / 3);
        int startX = 10;
        int startY = exit + size + border1 + border1 + border3;
        Color textColor = Color.WHITE;
        Color rectColor = Color.BLACK;
        Color border1Color = Color.BLACK;
        Color border2Color = Color.BLUE;
        Color border3Color = Color.WHITE;
        graphics.setFont(new Font("Verdana", 1, size));
        this.writePanel(graphics, str, sizeTimer, startX, startY, size, border1, border2, border3, textColor, rectColor,
                border1Color, border2Color, border3Color);
        graphics.drawImage(this.getTimerImage(), startX + 10, startY, size + 5, size + 5, this);
    }

    /**
     * Sets the view frame.
     *
     * @param viewFrame the new view frame
     */
    void setViewFrame(final ViewFrame viewFrame) {
        this.viewFrame = viewFrame;
    }

    /**
     * Update.
     *
     * @param arg0 the arg 0
     * @param arg1 the arg 1
     */
    /*
     * (non-Javadoc)
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    @Override
    public void update(final Observable arg0, final Object arg1) {
        this.repaint();
    }

    /**
     * Gets the diamond counter image.
     *
     * @return the diamond counter image
     */
    public Image getDiamondCounterImage() {
        return this.diamondCounterImage;
    }

    /**
     * Sets the diamond counter image.
     *
     * @param diamondCounterImage the new diamond counter image
     */
    public void setDiamondCounterImage(Image diamondCounterImage) {
        this.diamondCounterImage = diamondCounterImage;
    }

    /**
     * Gets the timer image.
     *
     * @return the timer image
     */
    public Image getTimerImage() {
        return this.timerImage;
    }

    /**
     * Sets the timer image.
     *
     * @param timerImage the new timer image
     */
    public void setTimerImage(Image timerImage) {
        this.timerImage = timerImage;
    }
}
