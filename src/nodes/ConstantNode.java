package nodes;

public class ConstantNode extends ExpressionNode {

	private double value;
		
	
	public ConstantNode() {
		super();
		value = 0;
		name = "Constant Node";
	}
	
	@Override
	public void print(String prefix) {
		System.out.println(prefix + this.name + " " + value);
		this.printChildren(prefix + " ");
		
	}


	public ConstantNode(double value) {
		super();
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(String image) {
		this.value = Double.parseDouble(image);
	}

	@Override
	public Object execute(Context context) {	
		return value;		
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
