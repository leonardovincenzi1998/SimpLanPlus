package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewErrors implements ActionListener {
    public ViewErrors(){}

    @Override
    public void actionPerformed(ActionEvent e) {
        ViewErrorsThread newThread = new ViewErrorsThread();
        newThread.start();
    }
}