package nodes;

public class BlockNode extends AbstractTreeNode {
	
	public BlockNode() {
		name = "Block Node";
	}

	@Override
	public Object execute(Context context) throws Exception {
		context.startScope();
		for (AbstractTreeNode n : children)
			n.execute(context);
		context.endScope();
		return null;
	}

	@Override
	public Object convert(Context context) {
		String [] res = new String[children.size()];
		for(int i=0;i<res.length;i++)
			res[i] = (String)children.get(i).convert(context);
		return String.join("\r\n", res);
	}

}
