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
		//set place as Queen
		//-1:Queen
		//0:open spot
		//whole numbers:# of queens threatening a spot
		board[r][c] = -1;
		//check if valid spot
		for (int i=0 ; i<board.length ; i++) {
			if(isOnBoard()){			
				board[r+i][c+i]+=1;
				board[r-i][c+i]+=1;
				board[r][c+i]+=1;
				board[r+i][c]+=1;
				board[r-i][c]+=1;
			}
		}
	}
	private boolean isOnBoard(int r, int c){
		if(-1<r<board
	}

	private boolean removeQueen(int r, int c) {
		
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
	
	public boolean solve(int col){
		if (col == board.length){
			return true;
		}
		for (int r=0 ; r<board.length ; r++){
			addQueen(r,col);
			if (solve(col+1)) {
				return true;
			}
			else {
				removeQueen(r,col);
			}
		}		
		return false;
	}
	
	public int countSolutions(){
		return 1;
	}
  
}
