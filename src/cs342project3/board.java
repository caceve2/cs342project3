package cs342project3;
//Carlos Aceves and David Sanchez
//class for board and handlers for buttons

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;


import java.awt.event.*;
import java.util.*;

public class board extends JFrame
{
	private JButton Cells[][];
	private JPanel nestedPanel;
	private Container container;
	private JPanel GRID;
	public static int GRIDSIZE = 9;
	public static int SUBSIZE = 3;
	private JPanel[][] miniPanels;
	private JButton PANEL[];
	private String panelArray[] = {"1","2","3","4","5","6","7","8","9","X"};
	private String SELECTEDNUMBER = "";
	private JMenuItems gameMenuBar;
	private JPanel candidatePanel;
	private JLabel candidateLabel;
	protected Hashtable<Integer,ArrayList<String>> puzzleTable = new Hashtable<Integer,ArrayList<String>>();
	
	public board(String puzzle[][])
	{
		
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		container = getContentPane( );
		container.setLayout(new BorderLayout());
		
		// cells for game
		Cells = new JButton[GRIDSIZE][GRIDSIZE];
		
		//handlers for Panel and Grid
		PANELHandler PH = new PANELHandler();
		GRIDHandler GH = new GRIDHandler();
		
		//get Grid and insert buttons
		GRID = new JPanel(new GridLayout(GRIDSIZE,GRIDSIZE));
		for(int i = 0; i < GRIDSIZE; i++)
		for ( int j = 0; j < GRIDSIZE; j++ )
		{
			
			Cells[i][j] = new JButton(puzzle[i][j]);
			Cells[i][j].addActionListener(GH);
			
			GRID.add( Cells[i][j]);
			//set background to white
			Cells[i][j].setBackground(Color.WHITE);
			
			//if cells are not blank then get rid of action listener and set the numbers to blue
			if (Cells[i][j].getText() != "")
			{
				
				Cells[i][j].removeActionListener(GH);
				Cells[i][j].setForeground(Color.BLUE);
				
			}
			
		}
		
		
		//get miniPanels to get 9 grids
		int miniPanelSize = (int) Math.sqrt(GRIDSIZE);
		GRID.setLayout(new GridLayout(miniPanelSize,miniPanelSize));

		miniPanels = new JPanel[miniPanelSize]
		[miniPanelSize];
		
		//insert borders
		Border minisquareBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		//set up panels
		for (int i = 0; i < miniPanelSize; ++i) {
			for (int j = 0; j < miniPanelSize; ++j) {
				JPanel panel = new JPanel();
				panel.setLayout(new GridLayout(miniPanelSize,miniPanelSize));
				panel.setBorder(minisquareBorder);
				miniPanels[i][j] = panel;
				GRID.add(panel);
			}
		}
		
		//insert buttons into panels
		for (int i = 0; i < GRIDSIZE; ++i) {
			for (int j = 0; j < GRIDSIZE; ++j) {
				int X = j / miniPanelSize;
				int Y = i / miniPanelSize;

				miniPanels[Y][X].add(Cells[i][j]);
			}
		}
		
		// insert panels and labels into the board
		gameMenuBar = new JMenuItems();
		
		nestedPanel = new JPanel(new GridLayout(10,1),false);
	    candidatePanel = new JPanel (new GridLayout(1,10),false);
		candidateLabel = new JLabel();
		candidatePanel.add(candidateLabel);
		
		// get Panel for choosing buttons
		PANEL = new JButton[10];
		
		for ( int j = 0; j <= 9; j++ )
		{
			PANEL[j] = new JButton(panelArray[j]);
			PANEL[j].addActionListener(PH);
			PANEL[j].setForeground(Color.WHITE);
			PANEL[j].setBackground(Color.BLACK);
			
			nestedPanel.add(PANEL[j]);
		}
		
		
		GRID.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		// add all elements into container
		container.add(GRID, BorderLayout.CENTER);
		container.add(nestedPanel, BorderLayout.EAST);
		container.add(candidatePanel, BorderLayout.SOUTH);
		setMenuBar();
		
		
	
	}
	
