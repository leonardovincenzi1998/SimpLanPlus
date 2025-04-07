package ast;

import util.Effect;
import util.Environment;

public class STentry {
  private final int nl;
  private final Node type;
  private int offset;
  private Effect effect;
  private final boolean isFunction;
  private final boolean isArgumentVar;
  private final boolean isParameter;


  public STentry (int nl, Node type, int offset,Effect effect, boolean isFunction, boolean isParameter,boolean isArgumentVar){
	  this.nl = nl;
	  this.type = type;
	  this.offset = offset;
	  this.effect = effect;
	  this.isFunction = isFunction;
	  this.isParameter = isParameter;
      this.isArgumentVar = isArgumentVar;
  }

  public Node getType (){
	  return type;
  }

  public int getOffset (){
	  return offset;
  }

  public void setOffset(int offset){
      this.offset = offset;
  }

  public int getNestinglevel (){
	  return nl;
  }

  public Effect getEffect() {
	  return effect;
  }


  public boolean isAFunction() {
	  return this.isFunction;
  }

  public boolean isAnArgumentVar(){
      return isArgumentVar;
  }
  
  public boolean isParameter() {
	  return isParameter;
  }

  public String toPrint(String indent,Environment env) {
	  Effect initialized = new Effect(true);
	  Effect used = new Effect(true);
	  used.setUsed();
	   return indent + "STentry: nestinglevel " + nl + "\n" +
			  indent + "STentry: type" +  type.toPrint(indent,env) + "\n" +
			  indent + "STentry: offset " + offset + "\n" +
			  indent + "STentry: initialized is " + !(effect.isLess(initialized)) + "\n" +
			  indent + "STentry: used is " + !(effect.isLess(used)) + "\n";
  }
}  