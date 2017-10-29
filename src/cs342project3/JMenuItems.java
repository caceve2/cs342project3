package cs342project3;
//Carlos Aceves and David Sanchez
// Class to set up the help menu
import javax.swing.*;
import java.awt.event.*;
import java.io.FileNotFoundException;


public class JMenuItems extends JPanel {
  private  JMenuBar boardMenu=new JMenuBar();
  
  private JMenu fileMenu = new JMenu( "File" );
  private JMenuItem loadPuzzle = new JMenuItem( "Load Puzzle" );
  private JMenuItem storePuzzle = new JMenuItem( "Save Puzzle" );
  private JMenuItem exitPuzzle = new JMenuItem( "Exit" );
  
  private JMenu helpMenu = new JMenu( "Help" );
  private JMenuItem howToPlay= new JMenuItem( "How To Play" );
  private JMenuItem howToUse = new JMenuItem( "How To Use Interface" );
  private JMenuItem aboutItem = new JMenuItem( "About" );
  
  private JMenu hintsMenu = new JMenu( "Hints" );
  private JCheckBoxMenuItem candidateList= new JCheckBoxMenuItem( "?" );
  private JCheckBoxMenuItem checkOnFill= new JCheckBoxMenuItem( "Check on Fill" );
  private JMenuItem singleAlgorithm = new JMenuItem( "Single Algorithm" );
  private JMenuItem hiddenSingleAlgorithm= new JMenuItem( "Hidden Single Algorithm" );
  private JMenuItem lockedCandidateAlgorithm= new JMenuItem( "Locked Candidate Algorithm" );
  private JMenuItem nakedPairsAlgorithm= new JMenuItem( "Naked Pairs Algorithm" );
  private JMenuItem useAllAlgorithms= new JMenuItem( "Fill In" );
  
  private boolean isSelectedCOF = false;
  private boolean isSelectedCL = false;
  
  
  public JMenuItems()
  {
	
	
    setupFileMenu();
    setupHelpMenu();
    setupHintsMenu();
    
    boardMenu.add(fileMenu);
    boardMenu.add(helpMenu);
    boardMenu.add(hintsMenu);
    
    
  }
  
  //sets up the file menu to 
  private void setupFileMenu()
  {
    fileMenu.add(loadPuzzle);
    //basically starts a new game with a new puzzle chosen
    loadPuzzle.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent event)
      {
        java.awt.Window win[] = java.awt.Window.getWindows(); 
        win[0].dispose();
        
        try {
          new Game();
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
        
        
        
      }
    }
    );
    
    fileMenu.add(storePuzzle);
    fileMenu.add(exitPuzzle);
    //exits game
    exitPuzzle.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent event)
    	{
    		System.exit(0);
    	}
    });
  }
  
  //sets up help section
  private void setupHelpMenu()
  {
    helpMenu.add(howToPlay);
    howToPlay.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent event)
    	{
    		JOptionPane.showMessageDialog(JMenuItems.this, "The objective is to fill a 9x9 grid so that each column, each row,\nand each of the nine 3x3 boxes (also called blocks or regions)\ncontains the digits from 1 to 9. \r\n" + 
    				"\r\n" + 
    				"A cell is the smallest block in the game. A row , column and region consists of 9 cells\nand the whole game consists of 81 cells. A region has thicker lines surrounding it.\nThis simply makes it easier to play the game.\n", "Help", JOptionPane.PLAIN_MESSAGE);
    	}
    });
    
    helpMenu.add(howToUse);
    howToUse.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent event)
    	{
    		JOptionPane.showMessageDialog(JMenuItems.this, "You can select desired number from the right most column to input into cell\nSelected number will stay selected until deselected\r\n"
    				 + "\nFile menu allows you to load a new game from a different .txt file\nor save your current game"
    				 + "\n\nHelp menu contains useful algorithms that will help solve the soduko", "How To Use", JOptionPane.PLAIN_MESSAGE);
    	}
    });
    
    helpMenu.add(aboutItem);	
    aboutItem.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent event)
    	{
    		JOptionPane.showMessageDialog(JMenuItems.this, "Authors: Carlos Aceves, David Sanchez\n"
    													  +"NetId's: caceve2, dsanch42\n", "About", JOptionPane.PLAIN_MESSAGE);
    	}
    });
  }
  //sets up the hint menu
  private void setupHintsMenu()
  {
    hintsMenu.add(candidateList);
    //checks if button is selected for checking candidates list
    candidateList.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent event)
      {
        AbstractButton	button = (AbstractButton) event.getSource();
        isSelectedCL = button.getModel().isSelected();
        
      }
    }
    );
    
    hintsMenu.add(checkOnFill);
    //checks if button is selected for checking on fill
    checkOnFill.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent event)
      {
        AbstractButton	button = (AbstractButton) event.getSource();
        isSelectedCOF = button.getModel().isSelected();
        
      }
    }
    );
    //add them to menu
    hintsMenu.add(singleAlgorithm);
    hintsMenu.add(hiddenSingleAlgorithm);
    hintsMenu.add(lockedCandidateAlgorithm);
    hintsMenu.add(nakedPairsAlgorithm);
    hintsMenu.add(useAllAlgorithms);
    
  }
  
  //get button for singles algorithm /button handler is in board class
  public JMenuItem getSingleAl()
  {
	  return singleAlgorithm;
  }
  //get button for hidden singles algorithm /button handler is in board class
  public JMenuItem getHiddenSingleAl()
  {
	  return hiddenSingleAlgorithm;
  }
  // return is selected or not
  public boolean checkOnFillSelected()
  {
    return isSelectedCOF;
  }
  public boolean candidateListSelected()
  {
    return isSelectedCL;
  }
  
  // returns the help menu bar
  public JMenuBar returnBoard()
  {
    return boardMenu;
  }
  
}
