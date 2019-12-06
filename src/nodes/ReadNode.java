package nodes;
import java.util.Scanner;
public class ReadNode extends AbstractTreeNode {

	public ReadNode() {
		this.name = "Read Node";
	}
	
	String varName;
	
	
	@Override
	public void print(String prefix) {
		// TODO Auto-generated method stub
		System.out.println(prefix + this.name + " var Name "+this.varName);
		this.printChildren(prefix);
	}

	@Override
	public Object execute(Context context) {
		Scanner scan = new Scanner(System.in);
		context.getVars().put(this.varName,scan.nextDouble());
		return null;
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
