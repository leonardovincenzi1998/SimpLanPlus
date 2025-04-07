package util;

public class Environment {
	//symbolTable, nestingLevel and offset are declared private, so there were also implemented the methods that
	//allows to call them when it's needed
	private final SymbolTableManagement symTable;
	private int nestingLevel;
	private int offsetVariabili;
	private int offsetParametriFunzioni;

	//creation of a new environment with an empty symbol table
	public Environment() {
		symTable = new SymbolTableManagement();
		nestingLevel = -1;
		offsetVariabili = 0;
		offsetParametriFunzioni = 0;
	}

	//create a copy of an environment and the symbol table associated
	public Environment(Environment originalEnv) {
		symTable = new SymbolTableManagement(originalEnv.getSymTableManagement().getSymbolTable());
		nestingLevel = originalEnv.getNestingLevel();
		offsetVariabili = originalEnv.getOffsetVariabili();
		offsetParametriFunzioni = originalEnv.getOffsetParametriFunzioni();
		System.out.println("offparamfunEnv: " + offsetParametriFunzioni);
	}

	public SymbolTableManagement getSymTableManagement() {
		return symTable;
	}

	public int getNestingLevel() {
		return nestingLevel;
	}

	public int getOffsetVariabili() {
		return offsetVariabili;
	}

	public void incrementNestingLevel() {
		nestingLevel++;
	}

	public void decrementNestingLevel() {
		nestingLevel--;
	}

	public void decrementOffsetVariabili() {
		offsetVariabili--;
	}

	public void setOffsetVariabili(int offset) {
		this.offsetVariabili=offset;
	}

	public int getOffsetParametriFunzioni() {
		return offsetParametriFunzioni;
	}

	public void setOffsetParametriFunzioni(int offsetParametriFunzioni) {
		this.offsetParametriFunzioni = offsetParametriFunzioni;
	}

	public void decrementOffsetParametriFunzioni() {
		offsetParametriFunzioni--;
	}
}