package bwv.itf.sud.formen.figur;

import bwv.itf.sud.exceptions.InvalidInputException;

public class Dreieck implements Figur {

	private static final String ERROR_NEGATIV = "Fehler beim Erstellen des Dreiecks: Eine Seitenlänge war <= 0";
	private static final String ERROR_VERHAELTNIS = "Fehler beim Erstellen des Dreiecks: Das Verhältnis der Seitenlängen war ungültig";

	private double seite1;
	private double seite2;
	private double seite3;

	public Dreieck(double seite1, double seite2, double seite3) throws InvalidInputException {
		if (seite1 <= 0 || seite2 <= 0 || seite3 <= 0) {
			throw new InvalidInputException(ERROR_NEGATIV);
		}
		if (seite1 >= seite2 + seite3 || seite2 >= seite1 + seite3 || seite3 >= seite1 + seite2) {
			throw new InvalidInputException(ERROR_VERHAELTNIS);
		}
		this.seite1 = seite1;
		this.seite2 = seite2;
		this.seite3 = seite3;
	}

	@Override
	public double umfang() {
		return seite1 + seite2 + seite3;
	}

	@Override
	public double flaeche() {
		double s = umfang() / 2;
		return Math.sqrt(s * (s - seite1) * (s - seite2) * (s - seite3));
	}

	public double getSeite1() {
		return seite1;
	}

	public double getSeite2() {
		return seite2;
	}

	public double getSeite3() {
		return seite3;
	}

}
