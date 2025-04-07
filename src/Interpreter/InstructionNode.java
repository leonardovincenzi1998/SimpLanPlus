package Interpreter;

public class InstructionNode implements SVMNode {
    private final String name;
    private final String parameter1;
    private final String parameter2;
    private final String parameter3;

    public InstructionNode(String name){
        this.name = name;
        parameter1 = "";
        parameter2 = "";
        parameter3 = "";
    }

    public InstructionNode(String name,String parameter){
        this.name = name;
        this.parameter1 = parameter;
        parameter2 = "";
        parameter3 = "";
    }

    public InstructionNode(String name,String parameter1,String parameter2){
        this.name = name;
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
        parameter3 = "";
    }

    public InstructionNode(String name,String parameter1,String parameter2,String parameter3){
        this.name = name;
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
        this.parameter3 = parameter3;
    }
    
    @Override
    public String toPrint(String indent) {
        String stringa = "";
        switch(name){
            case "top":
                stringa += parameter1 + " <- " + name;
                break;
            case "label":
                stringa += name + " " + parameter1 + ":";
                break;
            case "lw":
                stringa += name + " " + parameter1 + " " + parameter2 + "(" + parameter3 + ")";
                break;
            case "sw":
                stringa += name + " " + parameter1 + " " + parameter2 + "(" + parameter3 + ")";
                break;
            case "lb":
                stringa += name + " " + parameter1 + " " + parameter2 + "(" + parameter3 + ")";
                break;
            case "sb":
                stringa += name + " " + parameter1 + " " + parameter2 + "(" + parameter3 + ")";
                break;
            default:
                stringa += name + " ";
                if(!(parameter1.equals(""))){
                    stringa += parameter1 + " ";
                }
                if(!(parameter2.equals(""))){
                    stringa += parameter2 + " ";
                }
                if(!(parameter3.equals(""))){
                    stringa += parameter3 + " ";
                }
                break;
        }
        return indent + stringa + "\n";
    }

    public String getName(){
        return name;
    }

    public String getParameter1(){
        return parameter1;
    }

    public String getParameter2(){
        return parameter2;
    }

    public String getParameter3(){
        return parameter3;
    }
}
