package nodes;

public class IfNode extends AbstractTreeNode {

	public IfNode() {
		this.name = "If Node";
	}
	@Override
	public Object execute(Context context) {
		if ((Boolean)this.getChildren().get(0).execute(context))
			return this.getChildren().get(1).execute(context);
		else if (this.getChildren().size() > 2)
				return this.getChildren().get(2).execute(context);
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
