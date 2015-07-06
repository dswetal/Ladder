package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the Snake and Ladder Board class representing Board for the game.
 * 
 * @author Swetal
 * 
 */
public class SnakeAndLadderBoard {

	/**
	 * Constant to define finish line.
	 */
	private final int FINISH_POSITION = 100;

	/**
	 * Regex to validate input.
	 */
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

	/**
	 * Returns singleton instance for the class.
	 * 
	 * @return
	 */
	public static SnakeAndLadderBoard getInstance() {

		return snakeAndLadderBoard;

	}

	/**
	 * Calculates new position on the board based on players current position
	 * and new input.
	 * 
	 * @param currentPosition
	 * @param input
	 * @return New Position
	 */
	public int calculateNewPosition(int currentPosition, int input) {

		int newPosition = currentPosition + input;
		if (mapSnakesAndLadders.get(newPosition) != null) {
			newPosition = mapSnakesAndLadders.get(newPosition);
		}

		return newPosition;

	}

	/**
	 * This method will check if current position has reahced to the finish
	 * line.
	 * 
	 * @param position
	 * @return True or false
	 */
	public boolean isFinished(int position) {
		return position == FINISH_POSITION;
	}

	/**
	 * This method will validate user input.
	 * 
	 * @param input
	 * @return True or False
	 */
	public boolean validateInput(String input) {
		return input.matches(inputRegex);
	}

}
