package nodes;

public class DefNode extends AbstractTreeNode{

	private String varName;
	private String varType;
	
	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	public String getVarType() {
		return varType;
	}

	public void setVarType(String varType) {
		this.varType = varType;
	}

	public DefNode() {
		super();
		name = "Def Node";
	}

	@Override
	public Object execute(Context context) throws Exception {
		if(!context.getVars().containsKey(varName))
			switch (varType) {
			case "int":{
				context.getVars().put(varName, new Integer(0));
				break;
			}
			case "char":{
				context.getVars().put(varName, new Character('\0'));
				break;
			}
			case "string":{
				context.getVars().put(varName, new String(""));			
				break;
			}
			case "double":{
				context.getVars().put(varName, new Double(0));
				break;
			}
			default:
				break;
			}
		else
			throw new RunTimeException("you can't change variable type");
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
