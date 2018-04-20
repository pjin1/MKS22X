import java.util.*;

public class Sort extends MyLinkedListImproved{

	public static void radixsort(MyLinkedListImproved<Integer> data){
		if (data.size() <= 1){
		    return;
		}
		
		@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] bucket = new MyLinkedListImproved[10];
		
		MyLinkedListImproved<Integer> posVals = new MyLinkedListImproved<>(), negVals = new MyLinkedListImproved<>();

		for (Integer i : data){
			if (i>0){
				posVals.add(i);
			}
			else{
				negVals.add(i);
			}
		}
		
		for(int i = 0; i < 10; i++) {
			bucket[i]= new MyLinkedListImproved<Integer>();
		}
		
	}

	public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){ 
		
	}

}