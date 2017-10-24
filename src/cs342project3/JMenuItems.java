package cs342project3;

import javax.swing.*;
import java.awt.event.*;
import java.io.FileNotFoundException;


public class JMenuItems  {
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
  
  private String singlesValue;
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
  }
  
  private void setupHelpMenu()
  {
    helpMenu.add(howToPlay);
    helpMenu.add(howToUse);
    helpMenu.add(aboutItem);		
  }
  
  private void setupHintsMenu()
  {
    hintsMenu.add(candidateList);
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
    
    hintsMenu.add(singleAlgorithm);
    hintsMenu.add(hiddenSingleAlgorithm);
    hintsMenu.add(lockedCandidateAlgorithm);
    hintsMenu.add(nakedPairsAlgorithm);
    hintsMenu.add(useAllAlgorithms);
    
  }
  
  public JMenuItem getSingleAl()
  {
	  return singleAlgorithm;
  }
  public JMenuItem getHiddenSingleAl()
  {
	  return hiddenSingleAlgorithm;
  }
  
  public boolean checkOnFillSelected()
  {
    return isSelectedCOF;
  }
  public boolean candidateListSelected()
  {
    return isSelectedCL;
  }
  public JMenuBar returnBoard()
  {
    return boardMenu;
  }
  
}
