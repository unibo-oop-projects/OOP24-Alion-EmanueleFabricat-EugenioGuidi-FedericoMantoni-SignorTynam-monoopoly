package it.unibo.monoopoly.view.impl.banker.state;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JPanel;

import it.unibo.monoopoly.view.api.ViewState;
import it.unibo.monoopoly.view.impl.MainView;

public class ViewBankerState implements ViewState<Boolean, Optional<List<Integer>>>{
    private final MainView mainView;
    private boolean mode;
    private JPanel panel;

    public ViewBankerState(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void setMode(Boolean mode) {
        this.mode = mode;
    }

    @Override
    public void visualize(Optional<List<Integer>> cellList) {
        if (cellList.isPresent()) {
            if (mode) {
                
            } else {

            }
            
        } else {
            if (mode) {
                
            } else {
                
            }

        }
    }

    public class exit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            var button = (JButton)e.getSource();
            String cellName = button.getText();
            mainView.getMainController().getControllerState().continueState(cellName);
        }

    }

}
