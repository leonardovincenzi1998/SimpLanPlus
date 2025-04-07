package Interpreter;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleVirtualMachine {
    //la memoria di lavoro è la parte di memoria compresa tra 0 e (MEMORYMAXSIZE-WORKINGMEMORY)
    //lo stack è la parte di memoria compresa tra (MEMORYMAXSIZE-WORKINGMEMORY) e MEMORYMAXSIZE

    private final AssemblyNode assemblyTree;
    private final HashMap<String,Integer> labels;
    private final int MEMORYMAXSIZE = 10000; //valore predefinito di default (dimensione totale della memoria)
    //private final int STACKSIZE;
    //private final int WORKINGMEMORYSIZE;
    private final int MEMORY_RESERVED = 100;
    private int[] memory;


    private HashMap<Integer,int[]> memoryAddress;
    private int counter;



    private int pc; //program counter
    private int sp; //stack pointer
    private int fp; //frame pointer
    private int al; //access link
    private int ra; //return address
    //registers general purpose
    private int a0;
    private int t0;
    private int t1;
    private int t2;
    private int t3;
    private int t4;
    private int t5;
    private int t6;
    private int t7;
    private int t8;
    private int t9;
    
    public SimpleVirtualMachine(SVMNode assemblyTree) {
        this.assemblyTree = (AssemblyNode)(assemblyTree);
        labels = new HashMap<>();
        ArrayList<InstructionNode> listInstructions = this.assemblyTree.getListInstructions();
        //int variablesMemory = 0;
        for(int i = 0;i < listInstructions.size();i++){
            InstructionNode instruction = listInstructions.get(i);
            if(instruction.getName().equals("label")){
                labels.put(instruction.getParameter1(),i);
            }
            /*if(instruction.getName().equals("addi")){
                int temp = Integer.parseInt(instruction.getParameter3());
                if(temp < 0){
                    temp *= -1;
                }
                variablesMemory += temp;
            }*/
        }

        memoryAddress = new HashMap<>();
        counter = 0;



        //STACKSIZE = variablesMemory/2;
        //WORKINGMEMORYSIZE = MEMORYMAXSIZE - STACKSIZE;
        Thread thread = Thread.currentThread();
        /*if(STACKSIZE >= MEMORYMAXSIZE){ //errore di stack sovradimensionato
            System.err.println("Error during the execution: stack overflow.");
            thread.interrupt();
        }*/
        if(!thread.isInterrupted()){
            memory = new int[MEMORYMAXSIZE];
            pc = 0;
            sp = MEMORYMAXSIZE-1;
            fp = MEMORYMAXSIZE-1;
            al = 0;
            ra = 0;
            a0 = 0;
            t0 = 0;
            t1 = 0;
            t2 = 0;
            t3 = 0;
            t4 = 0;
            t5 = 0;
            t6 = 0;
            t7 = 0;
            t8 = 0;
            t9 = 0;
        }
    }

    public int readRegister(String name){
        switch(name){
            case "$pc":
                return pc;
            case "$sp":
                return sp;
            case "$fp":
                return fp;
            case "$al":
                return al;
            case "$ra":
                return ra;
            case "$a0":
                return a0;
            case "$t0":
                return t0;
            case "$t1":
                return t1;
            case "$t2":
                return t2;
            case "$t3":
                return t3;
            case "$t4":
                return t4;
            case "$t5":
                return t5;
            case "$t6":
                return t6;
            case "$t7":
                return t7;
            case "$t8":
                return t8;
            case "$t9":
                return t9;
            default:
                return 0;
        }
    }

    public void writeRegister(String name,int value){
        switch(name){
            case "$pc":
                pc = value;
                break;
            case "$sp":
                sp = value;
                break;
            case "$fp":
                fp = value;
                break;
            case "$al":
                al = value;
                break;
            case "$ra":
                ra = value;
                break;
            case "$a0":
                a0 = value;
                break;
            case "$t0":
                t0 = value;
                break;
            case "$t1":
                t1 = value;
                break;
            case "$t2":
                t2 = value;
                break;
            case "$t3":
                t3 = value;
                break;
            case "$t4":
                t4 = value;
                break;
            case "$t5":
                t5 = value;
                break;
            case "$t6":
                t6 = value;
                break;
            case "$t7":
                t7 = value;
                break;
            case "$t8":
                t8 = value;
                break;
            case "$t9":
                t9 = value;
                break;
            default:
                break;
        }
    }

    public String cpu(){
        ArrayList<InstructionNode> listInstructions = assemblyTree.getListInstructions();
        int indexMemory = MEMORYMAXSIZE - 1;
        writeRegister("$pc",0);
        Thread thread = Thread.currentThread();
        while(readRegister("$pc") < listInstructions.size()){
            if(!thread.isInterrupted()){
                /*if(indexMemory >= WORKINGMEMORYSIZE || indexMemory < 0){
                    System.err.println("Error during the execution: out of memory.");
                    thread.interrupt();
                }*/

                if(indexMemory <= 0){
                    System.err.println("Error during the execution: out of memory.");
                    thread.interrupt();
                }




                InstructionNode instruction = listInstructions.get(readRegister("$pc"));
                String bytecode = instruction.getName();
                String src;
                String destination;
                String departure;
                String register1;
                String register2;
                String label;
                int number;
                int offset;
                boolean result1;
                boolean result2;


               System.out.println("------------------------------------");
                System.out.println(instruction.toPrint(""));
                for (int qw = 0; qw < memory.length; qw++) {
                    if(memory[qw] != 0){
                        System.out.println(qw + " - " + memory[qw]);
                    }
                }
                System.out.println("pc:"+pc);
                System.out.println("sp:"+sp);
                System.out.println("fp:"+fp);
                System.out.println("al:"+al);
                System.out.println("ra:"+ra);
                System.out.println("a0:"+a0);
                System.out.println("t0:"+t0);
                System.out.println("t1:"+t1);
                System.out.println("t2:"+t2);
                System.out.println("t3:"+t3);
                System.out.println("------------------------------------");


                
                switch (bytecode){
                    case "push":
                        src = instruction.getParameter1();
                        if(memory[readRegister("$sp")] == 0) {
                            indexMemory = readRegister("$sp");

                            memory[indexMemory] = readRegister(src);
                           // writeRegister("$sp",readRegister("$sp")-1);
                            indexMemory = indexMemory-1;
                           // writeRegister("$sp",readRegister("$sp")-1);
                            
                            //indexMemory--;
                        }else{
                        	int cont = 0;
                        	while(!(memory[readRegister("$sp") - cont] == 0)) {
                        		cont++;
                        	}
                            memory[readRegister("$sp") - cont] = readRegister(src);
                            
                            indexMemory = readRegister("$sp") - cont;
                            writeRegister("$sp",readRegister("$sp")-cont);
                         //   indexMemory = readRegister("$sp");
                          //  indexMemory -= 2;
                        }
                        //indexMemory++;
                        break;
                    case "pop":
                        memory[readRegister("$sp")] = 0; //readregister $sp
                        writeRegister("$sp",readRegister("$sp")+1);

                        //indexMemory++;
                        break;
                    case "top":
                        destination = instruction.getParameter1();
                        writeRegister(destination,memory[readRegister("$sp")]);
                        break;
                    case "li":
                        destination = instruction.getParameter1();
                        writeRegister(destination,Integer.parseInt(instruction.getParameter2()));
                        break;
                    case "move":
                        destination = instruction.getParameter1();
                        departure = instruction.getParameter2();
                        writeRegister(destination,readRegister(departure));
                        break;
                    case "lw":
                        register1 = instruction.getParameter1();
                        offset = Integer.parseInt(instruction.getParameter2());
                        register2 = instruction.getParameter3();
                        writeRegister(register1,memory[readRegister(register2) + offset]);
                        break;
                    case "sw":
                        register1 = instruction.getParameter1();
                        offset = Integer.parseInt(instruction.getParameter2());
                        register2 = instruction.getParameter3();
                        memory[readRegister(register2) + offset] = readRegister(register1);
                        break;
                    case "lb":
                        register1 = instruction.getParameter1();
                        offset = Integer.parseInt(instruction.getParameter2());
                        register2 = instruction.getParameter3();
                        writeRegister(register1,memory[readRegister(register2) + offset]);
                        break;
                    case "sb":
                        register1 = instruction.getParameter1();
                        offset = Integer.parseInt(instruction.getParameter2());
                        register2 = instruction.getParameter3();
                        memory[readRegister(register2) + offset] = readRegister(register1);
                        break;
                    case "add":
                        destination = instruction.getParameter1();
                        register1 = instruction.getParameter2();
                        register2 = instruction.getParameter3();
                        writeRegister(destination,readRegister(register1)+readRegister(register2));
                        break;
                    case "addi":
                        destination = instruction.getParameter1();
                        register1 = instruction.getParameter2();
                        number = Integer.parseInt(instruction.getParameter3());
                        writeRegister(destination,number+readRegister(register1));
                        break;
                    case "mult":
                        destination = instruction.getParameter1();
                        register1 = instruction.getParameter2();
                        register2 = instruction.getParameter3();
                        writeRegister(destination,readRegister(register1)*readRegister(register2));
                        break;
                    case "multi":
                        destination = instruction.getParameter1();
                        register1 = instruction.getParameter2();
                        number = Integer.parseInt(instruction.getParameter3());
                        writeRegister(destination,number*readRegister(register1));
                        break;
                    case "div":
                        destination = instruction.getParameter1();
                        register1 = instruction.getParameter2();
                        register2 = instruction.getParameter3();
                        if(readRegister(register2) != 0){
                            writeRegister(destination,readRegister(register1)/readRegister(register2));
                        }else{
                            System.err.println("Error during the execution: division by zero isn't allowed.");
                            thread.interrupt();
                        }
                        break;
                    case "divi":
                        destination = instruction.getParameter1();
                        register1 = instruction.getParameter2();
                        number = Integer.parseInt(instruction.getParameter3());
                        if(readRegister(register1) != 0){
                            writeRegister(destination,number/readRegister(register1));
                        }else{
                            System.err.println("Error during the execution: division by zero isn't allowed.");
                            thread.interrupt();
                        }
                        break;
                    case "sub":
                        destination = instruction.getParameter1();
                        register1 = instruction.getParameter2();
                        register2 = instruction.getParameter3();
                        writeRegister(destination,readRegister(register1)-readRegister(register2));
                        break;
                    case "subi":
                        destination = instruction.getParameter1();
                        register1 = instruction.getParameter2();
                        number = Integer.parseInt(instruction.getParameter3());
                        writeRegister(destination,number-readRegister(register1));
                        break;
                    case "bgt":
                        register1 = instruction.getParameter1();
                        register2 = instruction.getParameter2();
                        label = instruction.getParameter3();
                        number = labels.get(label);
                        if(readRegister(register1) > readRegister(register2)){
                            //assegno come valore una unità in meno, in questo modo quando l'indice i si
                            //incrementa alla fine del ciclo il valore è corretto
                            writeRegister("$pc",number-1);
                        }
                        break;
                    case "bgeq":
                        register1 = instruction.getParameter1();
                        register2 = instruction.getParameter2();
                        label = instruction.getParameter3();
                        number = labels.get(label);
                        if(readRegister(register1) >= readRegister(register2)){
                            //assegno come valore una unità in meno, in questo modo quando l'indice i si
                            //incrementa alla fine del ciclo il valore è corretto
                            writeRegister("$pc",number-1);
                        }
                        break;
                    case "bleq":
                        register1 = instruction.getParameter1();
                        register2 = instruction.getParameter2();
                        label = instruction.getParameter3();
                        number = labels.get(label);
                        if(readRegister(register1) <= readRegister(register2)){
                            //assegno come valore una unità in meno, in questo modo quando l'indice i si
                            //incrementa alla fine del ciclo il valore è corretto
                            writeRegister("$pc",number-1);
                        }
                        break;
                    case "blt":
                        register1 = instruction.getParameter1();
                        register2 = instruction.getParameter2();
                        label = instruction.getParameter3();
                        number = labels.get(label);
                        if(readRegister(register1) < readRegister(register2)){
                            //assegno come valore una unità in meno, in questo modo quando l'indice i si
                            //incrementa alla fine del ciclo il valore è corretto
                            writeRegister("$pc",number-1);
                        }
                        break;
                    case "bne":
                        register1 = instruction.getParameter1();
                        register2 = instruction.getParameter2();
                        label = instruction.getParameter3();
                        number = labels.get(label);
                        if(readRegister(register1) != readRegister(register2)){
                            //assegno come valore una unità in meno, in questo modo quando l'indice i si
                            //incrementa alla fine del ciclo il valore è corretto
                            writeRegister("$pc",number-1);
                        }
                        break;
                    case "and":
                        destination = instruction.getParameter1();
                        register1 = instruction.getParameter2();
                        register2 = instruction.getParameter3();
                        result1 = (readRegister(register1) != 0);
                        result2 = (readRegister(register2) != 0);
                        if(result1 && result2){
                            writeRegister(destination,1);
                        }else{
                            writeRegister(destination,0);
                        }
                        break;
                    case "or":
                        destination = instruction.getParameter1();
                        register1 = instruction.getParameter2();
                        register2 = instruction.getParameter3();
                        result1 = (readRegister(register1) != 0);
                        result2 = (readRegister(register2) != 0);
                        if(result1 || result2){
                            writeRegister(destination,1);
                        }else{
                            writeRegister(destination,0);
                        }
                        break;
                    case "not":
                        destination = instruction.getParameter1();
                        src = instruction.getParameter2();
                        if(readRegister(src) == 0){
                            writeRegister(destination,1);
                        }else{
                            writeRegister(destination,0);
                        }
                        break;
                    case "neg":
                        destination = instruction.getParameter1();
                        src = instruction.getParameter2();
                        writeRegister(destination,readRegister(src) * (-1));
                        break;
                    case "print":
                        src = instruction.getParameter1();
                        System.out.println(readRegister(src));
                        break;
                    case "beq":
                        register1 = instruction.getParameter1();
                        register2 = instruction.getParameter2();
                        label = instruction.getParameter3();
                        number = labels.get(label);
                        if(readRegister(register1) == readRegister(register2)){
                            //assegno come valore una unità in meno, in questo modo quando l'indice i si
                            //incrementa alla fine del ciclo il valore è corretto
                            writeRegister("$pc",number-1);
                        }
                        break;
                    case "jal":
                        label = instruction.getParameter1();
                        number = labels.get(label);
                        writeRegister("$ra",readRegister("$pc")+1); //istruzione valida nelle dichiarazioni di funzioni e
                                                            //le rispettive chiamate. Quando chiamo la funzione dopo
                                                            //l'esecuzione della funzione ritorno all'istruzione
                                                            //immediatamente successiva alla chiamata per proseguire
                                                            //con il flusso regolare del programma.
                        writeRegister("$pc",number-1); //assegno come valore una unità in meno, in questo
                                                                    //modo quando l'indice i si incrementa alla fine
                                                                    //del ciclo il valore è corretto
                        break;
                        
                    case "branch":
                        label = instruction.getParameter1();
                        number = labels.get(label);
                        
                        writeRegister("$pc",number-1); //assegno come valore una unità in meno, in questo
                                                                    //modo quando l'indice i si incrementa alla fine
                                                                    //del ciclo il valore è corretto
                        break;
                        
                    case "jr":
                        destination = instruction.getParameter1();
                        //assegno come valore una unità in meno, in questo modo quando l'indice i si
                        //incrementa alla fine del ciclo il valore è corretto
                        writeRegister("$pc",readRegister(destination)-1);
                        break;
                    



                        /*System.out.println("operazione news rilevata " + instruction.getParameter1() + " " + instruction.getParameter2());

                        writeRegister("$fp", readRegister("$sp") + Integer.parseInt(instruction.getParameter2()));

                        if(instruction.getParameter1().equals("program")){
                            System.out.println("fp:" +  ( readRegister("$fp") - 4 )  + "  - sp:" +  (readRegister("$sp") - 4 )  );
                        }else{
                            System.out.println("fp:" + (readRegister("$fp") + 4 - 4) + "  - sp:" + (  (readRegister("$sp")) - 8 - 4 )  );
                        }






                        memoryAddress.put(counter,new int[2]);
                        //memoryAddress.get(counter)[0] = ;
                        //memoryAddress.get(counter)[1] = 0;
                        counter++;*/




                    case "ret":
                        break;
                    case "label":
                        break;
                    case "halt":
                        break;
                    default:
                        System.err.println("Error during the execution: this instruction can't be executed because the virtual machine don't know it.");
                        thread.interrupt();
                }
                if(!thread.isInterrupted()){
                    if(instruction.getName().equals("halt")){
                        break; //exit to the cycle
                    }
                }
            }
            writeRegister("$pc",readRegister("$pc")+1);
        }
        if(!thread.isInterrupted()){
            return "\nExecution terminated successfully.";
        }
        return "\n";
    }
}