package nodes;

public class ForNode extends AbstractTreeNode {
	String varName;
	public ForNode() {
		this.name = "For Node";
	}
	
	@Override
	public void print(String prefix) {
		// TODO Auto-generated method stub
		System.out.println(prefix + this.name + "  var name " + this.varName);
		this.printChildren(prefix);
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	@Override
	public Object execute(Context context) {
		double start = (Double)this.getChildren().get(0).execute(context);
		double end =(Double)this.getChildren().get(0).execute(context);
		double step = 1;
		if(this.getChildren().size() > 3)
			step = (Double)this.getChildren().get(3).execute(context);
		double current = start;
		while(true) {
			if (step < 0 && current < end)
				break;
			if (step > 0 && current > end)
				break;
			context.getVars().put(this.varName,current);
			this.getChildren().get(2).execute(context);
			end = (Double)this.getChildren().get(1).execute(context);
			if(this.getChildren().size() > 3)
				step = (Double)this.getChildren().get(3).execute(context);
			current += step;
		}
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
