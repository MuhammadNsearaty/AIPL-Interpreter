package nodes;
import java.util.*;
public class Context {
	HashMap<String,Double> vars = new HashMap<String, Double>();
	public static HashMap<String, FunctionNode> functionMap = new HashMap<>();
	
	public HashMap<String, Double> getVars() {
		return vars;
	}	
	
}
