package tt.fares.games.sinktheship.gui;

public class GameLogic {

	public int SHIP_SIZE = 3;
	public int BOATS_NUMBER = 3;
	public int SLATE_SIZE = 25;
	public int[] gameSlateMap = new int[SLATE_SIZE];
	
	//against computer: generate random locations
	public GameLogic(){
		 initGameSlateMap();
	}
	
	//2 players: set the locations of the user
	public GameLogic(int[] locationMap){
		
	}
	
	private void initGameSlateMap(){
		int boatsCnt = 0;
		int boatLengthCnt = 0;
		int triesCnt = 0;
		int placementPace = 0;
		
		int vertOrientation = (int) (Math.random() * 2); // horizontal = 0, vertical = 1
		
		if(vertOrientation == 0){
			placementPace = 1;
		}else{
			placementPace = (int) Math.sqrt(SLATE_SIZE);
		}
		
		while(boatsCnt < BOATS_NUMBER){
			
		}
	}
	
}
