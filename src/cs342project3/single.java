package cs342project3;

import java.util.ArrayList;

public class single extends candidateList {

	private ArrayList<String> temparray = new ArrayList<String>();
	private String value;
	
	public single(String[][] puzzle ,int posX, int posY) {
		super(puzzle,posX,posY);
	
	//candidateList tempCandArray  = new candidateList(getBoard(), posX, posY);
	
	temparray = returnArray();
	
	value = temparray.get(0);
		
		
		
	}
	
	public String getValue()
	{
		return value;
	}

}
