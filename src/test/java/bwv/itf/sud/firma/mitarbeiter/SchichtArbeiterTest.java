package bwv.itf.sud.firma.mitarbeiter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bwv.itf.sud.exceptions.InvalidInputException;

class SchichtArbeiterTest {
	
	private static final int ID_INITIAL = 3001;
	private static final int ID_ZU_TIEF = 2999;
	private static final int ID_ZU_HOCH = 4000;
	private static final String NAME_INITIAL = "Tom Bombadil";
	private static final double STUNDEN_SATZ_INITIAL = 20.;
	private static final double STUNDEN_SATZ_NEGATIV = -5.;
	private static final int ANZAHL_STUNDEN_INITIAL = 0;
	private static final int ANZAHL_STUNDEN_NEGATIV = -5;
	private static final int ANZAHL_STUNDEN_TESTWERT_1 = 7;
	private static final int ANZAHL_STUNDEN_TESTWERT_2 = 8;
	
	private SchichtArbeiter schichtArbeiter;

	@BeforeEach
	void setUp() throws Exception {
		schichtArbeiter = new SchichtArbeiter(ID_INITIAL, NAME_INITIAL, STUNDEN_SATZ_INITIAL);
	}

	@Test
	@DisplayName("Konstruktor: Funktioniert bei ID, die mit 3 beginnt")
	void shouldCreateSchichtArbeiter() {
		int tatsID = schichtArbeiter.getID();
		String tatsName = schichtArbeiter.getName();
		double tatsStundenSatz = schichtArbeiter.getStundenSatz();
		int tatsAnzahlStunden = schichtArbeiter.getAnzahlStunden();
		
		assertEquals(ID_INITIAL, tatsID);
		assertEquals(NAME_INITIAL, tatsName);
		assertEquals(STUNDEN_SATZ_INITIAL, tatsStundenSatz);
		assertEquals(ANZAHL_STUNDEN_INITIAL, tatsAnzahlStunden);
	}
	
	@Test
	@DisplayName("Konstruktor: Schlägt fehl, wenn die ID nicht mit 3 beginnt")
	void shouldNotCreateSchichtArbeiterWhenIdOutOfRange() {
		assertThrows(InvalidInputException.class, () -> new SchichtArbeiter(ID_ZU_TIEF, NAME_INITIAL, STUNDEN_SATZ_INITIAL));
		assertThrows(InvalidInputException.class, () -> new SchichtArbeiter(ID_ZU_HOCH, NAME_INITIAL, STUNDEN_SATZ_INITIAL));
	}
	
	@Test
	@DisplayName("Konstruktor: Schlägt fehl, wenn Stundensatz negativ ist")
	void shouldNotCreateSchichtArbeiterWhenStundenSatzNegative() {
		assertThrows(InvalidInputException.class, () -> new SchichtArbeiter(ID_INITIAL, NAME_INITIAL, STUNDEN_SATZ_NEGATIV));
	}
	
	@Test
	@DisplayName("arbeite: Addiert Stunden auf Anzahl Stunden")
	void shouldAddStunden() {
		schichtArbeiter.arbeite(ANZAHL_STUNDEN_TESTWERT_1);
		schichtArbeiter.arbeite(ANZAHL_STUNDEN_TESTWERT_2);
		int tatsAnzahlStunden = schichtArbeiter.getAnzahlStunden();
		
		assertEquals(ANZAHL_STUNDEN_TESTWERT_1 + ANZAHL_STUNDEN_TESTWERT_2, tatsAnzahlStunden);
	}
	
	@Test
	@DisplayName("arbeite: Addiert keine negative Stundenzahl")
	void shouldNotAddNegativeValues() {
		assertThrows(InvalidInputException.class, () -> schichtArbeiter.arbeite(ANZAHL_STUNDEN_NEGATIV));
	}
	
	@Test
	@DisplayName("einkommen: Berechnet das Einkommen korrekt")
	void shouldGetEinkommen() {
		schichtArbeiter.arbeite(ANZAHL_STUNDEN_TESTWERT_1);
		double erwEinkommen = STUNDEN_SATZ_INITIAL * ANZAHL_STUNDEN_TESTWERT_1;
		double tatsEinkommen = schichtArbeiter.einkommen();
		
		assertEquals(erwEinkommen, tatsEinkommen);
	}

}
