package cs342project3;
//Carlos Aceves and David Sanchez
//class to get candidate lists of blank cells
import java.util.ArrayList;



public class candidateList extends board {
	
	private ArrayList<String> candidateArray = new ArrayList<String>();
	
	
	public candidateList(String[][] puzzle, int posX , int posY) 
	{
		super(puzzle);
		
		// sets the array of all possible values
		for (int i = 1; i<10; i++ )
			candidateArray.add(Integer.toString(i));
		
		// checks for number for both rows and columns and deletes them
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
		
		//checks for numbers in the current grid
		for(int k = 0; k< 3; k++)
			for(int j=0; j<3; j++)
			{
				int X = posX/3*3+k;
				int Y = posY/3*3+j;
				if(candidateArray.contains(puzzle[X][Y]))
					candidateArray.remove(puzzle[X][Y]);
				
			}	
		
	}
	
	//returns the array of candidates
	public ArrayList<String> returnArray()
	{
		return candidateArray;
	}
	
	//erases the array
	public void eraseArray()
	{
		candidateArray.clear();
	}
	
	
	
}
