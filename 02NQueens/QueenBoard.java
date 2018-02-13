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
			if(isOnBoard(r+i,c)) {board[r+i][c]+=1;}
			if(isOnBoard(r-i,c)) {board[r-i][c]+=1;}
			return true;
		}
		return false;
	}

	private boolean isOnBoard(int r, int c){
		return (-1<r && r<board.length) && (-1<c && c<board.length);
	}

	private boolean removeQueen(int r, int c) {
		
		board[r][c] = 0;
		
		//check if valid spot
		for (int i=1 ; i<board.length ; i++) {
			board[r+i][c+i]-=1;
			board[r-i][c+i]-=1;
			board[r][c+i]-=1;
			board[r+i][c]-=1;
			board[r-i][c]-=1;
			return true;
		}
		return false;
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
		for(int r=0 ; r<board.length ; r++){
		    for(int c=0; c<board.length ; c++){
				if(board[r][c] != 0){
				    throw new IllegalStateException();
				}
		    }
		}
		return countSolutionsHelp();
	}
	
	public int countSolutionsHelp() {
		
	}

	public static void main(String[] ans){
	    QueenBoard b = new QueenBoard(4);
	    System.out.println(b.addQueen(0,0));
	    System.out.println(b.addQueen(1,0));
	    System.out.println(b);
	  }
  
}
