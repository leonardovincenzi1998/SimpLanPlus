grammar SVM;

@lexer::members {
public int lexicalErrors=0;
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

assembly: (instruction)* ;

instruction:
    ( push		     
	  | pop
	  | top
	  | li
	  | move
	  | lw
	  | sw
	  | lb
	  | sb
	  | add
	  | addi
	  | sub
	  | subi
	  | mult
	  | multi
	  | div
	  | divi
	  | bgt
	  | bgeq
	  | bleq
	  | blt
	  | bne
	  | and
	  | or
	  | not
	  | neg
	  | print
	  | ret
	  | beq
	  | label
	  | jal
	  | branch
	  | jr
	  | halt
	  ) ;

push: PUSH src=REG;

pop: POP;

top: destination=REG '<-' TOP;

li: LI destination=REG numbers=NUMBER;

move: MOVE destination=REG departure=REG;

lw: LW register1=REG offset=NUMBER '('register2=REG')';

sw: SW register1=REG offset=NUMBER '('register2=REG')';

lb: LB register1=REG offset=NUMBER '('register2=REG')';

sb: SB register1=REG offset=NUMBER '('register2=REG')';

add: ADD destination=REG register1=REG register2=REG;

addi: ADDI destination=REG register1=REG value=NUMBER;

sub: SUB destination=REG register1=REG register2=REG;

subi: SUBI destination=REG register1=REG value=NUMBER;

mult: MULT destination=REG register1=REG register2=REG;

multi: MULTI destination=REG register1=REG value=NUMBER;

div: DIV destination=REG register1=REG register2=REG;

divi: DIVI destination=REG register1=REG value=NUMBER;

bgt: BGT register1=REG register2=REG namelab=LABEL;

bgeq: BGEQ register1=REG register2=REG namelab=LABEL;

bleq: BLEQ register1=REG register2=REG namelab=LABEL;

blt: BLT register1=REG register2=REG namelab=LABEL;

bne: BNE register1=REG register2=REG namelab=LABEL;

and: AND destination=REG register1=REG register2=REG;

or: OR destination=REG register1=REG register2=REG;

not: NOT destination=REG src=REG;

neg: NEG destination=REG src=REG;

print: PRINT src=REG;

ret: RET src=REG;

beq: BEQ register1=REG register2=REG namelab=LABEL;

label: LABEL_INSTRUCTION namelab=LABEL ':' ;

jal: JAL namelab=LABEL;

branch: BRANCH namelab=LABEL;

jr: JR destination=REG;

halt: HALT ;


/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

PUSH : 'push' ; 	//pushes constant in the stack
POP	 : 'pop' ; 	//pops from stack
TOP : 'top';
LI : 'li';
MOVE : 'move';
LW : 'lw';
SW : 'sw';
LB : 'lb';
SB : 'sb';

ADD : 'add' ; //add two values from the stack
ADDI : 'addi' ; //add one value from the stack with a number
SUB	 : 'sub' ; //substract two values from the stack
SUBI : 'subi' ; //substract one value from the stack with a number
MULT : 'mult' ; //multiply two values from the stack
MULTI : 'multi' ; //multiply one value from the stack with a number
DIV : 'div' ; //divide two values from the stack
DIVI : 'divi' ; //divide one value from the stack with a number
BGT : 'bgt' ; //greater then (major)
BGEQ : 'bgeq' ; //greater then equals (major equal)
BLEQ : 'bleq' ; //lower then equals (minor equal)
BLT : 'blt' ; //lower then (minor)
BNE : 'bne' ; //not equal
AND : 'and' ; //logical-and
OR : 'or' ; //logical-or
NOT : 'not' ; //not (boolean operator)
NEG : 'neg' ; //not (aritmetic operator [multiplication with -1])

PRINT : 'print' ; //print top of stack
RET : 'ret' ; //return to register specified
BEQ : 'beq' ; //statement if-then-else

LABEL_INSTRUCTION : 'label' ;
JAL : 'jal' ;	//jump to label specified
BRANCH: 'branch'; // jump to label without conditions
JR : 'jr' ;	//jump to register
HALT : 'halt' ;	//stop execution of the program


fragment CHAR : ('a'..'z'|'A'..'Z');
fragment DIGIT  : '0'..'9';

UNDERSCORE : '_';
NUMBER	 :  ('-')? ('0' | ('1'..'9')DIGIT*);
LABEL   : CHAR(CHAR|NUMBER|UNDERSCORE)*;
REG : '$'('t'DIGIT|'ra'|'sp'|'fp'|'a0'|'al'|'pc');

WHITESP  : ( '\t' | ' ' | '\r' | '\n' )+   -> skip;
LINECOMMENTS 	: ';' (~('\n'|'\r'))* -> skip;
ERR : . { System.err.println("Invalid char: "+ getText()); lexicalErrors++;  } -> channel(HIDDEN);