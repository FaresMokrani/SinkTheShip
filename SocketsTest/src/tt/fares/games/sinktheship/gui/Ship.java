package tt.fares.games.sinktheship.gui;

public class Ship {

	public int size = 0;
	public String name;
	public int[] location;
	public int hitsNumber;
	
	public Ship(String name, int size){
		this.name = name;
		this.size = size;
		location = new int[size];
		this.hitsNumber = 0;
	}
	
	public void setSize(int size){
		this.size = size;
	}
	
	public int getSize(){
		return(this.size);
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return(this.name);
	}
	
	public void setLocation(int index, int location){
		this.location[index] = location;
	}
	
	public void setLocarion(int[] location){
		this.location = location;
	}
	
	public int getLocation(int index){
		return(this.location[index]);
	}
	
	public int[] getLocation(){
		return this.location;
	}
	
	public boolean hasLocation(int hitLocation){
		boolean hasLocation = false;
		for (int spot: location){
			if (spot == hitLocation){
				hasLocation = true;
				hitsNumber++;
			} else {
				hasLocation = false;
			}
		}
		return hasLocation;
	}
	
	public boolean isSunk(){
		if (hitsNumber < this.size){
			return false;
		}else{
			return true;
		}
	}
}
