package util;

import ast.Node;

public class SimpLanPlusLib {
	private static int numberLabels=0;

	public static boolean isSubtype (Node a, Node b,Environment env) {
		return a.toPrint("",env).equals(b.toPrint("",env));
	}

	public static String newLabel(String name) {
		String label = name + "_" + numberLabels;
		numberLabels++;
		return label;
	}

	public static void setNumberLabels(int numberLabels){
		SimpLanPlusLib.numberLabels = numberLabels;
	}
}