import java.util.*;
import java.io.*;

public class USACO {

	public static int bronze(String filename){
		int[][] lake;

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
					ArrayList<Integer> list = new ArrayList<Integer>();
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
								lake[r][c]--;
							}
						}
					}

					D_s--;
				}

				N--;
			}

			//------------------------------


			for (int i = 0; i < lake.length; i++){
				for (int j = 0; j < lake[i].length; j++){
					if (lake[i][j] < E){
						ans += E - lake[i][j];
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

			while (T>0){
				for (int i = 0; i < N; i++){
					for (int j = 0; j < M; j++){
						if (board2[i][j] != -1){

							int[][] moves = {{i+1,j},{i-1,j},{i,j+1},{i,j-1}};

							for (int[] x:moves){
								if (x[0]>-1 && x[0]<N && x[1]>-1 && x[1]<M){
									if(board1[x[0]][x[1]] != -1){
										board2[i][j] += board1[x[0]][x[1]];
									}
								}
							}


						}

					}

				}

				for (int i = 0; i < N; i++){
					for (int j = 0; j < M; j++){
						board1[i][j] = board2[i][j];
						if (board2[i][j] != -1){
							board2[i][j] = 0;
						}
					}
				}


				T = T-1;
			}

			/*if (T % 2 == 0){
	    			return board1[R2][C2];
	    		}*/

			return board1[R2][C2];
		}

		catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException: " + e.getMessage());
		}

		return 0;
	}

}
