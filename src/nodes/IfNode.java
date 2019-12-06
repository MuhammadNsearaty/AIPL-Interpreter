package nodes;

public class IfNode extends AbstractTreeNode {

	public IfNode() {
		this.name = "If Node";
	}
	@Override
	public Object execute(Context context) throws Exception {
		if ((Boolean)getChildren().get(0).execute(context))
			getChildren().get(1).execute(context);
		else if (getChildren().size() > 2)
			getChildren().get(2).execute(context);
		
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
