package edu.jsu.mcis;

import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest{
	@Test

	public void testInitialBoardIsCompletelyEmpty(){
		TicTacToe board = new TicTacToe();
		for(int row = 0; row < 3; row++){
			for(int col = 0; col < 3; col++){
				assertEquals(TicTacToe.Mark.EMPTY, board.getMark(row,col));
			}
		}	
	}
	@Test

	public void testMarkXInUpperRightCorner(){
		TicTacToe board = new TicTacToe();
		board.getInput(2,2);
		assertEquals(TicTacToe.Mark.X, board.getMark(2,2));
	}
	@Test

	public void testMarkXInUpperRightCornerThenOInBottomCenter(){
		TicTacToe board = new TicTacToe();
		board.getInput(2,2);
		assertEquals(TicTacToe.Mark.X, board.getMark(2,2));
		board.getInput(1,1);
		assertEquals(TicTacToe.Mark.O, board.getMark(1,1));
	}
	@Test
	
	public void testInputAErrorPosition(){
		TicTacToe board = new TicTacToe();
		board.getInput(3,3);
		assertEquals("Wrong position to mark. Please enter again!",board.getErrorInput());
	}
	@Test
	
	public void testPositionHasBeenTaken(){
		TicTacToe board = new TicTacToe();
		board.getInput(1,2);
		board.getInput(1,2);
		assertEquals("Wrong position to mark. Please enter again!",board.getErrorInput());
	}
	@Test
	
	public void testTheGameIsTie(){
		TicTacToe  board = new TicTacToe();
		board.getInput(1,1);
		board.getInput(0,0);
		board.getInput(2,0);
		board.getInput(0,2);
		board.getInput(0,1);
		board.getInput(2,1);
		board.getInput(1,2);
		board.getInput(1,0);
		board.getInput(2,2);
		assertEquals(TicTacToe.Mark.TIE, board.currentState);
	}
	@Test
	
	public void testTheGameIsO(){
		TicTacToe  board = new TicTacToe();
		board.getInput(1,1);
		board.getInput(2,0);
		board.getInput(0,0);
		board.getInput(2,2);
		board.getInput(0,2);
		board.getInput(2,1);
		assertEquals(TicTacToe.Mark.O, board.currentState);
	}
	@Test
	
	public void testTheGameIsX(){
		TicTacToe  board = new TicTacToe();
		board.getInput(1,1);
		board.getInput(0,1);
		board.getInput(0,0);
		board.getInput(2,0);
		board.getInput(2,2);
		assertEquals(TicTacToe.Mark.X, board.currentState);
	}
}
