package nodes;

public class CharNode extends ExpressionNode {
	
	char c;
	
	public CharNode(String s) {
		super();
		if(s.length() >= 3)
			this.c = s.charAt(1);
		else
			this.c = '\0';
	}

	@Override
	public Object execute(Context context) throws Exception {
		return c;
	}
	
	public Object convert(Context context) {
		return "\'" + c +"\'";
	}

}
