package bwv.itf.sud.firma.mitarbeiter;

import bwv.itf.sud.exceptions.InvalidInputException;

public class BueroArbeiter extends Mitarbeiter {

	private static final String ERROR_ID = "Fehler beim Erstellen des BüroArbeiters: "
			+ "Die ID hat nicht mit 5 begonnen.";
	private static final String ERROR_FESTGEHALT = "Fehler beim Erstellen des BüroArbeiters: "
			+ "Das Festgehalt war nicht positiv.";
	
	private static final String STARTZIFFER_BUEROARBEITER_ID = "5";
	
	private double festgehalt;

	protected BueroArbeiter(int id, String name, double festgehalt) throws InvalidInputException {
		super(id, name);
		if (festgehalt < 0) {
			throw new InvalidInputException(ERROR_FESTGEHALT);
		}
		this.festgehalt = festgehalt;
	}

	@Override
	public double einkommen() {
		return festgehalt;
	}
	
	@Override
	protected void setID(int id) {
		if (!Integer.toString(id).startsWith(STARTZIFFER_BUEROARBEITER_ID)) {
			throw new InvalidInputException(ERROR_ID);
		}
		super.setID(id);
	}

}
