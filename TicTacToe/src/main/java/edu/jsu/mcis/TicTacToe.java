package edu.jsu.mcis;

import java.util.*;

public class TicTacToe{
	public enum Mark{ X, O, EMPTY};
	public static Mark Turn;
	public static Mark[][] board;
	public static int row = 3;
	public static int col = 3;
	public enum state{ TIE, X_WIN, O_WIN, PLAYING}
	public static state currentState;
	public int sign;
	public static Scanner in = new Scanner(System.in);
	public TicTacToe(){
		board = new Mark[row][col];
		for(int i = 0; i < row; i++)
			for(int j = 0; j < col; j++){
				board[i][j] = Mark.EMPTY;
			}
		currentState = state.PLAYING;
		Turn = Mark.EMPTY;
	}
	public void getInput(int r, int c){
			if(r >= 0 && r < 3 && c >= 0 && c < 3 && board[r][c] == Mark.EMPTY)
			{
				getMark(r,c);
				if(Turn == Mark.EMPTY || Turn == Mark.O){
					Turn = Mark.X;
				}
				else{
					Turn = Mark.O;
				}
			}
			else {
				getErrorInput();
			}
	}
	public String getErrorInput(){
		return "Wrong position to mark. Please enter again!";
	}
	public Mark getMark(int r, int c){
		do{
		if (Turn == Mark.EMPTY){
			board[r][c] = Mark.EMPTY;
		}
		else if(Turn == Mark.X){
			board[r][c] = Mark.X;
		}
		else if(Turn == Mark.O){
			board[r][c] = Mark.O;
		}	
		updateGame(Turn,r,c);
		}while(currentState == state.PLAYING);
		return board[r][c];
	}
	public static void updateGame(Mark t, int r, int c){
		if(hasWon(t, r, c)){
			currentState = (t == Mark.X)? state.X_WIN : state.O_WIN;
		}
		else if(isTie()){
			currentState = state.TIE;
		}
	}
	public static boolean isTie(){
		for(int i = 0; i < 3; i++ ){
			for(int j = 0; j < 3; j++){
				if(board[i][j] == Mark.EMPTY){
					return false;
				}
			}
		}
		return true;
	}
	public static boolean hasWon(Mark t, int r, int c){
		return (board[r][0] == t 
			&& board[r][1] == t 
			&& board[r][2] == t
		|| board[0][c] == t 
			&& board[1][c] == t 
			&& board[2][c] == t
		|| r == c 
			&& board[0][0] == t 
			&& board[1][1] == t 
			&& board[2][2] == t
		|| r + c == 2 
			&& board[0][2] == t 
			&& board[1][1] == t 
			&& board[2][0] == t);
	}
	
}