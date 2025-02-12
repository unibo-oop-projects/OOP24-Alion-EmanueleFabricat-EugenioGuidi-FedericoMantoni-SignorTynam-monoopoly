package it.unibo.monoopoly.view.api;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * Interface for personalized methods of the {@link JPanel}s used in the game.
 */
public interface GamePanel {

    /**
     * Resize the text of the {@link JComponent}s containing text when frame is resized.
     * @param screenSize the size of the screen of the device where runs the application
     */
    void resizeText(Dimension screenSize);

}
