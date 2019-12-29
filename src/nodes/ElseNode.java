package nodes;

public class ElseNode extends AbstractTreeNode {

	public ElseNode() {
		name = "Else Node";
	}
	@Override
	public Object execute(Context context) throws Exception {
		children.get(0).execute(context);
		return null;
	}

	@Override
	public Object convert(Context context) {
		return "else{" + children.get(0).convert(context) + "}";
	}

}
