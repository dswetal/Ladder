package test;
import junit.framework.Assert;

import main.java.SnakeAndLadderBoard;

import org.junit.Test;


public class TestSnakeAndLadder {

	@Test
	public void testValidateInput() {

		SnakeAndLadderBoard snakeAndLadderBoard = SnakeAndLadderBoard
				.getInstance();

		// Valid Inputs
		Assert.assertEquals(true, snakeAndLadderBoard.validateInput("1"));
		Assert.assertEquals(true, snakeAndLadderBoard.validateInput("2"));
		Assert.assertEquals(true, snakeAndLadderBoard.validateInput("3"));
		Assert.assertEquals(true, snakeAndLadderBoard.validateInput("4"));
		Assert.assertEquals(true, snakeAndLadderBoard.validateInput("5"));
		Assert.assertEquals(true, snakeAndLadderBoard.validateInput("6"));

		// Invalid Inputs
		Assert.assertEquals(false, snakeAndLadderBoard.validateInput("-1"));
		Assert.assertEquals(false, snakeAndLadderBoard.validateInput("a"));
		Assert.assertEquals(false, snakeAndLadderBoard.validateInput("ab"));
		Assert.assertEquals(false, snakeAndLadderBoard.validateInput("10"));
		Assert.assertEquals(false, snakeAndLadderBoard.validateInput("7"));

	}

	@Test
	public void testValidateBoard() {

		SnakeAndLadderBoard snakeAndLadderBoard = SnakeAndLadderBoard
				.getInstance();

		Assert.assertEquals(1, snakeAndLadderBoard.calculateNewPosition(0, 1));

		// Test ladder
		Assert.assertEquals(14, snakeAndLadderBoard.calculateNewPosition(1, 3));
		Assert.assertEquals(84, snakeAndLadderBoard.calculateNewPosition(27, 1));

		// Test snake
		Assert.assertEquals(34, snakeAndLadderBoard.calculateNewPosition(53, 1));

	}

}
