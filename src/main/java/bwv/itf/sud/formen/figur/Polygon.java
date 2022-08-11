package bwv.itf.sud.formen.figur;

import bwv.itf.sud.exceptions.InvalidInputException;

public abstract class Polygon implements Figur {
	
	private static final String ERROR_LAENGE = "Fehler beim Erstellen des Polygons: Die Seitenlänge war <= 0";
	private static final String ERROR_ANZAHL_SEITEN = "Fehler beim Erstellen des Polygons: Die Anzahl der Seiten war zu gering";
	
	private int anzahlSeiten;
	private Dreieck dreieck;
	
	protected Polygon(int anzahlSeiten, double laenge) throws InvalidInputException {
		if (laenge <= 0) {
			throw new InvalidInputException(ERROR_LAENGE);
		}
		if (anzahlSeiten <= 2) {
			throw new InvalidInputException(ERROR_ANZAHL_SEITEN);
		}
		this.anzahlSeiten = anzahlSeiten;
		double umkreisRadius = umkreisradius(anzahlSeiten, laenge);
		this.dreieck = new Dreieck(laenge, umkreisRadius, umkreisRadius);
	}

	@Override
	public double umfang() {
		return anzahlSeiten * dreieck.getSeite1();
	}

	@Override
	public double flaeche() {
		return anzahlSeiten * dreieck.flaeche();
	}
	
	public int getAnzahlSeiten() {
		return anzahlSeiten;
	}
	
	public double getLaenge() {
		return dreieck.getSeite1();
	}
	
	private static double umkreisradius(int anzahlSeiten, double laenge) {
		return laenge / (2 * Math.sin(Math.PI / anzahlSeiten));
	}

}
