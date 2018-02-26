public class Recursion {
	public int fact(int n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		if (n == 0) {
			return 1;
		}
		return n * fact(n - 1);
	}
	
	public int fib (int n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		
		return fibHelp(n, 0, 1);
	}
	
	public int fibHelp (int n, int f1, int f2) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return f2;
		}
		return fibHelp (n-1, f2, f1 + f2);
	}
	
	public double sqrt (double n) {
		return sqrtHelp(n, n/2);
	}
	
	public double sqrtHelp (double n, double guess) {
		double sqGuess = guess * guess;
		double guess1 = (n / guess + guess) / 2;
		
		if (n < 0){
			throw new IllegalArgumentException();
	    }
	    else if(n == 0){
	    		return 0;
	    }
	    else if (Math.abs((sqGuess - n) / n)< 0.0001){
		    return guess; 
	    }
		
		return sqrtHelp(n, guess1);
	}
	
	public static void main(String[] args) {
		Recursion r = new Recursion();
		
		System.out.println(r.fact(0));
		System.out.println(r.fact(1));
		System.out.println(r.fact(2));
		System.out.println(r.fact(3));
		System.out.println(r.fact(4));
		
		System.out.println(r.fib(0));
		System.out.println(r.fib(1));
		System.out.println(r.fib(2));
		System.out.println(r.fib(3));
		System.out.println(r.fib(4));
		System.out.println(r.fib(5));
		
		System.out.println(r.sqrt(1.0));
	    System.out.println(r.sqrt(2.0));
	    System.out.println(r.sqrt(4.0));
	    System.out.println(r.sqrt(9.0));
	    System.out.println(r.sqrt(100.0));
	    System.out.println(r.sqrt(676.0));
	}
	
}
