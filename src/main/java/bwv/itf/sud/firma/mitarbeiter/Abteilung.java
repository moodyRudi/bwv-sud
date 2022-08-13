package bwv.itf.sud.firma.mitarbeiter;

import java.util.Set;
import java.util.TreeSet;

import bwv.itf.sud.exceptions.InvalidInputException;

public class Abteilung {
	
	private static final String ERROR_LEITER_NULL = "Fehler beim Erstellen der Abteilung: "
			+ "Der Leiter darf nicht null sein.";
	private static final String ERROR_ADD_MITARBEITER_NULL = "Fehler beim Hinzufügen des Mitarbeiters: "
			+ "Der Mitarbeiter darf nicht null sein.";
	private static final String ERROR_REMOVE_MITARBEITER_NULL = "Fehler beim Entfernen des Mitarbeiters: "
			+ "Der Mitarbeiter darf nicht null sein.";
	private static final String ERROR_MITARBEITER_EXISTIERT_BEREITS = "Fehler beim Hinzufügen des Mitarbeiters: "
			+ "Der Mitarbeiter ist bereits in der Abteilung.";
	private static final String ERROR_MITARBEITER_EXISTIERT_NICHT = "Fehler beim Entfernen des Mitarbeiters: "
			+ "Der Mitarbeiter existiert nicht in der Abteilung.";
	private static final String ERROR_CHANGE_LEITER_NULL = "Fehler beim Austauschen des Leiters: "
			+ "Der Leiter darf nicht null sein.";
	private static final String ERROR_CHANGE_LEITER_GLEICH = "Fehler beim Austauschen des Leiters: "
			+ "Der neue Leiter ist auch der alte Leiter.";
	
	private String name;
	private Set<Mitarbeiter> mitarbeiter;
	private Manager leiter;
	
	public Abteilung(String name, Manager leiter) throws InvalidInputException {
		if (leiter == null) {
			throw new InvalidInputException(ERROR_LEITER_NULL);
		}
		this.name = name;
		this.leiter = leiter;
		mitarbeiter = new TreeSet<>();
	}
	
	public void add(Mitarbeiter neuer) throws InvalidInputException {
		if (neuer == null) {
			throw new InvalidInputException(ERROR_ADD_MITARBEITER_NULL);
		}
		if (mitarbeiter.contains(neuer)) {
			throw new InvalidInputException(ERROR_MITARBEITER_EXISTIERT_BEREITS);
		}
		mitarbeiter.add(neuer);
	}
	
	public void remove(Mitarbeiter welcher) throws InvalidInputException {
		if (welcher == null) {
			throw new InvalidInputException(ERROR_REMOVE_MITARBEITER_NULL);
		}
		if (!mitarbeiter.contains(welcher)) {
			throw new InvalidInputException(ERROR_MITARBEITER_EXISTIERT_NICHT);
		}
		mitarbeiter.remove(welcher);
	}
	
	public Manager changeLeiter(Manager neuer) throws InvalidInputException {
		if (neuer == null) {
			throw new InvalidInputException(ERROR_CHANGE_LEITER_NULL);
		}
		if (leiter.equals(neuer)) {
			throw new InvalidInputException(ERROR_CHANGE_LEITER_GLEICH);
		}
		Manager alterLeiter = leiter;
		leiter = neuer;
		return alterLeiter;
	}
	
	public String gehaltsliste() {
		StringBuilder gehaltsListe = new StringBuilder();
		for (Mitarbeiter arbeiter : mitarbeiter) {
			gehaltsListe.append(arbeiter.toString() + "\n");
		}
		return gehaltsListe.toString();
	}
	
	public String getName() {
		return name;
	}
	
	public Manager getLeiter() {
		return leiter;
	}
	
	public boolean containsMitarbeiter(Mitarbeiter mitarbeiter) {
		return this.mitarbeiter.contains(mitarbeiter);
	}

}
