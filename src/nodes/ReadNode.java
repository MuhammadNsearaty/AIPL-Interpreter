package nodes;
import java.util.Scanner;
public class ReadNode extends AbstractTreeNode {

	public ReadNode() {
		this.name = "Read Node";
	}
	
	private String varName;
	
	
	@Override
	public void print(String prefix) {
		// TODO Auto-generated method stub
		System.out.println(prefix + name + " var Name "+ varName);
		printChildren(prefix);
	}

	@Override
	public Object execute(Context context) throws RunTimeException {
		context.put(varName, new Scanner(System.in).next());
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
