package bwv.itf.sud.firma.mitarbeiter;

import bwv.itf.sud.exceptions.InvalidInputException;

public class SchichtArbeiter extends Mitarbeiter {
	
	private static final String ERROR_ID = "Fehler beim Erstellen des SchichtArbeiters: "
			+ "Die ID hat nicht mit 3 begonnen.";
	private static final String ERROR_STUNDEN_SATZ = "Fehler beim Erstellen des SchichtArbeiters: "
			+ "Der Stundensatz war negativ.";
	private static final String ERROR_ANZAHL_STUNDEN = "Fehler beim Hinzufügen von Arbeitsstunden: "
			+ "Der Anzahl Stunden war negativ.";
	
	private static final String STARTZIFFER_SCHICHTARBEITER_ID = "3";
	
	private double stundenSatz;
	private int anzahlStunden;
	
	public SchichtArbeiter(int id, String name, double stundenSatz) throws InvalidInputException {
		super(id, name);
		if (stundenSatz < 0) {
			throw new InvalidInputException(ERROR_STUNDEN_SATZ);
		}
		this.stundenSatz = stundenSatz;
	}

	@Override
	public double einkommen() {
		return stundenSatz * anzahlStunden;
	}
	
	public void arbeite(int anzahlStunden) {
		if (anzahlStunden < 0) {
			throw new InvalidInputException(ERROR_ANZAHL_STUNDEN);
		}
		setAnzahlStunden(this.anzahlStunden + anzahlStunden);
	}
	
	public double getStundenSatz() {
		return stundenSatz;
	}
	
	public int getAnzahlStunden() {
		return anzahlStunden;
	}
	
	@Override
	protected void setID(int id) throws InvalidInputException {
		if (!Integer.toString(id).startsWith(STARTZIFFER_SCHICHTARBEITER_ID)) {
			throw new InvalidInputException(ERROR_ID);
		}
		super.setID(id);
	}
	
	protected void setAnzahlStunden(int anzahlStunden) {
		this.anzahlStunden = anzahlStunden;
	}

}
