package nodes;
import java.util.ArrayList;

public abstract class AbstractTreeNode {
	
	protected String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private ArrayList<AbstractTreeNode> children = new ArrayList<AbstractTreeNode>();
	public ArrayList<AbstractTreeNode> getChildren(){
		return this.children;
	}
	//add function for arraylist
	public void addChild(AbstractTreeNode child) {
		this.children.add(child);
	}
	public abstract Object execute(Context context);
	public abstract Object convert(Context context);
	public void print(String prefix) {
		System.out.println(prefix + this.getName());
		this.printChildren(prefix);
	}
	public void printChildren(String prefix) {
		for(AbstractTreeNode node : children)
			node.print(prefix + "  ");
	}
}
