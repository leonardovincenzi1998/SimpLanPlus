package gui;

import main.ErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import ast.Node;
import ast.SimpLanPlusVisitorImpl;
import parser.SimpLanPlusLexer;
import parser.SimpLanPlusParser;
import util.Environment;
import util.SemanticError;
import util.SimpLanPlusLib;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;

public class CompilerThread extends Thread{
    public CompilerThread(){}

    @Override
    public void run(){
        try{
            File oldFileCodeAssembly = new File("simplanplus.asm");
            oldFileCodeAssembly.delete();
            FileWriter writerOldFileCodeAssembly = new FileWriter(oldFileCodeAssembly,true);
            writerOldFileCodeAssembly.write("\n");
            writerOldFileCodeAssembly.flush();
            writerOldFileCodeAssembly.close();
            SimpLanPlusLib.setNumberLabels(0);

            //Lexical Analyzer Ex. 1 - The
            // first part of the function
            //extracts the lexical errors and print them on a file .txt
            String filename = "codice.simplanplus";
            InputStream is = new FileInputStream(filename);
            CharStream input = CharStreams.fromStream(is);
            SimpLanPlusLexer lexer = new SimpLanPlusLexer(input);
            ErrorListener listener = new ErrorListener();
            lexer.addErrorListener(listener);
            lexer.removeErrorListener(lexer.getErrorListeners().get(0));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SimpLanPlusParser parser = new SimpLanPlusParser(tokens);
            parser.addErrorListener(listener);
            parser.removeErrorListener(parser.getErrorListeners().get(0));

            //Symbol Table Ex. 2 - The second part of the function
            //creates the Symbol table implemented as list of hash
            //(visible inside the file SymbolTableManagement.java)
            SimpLanPlusVisitorImpl visitor = new SimpLanPlusVisitorImpl();
            Node ast = visitor.visit(parser.program());
            if(!this.isInterrupted()){
                listener.writeErrorsToFile(); //write the syntax errors to file errori.txt
                if(listener.getNumberErrors() > 0) {
                    int numberSyntaxErrors = parser.getNumberOfSyntaxErrors();
                    int numberLexicalErrors = listener.getNumberErrors() - numberSyntaxErrors;
                    System.err.println("There are " + numberSyntaxErrors + " syntax errors and " + numberLexicalErrors + " lexical errors written in the file errori.txt");
                    this.interrupt();
                }
                if(!this.isInterrupted()){
                    Environment env = new Environment();

                    //Semantic analysis Ex. 3 - After the construction of the symbol table,
                    //the code do the semantic analysis of the SimpLanPlus-code following the
                    //requests written on the project
                    ArrayList<SemanticError> err = ast.checkSemantics(env); //catch the semantic errors and print them
                    if (err.size() > 0) {
                        if(err.size() == 1) {
                            System.err.println("There is " + err.size() + " semantic error:");
                        }else{
                            System.err.println("There are " + err.size() + " semantic errors:");
                        }
                        for (SemanticError singleErr : err) {
                            System.err.println("\t" + singleErr);
                        }
                        this.interrupt();
                    }
                    if(!this.isInterrupted()){
                        ast.typeCheck(env);
                        if(!this.isInterrupted()){
                            System.out.println(ast.toPrint("\t",env)); //print of the tree on the console

                            //Generation assembly code Ex. 4 first part - After all controls, if there aren't
                            //error, the next step consists to generate the bytecode starting to SimpLanPlus
                            //language and write the result in a binary file (extension .asm)
                            String code = ast.codeGeneration(env);
                            String ASMCodeGenerated = "simplanplus.asm";
                            File file = new File(ASMCodeGenerated);
                            file.delete(); //delete the file generated during the previous execution
                            FileWriter codeGenerated = new FileWriter(file,true);
                            codeGenerated.write(code);
                            codeGenerated.flush();
                            codeGenerated.close();





                            InterpreterThread interpreter = new InterpreterThread();
                            interpreter.start();




                        }
                    }
                }
            }
        }catch(Exception errorGenerated){
            errorGenerated.printStackTrace();
            this.interrupt();
        }
    }
}
