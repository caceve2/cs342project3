package cs342project3;

import java.awt.*;
import javax.swing.*;
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
	
	public board()
	{
	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	container = getContentPane( );
	container.setLayout(new BorderLayout());
	
	Cells = new JTextField[GRIDSIZE][GRIDSIZE];
	
	GRID = new JPanel(new GridLayout(GRIDSIZE,GRIDSIZE));
	for(int i = 0; i < GRIDSIZE; i++)
	for ( int j = 0; j < GRIDSIZE; j++ )
	{
		Cells[ i][j] = new JTextField("1");
		
		//buttons[ count ].addActionListener( bh1 );
		GRID.add( Cells[i][j]);
		Cells[i][j].setHorizontalAlignment(JTextField.CENTER);
	}
	
	
	container.add(GRID, BorderLayout.CENTER);
	}
	
	
}
