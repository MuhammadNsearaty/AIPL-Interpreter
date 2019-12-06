package nodes;

public class ConditionNode extends AbstractTreeNode {
	
	public ConditionNode() {
		this.name = "Condition Node";
	}
	private String operationName;

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	@Override
	public void print(String prefix) {
		System.out.println(prefix + this.name + " : operation name " + this.operationName);
		this.printChildren(prefix);
	}

	@Override
	public Object execute(Context context) {
		
		double d1 = (Double)this.getChildren().get(0).execute(context);
		double d2 = (Double)this.getChildren().get(1).execute(context);
		switch(this.operationName)
		{
		case ">":
			return d1>d2;
		case "<":
			return d1<d2;
		case ">=":
			return d1>=d2;
		case "<=":
			return d1<=d2;
		case"<>":
			return d1!=d2;
		case "=":
			return d1==d2;
		}
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