	// class for handling the Panel
	private class PANELHandler implements ActionListener
	{
		public void actionPerformed( ActionEvent event )
		{
			JButton pushed = (JButton) event.getSource();
			
			for ( int count = 0; count < 10; count++ )
			{
				if(PANEL[count] == pushed)
				{

					SELECTEDNUMBER = pushed.getText();
				}

			}
			
		}

	}
	
	// class for handling the Grid
	private class GRIDHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			JButton pushed = (JButton) event.getSource();
			
		for(int i = 0 ; i < GRIDSIZE; i++)
			for ( int j = 0; j < GRIDSIZE; j++ )
			{
				if(Cells[i][j] == pushed)
				{
					
					
		
					candidateList candList = new candidateList(getBoard(),i,j);
					ArrayList<String> temparray = candList.returnArray();
					
					if(gameMenuBar.candidateListSelected())
					{
						
						String list = "candidate list: ";
						for(String s: temparray)
						{
							list += s + " \t";
						}
						candidateLabel.setText(list);
						
						
						
						
					}
					//checks to see if checkonfill button is selcetd
					if(gameMenuBar.checkOnFillSelected())
					{
						
					   if(SELECTEDNUMBER == "X" || SELECTEDNUMBER == "")
							Cells[i][j].setText("");
					   //shows message if not a possible input
					   else if(!temparray.contains(SELECTEDNUMBER))
							JOptionPane.showMessageDialog( null,"WRONG INPUT");
					   else
							Cells[i][j].setText(SELECTEDNUMBER);
					}
					else
					{
						if(SELECTEDNUMBER == "X")
							Cells[i][j].setText("");
						else
							Cells[i][j].setText(SELECTEDNUMBER);
					}
					
				}

			}
			
		}
	}
	
	//class for handling the singles algorithm
	private class singleHandler implements ActionListener
	{
		int count = 0;
		public void actionPerformed(ActionEvent event)
		{
			for(int i = 0 ; i < GRIDSIZE; i++)
			{
				for ( int j = 0; j < GRIDSIZE; j++ )
				{
					if(Cells[i][j].getText() == "" && count != 1)
					{
						candidateList candList = new candidateList(getBoard(),i,j);
						ArrayList<String> temparray = candList.returnArray();
						
						if(temparray.size() == 1)
						{
							//change value of if one of cell
							single newSingleAL =new single(getBoard(),i,j);
							Cells[i][j].setText(newSingleAL.getValue());
							
							count++; //so it will iterate only once
						}
						
						
					}
					
				}
				
			}
			count =0;
			
		}
	}
	
	//class for handling the hidden singles algorithm
	private class hiddenSingleHandler implements ActionListener
	{
		int count = 0;
		public void actionPerformed(ActionEvent event)
		{
			for(int i = 0 ; i < GRIDSIZE; i++)
			{
				for ( int j = 0; j < GRIDSIZE; j++ )
				{
					if(Cells[i][j].getText() == "" && count != 1)
					{
						candidateList candList = new candidateList(getBoard(),i,j);
						ArrayList<String> temparray = candList.returnArray();
						
						if(temparray.size() == 1)
						{
							hiddenSingle newHiddenSingleAL =new hiddenSingle(getBoard(),i,j);
							Cells[i][j].setText(newHiddenSingleAL.getValue());
							count++;
						}
						
						
					}
					
				}
				
			}
			count =0;
			
		}
	}
	
	
	// will set the menu bar
	private void setMenuBar()
	{ 
		JMenuBar gameMenuBar_ = new JMenuBar();
		gameMenuBar_ = gameMenuBar.returnBoard();
		singleHandler SH = new singleHandler();
		hiddenSingleHandler HS = new hiddenSingleHandler();
		gameMenuBar.getSingleAl().addActionListener(SH);
		gameMenuBar.getHiddenSingleAl().addActionListener(HS);
		container.add(gameMenuBar_, BorderLayout.NORTH);
	}
	
	// gets the game state of the puzzle
	public String[][] getBoard()
	{
		String tempPuzzle[][] = new String[GRIDSIZE][GRIDSIZE];
		for(int i = 0 ; i < GRIDSIZE; i++)
			for ( int j = 0; j < GRIDSIZE; j++ )
			{
				tempPuzzle[i][j] = Cells[i][j].getText();
			}
		
		return tempPuzzle;
	}

	



}
