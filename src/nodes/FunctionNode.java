package nodes;

import java.util.ArrayList;

public class FunctionNode extends BlockNode {
	
	ArrayList<String> parIds = new ArrayList<>();
	String functionId;
	
	public FunctionNode() {
		this.name = "Function Node";
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public ArrayList<String> getParIds() {
		return parIds;
	}
	@Override
	public void print(String prefix) {
		System.out.println(prefix + this.name + " " + functionId + " with parameters: " + parIds);
		this.printChildren(prefix);
	}

	public void setParIds(ArrayList<String> parIds) {
		this.parIds = parIds;
	}	

}
