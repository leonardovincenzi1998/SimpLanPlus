package gui;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import java.io.FileInputStream;
import java.io.InputStream;
import Interpreter.SVMVisitorImpl;
import parser.SVMLexer;
import parser.SVMParser;
import Interpreter.SimpleVirtualMachine;
import Interpreter.SVMNode;

public class InterpreterThread extends Thread{
    public InterpreterThread(){}

    @Override
    public void run(){
        try{
            //Interpreter and execution Ex. 4 second and third part
            //This part of the exercise consists to read the bytecode from file generated and
            //execute it on local machine
            String ASMCodeGenerated = "simplanplus.asm";
            InputStream isASM = new FileInputStream(ASMCodeGenerated);
            CharStream inputASM = CharStreams.fromStream(isASM);
            SVMLexer lexerASM = new SVMLexer(inputASM);
            CommonTokenStream tokensASM = new CommonTokenStream(lexerASM);
            SVMParser parserASM = new SVMParser(tokensASM);
            SVMVisitorImpl visitorSVM = new SVMVisitorImpl();
            SVMNode assemblyTree = visitorSVM.visit(parserASM.assembly());
            if(!this.isInterrupted()){
                if (lexerASM.lexicalErrors>0 || parserASM.getNumberOfSyntaxErrors()>0){
                    System.err.println("In the assembly code there are "+lexerASM.lexicalErrors+" lexical errors and "+parserASM.getNumberOfSyntaxErrors()+" syntax errors.");
                    this.interrupt();
                }
                if(!this.isInterrupted()){
                    System.out.println(assemblyTree.toPrint("\t")); //print the tree of the assembly code generated
                    System.out.println("Starting Virtual Machine and execution code\n");
                    SimpleVirtualMachine vm = new SimpleVirtualMachine(assemblyTree);
                    if(!this.isInterrupted()){
                        System.out.println(vm.cpu());
                    }
                }
            }
        }catch(Exception errorGenerated){
            errorGenerated.printStackTrace();
            this.interrupt();
        }
    }
}
