import java.util.*;
import java.io.*;

public class Quick {
	
	private static void swap(int[] ary,int a, int b) {
		int c = ary[a];
		ary[a] = ary[b];
		ary[b] = c;
	}

	public static int quickselect(int[] data, int k){
		int start = 0, end = data.length-1;
		int i = partition(data, start, end);

		while(i != k){
			if (i < k){
				start = i+1;
				i = partition(data, start, end);
			}
			else {
				end = i-1;
                i = partition(data, start, end);
			}
			i = partition(data,start,end);
		
		}
		 
		return data[i];
	}

	public static void quicksort(int[] a){
		if (a.length >= 2) {
			QuickSortH(a, 0, a.length - 1);
		}
	}

	public static void QuickSortH(int[] a, int start, int end){
		if(start<end) {
			int x = partition(a,start,end);
			QuickSortH(a,start,x-1);
			QuickSortH(a,x+1,end);
		}
	}

	private static int partition(int[] data,int start,int end){
		if (data.length < 2){
			return start;
		}

		int s = start;
		int pi = (int) (Math.random()*(end-start+1));
		pi += start;
		int pv = data[pi];

		swap(data,pi,end);

		while (start < end+1){

			if(data[start]<pv){
				swap(data,start,s);
				s++;
			}
			start++;

		}

		swap(data,s,end);
		return s;
	}

	
	
	private static final int INCREASE = 0;
	private static final int DECREASE = 1;
	private static final int STANDARD = 2;
	private static final int SMALL_RANGE = 3;
	private static final int EMPTY = 4;

	private static String name(int i){
		if(i==0)return "Increassing";
		if(i==1)return "Decreassing";
		if(i==2)return "Normal Random";
		if(i==3)return "Random with Few Values";
		if(i==4)return "size 0 array";
		return "Error stat array";

	}

	private static int create(int min, int max){
		return min + (int)(Math.random()*(max-min));
	}

	private static int[]makeArray(int size,int type){
		int[]ans =new int[size];
		if(type == STANDARD){
			for(int i = 0; i < size; i++){
				ans[i]= create(-1000000,1000000);
			}
		}
		if(type == INCREASE){
			int current = -5 * size;
			for(int i = 0; i < size; i++){
				ans[i]= create(current,current + 10);
				current += 10;
			}
		}
		if(type == DECREASE){
			int current = 5 * size;
			for(int i = 0; i < size; i++){
				ans[i]= create(current,current + 10);
				current -= 10;
			}
		}
		if(type == SMALL_RANGE){
			for(int i = 0; i < size; i++){
				ans[i]= create(-5,5);
			}
		}
		if(type == EMPTY){
			ans = new int[0];
		}
		return ans;
	}

	public static void main(String[]args){
		if(args.length < 2)return;

		int size =  Integer.parseInt(args[0]);
		int type =   Integer.parseInt(args[1]);

		int [] start = makeArray(size,type);
		int [] result = Arrays.copyOf(start,start.length);
		Arrays.sort(result);

		long startTime = System.currentTimeMillis();
		/*
		 * Test your sort here!
		 */
		quicksort(start);
		long elapsedTime = System.currentTimeMillis() - startTime;
		if(Arrays.equals(start,result)){
			System.out.println("PASS Case "+name(type)+" array, size:"+size+" "+elapsedTime/1000.0+"sec ");
		}else{
			System.out.println("FAIL ! ERROR ! "+name(type)+" array, size:"+size+"  ERROR!");
		}
	}
}


/*pi = selectARandomIndex()
swap (data,pi,lo)
i=lo+1
j=hi
while(i<=j) {
	if data[i]>V: //v is data[0]
		swap(data,i,j)
		j--
		else
			i++
}
swap(data,j,lo)
return j
	//THIS DOESNT ACCOUNT FOR WHEN ARRAY HAS ALL SAME VALUE, ONLY RANDOMIZED ARRAYS
*/