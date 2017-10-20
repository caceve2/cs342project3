package cs342project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {
	private String puzzle[][] = new String[9][9];
	private File selectedFile;
	public Game() throws FileNotFoundException
	{
		//FileChooser getFile = new FileChooser();
		//selectedFile = getFile.getFile();
		selectedFile = new File("proj3dat1");
		parseFile(selectedFile);
		printpuzzle();
		board sudoku  =  new board(puzzle);
		sudoku.setSize(600, 600);
		sudoku.setVisible(true);
	}
	
	
	public void parseFile(File file) throws FileNotFoundException
	{
		//File file = new File("proj3dat1");
		Scanner input = new Scanner(file);

		while(input.hasNext()) {
		    String nextToken = input.next();
		    int i = Integer.parseInt(nextToken);
		    String nextToken1 = input.next();
		    int j = Integer.parseInt(nextToken1);
		    String nextToken2 = input.next();
		 
		    puzzle[i-1][j-1] = nextToken2;
		  
		}
		input.close();
	}
	
	public void printpuzzle()
	{
		for(int i = 0; i < 9; i++)
		{
			for(int j =0; j < 9; j++)
				System.out.print(puzzle[i][j]);
			System.out.println();
		}
	}
}
