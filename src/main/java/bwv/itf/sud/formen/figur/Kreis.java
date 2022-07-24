package bwv.itf.sud.formen.figur;

import bwv.itf.sud.exceptions.InvalidInputException;

public class Kreis implements Figur {
	
	private static final String ERROR_NEGATIV = "Fehler beim Erstellen des Kreises: Der Radius war <= 0";
	
	private double radius;
	
	public Kreis(double radius) throws InvalidInputException {
		if (radius <= 0) {
			throw new InvalidInputException(ERROR_NEGATIV);
		}
		this.radius = radius;
	}

	@Override
	public double umfang() {
		return 2 * Math.PI * radius;
	}

	@Override
	public double flaeche() {
		return Math.PI * radius * radius;
	}
	
	public double getRadius() {
		return radius;
	}

}
