package tt.fares.games.sinktheship.gui;

public class GameHelper {

	private int[] shipSizes;
	private int gameSlateSize = 0;
	private int numberOfShips = 0;
	public Ship[] battleShips;
	public GameLogic gameLogic;
	
	public GameHelper(int gameSlateSize, int numberOfShips, int[] shipSizes, String[] shipNames){
		this.shipSizes = new int[numberOfShips];
		this.shipSizes = shipSizes;
		this.gameSlateSize = gameSlateSize;
		this.numberOfShips = numberOfShips;
		battleShips = new Ship[numberOfShips];
		
		gameLogic = new GameLogic(this.gameSlateSize);
		
		for(int i=0; i < this.numberOfShips; i++){
			battleShips[i] = new Ship(shipNames[i], this.shipSizes[i]);
			gameLogic.initGameSlateMap(battleShips[i]);
		}
	}
}
