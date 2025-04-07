package util;

import java.util.ArrayList;
import java.util.HashMap;
import ast.STentry;
import ast.TypeNode;

public class SymbolTableManagement {
	private final ArrayList<HashMap<String, STentry>> symTable;

    public SymbolTableManagement(){
    	symTable = new ArrayList<>();
    }

    public SymbolTableManagement(ArrayList<HashMap<String, STentry>> st){
    	symTable = new ArrayList<>();
    	for(HashMap<String,STentry> hm:st){
            HashMap<String,STentry> hmCopy = new HashMap<>();
            for(String entry:hm.keySet()){
                STentry flag = hm.get(entry);
                STentry flagCopy = new STentry(flag.getNestinglevel(), flag.getType(), flag.getOffset(),new Effect(false),flag.isAFunction(),flag.isParameter(),flag.isAnArgumentVar());
                if(flag.getEffect().isInitialized()){
                    flagCopy.getEffect().setInitialized();
                }else{
                    if(flag.getEffect().isUsed()){
                        flagCopy.getEffect().setUsed();
                    }
                }
                hmCopy.put(entry,flagCopy);
            }
            symTable.add(hmCopy);
        }
    }

    public ArrayList<HashMap<String, STentry>> getSymbolTable() {
        return symTable;
    }

    public HashMap<String, STentry> getLevel(int nl){
        return symTable.get(nl);
    }

    public STentry getEntryId(String id, int nl){
        for(int i=nl; i>=0; i--){
            if(symTable.get(i).get(id) != null)
                return symTable.get(i).get(id);
        }
        return null;
    }

    public void addLevel(HashMap<String, STentry> newLevel){
    	symTable.add(newLevel);
    }

    public void removeLevel(int index){
    	symTable.remove(index);
    }

    public int computeMemorySpace(int nestinglevel){
        int totalSpace = 0;
        HashMap<String,STentry> hm = symTable.get(nestinglevel);
        STentry flag;
        for(String id:hm.keySet()){
            flag = hm.get(id);
            if(!(flag.isAFunction()) && !(flag.isParameter())){
                TypeNode typeVariable = (TypeNode)(flag.getType());
                if(typeVariable.getType().equals("int")){
                    totalSpace += 4;
                }
                if(typeVariable.getType().equals("bool")){
                    totalSpace += 1;
                }
            }
        }
        return totalSpace;
    }
}