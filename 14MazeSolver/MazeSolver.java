import java.util.*;
import java.io.*;

public class MazeSolver{
	private Maze maze;
	private Frontier frontier;

	public MazeSolver(String mazeText){
		maze = new Maze(mazeText);
	}

	//Default to BFS
	public boolean solve(){ return solve(0); }

	//mode: required to allow for alternate solve modes.
	//0: BFS
	//1: DFS
	public boolean solve(int mode){
		//initialize your frontier
		//while there is stuff in the frontier:
		//  get the next location
		//  process the location to find the locations (use the maze to do this)
		//  check if any locations are the end, if you found the end just return true!
		//  add all the locations to the frontier
		//when there are no more values in the frontier return false
		
		if (mode == 0){
		    frontier = new FrontierQueue();
		}
		else if(mode == 1){
		    frontier = new FrontierStack();
		}
		else if(mode == 2){
		    frontier = new FrontierPriorityQueue();
		}
		else if(mode == 3){
		    frontier = new FrontierPriorityQueue();
		    maze.setAStar(true);
		}
		
		frontier.add(maze.getStart());
		
		while (frontier.hasNext()){
			Location temp = frontier.next();
	  		Location[] temp1 = maze.getNeighbors(temp);

	  		int counter = 0;

	  		if (temp	 != null){
	  			Location end = maze.getEnd();

	  			while (counter<4) {
	  				if (temp1[counter].getX() == end.getX() && temp1[counter].getY() == end.getY()) {
	  					Location curr = temp1[counter];
	  					while (curr.getPrev() != null) {
	  						maze.set(curr.getX(),curr.getY(),'@');
	  						curr = curr.getPrev();
	  					}
	  					return true;
	  				}
	  				else{
	  					frontier.add(temp1[counter]);
	  					maze.set(temp1[counter].getX(), temp1[counter].getY(), '?');
	  				}

	  				counter++;
	  			}

	  			if (maze.get(temp.getX(),temp.getY() ) != 'S') {
	  				maze.set(temp.getX(),temp.getY(),'.');
	  			}
	  		}

	  		   
		return false;
	}

	public String toString(){
		return maze.toString();
	}


}