package cs342project3;
//Carlos Aceves and David Sanchez
//class for the singles algorithm

import java.util.ArrayList;

public class single extends candidateList {

	private ArrayList<String> temparray = new ArrayList<String>();
	private String value;
	
	public single(String[][] puzzle ,int posX, int posY) {
		super(puzzle,posX,posY);
	
	
	// gets the candidates list of current cell
	temparray = returnArray();
	
	//gets remaining candidate
	value = temparray.get(0);
		
		
		
	}
	
	//returns remaining candidate
	public String getValue()
	{
		return value;
	}

}
