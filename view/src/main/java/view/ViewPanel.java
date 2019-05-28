/*
 *
 */
package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import entity.IEntity;

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
        viewFrame.getModel().getObservable().addObserver(this);
    }

    /**
     * Gets the view frame.
     *
     * @return the view frame
     */
    private ViewFrame getViewFrame() {
        return this.viewFrame;
    }

    /*
     * (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    protected void paintComponent(final Graphics graphics) {
        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
        for (int y = 0; y < this.getViewFrame().getModel().getMap().getViewMap().length; y++) {
            for (int x = 0; x < this.getViewFrame().getModel().getMap().getViewMap()[y].length; x++) {
                System.out.print(this.getViewFrame().getModel().getMap().getViewMap()[y][x].getImage());
            }
            System.out.println();
        }

    }

    /**
     * Sets the view frame.
     *
     * @param viewFrame
     *                      the new view frame
     */
    private void setViewFrame(final ViewFrame viewFrame) {
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
