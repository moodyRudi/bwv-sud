package bwv.itf.sud.firma.mitarbeiter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bwv.itf.sud.exceptions.InvalidInputException;

class MitarbeiterTest {
	
	private static final int ID_INITIAL = 5100;
	private static final int ID_NULL = 0000;
	private static final int ID_NEGATIV = -4000;
	private static final int ID_ZU_KLEIN = 999;
	private static final int ID_ZU_GROSS = 10_000;
	private static final String NAME_INITIAL = "Rooobert";
	
	private MitarbeiterTestKlasse mitarbeiter;

	@BeforeEach
	void setUp() throws Exception {
		mitarbeiter = new MitarbeiterTestKlasse(ID_INITIAL, NAME_INITIAL);
	}

	@Test
	@DisplayName("Konstruktor: Funktioniert bei positiver vierstelliger ID")
	void shouldCreateMitarbeiter() {
		int tatsID = mitarbeiter.getID();
		String tatsName = mitarbeiter.getName();
		
		assertEquals(ID_INITIAL, tatsID);
		assertEquals(NAME_INITIAL, tatsName);
	}
	
	@Test
	@DisplayName("Konstruktor: Schlägt fehl, wenn ID nicht positiv")
	void shouldNotCreateMitarbeiterWhenIdNegative() {
		assertThrows(InvalidInputException.class, () -> new MitarbeiterTestKlasse(ID_NULL, NAME_INITIAL));
		assertThrows(InvalidInputException.class, () -> new MitarbeiterTestKlasse(ID_NEGATIV, NAME_INITIAL));
	}
	
	@Test
	@DisplayName("Konstruktor: Schlägt fehl, wenn ID nicht vierstellig")
	void shouldNotCreateMitarbeiterWhenIdTooShortOrLong() {
		assertThrows(InvalidInputException.class, () -> new MitarbeiterTestKlasse(ID_ZU_KLEIN, NAME_INITIAL));
		assertThrows(InvalidInputException.class, () -> new MitarbeiterTestKlasse(ID_ZU_GROSS, NAME_INITIAL));
	}
	
	@Test
	@DisplayName("toString: Gibt einen gültigen String zurück")
	void shouldGetString() {
		String ausgabeMitarbeiter =  mitarbeiter.toString();
		
		assertNotNull(ausgabeMitarbeiter);
		assertFalse(ausgabeMitarbeiter.isEmpty());
	}
	
	private class MitarbeiterTestKlasse extends Mitarbeiter {
		
		public MitarbeiterTestKlasse(int id, String name) throws InvalidInputException {
			super(id, name);
		}
		
		@Override
		public double einkommen() {
			return 0.;
		}
		
	}

}
