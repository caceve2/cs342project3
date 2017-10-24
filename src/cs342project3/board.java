package cs342project3;

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
		

		Cells = new JButton[GRIDSIZE][GRIDSIZE];
		
		PANELHandler PH = new PANELHandler();
		GRIDHandler GH = new GRIDHandler();
		

		GRID = new JPanel(new GridLayout(GRIDSIZE,GRIDSIZE));
		for(int i = 0; i < GRIDSIZE; i++)
		for ( int j = 0; j < GRIDSIZE; j++ )
		{
			
			Cells[i][j] = new JButton(puzzle[i][j]);
			Cells[i][j].addActionListener(GH);
			
			GRID.add( Cells[i][j]);
			
			Cells[i][j].setBackground(Color.WHITE);
			
			
			if (Cells[i][j].getText() != "")
			{
				
				Cells[i][j].removeActionListener(GH);
				Cells[i][j].setForeground(Color.BLUE);
				
			}
			
		}
		

		int miniPanelSize = (int) Math.sqrt(GRIDSIZE);
		GRID.setLayout(new GridLayout(miniPanelSize,miniPanelSize));

		miniPanels = new JPanel[miniPanelSize]
		[miniPanelSize];

		Border minisquareBorder = BorderFactory.createLineBorder(Color.BLACK, 1);

		for (int i = 0; i < miniPanelSize; ++i) {
			for (int j = 0; j < miniPanelSize; ++j) {
				JPanel panel = new JPanel();
				panel.setLayout(new GridLayout(miniPanelSize,miniPanelSize));
				panel.setBorder(minisquareBorder);
				miniPanels[i][j] = panel;
				GRID.add(panel);
			}
		}

		for (int i = 0; i < GRIDSIZE; ++i) {
			for (int j = 0; j < GRIDSIZE; ++j) {
				int X = j / miniPanelSize;
				int Y = i / miniPanelSize;

				miniPanels[Y][X].add(Cells[i][j]);
			}
		}
		
		gameMenuBar = new JMenuItems();
		
		nestedPanel = new JPanel(new GridLayout(10,1),false);
	    candidatePanel = new JPanel (new GridLayout(1,10),false);
		candidateLabel = new JLabel();
		candidatePanel.add(candidateLabel);
		
		
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
		
		container.add(GRID, BorderLayout.CENTER);
		container.add(nestedPanel, BorderLayout.EAST);
		container.add(candidatePanel, BorderLayout.SOUTH);
		setMenuBar();
		
		
	
	}
	
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
					
					
		
					ArrayList<String> temparray = puzzleTable.get(i^j);
					
					if(gameMenuBar.candidateListSelected())
					{
						
						String list = "candidate list: ";
						for(String s: temparray)
						{
							list += s + " \t";
						}
						candidateLabel.setText(list);
						
						
						
						
					}
					
					if(gameMenuBar.checkOnFillSelected())
					{
						
					   if(SELECTEDNUMBER == "X" || SELECTEDNUMBER == "")
							Cells[i][j].setText("");
					 
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
							single newSingleAL =new single(getBoard(),i,j);
							Cells[i][j].setText(newSingleAL.getValue());
							
							count++;
						}
						
						
					}
					
				}
				
			}
			count =0;
			
		}
	}
	
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
