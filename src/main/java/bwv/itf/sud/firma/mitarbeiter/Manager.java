package bwv.itf.sud.firma.mitarbeiter;

import bwv.itf.sud.exceptions.InvalidInputException;

public class Manager extends BueroArbeiter {
	
	private static final String ERROR_BONUS = "Fehler beim Erstellen des Managers: "
			+ "Der Bonussatz war negativ.";
	private static final String ERROR_ID = "Fehler beim Erstellen des Managers: "
			+ "Die ID hat nicht mit 50 begonnen.";
	
	private static final String STARTZIFFER_MANAGER_ID = "50";
	
	private double bonusSatz;
	
	public Manager(int id, String name, double festgehalt, double bonusSatz) {
		super(id, name, festgehalt);
		if (bonusSatz < 0) {
			throw new InvalidInputException(ERROR_BONUS);
		}
		this.bonusSatz = bonusSatz;
	}
	
	@Override
	public double einkommen() {
		return super.einkommen() + berechneBonus();
	}
	
	public double berechneBonus() {
		return super.einkommen() * bonusSatz / 100.;
	}
	
	public double getBonusSatz() {
		return bonusSatz;
	}
	
	@Override
	protected void setID(int id) {
		if (!Integer.toString(id).startsWith(STARTZIFFER_MANAGER_ID)) {
			throw new InvalidInputException(ERROR_ID);
		}
		super.setID(id);
	}

}
