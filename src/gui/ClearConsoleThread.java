package gui;

import javax.swing.*;

public class ClearConsoleThread extends Thread{
    private final JTextArea console;

    public ClearConsoleThread(JTextArea console){
        this.console = console;
    }

    @Override
    public void run(){
        console.setText("");
    }
}
