package nodes;

public class BlockNode extends AbstractTreeNode {
	
	public BlockNode() {
		this.name = "Block Node";
	}

	@Override
	public Object execute(Context context) {
		for (AbstractTreeNode n : this.getChildren()){
			if(n instanceof ReturnNode)
				return n.execute(context);
			n.execute(context);
		}
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
