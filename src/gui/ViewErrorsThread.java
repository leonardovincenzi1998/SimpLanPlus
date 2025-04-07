package gui;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ViewErrorsThread extends Thread{
    private final JTextArea textArea;

    public ViewErrorsThread(){
        //create a window with a text area which contains the content of the file errori.txt
        JFrame window = new JFrame("Syntax and lexical errors");
        textArea = new JTextArea(10,25);
        textArea.setEditable(false);
        JScrollPane scrollbarSyntaxErrors = new JScrollPane(textArea);
        scrollbarSyntaxErrors.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollbarSyntaxErrors.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JPanel container = new JPanel();
        GridLayout grid = new GridLayout(1,1);
        container.setLayout(grid);
        container.add(scrollbarSyntaxErrors);
        window.add(container);
        window.setSize(500,500);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    public void run(){
        String list = "";
        try{
            Scanner in = new Scanner(new File("errori.txt"));
            while(in.hasNextLine()){
                list += in.nextLine() + "\n";
            }
            in.close();
        }catch(FileNotFoundException exc){
            System.out.println("The file \"errori.txt\" isn't available.");
            list = "";
        }
        textArea.setText(list);
    }
}