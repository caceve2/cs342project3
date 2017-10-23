package cs342project3;

import java.util.ArrayList;

import javax.swing.JButton;

public class candidateList extends board {
	
	private ArrayList<String> candidateArray = new ArrayList<String>();
	
	
	public candidateList(String[][] puzzle, int posX , int posY) 
	{
		super(puzzle);
		
	
		for (int i = 1; i<10; i++ )
			candidateArray.add(Integer.toString(i));
		
		for(int i = 0 ; i < GRIDSIZE; i++)
		{
			if(candidateArray.contains(puzzle[posX][i]))
			{
			 candidateArray.remove(puzzle[posX][i]);
			}
			
			if(candidateArray.contains(puzzle[i][posY]))
			{
			 candidateArray.remove(puzzle[i][posY]);
			}
		}
		
		for(int k = 0; k< 3; k++)
			for(int j=0; j<3; j++)
			{
				int X = posX/3*3+k;
				int Y = posY/3*3+j;
				if(candidateArray.contains(puzzle[X][Y]))
					candidateArray.remove(puzzle[X][Y]);
				
			}	
		
	}

	public ArrayList<String> returnArray()
	{
		return candidateArray;
	}
	
	public void eraseArray()
	{
		candidateArray.clear();
	}
	
	
	
}
