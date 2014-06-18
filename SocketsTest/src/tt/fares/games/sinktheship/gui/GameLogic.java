package tt.fares.games.sinktheship.gui;

public class GameLogic {

	public int MAX_TRIALS = 100;
	public int gameSlateSize = 0;
	public int[] gameSlateMap;

	// against computer: generate random locations
	public GameLogic(int gameSlateSize) {
		this.gameSlateSize = gameSlateSize;
		gameSlateMap = new int[gameSlateSize];
	}

	// 2 players: set the locations of the user
	public GameLogic(int[] locationMap) {

	}

	public void initGameSlateMap(Ship ship) {
		int shipLengthCnt = 0;
		int triesCnt = 0;
		int placementPace = 0;
		boolean shipPlaced = true;
		int[] locationHolder = new int[ship.size];

		int vertOrientation = (int) (Math.random() * 2); // ship orientation horizontal = 0, vertical = 1

		if (vertOrientation == 0) {
			placementPace = 1;
		} else {
			placementPace = (int) Math.sqrt(gameSlateSize);
		}
		System.out.println("ship orientation: " + vertOrientation);
		System.out.println("placement pace: " + placementPace);

		while ((triesCnt < 1000)) {
			int currentSpot = (int) (Math.random() * (gameSlateSize - ship.size));
			System.out.println("First Current Position: " + currentSpot);
			shipLengthCnt = 0;
			while ((shipLengthCnt < ship.size)) {
				if ((gameSlateMap[currentSpot] == 1)) {
					triesCnt++;
					shipPlaced = false;
					break;
				}
				if ((vertOrientation == 0)
						&& (currentSpot % placementPace == 4)
						&& (shipLengthCnt < ship.size - 1)) {
					triesCnt++;
					shipPlaced = false;
					break;
				}
				if ((vertOrientation == 1)
						&& (currentSpot > gameSlateSize - placementPace - 1)
						&& (shipLengthCnt < ship.size - 1)) {
					triesCnt++;
					shipPlaced = false;
					break;
				}
				locationHolder[shipLengthCnt] = currentSpot;
				currentSpot += placementPace;
				shipLengthCnt++;
				shipPlaced = true;
			}
			if (shipLengthCnt >= ship.size && shipPlaced) {
				break;
			} else if (shipPlaced) {

			} else {
				triesCnt++;
			}
		}
		if (shipPlaced) {
			ship.location = locationHolder;
			for (int i = 0; i < locationHolder.length; i++) {
				gameSlateMap[locationHolder[i]] = 1;
				System.out.println(locationHolder[i]);
			}
		}
		System.out.println("Ship placed: " + shipPlaced);
		System.out.println("Number of Trials: " + triesCnt);
		System.out
				.println("--------------------------------------------------------\n");
	}
}
