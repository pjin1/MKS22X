public class QueenBoard { 
	private int[][]board;
	
	//Constructor:
	public QueenBoard(int size){
		board = new int[size][size];
	}
	
	//Private methods (suggested):
	private boolean addQueen(int r, int c) {
		if (board[r][c] != 0) {
			return false;
		}
		// -1 : Queen
		//  0 : open spot
		// whole numbers : # of queens threatening a spot
		
		//set place as Queen
		board[r][c] = -1;
		
		//check if valid spot
		for (int i=1 ; i<board.length ; i++) {
			if(isOnBoard(r+i,c+i)) {board[r+i][c+i]+=1;}
			if(isOnBoard(r-i,c+i)) {board[r-i][c+i]+=1;}
			if(isOnBoard(r,c+i)) {board[r][c+i]+=1;}
		}
		return true;
	}

	private boolean isOnBoard(int r, int c){
		return (-1<r && r<board.length) && (-1<c && c<board.length);
	}

	private boolean removeQueen(int r, int c) {
		board[r][c] = 0;
		
		//check if valid spot
		for (int i=1 ; i<board.length ; i++) {
			if(isOnBoard(r+i,c+i)) {board[r+i][c+i]-=1;}
			if(isOnBoard(r-i,c+i)) {board[r-i][c+i]-=1;}
			if(isOnBoard(r,c+i)) {board[r][c+i]-=1;}
		}
		return true;
	}
	
	
	//Public Methods:
	public String toString(){
		String string = ""; 
		for (int r=0 ; r<board.length ; r++) {
			for (int c=0 ; c<board.length ; c++) {
				if (board[r][c]==-1) {
					string += "Q";
				}
				else {
					string += "_";
				}
			}
			string += "\n";
		}
		return string;
	}
	
	public boolean solve() {
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board.length; j++){
				if (board[i][j] != 0){
					throw new IllegalStateException();
		        }
		    }
		}
		return solveHelp(0);
	}
	
	public boolean solveHelp(int col){
		if (col == board.length){
			return true;
		}
		for (int r=0 ; r<board.length ; r++){
			if(addQueen(r,col)) {
				if (solveHelp(col+1)) {
					return true;
				}
				else {
					removeQueen(r,col);
				}
			}
		}		
		return false;
	}
	
	public int countSolutions(){
		for(int r=0 ; r<board.length ; r++){
		    for(int c=0; c<board.length ; c++){
				if(board[r][c] != 0){
				    throw new IllegalStateException();
				}
		    }
		}
		return countSolutionsHelp(0);
	}
	
	public int countSolutionsHelp(int col) {
		int sol = 0;
		if (col >= board.length){
		    sol++;
		}
		for (int r=0 ; r<board.length ; r++){
			if(addQueen(r,col)){
				countSolutionsHelp(col+1);
		        removeQueen(r,col);
		    }
		}
		return sol;
	}
	
  
}
