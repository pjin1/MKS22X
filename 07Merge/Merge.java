import java.util.*;
import java.io.*;

public class Merge {
	public static void mergesort(int[] data, int[] temp, int lo, int hi, int lo1, int hi1) {
		
	}
	
	public static void msort(int[] data, int[] temp, int lo, int hi) {
		if (lo<hi){
			for (int i=lo; i<hi+1; i++){
				temp[i]=data[i];
}
msort(temp,data,lo,(lo+hi)/2)
msort(temp,data,(lo+hi)/2 +1, hi)

merge(data,temp,lo,(lo+hi)/2,(lo+hi)/2 +1,hi)

	}
}

/*mergesort(data)
temp=new int[];
msort(data,temp,lo,hi)
msort(temp,data,lo,(lo+hi)/2)
msort(temp,data,(lo+hi)/2 +1, hi)

merge(data,temp,lo,hi)
*/
