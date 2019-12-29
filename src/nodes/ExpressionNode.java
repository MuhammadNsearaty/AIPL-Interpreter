package nodes;

public class ExpressionNode extends AbstractTreeNode {

	public ExpressionNode() {
		name = "Expression Node";
	}
	protected String operation;
	
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
			this.operation = operation;
	}
	
	double calc(double d1, double d2) {
		switch(this.operation)
		{
		case"+":
			return d1+d2;
		case"-":
			return d1-d2;
		case "*":
			return d1*d2;
		case "/":
			return d1/d2;
		case "%":
			return d1 % d2;
		case "^":
			return Math.pow(d1, d2);
		default:
			return 0;
		}
	}
	
	@Override
	public Object execute(Context context) throws Exception {
		Object b1 = children.get(0).execute(context);
		Object b2 = children.get(1).execute(context);
		try {
			if(b1 instanceof Integer) {
				int d1 = (int) b1;
				if(b2 instanceof Integer) {
					int d2 = (int) b2;
					return calc(d1, d2);
				}
				else {
					double d2 = (double) b2;
					return calc(d1, d2);
				}
			}
			else{
				double d1 = (double) b1;
				if(b2 instanceof Integer) {
					int d2 = (int) b2;
					return calc(d1, d2);
				}
				else {
					double d2 = (double) b2;
					return calc(d1, d2);
				}
			}
		}catch(ClassCastException e) {
			throw new RunTimeException("operations on strings is not supported");
		}
	}

	@Override
	public void print(String prefix) {
		// TODO Auto-generated method stub
		System.out.println(prefix + name + " operation " + operation);
		printChildren(prefix);
		
	}

	
	@Override
	public Object convert(Context context) {
		return children.get(0).convert(context) + operation
				+ children.get(1).convert(context);
	}

}
