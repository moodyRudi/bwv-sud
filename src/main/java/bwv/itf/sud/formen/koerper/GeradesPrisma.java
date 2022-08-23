package bwv.itf.sud.formen.koerper;

import bwv.itf.sud.exceptions.InvalidInputException;
import bwv.itf.sud.formen.figur.Figur;

public class GeradesPrisma<T extends Figur> implements Koerper {
	
	private static final String ERROR_GRUNDFLAECHE = "Fehler beim Erstellen des Prismas: Die Grundfläche war null.";
	private static final String ERROR_HOEHE = "Fehler beim Erstellen des Prismas: Die Höhe war <= 0.";
	
	private T grundflaeche;
	private double hoehe;
	
	public GeradesPrisma(T grundflaeche, double hoehe) throws InvalidInputException {
		if (grundflaeche == null) {
			throw new InvalidInputException(ERROR_GRUNDFLAECHE);
		}
		if (hoehe <= 0) {
			throw new InvalidInputException(ERROR_HOEHE);
		}
		this.grundflaeche = grundflaeche;
		this.hoehe = hoehe;
	}

	@Override
	public double volumen() {
		return grundflaeche.flaeche() * hoehe;

	}

	@Override
	public double oberflaeche() {
		return 2 * grundflaeche.flaeche() + mantelflaeche();
	}
	
	public T getGrundflaeche() {
		return grundflaeche;
	}
	
	public double getHoehe() {
		return hoehe;
	}
	
	private double mantelflaeche() {
		return grundflaeche.umfang() * hoehe;
	}

}
