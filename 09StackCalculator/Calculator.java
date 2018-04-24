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
					stack.push(num0-num1);
				}
				
				else if (i.equals("*")) {
					stack.push(num0*num1);
				}
				
				else if (i.equals("/")) {
					stack.push(num0/num1);
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

	public static void main(String [] args){
		System.out.println(eval("10 2 +"));//12.0
		System.out.println(eval("10 2 -"));//8.0
		System.out.println(eval("10 2.0 +"));//12.0
		System.out.println(eval("11 3 - 4 + 2.5 *"));//30.0
		System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));//839.0
		System.out.println(eval("10 2 + 10 * 1 + 1 1 1 + + + 10 10 + -"));//104.0
	    }
	}
