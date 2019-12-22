package nodes;
import java.util.*;
public class Context implements Cloneable{
	public static HashMap<String, FunctionNode> functionMap = new HashMap<>();
	
	private HashMap<String,Object> vars = new HashMap<String, Object>();
	
	public HashMap<String, Object> getVars() {
		return vars;
	}
	public void pushFunction() {}
	public void popFunctoin() {}

	private void findAndput(String varName, Object value, String type) throws RunTimeException {
		if(!vars.containsKey(varName))
			vars.put(varName, value);
		else {
			switch (type) {
			case "char":{
				if(vars.get(varName) instanceof Character)
					vars.put(varName,value);
				else
					throw new RunTimeException("Assignment Error");
				break;
			}
			case "string":{
				if(vars.get(varName) instanceof String)
					vars.put(varName,value);
				else
					throw new RunTimeException("Assignment Error");
				break;
			}
			case "double":{
				if(vars.get(varName) instanceof Double)
					vars.put(varName,value);
				else
					throw new RunTimeException("Assignment Error");
	
				break;
			}
			case "int":{
				if(vars.get(varName) instanceof Integer)
					vars.put(varName,value);
				else
					throw new RunTimeException("Assignment Error");
				break;
			}

			default:
				break;
			}
		}
	}
	
	public void put(String varName, String value) throws RunTimeException {
		try {
			Integer x = Integer.parseInt(value);
			findAndput(varName, x, "int");
		}catch(NumberFormatException e) {
			try {
				Double x = Double.parseDouble(value);
				findAndput(varName, x, "double");
			} catch (NumberFormatException e1) {
				if(value.length() == 1)
					findAndput(varName, value.charAt(0), "char");
				else
					findAndput(varName, value, "string");
			}
		}
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Context copy = new Context();
		for(String key : vars.keySet())
			copy.vars.put(key, vars.get(key));
		return copy;
	}
}
