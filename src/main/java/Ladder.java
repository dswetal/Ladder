package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This is a runnable java class with main method for Snake And Ladder
 * application.
 * 
 * @author Swetal Desai
 * 
 */
public class Ladder {

	private static SnakeAndLadderBoard snakeAndLadderBoard = SnakeAndLadderBoard
			.getInstance();

	public static void main(String[] args) {

		System.out.println("Welcome to Snakes And Ladder");
		System.out.println("****************************");

		SnakeAndLadderPlayer snakeAndLadderPlayer1 = new SnakeAndLadderPlayer(
				"Player 1");
		SnakeAndLadderPlayer snakeAndLadderPlayer2 = new SnakeAndLadderPlayer(
				"Player 2");
		while (true) {

			try {

				// Player 1
				int input = getPlayerInput(snakeAndLadderPlayer1);

				if (-1 == input) {
					break;
				}

				int newPosition = snakeAndLadderBoard.calculateNewPosition(
						snakeAndLadderPlayer1.getCurrentPosition(), input);
				snakeAndLadderPlayer1.setCurrentPosition(newPosition);
				if (snakeAndLadderBoard.isFinished(newPosition)) {

					displayFinishMessage(snakeAndLadderPlayer1);

					break;
				}
				displayPositionMessage(snakeAndLadderPlayer1);

				// Player 2
				input = getPlayerInput(snakeAndLadderPlayer2);
				if (-1 == input) {
					break;
				}
				newPosition = snakeAndLadderBoard.calculateNewPosition(
						snakeAndLadderPlayer2.getCurrentPosition(), input);
				snakeAndLadderPlayer2.setCurrentPosition(newPosition);
				if (snakeAndLadderBoard.isFinished(newPosition)) {
					displayFinishMessage(snakeAndLadderPlayer2);
					break;
				}
				displayPositionMessage(snakeAndLadderPlayer2);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * This method will display Current position to the user.
	 * 
	 * @param snakeAndLadder
	 */
	private static void displayPositionMessage(
			SnakeAndLadderPlayer snakeAndLadder) {
		System.out.println("You have moved to position :"
				+ snakeAndLadder.getCurrentPosition() + "\n");

	}

	/**
	 * This method will display Finish line message to the user.
	 * 
	 * @param snakeAndLadder
	 */
	private static void displayFinishMessage(SnakeAndLadderPlayer snakeAndLadder) {
		System.out.println("Congratulations " + snakeAndLadder.getPlayerName()
				+ " ! You WON !");

	}

	/**
	 * This method will ask Player to enter the input.
	 * 
	 * @param snakeAndLadder
	 * @return int
	 */
	private static int getPlayerInput(SnakeAndLadderPlayer snakeAndLadder) {

		System.out.println(snakeAndLadder.getPlayerName()
				+ " Please enter input number between 1 to 6 or -1 to exit");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		int input = 0;

		while (true) {

			try {
				String strInput = reader.readLine();

				if ("-1".equals(strInput)) {
					return -1;
				}

				if (!snakeAndLadderBoard.validateInput(strInput)) {

					System.out
							.println("Invalid input, Please Enter valid number beween 1 to 6 or -1 to exit");
					continue;

				}

				input = Integer.parseInt(strInput);
				break;

			} catch (IOException e) {
				e.printStackTrace();
			}

			break;
		}

		return input;

	}
}
