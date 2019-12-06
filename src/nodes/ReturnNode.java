package nodes;

public class ReturnNode extends AbstractTreeNode {

	public ReturnNode() {
		super();
		this.name = "Return Node";
	}

	
	@Override
	public Object execute(Context context) {
		return getChildren().get(0).execute(context);
	}


	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
