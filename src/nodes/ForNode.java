package nodes;

public class ForNode extends AbstractTreeNode {
	private String varName;
	public ForNode() {
		this.name = "For Node";
	}
	
	@Override
	public void print(String prefix) {
		System.out.println(prefix + name + "  var name " + varName);
		printChildren(prefix);
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	@Override
	public Object execute(Context context) throws Exception {
		double start = (Double)children.get(0).execute(context);
		double end =(Double)children.get(1).execute(context);
		double current = start;
		context.getVars().put(varName,current);
		double step = (Double)children.get(2).execute(context);
		while(true) {
			if (step < 0 && current < end)
				break;
			if (step > 0 && current > end)
				break;
			context.getVars().put(varName,current);
			children.get(3).execute(context);
			end = (Double)children.get(1).execute(context);
			step = (Double)children.get(2).execute(context);
			current += step;
		}
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return "for(" + varName + "=" + children.get(0).convert(context)
				+";" + varName + "<=" + children.get(1).convert(context)
				+ ";" + varName + "+=" + (children.size() > 3? children.get(3).convert(context) : "1")
				+ ")\r\n{" + children.get(2).convert(context) + "}" ;
	}

}
