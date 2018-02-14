public class QueenBoard { 
    private int[][]board;
	
    //Constructor:
    public QueenBoard(int size){
	board = new int[size][size];
    }
	
    //Private methods (suggested):
    private boolean addQueen(int r, int c){

		// -1 : Queen
		//  0 : open spot
		// whole numbers : # of queens threatening a spot
		
    		if (board[r][c] != 0) {
			return false;
		}
    		if (isOnBoard(r,c)){
			board[r][c] = -1;
			for (int i=1 ; i<board.length ; i++) {
				if(isOnBoard(r+i,c+i)) {board[r+i][c+i]+=1;}
				if(isOnBoard(r-i,c+i)) {board[r-i][c+i]+=1;}
				if(isOnBoard(r,c+i)) {board[r][c+i]+=1;}
			}
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
			    string += " Q ";
			}
			else {
			    string += " _ ";
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
		return countSolutionsHelp(0,0);
    }
	
    public int countSolutionsHelp(int col, int sol) {
		if (col >= board.length){
		    sol++;
		    return sol;
		}
		for (int r=0 ; r<board.length ; r++){
		    if(addQueen(r,col)){
				sol = countSolutionsHelp(col+1, sol);
				removeQueen(r,col);
		    }
		}
		return sol;
    }
    
    //CRYSTAL'S MAIN!!!
    public static void main(String[] ans){
		QueenBoard b = new QueenBoard(4);
	
		System.out.println(b.solve()); //prints true
		System.out.println(b); //prints a valid solution
	
		try{
		    b.solve();
		}catch(IllegalStateException e){
		    System.out.println("Error: The board contains non-zero values");
		} //prints "Error: The board contains non-zero values"
	
		try{
		    b.countSolutions();
		}catch(IllegalStateException e){
		    System.out.println("Error: The board contains non-zero values");
		} //prints "Error: The board contains non-zero values"
	
		for (int i = 0; i < 12; i++){
		    QueenBoard a = new QueenBoard(i);
		    System.out.println("# of Solutions for " + i + ": " + a.countSolutions());
		    /*          Expected Values
				i --> # of Solutions   i --> # of Solutions
				0 --> 1                6 --> 4
				1 --> 1                7 --> 40
				2 --> 0                8 --> 92
				3 --> 0                9 --> 352
				4 --> 2               10 --> 724
				5 --> 10              11 --> 2680
		    */
		    
		}
    }
  
}
