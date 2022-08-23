package bwv.itf.sud.formen.koerper;

import bwv.itf.sud.exceptions.InvalidInputException;

public class Kugel implements Koerper {
	
	private static final String ERROR_RADIUS = "Fehler beim Erstellen der Kugel: Der Radius war <= 0";
	
	private double radius;
	
	public Kugel(double radius) throws InvalidInputException {
		if (radius <= 0) {
			throw new InvalidInputException(ERROR_RADIUS);
		}
		this.radius = radius;
	}

	@Override
	public double volumen() {
		return 4. / 3 * Math.PI * radius * radius * radius;
	}

	@Override
	public double oberflaeche() {
		return 4 * Math.PI * radius * radius;
	}
	
	public double getRadius() {
		return radius;
	}

}
