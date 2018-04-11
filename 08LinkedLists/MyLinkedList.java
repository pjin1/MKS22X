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
	  
	  Node add = new Node(getNode(index), getNode(index).getPrev(), value);
	  
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
}