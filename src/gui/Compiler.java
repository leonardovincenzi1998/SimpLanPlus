package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Compiler implements ActionListener {
    public Compiler(){}

    @Override
    public void actionPerformed(ActionEvent e) {
        CompilerThread newThread = new CompilerThread();
        newThread.start();
    }
}
