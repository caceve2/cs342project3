package cs342project3;
//Carlos Aceves and David Sanchez
//class for the hidden singles algorithm
import java.util.ArrayList;

public class hiddenSingle extends candidateList {

	private ArrayList<String> temparray = new ArrayList<String>();
	private String value;
	
	public hiddenSingle(String[][] puzzle, int posX, int posY) {
		super(puzzle, posX, posY);
		//gets candidate list of current cell
		candidateList tempCandArray  = new candidateList(getBoard(), posX, posY);
		
		temparray = tempCandArray.returnArray();
		
		//checks candidate list of other cells in the column
		for(int i = 0 ; i < 9; i++)
		{
			if(puzzle[posX][i] == "")
			{
			tempCandArray = new candidateList(getBoard(),posX,i);
			
			//checks to see if any candidate is in the list and removes them
			for(String s: tempCandArray.returnArray())
			{
				if(temparray.contains(s))
					temparray.remove(s);
			}
			}
			
			
		}
		
		//checks candidate list of other cells in the row
		for(int i = 0 ; i < 9; i++)
		{
			if(puzzle[i][posY] == "")
			{
			tempCandArray = new candidateList(getBoard(),posX,i);
			
			for(String s: tempCandArray.returnArray())
			{
				if(temparray.contains(s))
					temparray.remove(s);
			}
			}
			
			
		}
		
		//checks candidate lists of other cells in current grid
		for(int k = 0; k< 3; k++)
			for(int j=0; j<3; j++)
			{
				int X = posX/3*3+k;
				int Y = posY/3*3+j;
				if(puzzle[X][Y] == "")
				{
					tempCandArray = new candidateList(getBoard(),X,Y);
					for(String s: tempCandArray.returnArray())
					{
						if(temparray.contains(s))
							temparray.remove(s);
					}
				}
				
			}
		value = temparray.get(0);
		
	}
	//returns the value
	public String getValue()
	{
		return value;
	}

}
