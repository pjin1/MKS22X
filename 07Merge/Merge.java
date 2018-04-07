import java.util.*;
import java.io.*;

public class Merge {
	
	public static void mergesort(int[] data) {
		int[] temp = new int[data.length];

		msort(data, temp, 0, data.length-1);
	}

	public static void msort(int[] data, int[] temp, int lo, int hi) {
		if (lo<hi){
			for (int i=lo; i<hi+1; i++){
				temp[i]=data[i];
			}

			msort(temp,data,lo,(lo+hi)/2);
			msort(temp,data,(lo+hi)/2 +1, hi);

			merge(data,temp,lo,(lo+hi)/2,(lo+hi)/2 +1,hi);

		}
	}

	public static void insertionSort(int[] ary, int lo, int hi) {
		for (int i = lo; i < hi; i++) {
			int temp = ary[i];
			int index =i;
			while (index > 0 && temp < ary[index-1]) {
				ary[index] = ary[index-1];
				index--;
			}
			ary[index] = temp;
		}
	}

	
}

/*mergesort(data)
temp=new int[];
msort(data,temp,lo,hi)
msort(temp,data,lo,(lo+hi)/2)
msort(temp,data,(lo+hi)/2 +1, hi)

merge(data,temp,lo,hi)
*/
