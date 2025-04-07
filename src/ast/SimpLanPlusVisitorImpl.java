package ast;

import java.util.ArrayList;
import ast.expNode.BaseExpNode;
import ast.expNode.BinExpNode;
import ast.expNode.BoolExpNode;
import ast.expNode.CallExpNode;
import ast.expNode.DerExpNode;
import ast.expNode.ExpNode;
import ast.expNode.NegExpNode;
import ast.expNode.NotExpNode;
import ast.expNode.ValExpNode;
import parser.SimpLanPlusBaseVisitor;
import parser.SimpLanPlusParser.ArgContext;
import parser.SimpLanPlusParser.AssignmentContext;
import parser.SimpLanPlusParser.BlockContext;
import parser.SimpLanPlusParser.DecFunContext;
import parser.SimpLanPlusParser.DecVarContext;
import parser.SimpLanPlusParser.DeclarationContext;
import parser.SimpLanPlusParser.ProgramContext;
import parser.SimpLanPlusParser.StatementContext;
import parser.SimpLanPlusParser.CallContext;
import parser.SimpLanPlusParser.PrintContext;
import parser.SimpLanPlusParser.RetContext;
import parser.SimpLanPlusParser.IteContext;
import parser.SimpLanPlusParser.TypeContext;
import parser.SimpLanPlusParser.ExpContext;
import parser.SimpLanPlusParser.BaseExpContext;
import parser.SimpLanPlusParser.NegExpContext;
import parser.SimpLanPlusParser.BinExpContext;
import parser.SimpLanPlusParser.CallExpContext;
import parser.SimpLanPlusParser.DerExpContext;
import parser.SimpLanPlusParser.NotExpContext;
import parser.SimpLanPlusParser.BoolExpContext;
import parser.SimpLanPlusParser.ValExpContext;

public class SimpLanPlusVisitorImpl extends SimpLanPlusBaseVisitor<Node>{
	public ExpNode visitExp(ExpContext ctx){
		return (ExpNode)(visit(ctx));
	}

	@Override
	public Node visitProgram(ProgramContext ctx) {
		ArrayList<DeclarationNode> declarations = new ArrayList<>();
		ArrayList<StatementNode> statements = new ArrayList<>();
		//for every declarations
		for(DeclarationContext decCtx : ctx.declaration()) {
			declarations.add((DeclarationNode)(visitDeclaration(decCtx)));
		}
		//for every statements
		for(StatementContext stmCtx : ctx.statement()) {
			statements.add((StatementNode)(visitStatement(stmCtx)));
		}
		return new ProgramNode(declarations,statements);
	}

	@Override 
	public Node visitBlock(BlockContext ctx) {
		ArrayList<DecVarNode> declarations = new ArrayList<>();
		ArrayList<StatementNode> statements = new ArrayList<>();
		//for every declarations
		for(DecVarContext decCtx : ctx.decVar()) {
			declarations.add((DecVarNode)(visitDecVar(decCtx)));
		}
		//for every statements
		for(StatementContext stmCtx : ctx.statement()) {
			statements.add((StatementNode)(visitStatement(stmCtx)));
		}
		return new BlockNode(declarations,statements);
	}

	@Override 
	public Node visitDeclaration(DeclarationContext ctx) {
		if(ctx.decFun() != null) {
			return new DeclarationNode(visitDecFun(ctx.decFun()));
		} 
		if(ctx.decVar() != null) {
			return new DeclarationNode(visitDecVar(ctx.decVar()));
		}
		return null;
	}

	@Override 
	public Node visitStatement(StatementContext ctx) {
		if(ctx.block() != null) {
			return new StatementNode(visitBlock(ctx.block()));
		}
		if(ctx.call() != null) {
			return new StatementNode(visitCall(ctx.call()));
		} 
		if(ctx.ite() != null) {
			return new StatementNode(visitIte(ctx.ite()));
		}
		if(ctx.ret() != null) {
			return new StatementNode(visitRet(ctx.ret()));
		}
		if(ctx.print() != null) {
			return new StatementNode(visitPrint(ctx.print()));
		}
		if(ctx.assignment() != null) {
			return new StatementNode(visitAssignment(ctx.assignment()));
		}
		return null;
	}

	@Override
	public Node visitDecFun(DecFunContext ctx) {
		Thread thread = Thread.currentThread();
		ArrayList<ArgNode> args = new ArrayList<>();
		for(ArgContext argCtx:ctx.arg()) {
			args.add((ArgNode)(visitArg(argCtx)));
		}
		if(ctx.block() == null){
			System.err.println("The block of the function is null.");
			thread.interrupt();
		}
		if(!thread.isInterrupted()){
			if(ctx.type() != null) {
				return new DecFunNode((TypeNode)(visitType(ctx.type())),new IdNode(ctx.ID().getText()),args,(BlockNode)(visitBlock(ctx.block())));
			}
			return new DecFunNode(new TypeNode("void"),new IdNode(ctx.ID().getText()),args,(BlockNode)(visitBlock(ctx.block())));
		}
		return new DecFunNode(new TypeNode("void"),new IdNode(ctx.ID().getText()),args,null);
	}

