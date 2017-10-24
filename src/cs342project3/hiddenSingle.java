package cs342project3;

import java.util.ArrayList;

public class hiddenSingle extends candidateList {

	private ArrayList<String> temparray = new ArrayList<String>();
	private String value;
	
	public hiddenSingle(String[][] puzzle, int posX, int posY) {
		super(puzzle, posX, posY);
		candidateList tempCandArray  = new candidateList(getBoard(), posX, posY);
		
		temparray = tempCandArray.returnArray();
		
		for(int i = 0 ; i < 9; i++)
		{
			if(puzzle[posX][i] == "")
			{
			tempCandArray = new candidateList(getBoard(),posX,i);
			
			for(String s: tempCandArray.returnArray())
			{
				if(temparray.contains(s))
					temparray.remove(s);
			}
			}
			
			
		}
		
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
	public String getValue()
	{
		return value;
	}

}
