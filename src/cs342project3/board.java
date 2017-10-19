package cs342project3;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;
//import java.lang.reflect.Array;
import java.util.*;

public class board extends JFrame
{
	private JTextField Cells[][];
	private JPanel nestedPanel;
	private Container container;
	private JPanel GRID;
	public static int GRIDSIZE = 9;
	public static int SUBSIZE = 3;
	private final JPanel[][] miniPanels;

	public board(String puzzle[][])
	{
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		container = getContentPane( );
		container.setLayout(new BorderLayout());

		Cells = new JTextField[GRIDSIZE][GRIDSIZE];

		GRID = new JPanel(new GridLayout(GRIDSIZE,GRIDSIZE));
		for(int i = 0; i < GRIDSIZE; i++)
		for ( int j = 0; j < GRIDSIZE; j++ )
		{
			Cells[i][j] = new JTextField(puzzle[i][j]);

			//buttons[ count ].addActionListener( bh1 );
			GRID.add( Cells[i][j]);
			Cells[i][j].setHorizontalAlignment(JTextField.CENTER);
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

		GRID.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

		container.add(GRID, BorderLayout.CENTER);
	}




}
