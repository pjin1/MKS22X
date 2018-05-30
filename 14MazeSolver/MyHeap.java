import java.util.*;

public class MyHeap<T extends Comparable<T>>{
	private T[] heap;
	private boolean max;
	private int size;

	@SuppressWarnings("unchecked")
	public MyHeap(){
		heap = (T[])new Comparable[10];

		max = true;
		size = 0;
	}

	@SuppressWarnings("unchecked")
	public MyHeap(boolean max){
		heap = (T[]) new Comparable[10];

		max = this.max;
		size = 0;
	}

	public int size(){
		return size;
	}

	public T peek(){
		return heap[0];
	}

	@SuppressWarnings("unchecked")
	private void resize(){
		T[] resized = (T[]) new Comparable[heap.length * 2];
		int counter = 0;

		while (counter<heap.length) {
			resized[counter] = heap[counter];

			counter++;
		}

		heap = resized;
	}


	public void add(T elem) {
		if (size == heap.length){
			resize();
		}
		heap[size] = elem;

		up(size); 
		size += 1;
	}

	public T remove() {
		T ans = heap[0];
		heap[0] = heap[size-1];
		heap[size-1] = null;
		size-=1;
		down(0);

		return ans;
	}

	private void swap(T[] temp,int a, int b) {
		T c = temp[a];
		temp[a] = temp[b];
		temp[b] = c;
	}

	private void up(int ind) {
		int pos = (ind-1)/2;

		while (max && (pos>=0) && (heap[ind].compareTo(heap[pos]))>0){
			swap(heap,pos,ind);
			ind = pos;
			pos = (ind - 1)/2;
		}
		while (!max && (pos>=0) && (heap[ind].compareTo(heap[pos]))<0){
			swap(heap,pos,ind);
			ind = pos;
			pos = (ind - 1)/2;
		}

	}

	private void down(int ind) {
		int pos1 = 2*ind+1;
		int pos2 = 2*ind+2;


		if (max) {
			if (((pos1 < size) && (heap[ind].compareTo(heap[pos1]) < 0)) || 
					((pos2 < size) && (heap[ind].compareTo(heap[pos2]) < 0))) {

				if (pos2 >= size || heap[pos1].compareTo(heap[pos2]) > 0) {
					swap(heap,pos1,ind);
					ind = pos1;
					down(pos1);
				}

				else if (pos2 < size && heap[ind].compareTo(heap[pos2]) < 0) {
					swap(heap,pos2,ind);
					ind = pos2;
					down(pos2);
				}

			}
		}

		else {
			if ((pos1 < size) && (heap[ind].compareTo(heap[pos1]) > 0) ||
					(pos2 < size) && (heap[ind].compareTo(heap[pos2]) > 0)) {

				if (pos2 >= size || heap[pos1].compareTo(heap[pos2]) < 0) {
					swap(heap,pos1,ind);
					ind = pos1;
					down(pos1);
				}

				else if(heap[ind].compareTo(heap[pos2]) > 0){
					swap(heap,pos2,ind);
					ind = pos2;
					down(pos2);
				}

			}
		}

	}

	//Crystal helped me debug

}