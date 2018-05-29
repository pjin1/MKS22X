import java.util.*;

public class FrontierStack implements Frontier{
	private Stack<Location> frontier;

	public FrontierStack(){
		frontier = new Stack<>();
	}

	public Location next(){
		if(frontier.size() == 0){
			throw new NoSuchElementException();
		}

		return frontier.pop();
	}

	public void add(Location n){
		frontier.push(n);
	}

	public boolean hasNext(){
		return frontier.size() != 0;
	}

	public String toString(){
		return frontier.toString();
	}
}