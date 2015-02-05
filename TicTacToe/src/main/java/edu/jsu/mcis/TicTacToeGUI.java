package edu.jsu.mcis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGUI extends JFrame
{
	private static final String TITLE="Tic Tac Toe";
	private static final int WIDTH=450;
	private static final int HEIGHT=600;
	
	private Container content;
	private JLabel result;
	private JButton[] cells;
	private JButton exitButton;
	private JButton initButton;
	private CellButtonHandler[] cellHandlers;
	private ExitButtonHandler exitHandler;
	private InitButtonHandler initHandler;
	
	private boolean O;
	private boolean gameOver;
	
	public TicTacToeGUI()
	{
		setTitle(TITLE);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		content=getContentPane();
		content.setBackground(Color.blue.darker());
		
		content.setLayout(new GridLayout(4,3));

		cells=new JButton[9];
		cellHandlers=new CellButtonHandler[9];
		for(int i=0; i<9; i++)
		{
			char ch=(char)('0'+i+1);
			cells[i]=new JButton(""+ch);
			cellHandlers[i]=new CellButtonHandler();
			cells[i].addActionListener(cellHandlers[i]);
		}
		
		exitButton=new JButton("EXIT");
		exitHandler=new ExitButtonHandler();
		exitButton.addActionListener(exitHandler);
		initButton=new JButton("CLEAR");
		initHandler=new InitButtonHandler();
		initButton.addActionListener(initHandler);
		
		result=new JLabel("O", SwingConstants.CENTER);
		result.setForeground(Color.white);
						
		for(int i=0; i<9; i++)
		{
			content.add(cells[i]);
		}
		content.add(initButton);
		content.add(result);
		content.add(exitButton);
		
		init();
	}
	
	public void init()
	{
		O=true;
		gameOver=false;
		
		for(int i=0; i<9; i++)
		{
			char ch=(char)('0'+i+1);
			cells[i].setText(""+ch);
		}
		
		result.setText("O");
		
		setVisible(true);
	}
	
	public boolean checkWinner()
	{
		if(cells[0].getText().equals(cells[1].getText()) && cells[1].getText().equals(cells[2].getText()))
		{
			return true;
		}
		else if(cells[3].getText().equals(cells[4].getText()) && cells[4].getText().equals(cells[5].getText()))
		{
			return true;
		}
		else if(cells[6].getText().equals(cells[7].getText()) && cells[7].getText().equals(cells[8].getText()))
		{
			return true;
		}
		else if(cells[0].getText().equals(cells[3].getText()) && cells[3].getText().equals(cells[6].getText()))
		{
			return true;
		}
		else if(cells[1].getText().equals(cells[4].getText()) && cells[4].getText().equals(cells[7].getText()))
		{
			return true;
		}
		else if(cells[2].getText().equals(cells[5].getText()) && cells[5].getText().equals(cells[8].getText()))
		{
			return true;
		}
		else if(cells[0].getText().equals(cells[4].getText()) && cells[4].getText().equals(cells[8].getText()))
		{
			return true;
		}
		else if(cells[2].getText().equals(cells[4].getText()) && cells[4].getText().equals(cells[6].getText()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void main(String[] args)
	{
		TicTacToeGUI gui=new TicTacToeGUI();
		
	}
	
	private class CellButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(gameOver)
			{
				return;
			}
			
			JButton pressed=(JButton)(e.getSource());
			
			String text=pressed.getText();
			
			if(text.equals("O") || text.equals("X"))
			{
				return;
			}
			
			if(O)
			{
				pressed.setText("O");
			}
			else
			{
				pressed.setText("X");
			}
			
			if(checkWinner())
			{
				gameOver=true;
				if(O)
				{
					result.setText("O win!!");
				}
				else
				{
					result.setText("X win!");
				}
			}
			else
			{
				O=!O;
				if(O)
				{
					result.setText("O");
				}
				else
				{
					result.setText("X");
				}
			}
		}
	}
	
	private class ExitButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}

	private class InitButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			init();
		}
	}
}