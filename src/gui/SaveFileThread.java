package gui;

import util.SimpLanPlusLib;
import javax.swing.JTextArea;
import java.io.File;
import java.io.FileWriter;

public class SaveFileThread extends Thread{
    private final JTextArea txtCode;

    public SaveFileThread(JTextArea txtCode){
        this.txtCode = txtCode;
    }

    @Override
    public void run(){
        try{
            File file1 = new File("errori.txt");
            file1.delete();
            FileWriter writer1 = new FileWriter(file1,true);
            writer1.write("\n");
            writer1.flush();
            writer1.close();
            File file2 = new File("simplanplus.asm");
            file2.delete();
            FileWriter writer2 = new FileWriter(file2,true);
            writer2.write("\n");
            writer2.flush();
            writer2.close();
            SimpLanPlusLib.setNumberLabels(0);
            String code = txtCode.getText();
            String codeHighLevel = "codice.simplanplus";
            File file = new File(codeHighLevel);
            file.delete(); //delete the file generated during the previous execution
            FileWriter codeExecutable = new FileWriter(file,true);
            codeExecutable.write(code);
            codeExecutable.flush();
            codeExecutable.close();
            System.out.println("The code has been saved into \"codice.simplanplus\" file.");
        }catch(Exception errorGenerated){
            errorGenerated.printStackTrace();
            this.interrupt();//System.exit(-1);
        }
    }
}
