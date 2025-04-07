package gui;

import javax.swing.*;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class TextAreaOutputStream extends OutputStream {
    private final JTextArea console;

    public TextAreaOutputStream(JTextArea console){
        this.console = console;
    }

    @Override
    public void write(int b){
        byte[] b1 = new byte[1];
        b1[0]=(byte)b;
        write(b1,0,1);
    }

    @Override
    public void write(byte[] b) {
        write(b,0,b.length);
    }

    @Override
    public void write(byte[] b,int off,int len) {
        if(console!=null) {
            console.append(bytesToString(b,off,len));
        }
    }

    public static String bytesToString(byte[] byteArray, int string, int length) {
        return new String(byteArray, string, length, StandardCharsets.UTF_8);
    }
}
