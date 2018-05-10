import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class MyDeque<E>{

    private E[] data;
    private int start,end,size;
	
    @SuppressWarnings("unchecked")
    public MyDeque() {
	data = (E[])new Object[10];
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity) {
	if (initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
		
	data = (E[]) new Object[initialCapacity];
    }
	
    public int size() {
	return size;
    }

	
    public void addFirst(E elem) {
	if (elem == null){
	    throw new NullPointerException();
	}

	if (data[start] == null) {
	    data[start] = elem;
	}
		
	else if (data.length == size()){
	    resize();
	    addFirst(elem);
	}
		
	else if (start == 0){
	    start = data.length-1;
	    data[start] = elem;
	}
		
	else{
	    start--;
	    data[start] = elem;
	}

	size++;
		
    }
	
    public void addLast(E elem) {
	if (elem == null){
	    throw new NullPointerException();
	}
		
	if (data[end] == null) {
	    data[end] = elem;
	}
		
	else if (data.length == size()){
	    resize();
	    addLast(elem);
	}
		
	else if (end == data.length-1){
	    end = 0;
	    data[end] = elem;
	}
		
	else{
	    data[++end] = elem;
	}

	size++;
    }

    public E removeFirst() {
	if(size == 0){
	    throw new NoSuchElementException();
	}
		
	E rem = data[start];
	data[start] = null;
		
	if (start == data.length-1) {
            start = 0;
        }

        else {
            start++;
        }
	size--;
        return rem;
    }
	
    public E removeLast() {
	if(size == 0){
	    throw new NoSuchElementException();
	}
		
	E rem = data[end];
	data[end] = null;
		
	if (end == 0) {
            end = data.length-1;
        }

        else {
            end--;
        }
	size--;
        return rem;
    }
	
    public E getFirst() {
	if(size == 0){
	    throw new NoSuchElementException();
	}
		
	return data[start];

    }
	
    public E getLast() {
	if(size == 0){
	    throw new NoSuchElementException();
	}
		
	return data[end];

    }

	
    @SuppressWarnings("unchecked")
    public void resize() {
	E[] resized = (E[]) new Object[data.length * 2];
    		
	for (int i=0; i<size; i++){
    			
	    if (start >= size){
		start = 0;
	    }
	    resized[i] = data[start];
	    start++;
    			
	}
    		
	start = 0;
	end = size-1;
	data = resized;
    }

	
	
	
    //==========================================================================
    public String toString(){
	String ans = "[";
	if(start < end){
	    for (int i = start; i <= end; i++){
		ans += data[i] + " , ";
	    }
	}
	else{
	    for(int i = start; i < data.length; i++){
		ans += data[i] + ", ";
	    }
	    for(int i = 0; i <= end; i++){
		ans += data[i] + ", ";
	    }
	}
	ans = ans.substring(0, ans.length() - 2) + "]";
	return ans;
    }




    public static void main(String[] args) {
	MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
	ArrayList<String> b = new ArrayList<>();

	int size = Integer.parseInt(args[0]);
	for(int i = 0; i < size; i++){
	    int temp = (int)(Math.random() * 1000);
	    /*	if(temp % 2 == 0){
		a.addFirst("" + temp);
		a1.addFirst("" + temp);
		b.add(0, "" + temp);
		}

		else{*/
	    a.addLast("" + temp);
	    a1.addLast("" + temp);
	    b.add("" + temp);
	    //	}
	}

	int index = 0;
	boolean hasError = false;
	String errorEvaluation = "Errors found at these indices: ";
	for (String x : b){
	    if (!(x.equals(a.getFirst()))){
		System.out.println("The getFirst() function is incorrect at index " + index);
		hasError = true;
	    }
	    if (!(x.equals(a.removeFirst()))){
		System.out.println("There is an error at index " + index);
		errorEvaluation += index + ", ";
		hasError = true;
	    }
	    index++;
	}


	if(hasError){
	    errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
	    System.out.println(errorEvaluation);
	    System.out.println("MyDeque: " + a1);
	    System.out.println("Actual Deque: " + b);
	}
	else{
	    System.out.println("Your deque is bug-free!");
	}
    }
}
