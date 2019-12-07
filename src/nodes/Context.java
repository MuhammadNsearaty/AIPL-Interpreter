package nodes;
import java.util.*;
public class Context implements Cloneable{
	public static HashMap<String, FunctionNode> functionMap = new HashMap<>();
	
	private HashMap<String,Double> vars = new HashMap<String, Double>();
	
	public HashMap<String, Double> getVars() {
		return vars;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Context copy = new Context();
		for(String key : vars.keySet())
			copy.vars.put(key, vars.get(key));
		return copy;
	}
}
