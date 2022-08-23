package bwv.itf.sud.formen.figur;

import bwv.itf.sud.exceptions.InvalidInputException;

public class GleichseitigesDreieck extends Polygon {
	
	public GleichseitigesDreieck(double laenge) throws InvalidInputException {
		super(3, laenge);
	}

}
