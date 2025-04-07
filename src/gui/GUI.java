package gui;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class GUI extends JFrame {
    public GUI(){
        super("Project for the university exam");

        //create the text area which contains the code in SimpLanPlus language
        JTextArea codeHighLevel = new JTextArea(10,44);
        String lastCode = "";
        try{
            Scanner in = new Scanner(new File("codice.simplanplus"));
            while(in.hasNextLine()){
                lastCode += in.nextLine() + "\n";
            }
            in.close();
        }catch(FileNotFoundException exc){
            System.out.println("The file \"codice.simplanplus\" isn't available.");
            lastCode = "";
        }
        codeHighLevel.setText(lastCode);
        JScrollPane scrollbarCodeHighLevel = new JScrollPane(codeHighLevel);
        scrollbarCodeHighLevel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollbarCodeHighLevel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        //create the buttons to manage the syntax errors
        Font font1 = new Font("Times new roman",Font.PLAIN,24);
        JButton viewErrors = new JButton("View syntax and lexical errors");
        viewErrors.setFont(font1);
        viewErrors.addActionListener(new ViewErrors());

        //create the text area which functions as console to print all messages of the program
        JTextArea printArea = new JTextArea(10,90);
        printArea.setEditable(false);
        printArea.setBackground(new Color(0,0,0));
        printArea.setForeground(new Color(255,255,255));
        TextAreaOutputStream console = new TextAreaOutputStream(printArea);
        PrintStream textOut = new PrintStream(console);
        System.setOut(textOut);
        System.setErr(textOut);
        JScrollPane scrollbarConsole = new JScrollPane(printArea);
        scrollbarConsole.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollbarConsole.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //create a label to indicate the title in the interface and establish his font and his alignment
        Font font2 = new Font("Times new roman",Font.BOLD,32);
        JLabel title = new JLabel("Compiler and interpreter SimpLanPlus");
        title.setFont(font2);
        title.setHorizontalAlignment(JLabel.CENTER);

        //create the button to operate in the application, each button has the same font established
        JButton saveFile = new JButton("Save the code");
        saveFile.setFont(font1);
        saveFile.addActionListener(new SaveFile(codeHighLevel));
        JButton compile = new JButton("Compile the code");
        compile.setFont(font1);
        compile.addActionListener(new Compiler());
        JButton execute = new JButton("Execute the code");
        execute.setFont(font1);
        execute.addActionListener(new Interpreter());
        JButton clearConsole = new JButton("Clear the console");
        clearConsole.setFont(font1);
        clearConsole.addActionListener(new ClearConsole(printArea));

        //add all elements to the program, set the main settings and show the graphical interface
        JPanel container1 = new JPanel();
        GridLayout grid1 = new GridLayout(1,4);
        container1.setLayout(grid1);
        container1.add(saveFile);
        container1.add(compile);
        container1.add(execute);
        container1.add(clearConsole);
        JPanel container2 = new JPanel();
        GridLayout grid2 = new GridLayout(2,1);
        container2.setLayout(grid2);
        container2.add(title);
        container2.add(container1);
        JPanel container3 = new JPanel();
        GridLayout grid3 = new GridLayout(10,1);
        container3.setLayout(grid3);
        container3.add(viewErrors);
        JPanel container4 = new JPanel();
        GridLayout grid4 = new GridLayout(1,2);
        container4.setLayout(grid4);
        container4.add(scrollbarCodeHighLevel);
        container4.add(container3);
        JPanel container5 = new JPanel();
        BorderLayout generalSpace = new BorderLayout();
        container5.setLayout(generalSpace);
        container5.add(container2,BorderLayout.NORTH);
        container5.add(container4,BorderLayout.CENTER);
        container5.add(scrollbarConsole,BorderLayout.SOUTH);
        add(container5);
        setResizable(false);
        setSize(1024,768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}