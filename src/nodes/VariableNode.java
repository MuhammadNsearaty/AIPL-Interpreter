package nodes;

public class VariableNode extends ExpressionNode {

	String varId;
	
	public VariableNode() {
		super();
		name = "Variable Node";
	}

	public String getVarId() {
		return varId;
	}

	public void setVarId(String varId) {
		this.varId = varId;
	}
	
	@Override
	public void print(String prefix) {
		System.out.println(prefix + this.name + " " + varId);
		this.printChildren(prefix + " ");
		
	}

	@Override
	public Object execute(Context context) {
		if(context.getVars().containsKey(varId))
			return context.getVars().get(varId);
		else
			System.out.println(varId +" dose not exsit assuming the value is 0");
		return 0.;
		
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