	@Override 
	public Node visitType(TypeContext ctx) { 
		return new TypeNode(ctx.getText());
	}

	@Override
	public Node visitArg(ArgContext ctx) {
		boolean var = ctx.children.get(0).toString().equals("var");
		return new ArgNode(var,(TypeNode)(visitType(ctx.type())),new IdNode(ctx.ID().getText()));
	}

	@Override 
	public Node visitAssignment(AssignmentContext ctx) { 
		return new AssignmentNode(new IdNode(ctx.ID().getText()),visitExp(ctx.exp()));
	}

	@Override
	public Node visitPrint(PrintContext ctx) {
		return new PrintNode(visitExp(ctx.exp()));
	}

	@Override 
	public Node visitRet(RetContext ctx) {
		if(ctx.exp() != null) {
			return new RetNode(visitExp(ctx.exp()));
		}
		return new RetNode(null);	
	}

	@Override
	public Node visitIte(IteContext ctx) {
		if(ctx.statement().size()==1) {
			return new IteNode(visitExp(ctx.exp()), (StatementNode)(visitStatement(ctx.statement().get(0))),null);
		}else if(ctx.statement().size()==2) {
			return new IteNode(visitExp(ctx.exp()), (StatementNode)(visitStatement(ctx.statement().get(0))), (StatementNode)(visitStatement(ctx.statement().get(1))));
		}else{
			return null;
		}

		/* ArrayList<StatementNode> statIf = new ArrayList<>();
		ArrayList<StatementNode> statElse = new ArrayList<>();
		int contStatIf = 0;
		int posElse = -1;
		for(int i = 0; i<ctx.children.size(); i++) {
			if(ctx.children.get(i).toString().equals("else")) {
				posElse = i;
			}
		}
		for(int i = 0; i<ctx.children.size(); i++) {
			if(ctx.children.get(i).getClass().getName().contains("Statement")) {
				if(i<posElse) {
					contStatIf++;
				}
			}
		}
		for(int i = 0; i<ctx.statement().size(); i++) {
			if(i<contStatIf) {
				statIf.add(new StatementNode(visitStatement(ctx.statement().get(i))));
			} else {
				statElse.add(new StatementNode(visitStatement(ctx.statement().get(i))));
			}
		}
		for(int i = 0; i<ctx.children.size(); i++) {
			if(i<=posElse) {
				if((ctx.statement(i)) != null) {
					if(ctx.children.get(i).getClass().getName().contains("Statement"))
						statIf.add(new StatementNode(visitStatement(ctx.statement().get(i))));
				}
			} else {
				if((ctx.statement(i)) != null) {
					if(ctx.children.get(i).getClass().getName().contains("Statement"))
						statElse.add(new StatementNode(visitStatement(ctx.statement().get(i))));
				}
			}
		}
		return new IteNode(visitExp(ctx.exp()),statIf, statElse);*/
	}

	@Override 
	public Node visitCall(CallContext ctx) {
		ArrayList<ExpNode> expressions = new ArrayList<>();
		if(!(ctx.exp().isEmpty())){
			for(ExpContext expCtx : ctx.exp()) {
				expressions.add(visitExp(expCtx));
			}
		}
		return new CallNode(new IdNode(ctx.ID().getText()), expressions);
	}

	@Override 
	public Node visitDecVar(DecVarContext ctx) {
		if(ctx.exp() != null) {
			return new DecVarNode((TypeNode)(visitType(ctx.type())),new IdNode(ctx.ID().getText()),visitExp(ctx.exp()));
		} else {
			return new DecVarNode((TypeNode)(visitType(ctx.type())),new IdNode(ctx.ID().getText()),null);
		}
	}

	@Override
	public Node visitBaseExp(BaseExpContext ctx) {
		return new BaseExpNode(visitExp(ctx.exp()));
	}

	@Override 
	public Node visitNegExp(NegExpContext ctx) {
		return new NegExpNode(visitExp(ctx.exp()));
	}

	@Override
	public Node visitBinExp(BinExpContext ctx) {
		if(ctx.left != null && ctx.right != null && ctx.op != null) {
			return new BinExpNode(visitExp(ctx.left),visitExp(ctx.right),ctx.op.toString());
		}
		return null;
	}

	@Override
	public Node visitDerExp(DerExpContext ctx) {
		return new DerExpNode(new IdNode(ctx.ID().getText()));
	}

	@Override
	public Node visitNotExp(NotExpContext ctx) {
		return new NotExpNode(visitExp(ctx.exp()));
	}

	@Override
	public Node visitBoolExp(BoolExpContext ctx) {
		return new BoolExpNode(Boolean.parseBoolean(ctx.getText()));
	}

	@Override
	public Node visitValExp(ValExpContext ctx) {
		return new ValExpNode(Integer.parseInt(ctx.getText()));
	}

	@Override
	public Node visitCallExp(CallExpContext ctx) {
		return new CallExpNode((CallNode)(visitCall(ctx.call())));
	}
}