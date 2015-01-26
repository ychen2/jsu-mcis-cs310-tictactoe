package edu.jsu.mcis;

import java.util.*;

public class TicTacToe{
	public enum Mark{ X, O, EMPTY, TIE};
	public static Mark Turn;
	public static Mark[][] board;
	public static int row = 3;
	public static int col = 3;
	public static Mark currentState;
	public int sign;
	public static Scanner in = new Scanner(System.in);
	public TicTacToe(){
		board = new Mark[row][col];
		for(int i = 0; i < row; i++)
			for(int j = 0; j < col; j++){
				board[i][j] = Mark.EMPTY;
			}
		currentState = Mark.EMPTY;
		Turn = Mark.EMPTY;
	}
	public void getInput(int r, int c){
		if (r >= 3 || c >= 3 || c <= 0 || r <= 0 || board[r][c] != Mark.EMPTY){
			getErrorInput();
		}
		else if(Turn == Mark.EMPTY || Turn == Mark.O){
			getMark(r,c);
			Turn = Mark.X;
		}
		else if(Turn == Mark.X){
			getMark(r,c);
			Turn = Mark.O;
		}
	}
	public String getErrorInput(){
		return "Wrong position to mark. Please enter again!";
	}
	public Mark getMark(int r, int c){
		int a = r;
		int b = c;
		if (Turn == Mark.EMPTY){
			board[a][b] = Mark.EMPTY;
		}
		else if(Turn == Mark.X){
			board[a][b] = Mark.X;
		}
		else if(Turn == Mark.O){
			board[a][b] = Mark.O;
		}	
		updateGame(Turn,r,c);
		return board[a][b];
	}
	public static void updateGame(Mark t, int r, int c){
		if(hasWon(t, r, c)){
			currentState = (t == Mark.X)? Mark.X : Mark.O;
		}
		else if(isTie()){
			currentState = Mark.TIE;
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
		if(board[r][0] == t && board[r][1] == t && board[r][2] == t
				|| board[0][c] == t && board[1][c] == t && board[2][c] == t
				|| r == c && board[0][0] == t && board[1][1] == t && board[2][2] == t
				|| r + c == 2 && board[0][2] == t && board[1][1] == t && board[2][0] == t){
					return true;
				}
		else return false;
	}
	
}