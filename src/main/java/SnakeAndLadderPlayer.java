package main.java;

/**
 * This is the class to represent Player of Snake and Ladder game.
 * 
 * @author Swetal Desai
 * 
 */
public class SnakeAndLadderPlayer {

	/**
	 * Current position of a player
	 */
	private int currentPosition = 0;

	/**
	 * Player Name
	 */
	private String playerName;

	public String getPlayerName() {
		return playerName;
	}

	public SnakeAndLadderPlayer(String aPlayerName) {
		this.playerName = aPlayerName;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int newPosition) {

		currentPosition = newPosition;

	}

}
