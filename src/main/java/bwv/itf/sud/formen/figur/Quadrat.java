package bwv.itf.sud.formen.figur;

import bwv.itf.sud.exceptions.InvalidInputException;

public class Quadrat extends Polygon {
	
	public Quadrat(double laenge) throws InvalidInputException {
		super(4, laenge);
	}

}
