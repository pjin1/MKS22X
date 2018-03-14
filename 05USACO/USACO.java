import java.util.*;
import java.io.*;

public class USACO {

    public static int bronze(String filename){
    		int[][] lake;
    		int R, C, E, N;
    		int ans = 0;
    		
    		try {
    			File text = new File(filename);
    		    Scanner inf = new Scanner(text);
    		    
    		    int R = inf.nextInt();
    		    int C = inf.nextInt();
    		    int E = inf.nextInt();
    		    int N = inf.nextInt();    			
    		    
    		    lake = new int [R][C];
    		    
    		    for (int i = 0; row < R; i++){
	    		    	for (int j = 0; col < C; j++){
	    		    		pasture[i][j] = inf.nextInt();
	    		    	}
    		    }
    		    
    		    while(inf.hasNextLine()){
    				
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
    }
}
