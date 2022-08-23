package bwv.itf.sud.formen.koerper;

import bwv.itf.sud.exceptions.InvalidInputException;
import bwv.itf.sud.formen.figur.Kreis;

public class Kreiskegel extends PyramidenArtige {

	private Kreis grundflaeche;

	public Kreiskegel(Kreis grundflaeche, double hoehe) throws InvalidInputException {
		super(grundflaeche.flaeche(), hoehe);
		this.grundflaeche = grundflaeche;
	}

	public Kreis getGrundflaeche() {
		return grundflaeche;
	}

	@Override
	protected double mantelflaeche() {
		double seitenHoehe = Math.sqrt(hoehe * hoehe + grundflaeche.getRadius() * grundflaeche.getRadius());
		return grundflaeche.getRadius() * seitenHoehe * Math.PI;
	}

}
