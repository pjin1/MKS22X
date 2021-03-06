import java.util.*;

public class Sorts {

	public static void heapsort(Integer[] data){
		/*
		heapify(data);
		for (int i = data.length-1; i >= 0; i-- ) {
			swap(data,i,0);
			down(data,i);
		}
		*/
		
		MyHeap<Integer> inf = new MyHeap<Integer>(false);
		
		for (int i = 0; i < data.length; i++){
		    inf.add(data[i]);
		}
		
		for (int i = 0; i < data.length; i++){
		    data[i] = inf.remove();
		}
		
		
	}

	private static void swap(Integer[] temp,int a, int b) {
		Integer c = temp[a];
		temp[a] = temp[b];
		temp[b] = c;
	}

	public static void heapify(Integer[] data){
		for (int i = data.length-1; i >= 0; i--) {
			down(data,i);
		}
	}

	private static void down(Integer[] data, int ind) {
		int pos1 = 2*ind+1;
		int pos2 = 2*ind+2;


		while (((pos1 < data.length) && (data[ind].compareTo(data[pos1]) < 0)) || 
		       ((pos2 < data.length) && (data[ind].compareTo(data[pos2]) < 0))) {

			if (pos2 >= data.length || data[pos1].compareTo(data[pos2]) > 0) {
				swap(data,pos1,ind);
				ind = pos1;
				//down(data,pos1);
			}

			else if (pos2 < data.length && data[ind].compareTo(data[pos2]) < 0) {
				swap(data,pos2,ind);
				ind = pos2;
				//down(data,pos2);
			}
			else {
				break;
			}
		}

		
		

		
	}
	


}