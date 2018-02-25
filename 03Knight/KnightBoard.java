public class KnightBoard {
	
	private int[][] board;
	private int[][] move = new int[][] {{-1,-2}, {-1,2}, {1,-2}, {1,2}, {-2,-1}, {-2,1}, {2,-1}, {2,1}};

	public KnightBoard(int startingRows, int startingCols) {
		//@throws IllegalArgumentException when either parameter is negative.
		if (startingRows<0 || startingCols<0) {
			throw new IllegalArgumentException;
		}
		
		board = new int[startingRows][startingCols];
		//Initialize the board to the correct size and make them all 0's 
	}
	 

	public String toString() {
		String string = ""; 
				
		for (int r=0 ; r<board.length ; r++) {
			for (int c=0 ; c<board[0].length ; c++) {
				if (board[r][c] == 0) {
					ans += " _"
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
		if(startingRow<0 || startingCol<0 || startingRow >= numRows || startingCol >= numCols) {
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
		if(startingRow<0 || startingCol<0 || startingRow >= numRows || startingCol >= numCols) {
			throw new IllegalArgumentException();
		}	
		
		return countSolutionsH(startingRow,startingCol,1);
	}
	
	public int countSolutionsH(int row, int col, int level) {
		
	}
}
