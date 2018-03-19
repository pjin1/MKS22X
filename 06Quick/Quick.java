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
	
	//IVAN'S MAIN FOR TESTING
	public static void main(String[] args){
		int[] tests = {1000, 999,999,999,4,1,0,3,2,999,999,100,100,-10000, 10212, -19212, 23, 12};

		int ans = partition(tests, 0, tests.length - 1);
		System.out.println("Pivot: " + tests[ans] + " Index: " + ans);
		System.out.println("Pivot correct? " + checkPivot(tests, ans));
		toString(tests);
		int[] testt = {};
		ans = partition(testt, 0, 0);
		toString(testt);

		int[] testu = {1};
		ans = partition(testu, 0, 1);
		System.out.println("Pivot: " + testu[ans] + " Index: " + ans);
		toString(testu);


		int[] testv = {1,1};
		ans = partition(testv, 0, 1);
		System.out.println("Pivot: " + testv[ans] + " Index: " + ans);
		toString(testv);

		int[] testw = {2,1};
		ans = partition(testw, 0, 1);
		System.out.println("Pivot: " + testw[ans] + " Index: " + ans);
		toString(testw);

		int[] testx = {1,2};
		ans = partition(testx, 0, 1);
		System.out.println("Pivot: " + testx[ans] + " Index: " + ans);
		toString(testx);
		System.out.println("DONE!\n");



		//Borrowed most from K
		int[] test = {1000, 999,999,999,4,1,0,3,2,999,999,100,100,-10000, 10212, -19212, 23, 12};
		toString(test);	
		////SHOULD PRINT THE ARRAY IN ORDER FROM LEAST TO GREATEST
		System.out.println("\nPRINTING LEAST TO GREATEST");
		for (int i = 0; i < test.length; i++){
		    System.out.println(quickselect(test, i));;
		}
		System.out.println("DONE!\n");


		//Testing QuickSort
		System.out.println("TESTING QUICKSORT!");
		//General Case

		long start,end;
		start = System.currentTimeMillis();

		System.out.print("Before: ");
		int[] testy = {1000, 999,999,999,4,1,0,3,2,999,999,100,100,-10000, 10212, -19212, 23, 12};
		toString(testy);
		quicksort(testy);
		end = System.currentTimeMillis();

		System.out.print("aAfter: ");
		toString(testy);
		System.out.println("Time: " + (end-start) + "ms");

		//Edge Cases
		System.out.print("\nTESTING EDGY CASES!\n");

		int[] testz = {};
		System.out.print("Before: ");
		toString(testz);
		System.out.print("aAfter: ");
		quicksort(testz);
		toString(testz);
		System.out.println();

		int[] testa = {1};
		System.out.print("Before: ");
		toString(testa);
		System.out.print("aAfter: ");
		quicksort(testa);
		toString(testa);
		System.out.println();

		int[] testb = {1,1};
		System.out.print("Before: ");
		toString(testb);
		System.out.print("aAfter: ");
		quicksort(testb);
		toString(testb);
		System.out.println();

		int[] testc = {2,1};
		System.out.print("Before: ");
		toString(testc);
		System.out.print("aAfter: ");
		quicksort(testc);
		toString(testc);
		System.out.println();

		int[] testd = {1,2};
		System.out.print("Before: ");
		toString(testd);
		System.out.print("aAfter: ");
		quicksort(testd);
		toString(testd);
		System.out.println();
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