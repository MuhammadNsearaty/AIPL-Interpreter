package nodes;

public class WriteNode extends AbstractTreeNode {

	public WriteNode() {
		this.name = "Write Node";
	}
	@Override
	public Object execute(Context context) throws Exception {
		System.out.println(this.getChildren().get(0).execute(context));
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
