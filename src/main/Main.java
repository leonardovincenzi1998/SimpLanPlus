package main;

import gui.CompilerThread;
import gui.GUI;
import gui.InterpreterThread;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main{
	public static void main(String[] args){
		/*GUI gui = new GUI();
		/System.out.println("The application \"" + gui.getTitle() + "\" has started correctly.");
		File file1 = new File("errori.txt");
		file1.delete();
		try{
			FileWriter writer1 = new FileWriter(file1,true);
			writer1.write("\n");
			writer1.flush();
			writer1.close();
		}catch(IOException exc){
			exc.printStackTrace();
		}
		File file2 = new File("simplanplus.asm");
		file2.delete();
		try{
			FileWriter writer2 = new FileWriter(file2,true);
			writer2.write("\n");
			writer2.flush();
			writer2.close();
		}catch(IOException exc){
			exc.printStackTrace();
		}*/


		CompilerThread compiler = new CompilerThread();
		compiler.start();



	}
}