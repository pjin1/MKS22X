import java.util.*;

public class MyHeap<T extends Comparable<T>>{
	private T[] heap;
	private boolean max;
	private int size;
	
	@SuppressWarnings("unchecked")
	public MyHeap(){
		data = (T[])new Comparable[10];
		max = true;
		size = 0;
	}
	
	@SuppressWarnings("unchecked")
	public MyHeap(boolean max){
		max = this.max;
		size = 0;
		heap = (T[]) new Comparable[10];
	}

	public int size(){
		return length;
	}

	public T peek(){
		return arr[0];
	}
	
	@SuppressWarnings("unchecked")
	private void resize(){
		T[] temp = (T[]) new Comparable[heap.length * 2];
		
		for (int i=0; i<heap.length; i++){
			temp[i] = heap[i];
		}
		
		heap = temp;
	}

	
	public void add(T elem) {
		
	}
	
	public T remove() {
		
	}
	
}