package nodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


public class FunctionCallNode extends ExpressionNode {
	public FunctionCallNode() {
		super();
		name = "Function Call Node";
	}
	
	@Override
	public Object execute(Context context) throws Exception {
		HashMap<String, FunctionNode> workingMap = null;
			for(int i = Context.privateFunctionMaps.size() - 1; i >= 0; i--)
			{
				HashMap<String ,FunctionNode> mp = Context.privateFunctionMaps.get(i);
				if(mp.containsKey(operation)) {
					workingMap = mp;
					break;
				}
			}
			if(workingMap == null)
				if(!Context.functionMap.containsKey(operation))
					throw new RunTimeException(operation + " is not defined");
				else			
					workingMap = Context.functionMap;
				
		ArrayList<String> parIds = workingMap.get(operation).getParIds();
		ArrayList<String> parTypes = workingMap.get(operation).getParTypes();
		
		if(parIds.size() != children.size())
			throw new RunTimeException(operation +" takes " + parIds.size() + " parameters found " + children.size());
		ArrayList<Object> pars = new ArrayList<>();
		StringBuilder builder = new StringBuilder();
		for(int i = 0;i < parTypes.size();i++) {
			Object b = children.get(i).execute(context);
			pars.add(b);
			switch (parTypes.get(i)) {
			case "string":{
				if(!(b instanceof String))
					builder.append(operation + " Parameter " + (i + 1) + " can only be a string\n");
				break;
			}
			case "char":{
				if(!(b instanceof Character))
					builder.append(operation + " Parameter " + (i + 1) + " can only be a character\n");		
				break;
			}			
			case "int":{
				if(!(b instanceof Number))
					builder.append(operation + " Parameter " + (i + 1) + " can only be a number\n");
				break;
			}
			case "double":{
				if(!(b instanceof Number))
					builder.append(operation + " Parameter " + (i + 1) + " can only be a number\n");				
				break;
			}
			}
		}
		if(!builder.toString().isEmpty())
			throw new RunTimeException(builder.toString());

		Object ret = null;
		Context c = new Context();
		for(int i = 0;i < parIds.size();i++) {
			c.createVar(parIds.get(i), parTypes.get(i));
			if(children.get(i) instanceof VariableNode) {
				c.put(parIds.get(i), pars.get(i).toString());
				continue;
			}
			if(!parTypes.get(i).equals("int"))
				c.findAndput(parIds.get(i), pars.get(i), parTypes.get(i));
			else
				c.findAndput(parIds.get(i), pars.get(i), "double");
		}
		try {
			boolean b = workingMap == Context.functionMap;
			Stack<HashMap<String, FunctionNode>> prv = Context.privateFunctionMaps;
			if(b)
				Context.privateFunctionMaps = new Stack<>();
			workingMap.get(operation).execute(c);
			if(b)
				Context.privateFunctionMaps = prv;
		} catch (ReturnException e) {
			ret = AssignmentNode.rets.pop();
		}
		return ret;
	}

	@Override
	public void print(String prefix) {
		System.out.println(prefix + name + " " + operation);
		printChildren(prefix);
	}

}
