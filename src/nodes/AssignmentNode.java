package nodes;

public class AssignmentNode extends AbstractTreeNode {
	
	public AssignmentNode() {
		this.name = "Assignment Node";
	}
	String varId;
	String operation;
	
	@Override
	public void print(String prefix) {
		System.out.println(prefix + this.name + " variable " + this.varId);
		this.printChildren(prefix);
	}
	public String getvarId() {
		return varId;
	}
	public void setvarId(String varId) {
		this.varId = varId;
	}
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	@Override
	public Object execute(Context context) throws Exception {
		if(context.getVars().containsKey(varId)) {
			double value = context.getVars().get(varId);
			switch(operation){
			case "*=":{context.getVars().put(varId, value * (Double)getChildren().get(0).execute(context)); break;}
			case "+=":{context.getVars().put(varId, value + (Double)getChildren().get(0).execute(context)); break;}
			case "/=":{context.getVars().put(varId, value / (Double)getChildren().get(0).execute(context)); break;}
			case "-=":{context.getVars().put(varId, value - (Double)getChildren().get(0).execute(context)); break;}
			default:{context.getVars().put(varId, (Double)getChildren().get(0).execute(context));}
			}		
		}
		else {
			if(!operation.equals(":="))
				System.out.println(varId + " dose not exist ignoring operation");
			context.getVars().put(varId, (Double)getChildren().get(0).execute(context));
		}
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
