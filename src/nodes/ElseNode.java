package nodes;

public class ElseNode extends AbstractTreeNode {

	public ElseNode() {
		this.name = "Else Node";
	}
	@Override
	public Object execute(Context context) throws Exception {
		getChildren().get(0).execute(context);
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
