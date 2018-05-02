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
		    int maxDig = (""+max).length();

		    for(int i = 0; i < maxDig; i++){
				for(Integer num : posVals){

			    		int val = (int) (num / Math.pow(10, i)) % 10;
	
			    		bucket[val].add(num);
				}
		    }

		    posVals.clear();
		    
		    for(int i = 0; i < 10; i++){
		    		posVals.extend(bucket[i]);
		    		bucket[i].clear();
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
			data.add(0, i);
		}
		System.out.println("positive vals: " + posVals);
		data.extend(posVals);
	    
	}

	public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){ 
		radixsort(data);
	}

	  public static void main(String[] args) {
	  	MyLinkedListImproved<Integer> donut = new MyLinkedListImproved<>();
	  	for(int i = 0; i < 10; i++){
	      int temp = (int)(Math.random() * 10);
	      donut.add(temp);
	    }
	  	System.out.println("orig linked list: " + donut + "\n\n\n\n\n\n\n");
	  	radixsort(donut);
	  	System.out.println("suppoed to be sorted: " + donut);

	    // //-----------SORTING POSITIVES-----------
	    // System.out.println("TESTING ON POSITIVE INTEGERS ONLY:");
	    // MyLinkedListImproved<Integer> data = new MyLinkedListImproved<>();
	    // int[] correctData = new int[1000];

	    // //Create MyLinkedListImproved and array with random integers
	    // for(int i = 0; i < 1000; i++){
	    //   int temp = (int)(Math.random() * 1000);
	    //   data.add(temp);
	    //   correctData[i] = temp;
	    // }

	    // //Sorts data and times the sort
	    // long end,start = System.currentTimeMillis();
	    // radixsort(data);
	    // end = System.currentTimeMillis();

	    // //Sorts the array
	    // Arrays.sort(correctData);
	    // System.out.println("Sort completed in " + (end - start) + " seconds");

	    // //Checks if data is properly sorted
	    // boolean hasError = false;
	    // int index = 0;
	    // for(Integer x: data){
	    //   if(!(x.equals(correctData[index]))){
	    //     System.out.println("THERE IS AN ERROR");
	    //     System.out.println("Index of error: " + index);
	    //     hasError = true;
	    //   }
	    //   index++;
	    // }

	    // if(!(hasError)){
	    //   System.out.println("Your LinkedList with all positive integers is properly sorted.");
	    // }
	    // else{
	    //   System.out.println(data);
	    // }
	    // System.out.println("\n");


	    // //-----------SORTING NEGATIVES-----------
	    // System.out.println("TESTING ON NEGATIVE INTEGERS ONLY:");
	    // data.clear();
	    // correctData = new int[1000];

	    // //Create MyLinkedListImproved and array with random integers
	    // for(int i = 0; i < 1000; i++){
	    //   int temp = (int)(Math.random() * 1000);
	    //   temp *= -1;
	    //   data.add(temp);
	    //   correctData[i] = temp;
	    // }

	    // //Sorts data and times the sort
	    // start = System.currentTimeMillis();
	    // radixsort(data);
	    // end = System.currentTimeMillis();

	    // //Sorts the array
	    // Arrays.sort(correctData);
	    // System.out.println("Sort completed in " + (end - start) + " seconds");

	    // //Checks if data is properly sorted
	    // hasError = false;
	    // index = 0;
	    // for(Integer x: data){
	    //   if(!(x.equals(correctData[index]))){
	    //     System.out.println("THERE IS AN ERROR");
	    //     System.out.println("Index of error: " + index);
	    //     hasError = true;
	    //   }
	    //   index++;
	    // }

	    // if(!(hasError)){
	    //   System.out.println("Your LinkedList with all negative numbers is properly sorted.");
	    // }
	    // else{
	    //   System.out.println(data);
	    // }
	    // System.out.println("\n");


	    // //-----------SORTING POSITIVES AND NEGATIVES-----------
	    // System.out.println("TESTING ON POSITIVE AND NEGATIVE INTEGERS:");
	    // data.clear();
	    // correctData = new int[1000];

	    // //Create MyLinkedListImproved and array with random integers
	    // for(int i = 0; i < 1000; i++){
	    //   int temp = (int)(Math.random() * 1000);
	    //   if((int)(Math.random() * 1000) % 2 == 0){
	    //     temp *= -1;
	    //   }
	    //   data.add(temp);
	    //   correctData[i] = temp;
	    // }

	    // //Sorts data and times the sort
	    // start = System.currentTimeMillis();
	    // radixsort(data);
	    // end = System.currentTimeMillis();

	    // //Sorts the array
	    // Arrays.sort(correctData);
	    // System.out.println("Sort completed in " + (end - start) + " seconds");

	    // //Checks if data is properly sorted
	    // hasError = false;
	    // index = 0;
	    // for(Integer x: data){
	    //   if(!(x.equals(correctData[index]))){
	    //     System.out.println("THERE IS AN ERROR");
	    //     System.out.println("Index of error: " + index);
	    //     hasError = true;
	    //   }
	    //   index++;
	    // }

	    // if(!(hasError)){
	    //   System.out.println("Your LinkedList with positive and negative integers is properly sorted.");
	    // }
	    // else{
	    //   System.out.println(data);
	    // }
	    // System.out.println("\n");


	    // //-----------SORTING EMPTY LISTS-----------
	    // System.out.println("SORTING ON EMPTY LISTS");
	    // data.clear();
	    // correctData = new int[0];

	    // start = System.currentTimeMillis();
	    // radixsort(data);
	    // end = System.currentTimeMillis();

	    // //Sorts the array
	    // Arrays.sort(correctData);
	    // System.out.println("Sort completed in " + (end - start) + " seconds");

	    // //Checks if data is properly sorted
	    // hasError = false;
	    // index = 0;
	    // for(Integer x: data){
	    //   if(!(x.equals(correctData[index]))){
	    //     System.out.println("THERE IS AN ERROR");
	    //     System.out.println("Index of error: " + index);
	    //     hasError = true;
	    //   }
	    //   index++;
	    // }

	    // if(!(hasError)){
	    //   System.out.println("Your empty LinkedList is properly sorted.");
	    // }
	    // else{
	    //   System.out.println(data);
	    // }
	    // System.out.println("\n");


	    // //-----------SORTING POSITIVE ONE-ELEMENT LISTS-----------
	    // System.out.println("SORTING POSITIVE ONE-ELEMENT LISTS");
	    // data.clear();
	    // correctData = new int[1];

	    // int temp = (int)(Math.random() * 1000);
	    // data.add(temp);
	    // correctData[0] = temp;

	    // start = System.currentTimeMillis();
	    // radixsort(data);
	    // end = System.currentTimeMillis();

	    // //Sorts the array
	    // Arrays.sort(correctData);
	    // System.out.println("Sort completed in " + (end - start) + " seconds");

	    // //Checks if data is properly sorted
	    // hasError = false;
	    // index = 0;
	    // for(Integer x: data){
	    //   if(!(x.equals(correctData[index]))){
	    //     System.out.println("THERE IS AN ERROR");
	    //     System.out.println("Index of error: " + index);
	    //     hasError = true;
	    //   }
	    //   index++;
	    // }

	    // if(!(hasError)){
	    //   System.out.println("Your LinkedList with one positive element is properly sorted.");
	    // }
	    // else{
	    //   System.out.println(data);
	    // }
	    // System.out.println("\n");


	    // //-----------SORTING NEGATIVE ONE-ELEMENT LISTS-----------
	    // System.out.println("SORTING NEGATIVE ONE-ELEMENT LISTS");
	    // data.clear();
	    // correctData = new int[1];

	    // temp = (int)(Math.random() * 1000) * -1;
	    // data.add(temp);
	    // correctData[0] = temp;

	    // start = System.currentTimeMillis();
	    // radixsort(data);
	    // end = System.currentTimeMillis();

	    // //Sorts the array
	    // Arrays.sort(correctData);
	    // System.out.println("Sort completed in " + (end - start) + " seconds");

	    // //Checks if data is properly sorted
	    // hasError = false;
	    // index = 0;
	    // for(Integer x: data){
	    //   if(!(x.equals(correctData[index]))){
	    //     System.out.println("THERE IS AN ERROR");
	    //     System.out.println("Index of error: " + index);
	    //     hasError = true;
	    //   }
	    //   index++;
	    // }

	    // if(!(hasError)){
	    //   System.out.println("Your LinkedList with one negative element is properly sorted.");
	    // }
	    // else{
	    //   System.out.println(data);
	    // }
	  }
	  
}