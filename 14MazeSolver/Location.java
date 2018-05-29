public class Location implements Comparable<Location>{
	private int x,y;
	private Location previous;
	private int distance, distSoFar;
    private boolean aStar;

	public Location(int _x, int _y, Location prev, int dist){
		x = _x;
		y = _y;
		previous = prev;
		distance = dist;
	}
	
	public Location(int _x, int _y, Location prev, int dist, boolean a){
		x = _x;
		y = _y;
		previous = prev;
		distance = dist;
		aStar = a;
	}


	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public Location getPrev(){
		return previous;
	}

	public int getDistance(){
		return distance;
	}

	public int getDistSoFar(){
		return distSoFar;
	}

	public int compareTo(Location other){
		if(aStar){
			Integer p = new Integer(distance+distSoFar);
		    Integer q = new Integer(other.getDistance()+other.getDistSoFar());
		    return p.compareTo(q);
		}
		
		Integer p = new Integer(distance);
	    Integer q = new Integer(other.getDistance());
	    
	    return p.compareTo(q);
	}
}