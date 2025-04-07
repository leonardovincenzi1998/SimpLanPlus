package Interpreter;

import java.util.ArrayList;

public class AssemblyNode implements SVMNode {
    private final ArrayList<InstructionNode> listInstructions;

    public AssemblyNode(ArrayList<InstructionNode> listInstructions){
        this.listInstructions = listInstructions;
    }

    @Override
    public String toPrint(String indent) {
        String stringa = "Assembly program executable\n";
        for(InstructionNode instruction:listInstructions){
            if(instruction != null){
                stringa += instruction.toPrint(indent);
            }
        }
        return stringa;
    }

    public ArrayList<InstructionNode> getListInstructions(){
        return listInstructions;
    }
}
