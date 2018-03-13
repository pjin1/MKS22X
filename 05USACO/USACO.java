import java.util.*;
import java.io.*;

public class USACO {

    public static int bronze(String filename){
    		int[][] lake;
    		int R, C, E, N;
    		
    		try {
    			File text = new File(filename);
    		    Scanner inf = new Scanner(text);
    		    
    		    int R = inf.nextInt();
    		    int C = inf.nextInt();
    		    int E = inf.nextInt();
    		    int N = inf.nextInt();    			
    		    
    		    lake = new int [R][C];
    		    
    		    while(inf.hasNextLine()){
    				
    			}
    		    
    		    
    		    
    			//------------------------------
    			for (int i = 0; i < R; x++){
    				for (int j = 0; j < C; y++){
    					if (E > lake[i][j]){
    						ans += lake[i][j];
    					}
    				}
    			}
    			
    			return ans*72*72;
    		}
    		
    		catch (FileNotFoundException e) {
    			System.err.println("FileNotFoundException: " + e.getMessage());
		}

    }

    public static int silver(String filename){
    }
}
