public class KnightBoard {
	
	private int[][] board;
	private int[][] move = new int[][] {{-1,-2}, {-1,2}, {1,-2}, {1,2}, {-2,-1}, {-2,1}, {2,-1}, {2,1}};

	public KnightBoard(int startingRows, int startingCols) {
		//@throws IllegalArgumentException when either parameter is negative.
		if (startingRows<0 || startingCols<0) {
			throw new IllegalArgumentException();
		}
		
		board = new int[startingRows][startingCols];
		//Initialize the board to the correct size and make them all 0's 
	}
	
	
	private boolean inRangeRow(int n) {
		if (n>=0 && n<board.length) {
			return true;
		}
		return false;
	}
	
	private boolean inRangeCol(int n) {
		if (n>=0 && n<board[0].length) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		String string = ""; 
				
		for (int r=0 ; r<board.length ; r++) {
			for (int c=0 ; c<board[0].length ; c++) {
				if (board[r][c] == 0) {
					string += " _";
				}
				else if (board[r][c] % 10 == board[r][c]) {
					string += "  "+board[r][c];
				}
				else {
					string += " "+board[r][c];
				}
			}
			string += "\n";
		}
		
		return string;
	}

	public boolean solve(int startingRow, int startingCol) {
		//@throws IllegalStateException when the board contains non-zero values.
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[0].length; j++){
				if (board[i][j] != 0){
		          throw new IllegalStateException();
		        }
		    }
		}
		//@throws IllegalArgumentException when either parameter is negative or out of bounds.
		if (!(inRangeRow(startingRow)) || !(inRangeCol(startingCol))) {
			throw new IllegalArgumentException();
		}
		
		return solveH(startingRow, startingCol, 1);
	}
	
	private boolean solveH(int row ,int col, int level) {
		// level is the # of the knight
		if (level == board.length*board[0].length){
		    board[row][col] = level;
		    return true;
		}
		
		for (int i=0; i<8 ; i++) {
			int tempRow = row + move[i][0];
			int tempCol = col + move[i][1];
			if ((inRangeRow(tempRow)) && (inRangeCol(tempCol)) && (board[tempRow][tempCol] == 0)) {
				board[row][col] = level;
				if (solveH(tempRow,tempCol,level+1)){
				    return true;
				}
				else {
					board[row][col] = 0;
				}
			}
		}
		return false;
	}
	
	public int countSolutions(int startingRow, int startingCol) {
		//@throws IllegalStateException when the board contains non-zero values.
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[0].length; j++){
				if (board[i][j] != 0){
		          throw new IllegalStateException();
		        }
		    }
		}
		//@throws IllegalArgumentException when either parameter is negative or out of bounds.
		if (!(inRangeRow(startingRow)) || !(inRangeCol(startingCol))) {
			throw new IllegalArgumentException();
		}	
		
		return countSolutionsH(startingRow,startingCol,1);
	}
	
	public int countSolutionsH(int row, int col, int level) {
		int total = 0;
		
		if (level == board.length * board[0].length){
		      return 1;
		}
		
		for (int i=0; i<8 ; i++) {
			int tempRow = row + move[i][0];
			int tempCol = col + move[i][1];
			if ((inRangeRow(tempRow)) && (inRangeCol(tempCol)) && (board[tempRow][tempCol] == 0)) {
				board[row][col] = level;
				total += (countSolutionsH(tempRow,tempCol,level+1));
				board[row][col] = 0;
			}
		}
		
		return total;
	}

	//CRYSTAL'S MAIN!!!
	public static void main(String[] args){
	    KnightBoard a = new KnightBoard(3,3);

	    System.out.println(a);
	    /* Prints
	      _ _ _
	      _ _ _
	      _ _ _
	    */

	    for (int i = 0; i < 3; i++){
	      for (int j = 0; j < 3; j++){
	        if (a.solve(i,j)){
	          System.out.println("There is an error with your solve method");
	        }
	      }
	    } //prints nothing

	    System.out.println(a.countSolutions(0,0)); //prints 0



	    KnightBoard b = new KnightBoard(5,5);
	    System.out.println(b.solve(0,0)); //prints true
	    System.out.println(b); //prints a valid solution

	    try{
	      b.solve(0,0);
	    }catch(IllegalStateException e){
	      System.out.println("Error: The board contains non-zero values");
	    } //prints "Error: The board contains non-zero values"

	    try{
	      b.countSolutions(0,0);
	    }catch(IllegalStateException e){
	      System.out.println("Error: The board contains non-zero values");
	    } //prints "Error: The board contains non-zero values"

	    try{
	      KnightBoard b1 = new KnightBoard(-1,0);
	    }catch(IllegalArgumentException e){
	      System.out.println("Error: There cannot be negative parameters in the constructor");
	    } //prints "Error: There cannot be negative parameters in the constructor"

	    try{
	      KnightBoard b1 = new KnightBoard(1,-1);
	    }catch(IllegalArgumentException e){
	      System.out.println("Error: There cannot be negative parameters in the constructor");
	    } //prints "Error: There cannot be negative parameters in the constructor"

	    try{
	      KnightBoard b1 = new KnightBoard(-1,-1);
	    }catch(IllegalArgumentException e){
	      System.out.println("Error: There cannot be negative parameters in the constructor");
	    } //prints "Error: There cannot be negative parameters in the constructor"

	    try{
	      KnightBoard b1 = new KnightBoard(5,5);
	      b1.solve(0,-1);
	    }catch(IllegalArgumentException e){
	      System.out.println("Error: There cannot be negative parameters");
	    } //prints "Error: There cannot be negative parameters"

	    try{
	      KnightBoard b1 = new KnightBoard(5,5);
	      b1.solve(-1,0);
	    }catch(IllegalArgumentException e){
	      System.out.println("Error: There cannot be negative parameters");
	    } //prints "Error: There cannot be negative parameters"

	    try{
	      KnightBoard b1 = new KnightBoard(5,5);
	      b1.solve(-1,-1);
	    }catch(IllegalArgumentException e){
	      System.out.println("Error: There cannot be negative parameters");
	    } //prints "Error: There cannot be negative parameters"



	    for (int i = 0; i < 5; i++){
	      for (int j = 0; j < 5; j++){
	        KnightBoard abc = new KnightBoard(5,5);
	        System.out.println(abc.solve(i,j)); //prints alternating lines of true/false starting with true
	      }
	    }
	    KnightBoard c = new KnightBoard(5,5);

	    int totalSol = 0;
	    for (int i = 0; i < 5; i++){
	      for (int j = 0; j < 5; j++){
	        totalSol += c.countSolutions(i,j);
	      }
	    }

	    System.out.println(totalSol); //prints 1728

	    KnightBoard d = new KnightBoard(5,5);
	    System.out.println(d.countSolutions(0,0)); //prints 304

	  }
	
}
