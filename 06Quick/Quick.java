import java.util.*;
import java.io.*;

public class Quick {
	
	public static void main(String[] args) {
		int[] arr = new int[] {4, 3, 2, 1};
		quicksort(arr);
		System.out.println(Arrays.toString(arr));
	}

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
		
		Random i = new Random();
		int pi = data[start + i.nextInt(end-start+1)];
		int s = start;
	    start++;
		
	    swap(data,start,end);
	    
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
	    
	  
	    return end;
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