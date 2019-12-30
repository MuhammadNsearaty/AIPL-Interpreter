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
	private double f(Context context) throws Exception {
		if(children.get(0) instanceof StringNode || children.get(0) instanceof CharNode)
			throw new RunTimeException("operation is not supported");
		double x;
		if(children.get(0) instanceof VariableNode) {
			Object ret = children.get(0).execute(context);
			if(ret instanceof String || ret instanceof Character)
				throw new RunTimeException("operation is not supported");
			if(ret instanceof Integer)
				x = (int) ret;
			else
				x = (double) ret;
		}
		else
			x = (double) children.get(0).execute(context);
		return x;
	}
	
	@Override
	public Object execute(Context context) throws Exception {
		if(varId.equals("ret")) {
			throw new ReturnException(children.get(0).execute(context));
		}
		if(context.getVars().containsKey(varId)) {
			Object b = context.getVars().get(varId);
			if(b instanceof Double) {
				double x = f(context);
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
				double x = f(context);
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
				throw new RunTimeException("operation is not supported");
			
			if(children.get(0) instanceof VariableNode)
				context.put(varId, (String) children.get(0).execute(context).toString());
			else
			if(children.get(0) instanceof CharNode) {
				if(b instanceof Character)
					context.getVars().put(varId, children.get(0).execute(context));
			}else
			if(children.get(0) instanceof StringNode) {
				if(b instanceof String)
					context.getVars().put(varId, children.get(0).execute(context));
			}
			else
				throw new RunTimeException("operation is not supported");	
		}
		else {
			if(!operation.equals(":="))
				System.err.println(varId + " dose not exist ignoring operation");
			context.put(varId, (String) children.get(0).execute(context).toString());	
		}
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return varId + "=" + children.get(0).convert(context) + ";";
	}

}
