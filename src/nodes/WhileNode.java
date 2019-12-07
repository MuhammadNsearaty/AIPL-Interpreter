package nodes;

public class WhileNode extends AbstractTreeNode {
	
	public WhileNode() {
		this.name = "While Node";
	}

	@Override
	public Object execute(Context context) throws Exception {
		while((Boolean)children.get(0).execute(context))
		{
			children.get(1).execute(context);
		}
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
