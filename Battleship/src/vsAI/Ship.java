package vsAI;

public class Ship {

	private int id;
	private int state;// 0 clean 1 damaged 2 sunk
	private int left;
	private int size;
	
	
	public Ship(int idship, int siz)
	{
		id=idship;
		state=0;
		left= siz;
		size= siz;
	}
	
	public int getId()
	{
		return(this.id);
		
	}
	public int getState()
	{
		return(this.state);
		
	}
	public void setState(int ste)
	{
		this.state=ste;
		
	}
	public int getSize()
	{
		return(this.size);
		
	}
	public int getLeft()
	{
		return(this.left);
		
	}
}
