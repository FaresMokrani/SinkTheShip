package tt.fares.games.sinktheship.gui;

public class GameHelper {

	private int[] shipSizes;
	private int gameSlateSize = 0;
	private int numberOfShips = 0;
	private Ship[] battleShips;
	
	
	public GameHelper(int gameSlateSize, int numberOfShips, int[] shipSizes, String[] shipNames){
		this.shipSizes = new int[numberOfShips];
		this.shipSizes = shipSizes;
		this.gameSlateSize = gameSlateSize;
		this.numberOfShips = numberOfShips;
		battleShips = new Ship[numberOfShips];
		
		GameLogic gameLogic = new GameLogic(this.gameSlateSize);
		
		for(int i=0; i < this.numberOfShips; i++){
			battleShips[i] = new Ship(shipNames[i], this.shipSizes[i]);
			gameLogic.initGameSlateMap(battleShips[i]);
		}
	}
	
	public static void main(String[] args){
		int[] shipSizes = {3, 2, 4};
		String[] shipNames = {"fares", "mares", "hares"};
		GameHelper gameHelper = new GameHelper(25, 3, shipSizes, shipNames);
	}
}
