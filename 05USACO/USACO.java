import java.util.*;
import java.io.*;

public class USACO {

    public static int bronze(String filename){
    		int[][] lake;

    		ArrayList<Integer> list = new ArrayList<Integer>();
    		int ans = 0;
    		
    		try {
    			File text = new File(filename);
    		    Scanner inf = new Scanner(text);
    		    
    		    int R = inf.nextInt();
    		    int C = inf.nextInt();
    		    int E = inf.nextInt();
    		    int N = inf.nextInt();    			
    		    
    		    lake = new int [R][C];
    		    for (int i = 0; i < R; i++){
	    		    	for (int j = 0; j < C; j++){
	    		    		lake[i][j] = inf.nextInt();
	    		    	}
    		    }

    		    while (N>0) {
	    		    	int R_s = inf.nextInt()-1;
	    		    	int C_s = inf.nextInt()-1;
	    		    	int D_s = inf.nextInt();
	    		    
	    		    	while (D_s > 0){
	    		    		for (int r = R_s; r < R+1; r++){
	    		    			for (int c = C_s; c < C; c++){
	    		    				if (r<(R_s+3) && c<(C_s+3)) {
	    		    					list.add(lake[r][c]);
	    		    				}
	    		    			}
	    		    		}

	    		    		int x = list.remove(0);
	    		    		
	    		    		for (int i : list) { 
	    		    			if (i > x) {
	    		    				x = i;
	    		    			}
	    		    		}

	    		    		for(int r = R_s; r < R+1; r++){
	    		    			for (int c = C_s; c < C; c++){
	    		    				if (r < (R_s+3) && c < (C_s+3) && lake[r][c] == x) {
	    		    					lake[r][c] --;
	    		    				}
	    		    			}
	    		    		}

	    		    		D_s--;
	    			}
	    		    	
	    		    	N--;
    		    }

    		    //------------------------------
    		    for (int i = 0; i < R; i++){
	    		    	for (int j = 0; j < C; j++){
	    		    		if (E > lake[i][j]){
	    		    			ans += lake[i][j];
	    		    		}
    				}
    			}
    		}
    		
    		catch (FileNotFoundException e) {
    			System.err.println("FileNotFoundException: " + e.getMessage());
		}

    		return ans*72*72;
    }

    public static int silver(String filename){
        int[][] moves = {{1,0},{0,1},{-1,0},{0,-1}};

    		try{
    			
	    		File text = new File(filename);
	    		Scanner inf = new Scanner(text);
	    		
	    		int N = inf.nextInt();
	    		int M = inf.nextInt();
	    		int T = inf.nextInt();
	    		
	    		inf.nextLine();
	
	    		char[][] field = new char[N][M];
	    		
	    		for (int r = 0; r < N; r++){
	    			String line = inf.nextLine();
	    			for (int c = 0; c < M; c++){
	    				field[r][c] = line.charAt(c);
	    			}
	    		}
	
	    		int R1 = inf.nextInt()-1;
	    		int C1 = inf.nextInt()-1;
	    		int R2 = inf.nextInt()-1;
	    		int C2 = inf.nextInt()-1;
	
	    	
	    	    int[][] board1 = new int[N][M],
	    	            board2 = new int[N][M];

	    		for (int r = 0; r < N; r++){
	    			for (int c = 0; c < M; c++){
	    				if (field[r][c] == '*'){
	    					board1[r][c] = -1;
	    					board2[r][c] = -1;
	    				}
	    				else{
	    					board1[r][c] = 0;
	    					board2[r][c] = 0;
	    				}
	    			}
	    		}
	
	  
	    		board1[R1][C1] = 1;
	    		board2[R1][C1] = 1;

            
            int x = 0;
	    		for (int i=0; i<T; i++){
	    			if (i % 2 == 1){
	    				
	    				for (int r=0; r<N; r++){
	    					for (int c = 0; c < M; c++){
	    						if (board2[r][c] > 0){
	    							board1[r][c] = 0;
	    						}
	    						if (board2[r][c] == 0){
	    							if((r+moves[i][0])<N && (r+moves[i][0])>-1 && (board2[r+moves[i][0]][c])>-1 && (board2[r][c+moves[i][0]])>-1) {
	    								x += board2[r+moves[i][0]][c];
	    							}
	    							if((c+moves[i][0])<M && (c+moves[i][0])>-1 && (board2[r+moves[i][0]][c])>-1 && (board2[r][c+moves[i][0]])>-1) {
	    								x += board2[r][r+moves[i][0]];
	    							}
	    							
	    							board1[r][c] = x;
	    						}
	    					}
	    				}
	    				
	    			}
	
	    			else{
	   
	    				for (int r=0; r<N; r++){
	    					for (int c = 0; c < M; c++){
	    						if (board1[r][c] > 0){
	    							board2[r][c] = 0;
	    						}
	    						if (board1[r][c] == 0){
	    							if((r+moves[i][0])<N && (r+moves[i][0])>-1 && (board1[r+moves[i][0]][c])>-1 && (board1[r][c+moves[i][0]])>-1) {
	    								x += board1[r+moves[i][0]][c];
	    							}
	    							if((c+moves[i][0])<M && (c+moves[i][0])>-1 && (board1[r+moves[i][0]][c])>-1 && (board1[r][c+moves[i][0]])>-1) {
	    								x += board1[r][r+moves[i][0]];
	    							}
	    							
	    							board1[r][c] = x;
	    						}
	    					}
	    				}
	    				
	    			}
	    		}
	
	    		if (T % 2 == 0){
	    			return board1[R2][C2];
	    		}
	    		return board2[R2][C2];
	    	}
	    	
	    	catch (FileNotFoundException e) {
    			System.err.println("FileNotFoundException: " + e.getMessage());
		}
    		
    		return 0;
    }
    
    
    //IVAN'S MAIN FOR TESTING!!
    public static void main(String[] args){
	    	for (int i = 1; i < 2; i ++){
	    		String file = "makelake/makelake." + i; // Remove the "makelake/" if the test files are in the same directory
	    		int ans = getAnswer(file + ".out");
	
	    		int ansU = USACO.bronze(file + ".in");
	
	    		System.out.println("Your Answer: " + ansU);
	    		System.out.println("Answer: " + ans);
	    		System.out.println("Correct? " + (ans == ansU));
	    	}
	    	
	    	for (int i = 1; i < 11; i ++){
	    	    String file = "ctravel/ctravel." + i; // Remove the "ctravel/" if the test files are in the same directory
	    	    int ans = getAnswer(file + ".out");
	    	    
	    	    int ansU = USACO.silver(file + ".in");
	    	    
	    	    System.out.println("Your Answer: " + ansU);
	    	    System.out.println("Answer: " + ans);
	    	    System.out.println("Correct? " + (ans == ansU));
	    	}
    }

    public static int getAnswer(String filename){
	    	try{
	    		File f = new File(filename);
	    		Scanner s = new Scanner(f);
	
	    		String inty = s.nextLine();
	    		return Integer.parseInt(inty);
	
	    	}catch (FileNotFoundException e){
	    		System.out.println("FILE!");
	    	}
	    	return 0;
    }
}
