package nodes;

public class StringNode extends ExpressionNode{
	String s;
	
	public StringNode(String image) {
		super();
		this.s = image.substring(image.indexOf("\"") + 1, image.lastIndexOf("\""));
	}

	@Override
	public Object execute(Context context) throws Exception {
		return s;
	}
	
}
