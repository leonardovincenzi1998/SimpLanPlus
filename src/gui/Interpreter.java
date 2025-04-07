package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interpreter implements ActionListener {
    public Interpreter(){}

    @Override
    public void actionPerformed(ActionEvent e) {
        InterpreterThread newThread = new InterpreterThread();
        newThread.start();
    }
}
