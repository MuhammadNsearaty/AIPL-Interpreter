package nodes;

public class IfNode extends AbstractTreeNode {

	public IfNode() {
		this.name = "If Node";
	}
	@Override
	public Object execute(Context context) throws Exception {
		if ((Boolean)children.get(0).execute(context))
			children.get(1).execute(context);
		else if (children.size() > 2)
			children.get(2).execute(context);
		
		return null;
	}

	@Override
	public Object convert(Context context) {
		return "if(" + children.get(0).convert(context) + "){\n"
				+ children.get(1).convert(context) + 
				"}\n" + (children.size() > 2? children.get(2).convert(context) :"" );
	}

}
