package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveFile implements ActionListener {
    private final JTextArea txtCode;

    public SaveFile(JTextArea txtCode){
        this.txtCode = txtCode;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SaveFileThread newThread = new SaveFileThread(txtCode);
        newThread.start();
    }
}
