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
			QuickSortH(a,end,x-1);
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