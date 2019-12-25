package nodes;

public class VariableNode extends ExpressionNode {

	private String varId;
	
	public VariableNode() {
		super();
		name = "Variable Node";
		operation = "Leaf";
	}
	
	public VariableNode(String s) {
		this.varId = s;
		name = "Variable Node";
		operation = "Leaf";
	}

	public String getVarId() {
		return varId;
	}

	public void setVarId(String varId) {
		this.varId = varId;
	}
	
	@Override
	public void print(String prefix) {
		System.out.println(prefix + name + " " + varId);
		printChildren(prefix + " ");
		
	}

	@Override
	public Object execute(Context context) throws Exception {
		if(context.getVars().containsKey(varId))
			return context.getVars().get(varId);
		else
			throw new RunTimeException("variable " + varId + " is not defined");
		
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
