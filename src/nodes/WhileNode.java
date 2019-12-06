package nodes;

public class WhileNode extends AbstractTreeNode {
	
	public WhileNode() {
		this.name = "While Node";
	}

	@Override
	public Object execute(Context context) {
		while((Boolean)this.getChildren().get(0).execute(context))
		{
			this.getChildren().get(1).execute(context);
		}
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
