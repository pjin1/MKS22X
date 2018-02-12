public class QueenBoard { 
	private int[][]board;
	
	//Constructor:
	public QueenBoard(int size){
		board = new int[size][size];
	}
	
	//Private methods (suggested):
	private boolean addQueen(int r, int c) {
		//check if place is valid
		if (board[r][c] != 0) {
			return false;
		}
		//set place as Queen
		board[r][c] = -1;
		for (int i=0 ; i<board.length ; i++) {
			
		}
		for (int i=0 ; i<board.length ; i++) {
			
		}
		for (int i=0 ; i<board.length ; i++) {
			
		}
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
	
	public boolean solve(){
		return true;
	}
	
	public int countSolutions(){
		return 1;
	}
  
}