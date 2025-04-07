package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.RecognitionException;

public class ErrorListener extends BaseErrorListener {
	private ArrayList<String> listSyntaxErrors;

	public ErrorListener(){
		listSyntaxErrors = new ArrayList<>();
	}

	@Override
	public void syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
		String error ="Error at line " + line + " at position " + charPositionInLine + ": " + msg+ "\n"; //The string containing the error to be printed
		listSyntaxErrors.add(error);
	}

	public void writeErrorsToFile(){
		File file = new File("errori.txt"); //Try printing to a file the string error in append; if the file don't exist, create it
		file.delete();
		try{
			FileWriter writer = new FileWriter(file,true);
			for(String error:listSyntaxErrors){
				writer.write(error);
				writer.flush();
			}
			writer.close();
		}catch(IOException exc){
			exc.printStackTrace();
		}
	}

	public int getNumberErrors(){
		return listSyntaxErrors.size();
	}
}

