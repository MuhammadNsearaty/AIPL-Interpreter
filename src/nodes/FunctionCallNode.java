package nodes;

import java.util.ArrayList;
import java.util.HashMap;

public class FunctionCallNode extends ExpressionNode {
	
	public FunctionCallNode() {
		super();
		this.name = "Function Call Node";
	}

	@Override
	public Object execute(Context context) {
		if(!Context.functionMap.containsKey(getOperationName())) {
			System.out.println(getOperationName() +" dose not exsit assuming the value is 0");
			return 0.;
		}
		
		ArrayList<String> parIds = Context.functionMap.get(getOperationName()).getParIds();
		
		if(parIds.size() != getChildren().size()) {
			System.out.println(this.getOperationName() +" takes " + parIds.size() + " parameters found" + getChildren().size());
			System.out.println("assuming the value is 0");
			return 0.;
		}
		
		
		int i = 0;
		HashMap<String, Double> globalVars = new HashMap<>();

		//copying global context		
		for(AbstractTreeNode n : getChildren()) {
			double value = (double) n.execute(context);
			if(context.getVars().containsKey(parIds.get(i))) {
				globalVars.put(parIds.get(i), context.getVars().get(parIds.get(i)));
			}
			context.getVars().put(parIds.get(i++), value);
		}
		
		double ret = (double) Context.functionMap.get(this.getOperationName()).execute(context);
		
		for(String id : parIds)
			context.getVars().remove(id);
		
		for(String id : globalVars.keySet())
			context.getVars().put(id, globalVars.get(id));
		
		return ret;
	}

	@Override
	public void print(String prefix) {
		System.out.println(prefix + this.name + " " + this.operationName);
		this.printChildren(prefix);
	}

}
