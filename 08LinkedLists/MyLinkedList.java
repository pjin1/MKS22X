public class MyLinkedList{
  private Node start,end;
  private int size;

  //This method will help you write other
  //methods, it is private to protect your list
  private Node getNode(int index) {
	  if(index>size+1 || index<0){
		  throw new IndexOutOfBoundsException();
	  }
	  
	  Node i = start;
	  
	  while(index>0) {
		  i=i.getNext();
	  }
	  
	  return i;
  }

  public MyLinkedList() {
	  clear();
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
  
  public Integer get(int index) {	  
	  return getNode(index).getValue();
	  //exceptions!
  }
  
  public Integer set(int index, Integer value) {
	  getNode(index).setValue(value);
	  return value;
	  //exceptions!
  }

  public int indexOf(Integer value) {
	  for(int i=0 ; i<size ; i++) {
		  if((getNode(i).getValue())==(value)){
			  return i;
		  }
	  }
	  return -1;
  }

  public boolean add(Integer newData) {
	  Node node = new Node(newData);

	  if(size==0) {
		  start = end = node;
		  size+=1;
		  return true;
	  }
	  	 
	  getNode(size-1).setNext(node);
	  size+=1;
	  getNode(size-1).setPrev(end);
	  
	  return true;
  }
  
  public void add(int index, Integer value) {
	  if(index>size+1 || index<0){
		  throw new IndexOutOfBoundsException();
	  }
	  
	  Node add = new Node(value);
	  
	  if(index==size){
		  add(value);
	  }
	  
	  if (getNode(index).getPrev() != null) {
		  getNode(index).getPrev().setNext(add);
	  }
	  
	  if (index==0) {
		  if (size==0) {
              start = add;
              end = start;
		  }

		  else {
			  start = add;
		  }
	  }
	  
	  size+=1;
	  //exceptions!
  }

  //The remove methods can cause a problem, this is why we shouldn't 
  //use an int as the data, we need objects to distinguish between index and data
  public boolean remove(Integer value) {
	  int i = indexOf(value);
	  if(i!=-1){
		  remove(i);
		  return true;
	  }
	  return false;
  }
  
  public Integer remove(int index) {
	  if(index>size+1 || index<0){
		  throw new IndexOutOfBoundsException();
	  }
	  
	  Integer a = get(index);
	  
	  if (index==0){
		  int n = start.getValue();
		  start = start.getNext();
		  start.setPrev(null);
		  size-=1;
		  return n;
	  }
	  if (index==size-1){
		  int n = end.getValue();
		  end = end.getPrev();
		  end.setNext(null);
		  size-=1;
		  return n;
	  }
	  return a;

	  //exceptions! 
	  //returns the value of what you removed.
  }
  private class Node{

	    private int data;
	    private Node prev, next;

	    public Node(int value){
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

	    public int getValue(){
	    		return data;
	    }

	    public void setValue(int value){
	    		data = value;
	    }
	    
	}
  public static void main(String[] args){
	     MyLinkedList a = new MyLinkedList();

	     System.out.println("Testing add(Integer value)");
	     for (int i = 0; i < 10; i++){
	       a.add(new Integer(i));
	       System.out.println("size: " + a.size() + " LinkedList: " + a.toString());
	     } //adds the integers from 0 to 9 inclusive and prints out the LinkedList

	     System.out.println("\nTesting get(int index)");
	     for (int i = 0; i < 10; i++){
	       System.out.println("index: " + i + " data: " + a.get(i));
	     } //prints the integers from 0 to 9 inclusive

	     System.out.println("\nTesting exception for get(int index)");
	     try{
	       System.out.println(a.get(10));
	       System.out.println(a.size());
	     }catch(IndexOutOfBoundsException e){
	       System.out.println("This size is out of bounds");
	     } //prints "This size is out of bounds"
	     try{
	       System.out.println(a.get(-1));
	     }catch(IndexOutOfBoundsException e){
	       System.out.println("This size is out of bounds");
	     } //prints "This size is out of bounds"

	     for (int i = 0; i < 10; i++){
	       a.add(new Integer(i));
	     }

	     System.out.println("\nTesting indexOf(Integer value)");
	     for (int i = 0; i < 10; i++){
	       System.out.println("Value: " + i + " Index: " + a.indexOf(i));
	     } //prints 0 to 9 inclusive

	     System.out.println("\nTesting remove(Integer value)");
	     for(int i = 0; i < 10; i++){
	       a.remove(new Integer(i));
	       System.out.println(a);
	     } //removes first half of the LinkedList

	     System.out.println("\nTesting set(int index, Integer value)");
	     for (int i = 0; i < 10; i++){
	       a.set(i, new Integer(i * 10));
	       System.out.println(a);
	     } //sets the data of each node to 10 * index

	     System.out.println("\nTesting exceptions for set(int index, Integer value)");
	     try{
	       System.out.println(a.set(-1, new Integer(1)));
	     }catch(IndexOutOfBoundsException e){
	       System.out.println("This size is out of bounds");
	     } //prints "This size is out of bounds"
	     try{
	       System.out.println(a.set(10, new Integer(1)));
	     }catch(IndexOutOfBoundsException e){
	       System.out.println("This size is out of bounds");
	     } //prints "This size is out of bounds"

	     System.out.println("\nTesing add(int index, Integer value)");
	     for (int i = 0; i < 9; i++){
	       a.add(i, new Integer(i * 3));
	       System.out.println("index added: " + i + " LinkedList: " + a.toString());
	     } //adds multiples of 3 up to 24 to the LinkedList at the beginning
	     a.add(19, new Integer(100)); //adds 100 to the LinkedList at the end
	     System.out.println("index added: " + 19 + " LinkedList: " + a.toString());

	     System.out.println("\nTesting exceptions for add(int index, Integer value)");
	     try{
	       a.add(-1, new Integer(5));
	     }catch(IndexOutOfBoundsException e){
	       System.out.println("This size is out of bounds");
	     } //prints "This size is out of bounds"
	     try{
	       a.add(21, new Integer(5));
	     }catch(IndexOutOfBoundsException e){
	       System.out.println("This size is out of bounds");
	     } //prints "This size is out of bounds"

	     System.out.println("\nTesting remove(int index)");
	     System.out.println("Original LinkedList: " + a.toString());
	     System.out.println("data removed: " + a.remove(0) + " index removed: 0"); //removes 0
	     System.out.println("LinkedList: " + a.toString());
	     System.out.println("data removed: " + a.remove(a.size() - 1) + " index removed: 18"); //removes 100
	     System.out.println("LinkedList: " + a.toString());
	     System.out.println("data removed: " + a.remove(2) + " index removed: 2 "); //removes 9
	     System.out.println("LinkedList: " + a.toString());

	     System.out.println("\nTesting exceptions for remove(int index)");
	     try{
	       System.out.println(a.remove(-1));
	     }catch(IndexOutOfBoundsException e){
	       System.out.println("This size is out of bounds");
	     } //prints "This size is out of bounds"
	     try{
	       System.out.println(a.remove(17));
	     }catch(IndexOutOfBoundsException e){
	       System.out.println("This size is out of bounds");
	     } //prints "This size is out of bounds"

	     System.out.println("\nTesting clear()");
	     a.clear();
	     System.out.println("LinkedList: " + a.toString()); //prints an empty LinkedList
	   }
}