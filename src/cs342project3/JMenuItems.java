package cs342project3;

import javax.swing.*;
import java.awt.event.*;


public class JMenuItems extends JFrame{
	private  JMenuBar boardMenu=new JMenuBar();
	
	private JMenu fileMenu = new JMenu( "File" );
	private JMenuItem loadPuzzle = new JMenuItem( "Load Puzzle" );
	private JMenuItem storePuzzle = new JMenuItem( "Save Puzzle" );
	private JMenuItem exitPuzzle = new JMenuItem( "Exit" );
	
	private JMenu helpMenu = new JMenu( "Help" );
	private JMenuItem howToPlay= new JMenuItem( "How To Play" );
	private JMenuItem howToUse = new JMenuItem( "How To Use Interface" );
	private JMenuItem aboutItem = new JMenuItem( "About" );
	
	private JMenu hintsMenu = new JMenu( "File" );
	private JMenuItem checkOnFill= new JMenuItem( "Check on Fill" );
	private JMenuItem singleAlgorithm = new JMenuItem( "Single Algorithm" );
	private JMenuItem hiddenSingleAlgorithm= new JMenuItem( "Hidden Single Algorithm" );
	private JMenuItem lockedCandidateAlgorithm= new JMenuItem( "Locked Candidate Algorithm" );
	private JMenuItem nakedPairsAlgorithm= new JMenuItem( "Naked Pairs Algorithm" );
	private JMenuItem useAllAlgorithms= new JMenuItem( "Fill In" );
	
	
	public JMenuItems()
	{
		setupFileMenu();
		setupHelpMenu();
		setupHintsMenu();
		
		boardMenu.add(fileMenu);
		boardMenu.add(helpMenu);
		boardMenu.add(hintsMenu);
	
		
	}
	
	private void setupFileMenu()
	{
		fileMenu.add(loadPuzzle);
		loadPuzzle.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent event)
			{
					FileChooser fl = new FileChooser();
			}
			}
	);
		
		fileMenu.add(storePuzzle);
		fileMenu.add(exitPuzzle);
	}
	
	private void setupHelpMenu()
	{
		helpMenu.add(howToPlay);
		helpMenu.add(howToUse);
		helpMenu.add(aboutItem);		
	}
	
	private void setupHintsMenu()
	{
		hintsMenu.add(checkOnFill);
		hintsMenu.add(singleAlgorithm);
		hintsMenu.add(hiddenSingleAlgorithm);
		hintsMenu.add(lockedCandidateAlgorithm);
		hintsMenu.add(nakedPairsAlgorithm);
		hintsMenu.add(useAllAlgorithms);
	}
	
	public JMenuBar returnBoard()
	{
		return boardMenu;
	}

}
