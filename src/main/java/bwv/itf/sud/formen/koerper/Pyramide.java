package bwv.itf.sud.formen.koerper;

import bwv.itf.sud.formen.figur.Polygon;

public class Pyramide extends PyramidenArtige {
	
	private Polygon grundflaeche;
	
	public Pyramide(Polygon grundflaeche, double hoehe) {
		super(grundflaeche.flaeche(), hoehe);
		this.grundflaeche = grundflaeche;
	}

	@Override
	protected double mantelflaeche() {
		return dreiecksFlaeche() * grundflaeche.getAnzahlSeiten();
	}
	
	private double dreiecksFlaeche() {
		return grundflaeche.getLaenge() * dreiecksHoehe() / 2;
	}
	
	private double dreiecksHoehe() {
		return Math.sqrt(kantenLaenge() * kantenLaenge()
				- grundflaeche.getLaenge() * grundflaeche.getLaenge() / 4);
	}
	
	private double kantenLaenge() {
		return Math.sqrt(hoehe * hoehe + grundflaeche.umkreisradius() * grundflaeche.umkreisradius());
	}

}
