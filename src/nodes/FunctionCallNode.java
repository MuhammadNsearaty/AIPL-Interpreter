package nodes;

import java.util.ArrayList;
import java.util.HashMap;

public class FunctionCallNode extends ExpressionNode {
	
	public FunctionCallNode() {
		super();
		this.name = "Function Call Node";
	}

	@Override
	public Object execute(Context context) throws Exception {
		if(!Context.functionMap.containsKey(getOperationName()))
			throw new RunTimeException(getOperationName() + "is not defined");
		
		ArrayList<String> parIds = Context.functionMap.get(getOperationName()).getParIds();
		
		if(parIds.size() != getChildren().size())
			throw new RunTimeException(this.getOperationName() +" takes " + parIds.size() + " parameters found " + getChildren().size());
		
		
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
		Double ret = null;
		try {
			Context.functionMap.get(this.getOperationName()).execute(context);	
		} catch (ReturnException e) {
			ret = e.getValue();
		}
		
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
