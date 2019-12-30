package nodes;

public class ConstantNode extends ExpressionNode {

	private Object value;
		
	
	public ConstantNode() {
		super();
		value = 0;
		name = "Constant Node";
		operation = "Leaf";
	}
	
	@Override
	public void print(String prefix) {
		System.out.println(prefix + name + " " + value);
		this.printChildren(prefix + " ");
		
	}


	public ConstantNode(double value) {
		super();
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(String image) {
		try {
			this.value = Integer.parseInt(image);
		}catch(NumberFormatException e) {
			this.value = Double.parseDouble(image);
		}
	}

	@Override
	public Object execute(Context context) {	
		return value;		
	}

	@Override
	public Object convert(Context context) {
		return value +"";
	}

}
