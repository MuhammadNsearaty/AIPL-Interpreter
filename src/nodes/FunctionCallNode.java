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
		HashMap<String, FunctionNode> workingMap;
		if(!Context.functionMap.containsKey(operation)) {
			if(!Context.privateFunctionMap.containsKey(operation))
				throw new RunTimeException(operation + " is not defined");
			else
				workingMap = Context.privateFunctionMap;
		}
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
			workingMap.get(operation).execute(c);
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
