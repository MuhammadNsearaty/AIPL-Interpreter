package nodes;

public class ElseNode extends AbstractTreeNode {

	public ElseNode() {
		this.name = "Else Node";
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
