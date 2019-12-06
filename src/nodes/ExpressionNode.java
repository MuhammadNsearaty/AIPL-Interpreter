package nodes;

public class ExpressionNode extends AbstractTreeNode {

	public ExpressionNode() {
		this.name = "Expression Node";
	}
	protected String operationName;
	
	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
			this.operationName = operationName;
	}

	@Override
	public Object execute(Context context) {
		double d1 = (Double)this.getChildren().get(0).execute(context);
		double d2 = (Double)this.getChildren().get(1).execute(context);
		
		switch(this.operationName)
		{
		case"+":
			return d1+d2;
		case"-":
			return d1-d2;
		case "*":
			return d1*d2;
		case "/":
			return d1/d2;
		
		}
	
		return null;
	}

	@Override
	public void print(String prefix) {
		// TODO Auto-generated method stub
		System.out.println(prefix + this.name + " operation " + this.operationName);
		this.printChildren(prefix);
		
	}

	
	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
