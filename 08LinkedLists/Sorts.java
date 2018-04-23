import java.util.*;

public class Sorts extends MyLinkedListImproved{

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
		
		if (posVals.size() > 0){
		    double max = posVals.max();
		    int maxDig = (int)Math.log10(max);

		    for(int i = 0; i < maxDig; i++){
				for(Integer num : posVals){

			    		int val = (int) (num / Math.pow(10, i)) % 10;
	
			    		bucket[val].add(num);
				}
		    }
		    posVals.clear();
		    
		    for(int i = 0; i < 10; i++){
		    		posVals.extend(bucket[i]);
		    }
		}
		
		if (negVals.size() > 0) {
			double min = negVals.min();
		    int maxDig = (int)Math.log10(min);

		    for(int i = 0; i < maxDig; i++){
				for(Integer num : negVals){

			    		int val = (int) (num / Math.pow(10, i)) % 10;
	
			    		bucket[val].add(num);
				}
		    }
		    negVals.clear();
		    
		    for(int i = 0; i < 10; i++){
		    		negVals.extend(bucket[i]);
		    }
		}

		data.clear();

		for(Integer i: negVals){
			data.add(0, -1*i);
		}
		
		data.extend(posVals);
	    
	}

	public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){ 
		radixsort(data);
	}

}