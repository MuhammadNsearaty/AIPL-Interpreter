package nodes;

public class AssignmentNode extends AbstractTreeNode {
	
	public AssignmentNode() {
		name = "Assignment Node";
	}
	private String varId;
	private String operation;
	
	@Override
	public void print(String prefix) {
		System.out.println(prefix + name + " variable " + varId);
		printChildren(prefix);
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
			Object b = context.getVars().get(varId);
			double x = (double) children.get(0).execute(context);
			if(b instanceof Double) {
				double value = (double) b;
				switch(operation){
				case "*=":{context.getVars().put(varId, value * x); break;}
				case "+=":{context.getVars().put(varId, value + x); break;}
				case "/=":{context.getVars().put(varId, value / x); break;}
				case "-=":{context.getVars().put(varId, value - x); break;}
				default:{context.getVars().put(varId, x);}
				}
				return null;
			}
			if(b instanceof Integer) {
				int value = (int) b;
				switch(operation){
				case "*=":{context.getVars().put(varId, (int) (value * x)); break;}
				case "+=":{context.getVars().put(varId, (int) (value + x)); break;}
				case "/=":{context.getVars().put(varId, (int) (value / x)); break;}
				case "-=":{context.getVars().put(varId, (int) (value - x)); break;}
				default:{context.getVars().put(varId, (int)x);}
				}
				return null;
			}
			if(!operation.equals(":="))
				System.out.println(varId + " is a Character(s) variable ignoring operation");
		}
		else {
			if(!operation.equals(":="))
				System.out.println(varId + " dose not exist ignoring operation");
			context.getVars().put(varId, (Double)children.get(0).execute(context));
		}
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
