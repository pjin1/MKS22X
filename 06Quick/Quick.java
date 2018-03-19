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

	}
	
	public static void QuickSortH(int[] a, int start, int end){

	}
	
	private static int partition(int[] data,int start,int end){
		Random i = new Random();
		int pi = data[start + i.nextInt(end-start+1)];
		int s = start;
	    start++;
		
	    while (start < end+1){
		    	if (data[start] > pi){
		    		swap(data,start,end);
		    		end--;
		    	}
		    	else if (data[start] < pi){
		    		swap(data,start,s);
		    		s++;
		    		start++;
		    	}
		    	else{
		    		start++;
		    	}
	    }
	    
	    swap(data,start,end);
	    
	    return end;
	}
	
	//IVAN'S MAIN FOR TESTING
	public static void main(String[] args){
		int[] tests = {1000, 999,999,999,4,1,0,3,2,999,999,100,100,-10000, 10212, -19212, 23, 12};

		int ans = partition(tests, 0, tests.length - 1);
		System.out.println("Pivot: " + tests[ans] + " Index: " + ans);
		System.out.println("Pivot correct? " + checkPivot(tests, ans));
		toString(tests);
	}
	private static boolean checkPivot(int[] ary, int pivot){
		for (int i = 0; i < pivot; i++){
			if (ary[i] > ary[pivot]){
				return false;
			}
		}
		for (int j = pivot + 1; j < ary.length; j++){
			if (ary[j] < ary[pivot]){
				return false;
			}
		}
		return true;
	}
	private static void toString(int[] parti){
		for (int k = 0; k < parti.length; k++){
			System.out.print(parti[k] + ", ");
		}
		System.out.println();
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