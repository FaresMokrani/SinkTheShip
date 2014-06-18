package tt.fares.games.sinktheship.gui;

public class Ship {

	public int size = 0;
	public String name;
	public int[] location;
	
	public Ship(String name, int size){
		this.name = name;
		this.size = size;
		location = new int[size];
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
}
