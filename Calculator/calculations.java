package Calculator;

public class calculations {
	
	int first = 0;
	int second = 0;
	String operator = null;
	int swap = 0;
	
	public int isSwap() {
		return swap;
	}
	public void setSwap(int swap) {
		this.swap = swap;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public static double adder (int x, int y) {
		
		return x + y;
	}
	public static double subtractor (int x, int y) {
		
		return x - y;
	}
	public static double multiplier (int x, int y) {
		
		return x * y;
	}
	public static double divider (int x, int y) {
		double z = x;
		double w = y;
		double result = z/w;
		return result;
	}
	
	public double calcultaion () {
		double result = 0;
		switch (operator) {
		case "+":
			result = adder(first, second);
			break;
		case "-":
			result = subtractor(first,second);
			break;
		case "*":
			result =  multiplier(first, second);
			break;
		case "/":
			result =  divider(first,second);
			break;
		default: 
			this.setFirst(0);
			this.setSecond(0);
			this.setSwap(0);
		} 
		return result;
		
	}
	
}
