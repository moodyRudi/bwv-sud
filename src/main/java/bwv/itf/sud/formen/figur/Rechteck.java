package bwv.itf.sud.formen.figur;

import bwv.itf.sud.exceptions.InvalidInputException;

public class Rechteck implements Figur {
	
	private static final String ERROR_NEGATIV = "Fehler beim Erstellen des Rechtecks: Eine Seitenlänge war <= 0";
	
	private double laenge;
	private double breite;
	
	public Rechteck(double laenge, double breite) throws InvalidInputException {
		if (laenge <= 0 || breite <= 0) {
			throw new InvalidInputException(ERROR_NEGATIV);
		}
		this.laenge = laenge;
		this.breite = breite;
	}

	@Override
	public double umfang() {
		return 2 * laenge + 2 * breite;
	}

	@Override
	public double flaeche() {
		return laenge * breite;
	}
	
	public double getLaenge() {
		return laenge;
	}
	
	public double getBreite() {
		return breite;
	}

}
