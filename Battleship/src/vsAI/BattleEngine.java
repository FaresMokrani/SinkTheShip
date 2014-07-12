package vsAI;
import java.math.*;

public class BattleEngine {
	
	
	private int[][] battleMap;
	private Ship[]  ships;
	
	public BattleEngine(int num)
	{
		if( num == 4)
		{	
		battleMap = new int[5][5];
		
		for(int i=0;i<5;i++)
		for(int j=0;j<5;j++)
		{
			battleMap[i][j] = -1;
		}/**/	
		
		
		ships = new Ship[4];
		String sizeleft="4332", s;
		int z;
		for(int i=0;i<4;++i)
		{
			s=sizeleft.substring(0, 1);
			sizeleft=sizeleft.substring(1);
			z=Integer.parseInt(s);
			ships[i] = new Ship(i, z );
			 
		}	
		
		arrangeShips(ships);
		
		}
		
	}
	
	private void arrangeShips(Ship[] shps)
	{	 Ship babor;int  x,y;
		for(int i=0,c=shps.length;i<c;++i)
		{  
			babor= shps[i];
			//System.out.println("shipID:"+shps[i].getSize());
			do
			{
				
			 x=   (int)Math.round(Math.random()*4);
			 y=   (int)Math.round(Math.random()*4);
			 
			// System.out.println(x);
			 //System.out.println(y);
			}while((y+babor.getSize() > 5)  || (battleMap[x][y+babor.getSize()-1]!=-1  ) );//System.out.println(pos);
			 
			
			for(int n=0, m=babor.getSize() ; n<m ; ++n)
			{
				battleMap[x][y]=babor.getId();
				++y;
				//System.out.println(babor.getId());
				
			}
			
		}	/*
			for(int iii=0;iii<4;iii++)
				System.out.println("size:"+(ships[iii]).getSize());
				
			for(int ii=0;ii<5;ii++)
			for(int jj=0;jj<5;jj++)
			{	 
				System.out.println("pos"+ii+"-"+jj+" id:"+battleMap[ii][jj]);
				
			}*/
		
		
		
	}
	
	public int testHit(int x , int y )
	{
		
		
		if( battleMap[x][y]!=-1 )
		{
			
			return battleMap[x][y];
		}else return -1;	
		
	}
	
	

}
