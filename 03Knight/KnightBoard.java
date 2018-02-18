public class KnightBoard {
	
	private int[][] board;
	
	//@throws IllegalArgumentException when either parameter is negative.
	public KnightBoard(int startingRows, int startingCols) {
		if(startingRows<0 || startingCols<0) {
			throw new IllegalArgumentException;
		}
		
		board = new int[startingRows][startingCols];
		
		for (int r=0 ; r<board.length ; r++) {
			for (int c=0 ; c<board.length ; c++) {
				board[r][c] = 0;
			}
		}
	}
	 
	//Initialize the board to the correct size and make them all 0's 


	public String toString() {
		String string = ""; 
		for (int r=0 ; r<board.length ; r++) {
		    for (int c=0 ; c<board.length ; c++) {
				
		    }
		    string += "\n";
		}
		return string;
	}
	/*
	see format for toString below
	blank boards display 0's as underscores 
	you get a blank board if you never called solve or 
	when there is no solution 

	@throws IllegalStateException when the board contains non-zero values.
	@throws IllegalArgumentException when either parameter is negative 
	 or out of bounds. 
	 */
	public boolean solve(int startingRow, int startingCol) {
		if() {
			throw new IllegalStateException;
		}
		return solveHelper(startingRow, startingCol, 1);
	}
	/*
	@throws IllegalStateException when the board contains non-zero values. 
	@throws IllegalArgumentException when either parameter is negative 
	 or out of bounds.
	 */
	public int countSolutions(int startingRow, int startingCol) {
		
	}

	
	private boolean solveHelper(int row ,int col, int level) {
		
	}
	// level is the # of the knight
}
