package it.unibo.monoopoly.view.impl;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Set;

import javax.swing.JFrame;

import it.unibo.monoopoly.view.api.View;

public abstract class AbstractView implements View {

    private final JFrame mainFrame = new JFrame("MONOOPOLY");

    public AbstractView() {
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(screenSize.width / 2, screenSize.height / 2);
        mainFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        mainFrame.addComponentListener(new ComponentAdapter() {
            
            @Override
            public void componentResized(ComponentEvent e) {
                getAllPanels().stream().forEach(p -> p.resizeText(mainFrame.getSize()));
            }
        });
    }

    public void display() {
        this.mainFrame.setVisible(true);
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    abstract public Set<PanelAdapter> getAllPanels();

}
