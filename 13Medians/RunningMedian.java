import java.util.*;
import java.io.*;

public class RunningMedian {

    private MyHeap<Double> max;
    private MyHeap<Double> min;
    
	//makes an empty container for Doubles.
	public RunningMedian() {
		max = new MyHeap<>();
		min = new MyHeap<>(false);
	}
	
	//insert a Double into the data structure.
	public void add(Double num) {

		if (max.size() == 0 && min.size() == 0){
		    min.add(num);
		}
		else if (num > min.peek()){
		    max.add(num);
		    if(max.size() - min.size() == 2){
		    		min.add(max.remove());
		    }
		}
		else {
			min.add(num);
	        if(min.size() - max.size() == 2){
	          max.add(min.remove());
	        }
		}
		
	}
	
	//return the current median, throws NoSuchElementException when size is 0.
	public Double getMedian() {
		if (max.size() == 0 && min.size() == 0) {
            throw new NoSuchElementException();
        }
		
		if (max.size() > min.size()) {
			return max.peek();
		}
		if (max.size() < min.size()) {
			return min.peek();
		}
		
		return (min.peek() + max.peek()) / 2;
	}
			
	public int size() {
		return max.size() + min.size();
	}

}