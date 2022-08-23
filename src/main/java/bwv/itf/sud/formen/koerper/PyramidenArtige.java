package bwv.itf.sud.formen.koerper;

import bwv.itf.sud.exceptions.InvalidInputException;

public abstract class PyramidenArtige implements Koerper {
	
	private static final String ERROR_HOEHE = "Fehler beim Erstellen der pyramidenartigen Figur: Die Höhe war <= 0.";
	private static final String ERROR_GRUNDFLAECHE = "Fehler beim Erstellen der pyramidenartigen Figur: "
			+ "Der Inhalt der Grundfläche war <= 0.";
	
	protected double flaechenInhaltGrundflaeche;
	protected double hoehe;
	
	protected PyramidenArtige(double flaechenInhaltGrundflaeche, double hoehe) throws InvalidInputException {
		if (hoehe <= 0) {
			throw new InvalidInputException(ERROR_HOEHE);
		}
		if (flaechenInhaltGrundflaeche <= 0) {
			throw new InvalidInputException(ERROR_GRUNDFLAECHE);
		}
		this.flaechenInhaltGrundflaeche = flaechenInhaltGrundflaeche;
		this.hoehe = hoehe;
	}

	@Override
	public double volumen() {
		return flaechenInhaltGrundflaeche * hoehe / 3;
	}

	@Override
	public double oberflaeche() {
		return flaechenInhaltGrundflaeche + mantelflaeche();
	}
	
	public double getHoehe() {
		return hoehe;
	}
	
	protected abstract double mantelflaeche();

}
