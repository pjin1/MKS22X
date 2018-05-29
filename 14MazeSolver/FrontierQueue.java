import java.util.*;

public class FrontierQueue implements Frontier {

	private LinkedList<Location> frontier;

	public FrontierQueue() {
		frontier = new LinkedList<Location>();
	}

	public Location next() {
		if (frontier.get(0) == null){
			throw new NoSuchElementException();
		}
		
		return frontier.remove();
	}

	public void add(Location n) {
		frontier.add(n);
	}

	public boolean hasNext() {
		return frontier.size() > 0;
	}

	public String toString(){
		return frontier.toString();
	}
}