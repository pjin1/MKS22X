import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private boolean animate;//false by default
    private int[][] move = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
    private int w,l;	
    
    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: print a meaningful error and exit the program.
    */
    public Maze(String filename) throws FileNotFoundException{
    		animate = false;

    		File text = new File(filename);
    		Scanner inf = new Scanner(text);
    		Scanner inf1 = new Scanner(text);
    		
    		l = 0;
    		w = 0;
    		
    		while (inf.hasNextLine()){
    			String line = inf.nextLine();
    			l = line.length();
    			w++;
    		}
    		maze = new char[w][l];

		while(inf1.hasNextLine()){
			String line = inf1.nextLine();
			for (int i=0; i<w ; i++){
	    	        for (int j=0; j<l ; j++){
	    	        		maze[i][j] = line.charAt(j);
	    	        }
	    		}
		}
    		
    		if (isValid()) {
    			throw new IllegalStateException("Quite unfortunate...please put valid amounts of starts and ends!");
		}
    }
    
    private boolean isValid() {
    		int e = 0, s = 0;
    		
		for (int i=0 ; i<maze.length ; i++) {
			for (int j=0 ; j<maze[i].length ; j++) {
			    if (maze[i][j] == 'E') {
				    e++;
				}
				if (maze[i][j] == 'S') {
				    s++;
				}
    			}
		}
		
		return e != 1 || s != 1;
    }
    
    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public int solve(){
    		int row = 0, col = 0;
   
    		for (int i = 0; i < maze.length; i++){
    			for (int j = 0; j < maze[i].length; j++){
    				if(maze[i][j] == 'S'){
    					maze[i][j] = '@';
	                row = i;
	                col = j;
    				}
    			}
    		}
    		return solve(row,col,1);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
            Note: This is not required based on the algorithm, it is just nice visually to see.
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col, int steps){ //you can add more parameters since this is private

        //automatic animation! You are welcome.
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }

        if (maze[row][col] == 'E') {
    			return steps;
        }
        
        
        //COMPLETE SOLVE
        return -1; //so it compiles
    }

}