package nodes;

import java.util.ArrayList;
import java.util.HashMap;

public class FunctionCallNode extends ExpressionNode {
	public FunctionCallNode() {
		super();
		name = "Function Call Node";
	}

	@Override
	public Object execute(Context context) throws Exception {
//		if(!Context.functionMap.containsKey(operation))
//			throw new RunTimeException(operation + "is not defined");
//		
//		ArrayList<String> parIds = Context.functionMap.get(operation).getParIds();
//		
//		if(parIds.size() != children.size())
//			throw new RunTimeException(operation +" takes " + parIds.size() + " parameters found " + children.size());
//		
//		
//		int i = 0;
//		HashMap<String, Double> globalVars = new HashMap<>();
//
//		//copying global context		
//		for(AbstractTreeNode n : children) {
//			double value = (double) n.execute(context);
//			if(context.getVars().containsKey(parIds.get(i))) {
//				globalVars.put(parIds.get(i), context.getVars().get(parIds.get(i)));
//			}
//			context.getVars().put(parIds.get(i++), value);
//		}
//		Double ret = null;
//		try {
//			Context.functionMap.get(operation).execute(context);	
//		} catch (ReturnException e) {
//			ret = e.getValue();
//		}
//		
//		for(String id : globalVars.keySet())
//			context.getVars().put(id, globalVars.get(id));
		
//		return ret;
		return null;
	}

	@Override
	public void print(String prefix) {
		System.out.println(prefix + name + " " + operation);
		printChildren(prefix);
	}

}
