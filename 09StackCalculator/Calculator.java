import java.util.*;

public class Calculator{

	public static double eval(String s) {
		LinkedList<Double> stack = new LinkedList<>();
		String[] expression = s.split(" ");

		
		for (String i: expression){
			if(isOp(i)) {
				
				double num0 = stack.pop();
				double num1 = stack.pop();
	
				if(i.equals("+")) {
					stack.push(num0+num1);
				}
				
				else if (i.equals("-")) {
					stack.push(num1-num0);
				}
				
				else if (i.equals("*")) {
					stack.push(num0*num1);
				}
				
				else if (i.equals("/")) {
					stack.push(num1/num0);
				}
				
				else if (i.equals("%")){
					stack.push(num0%num1);
				}
				
				else {
					throw new IllegalArgumentException();
				}
				
			}
			
		    else {
		    		stack.push(Double.parseDouble(i));
		    }

		}

		return stack.peek();
		
	}
	
	private static boolean isOp(String exp) {
		if (exp.equals("*") || 
			exp.equals("/") ||
			exp.equals("+") ||
			exp.equals("-") ||
			exp.equals("%")  ) {
			return true;
		}
		
		return false;

	}

}
