package main.java;
import java.util.HashMap;
import java.util.Map;

public class SnakeAndLadderBoard {

	/**
	 * Constant to define finish line.
	 */
	private final int FINISH_POSITION = 100;

	private final String inputRegex = "[1-6]{1}";

	/**
	 * Map to hold positions of snake and laddder.
	 */
	private Map<Integer, Integer> mapSnakesAndLadders;

	private static SnakeAndLadderBoard snakeAndLadderBoard = new SnakeAndLadderBoard();

	protected SnakeAndLadderBoard() {
		mapSnakesAndLadders = new HashMap<Integer, Integer>();
		// Ladder
		mapSnakesAndLadders.put(4, 14);
		mapSnakesAndLadders.put(9, 31);
		mapSnakesAndLadders.put(20, 38);
		mapSnakesAndLadders.put(28, 84);
		mapSnakesAndLadders.put(40, 59);
		mapSnakesAndLadders.put(51, 67);
		mapSnakesAndLadders.put(63, 81);
		mapSnakesAndLadders.put(71, 91);

		// Snake
		mapSnakesAndLadders.put(17, 7);
		mapSnakesAndLadders.put(54, 34);
		mapSnakesAndLadders.put(64, 60);
		mapSnakesAndLadders.put(87, 24);
		mapSnakesAndLadders.put(93, 73);
		mapSnakesAndLadders.put(95, 75);
		mapSnakesAndLadders.put(99, 78);
	}

	public static SnakeAndLadderBoard getInstance() {

		return snakeAndLadderBoard;

	}

	public int calculateNewPosition(int currentPosition, int input) {

		int newPosition = currentPosition + input;
		if (mapSnakesAndLadders.get(newPosition) != null) {
			newPosition = mapSnakesAndLadders.get(newPosition);
		}

		return newPosition;

	}

	public boolean isFinished(int position) {
		return position == FINISH_POSITION;
	}

	public boolean validateInput(String input) {
		return input.matches(inputRegex);
	}

}
