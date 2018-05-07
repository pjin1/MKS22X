import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class MyDeque<E>{

	private E[] data;
	private int start,end,size;
	
	
	public MyDeque() {
		
	}
	
	public MyDeque(int initialCapacity) {
		if (initialCapacity < 0){
		    throw new IllegalArgumentException();
		}
	}
	
	int size() {
		return size;
	}

	
	public void addFirst(E) {
		if (e == null){
		    throw new NullPointerException();
		}
	}
	
	public void addLast(E) {
		if (e == null){
		    throw new NullPointerException();
		}
	}

	public E removeFirst() {
		if(size == 0){
		    throw new NoSuchElementException();
		}
	}
	
	public E removeLast() {
		if(size == 0){
		    throw new NoSuchElementException();
		}
	}
	
	public E getFirst() {
		if(size == 0){
		    throw new NoSuchElementException();
		}
	}
	
	public E getLast() {
		if(size == 0){
		    throw new NoSuchElementException();
		}
		
	}

    	
}
