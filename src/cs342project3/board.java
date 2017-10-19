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
	private final JPanel[][] miniPanels;
	private JButton PANEL[];
	private String panelArray[] = {"1","2","3","4","5","6","7","8","9","X"};

	public board(String puzzle[][])
	{
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		container = getContentPane( );
		container.setLayout(new BorderLayout());
		Font f = new Font ("Serif" , Font.BOLD , 12);

		Cells = new JButton[GRIDSIZE][GRIDSIZE];
		
		

		GRID = new JPanel(new GridLayout(GRIDSIZE,GRIDSIZE));
		for(int i = 0; i < GRIDSIZE; i++)
		for ( int j = 0; j < GRIDSIZE; j++ )
		{
			Cells[i][j] = new JButton(puzzle[i][j]);

			
			GRID.add( Cells[i][j]);
			Cells[i][j].setBackground(Color.WHITE);
			
			if (Cells[i][j].getText() != "")
			{
				
				Cells[i][j].setBackground(Color.GREEN);
				
				Cells[i][j].setFont(f);
				
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
		
		nestedPanel = new JPanel(new GridLayout(10,1),false);
		PANEL = new JButton[10];
		Color color  = new Color(255,0,0);
		for ( int j = 0; j <= 9; j++ )
		{
			PANEL[j] = new JButton(panelArray[j]);
			PANEL[j].setBackground(color);
			
			nestedPanel.add(PANEL[j] );
		}

		GRID.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

		container.add(GRID, BorderLayout.CENTER);
		container.add(nestedPanel, BorderLayout.EAST);
	}




}
