package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearConsole implements ActionListener {
    private final JTextArea console;

    public ClearConsole(JTextArea console){
        this.console = console;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ClearConsoleThread newThread = new ClearConsoleThread(console);
        newThread.start();
    }
}