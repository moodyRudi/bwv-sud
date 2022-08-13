package bwv.itf.sud.firma.mitarbeiter;

import bwv.itf.sud.exceptions.InvalidInputException;

public abstract class Mitarbeiter implements Comparable<Mitarbeiter> {
	
	private static final String ERROR_ID = "Fehler beim Erstellen des Mitarbeiters: "
			+ "Die ID war nicht positiv oder nicht vierstellig.";
	
	private int id;
	private String name;
	
	protected Mitarbeiter(int id, String name) throws InvalidInputException {
		setID(id);
		this.name = name;
	}
	
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract double einkommen();
	
	@Override
	public String toString() {
		return String.format("(%d) %s: %.2f Euro", id, name, einkommen());
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof Mitarbeiter)) {
			return false;
		}
		var mitarbeiter = (Mitarbeiter) o;
		return this.id == mitarbeiter.id;
	}
	
	@Override
	public int compareTo(Mitarbeiter mitarbeiter) {
		return name.compareTo(mitarbeiter.getName());
	}
	
	protected void setID(int id) throws InvalidInputException {
		if (id < 1000 || 9999 < id) {
			throw new InvalidInputException(ERROR_ID);
		}
		this.id = id;
	}

}
