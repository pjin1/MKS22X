import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{
	private Node start, end;
	private int size;
	
	public MyLinkedListImproved(){
		clear();
	}
	
	//This method will help you write other
	//methods, it is private to protect your list
	private Node getNode(int index) {
		if(index>=size || index<0){
			throw new IndexOutOfBoundsException();
		}

		Node i = start;

		while(index>0) {
			i=i.getNext();
			index--;
		}

		return i;
	}

	public String toString() {
		String string = "{ ";

		for (int i = 0; i < size; i++){
			string += getNode(i).toString() + " ";
		}

		return string + "}";
	}

	public void clear() {
		start=null;
		end=null;
		size=0;
	}

	public int size() {
		return size;
	}

	public T get(int index) {
		if(index >= size || index < 0){
			throw new IndexOutOfBoundsException();
		}
		return getNode(index).getValue();
		//exceptions!
	}

	public T set(int index, T value) {
		getNode(index).setValue(value);
		return value;
		//exceptions!
	}

	public int indexOf(T value) {
		for(int i=0 ; i<size ; i++) {
			if((getNode(i).getValue())==(value)){
				return i;
			}
		}
		return -1;
	}

	public boolean add(T newData) {
		Node node = new Node(newData);

		if(size==0) {
			start = end = node;
			size+=1;
			return true;
		}

		end.setNext(node);
		size+=1;
		node.setPrev(end);
		end = node;
		return true;
	}

	public void add(int index, T value) {
		if(index>size || index<0){
			throw new IndexOutOfBoundsException();
		}

		Node add = new Node(value);

		if(index==size){
			add(value);
		}

		else if (getNode(index).getPrev() != null) {
			Node temp = getNode(index), temp2 = temp.getPrev();
			temp2.setNext(add);
			add.setNext(temp);
			temp.setPrev(add);
			add.setPrev(temp2);
			size+=1;
		}

		else if (index==0) {
			if (size==0) {
				start = add;
				end = start;
			}

			else {
				Node temp = start;
				start = add;
				add.setNext(temp);
				temp.setPrev(start);

			}
			size+=1;
		}

		//exceptions!
	}

	//The remove methods can cause a problem, this is why we shouldn't
	//use an int as the data, we need objects to distinguish between index and data
	public boolean remove(T value) {
		int i = indexOf(value);
		if(i!=-1){
			remove(i);
			return true;
		}
		return false;
	}

	public T remove(int index) {
		if(index>=size || index<0){
			throw new IndexOutOfBoundsException();
		}

		T a = get(index);

		if (index==0){
			T n = start.getValue();
			start = start.getNext();
			start.setPrev(null);
			size-=1;
			return n;
		}
		if (index==size-1){
			T n = end.getValue();
			end = getNode(index - 1);
			end.setNext(null);
			size-=1;
			return n;
		}
		Node prev = getNode(index).getPrev(), next = prev.getNext().getNext();
		prev.setNext(next);
		next.setPrev(prev);
		size-=1;
		return a;

		//exceptions!
		//returns the value of what you removed.
	}

	
	
	public int max() {
		if(size == 0){
		    return -1;
		}
		
		int index = 0, i = 0;
		T max = start.getValue();

		for(T elem: this) {
			if(elem.compareTo(max) > 0) {
				max = elem;
				index = i;
			}
			i++;
		}
		
		return index;
	}

	public int min() {
		if(size == 0){
		    return -1;
		}
		
		int index = 0, i = 0;
		T min = start.getValue();

		for(T elem: this) {
			if(elem.compareTo(min) < 0) {
				min = elem;
				index = i;
			}
			i++;
		}
		
		return index;
	}

	public void extend(MyLinkedListImproved<T> other){
		if(other.start != null){
			
			if(start != null){
				end.setNext(other.start);
				other.start.setPrev(end);
				
			}
			else{
				start = other.start;
			}
			
			end = other.end;
			size += other.size();

			other.clear();
		}
	}



	
    private class Node{
	
	    	private T data;
	    	private Node prev, next;
	
	    	public Node(T value){
	    		data = value;
	    		prev = next = null;
	    	}
	
	    	public Node getPrev(){
	    		return prev;
	    	}
	
	    	public void setPrev(Node node){
	    		prev = node;
	    	}
	
	    	public Node getNext(){
	    		return next;
	    	}
	
	    	public void setNext(Node node){
	    		next = node;
	    	}
	
	    	public T getValue(){
	    		return data;
	    	}
	
	    	public void setValue(T value){
	    		data = value;
	    	}
	
	    	public String toString(){
	    		return "[" + data + "]";
	    	}
    }
    
    
    public LinkedIterator iterator(){
		return new LinkedIterator(start);
	}
    
    public class LinkedIterator implements Iterator<T>{
	    	Node curr;
	
	    	public LinkedIterator(Node start){
	    		curr = start;
	    	}
	    	
	    	public boolean hasNext() {
	    		return curr != null;	    	
	    	}
	
	    	public T next() {
	    		if (!hasNext()){		    
	    			throw new NoSuchElementException();
	    		}

	    		T ans = curr.getValue();
	    		curr = curr.getNext();
	    		return ans;
	    	}
	    	
    }

}