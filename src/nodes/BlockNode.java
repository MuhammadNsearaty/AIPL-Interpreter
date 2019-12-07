package nodes;

public class BlockNode extends AbstractTreeNode {
	
	public BlockNode() {
		name = "Block Node";
	}

	@Override
	public Object execute(Context context) throws Exception {
		for (AbstractTreeNode n : children)
			n.execute(context);	
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
