package nodes;

public class ReturnException extends Exception {

	private static final long serialVersionUID = 110629117875938566L;
	private double value;
	public ReturnException(double value) {
		super();
		this.value = value;
	}
	public double getValue() {
		return value;
	}
	

}
