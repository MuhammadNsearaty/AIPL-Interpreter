package nodes;

public class OrNode extends ConditionNode {

	public OrNode() {
		super();
		name = "Or Node";
	}

	@Override
	public Object execute(Context context) throws Exception {
		boolean b1 = (boolean) children.get(0).execute(context);
		boolean b2 = (boolean) children.get(1).execute(context);

		return b1 || b2;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
