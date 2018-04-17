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