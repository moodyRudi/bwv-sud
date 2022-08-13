package bwv.itf.sud.firma.mitarbeiter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bwv.itf.sud.exceptions.InvalidInputException;

class BueroArbeiterTest {
	
	private static final int ID_INITIAL = 5001;
	private static final int ID_ZU_TIEF = 4999;
	private static final int ID_ZU_HOCH = 6000;
	private static final String NAME_INITIAL = "Tom Bombadil";
	private static final int FESTGEHALT_INITIAL = 2000;
	private static final int FESTGEHALT_NEGATIV = -500;
	
	private BueroArbeiter bueroArbeiter;

	@BeforeEach
	void setUp() throws Exception {
		bueroArbeiter = new BueroArbeiter(ID_INITIAL, NAME_INITIAL, FESTGEHALT_INITIAL);
	}

	@Test
	@DisplayName("Konstruktor: Funktioniert bei ID, die mit 5 beginnt")
	void shouldCreateBueroArbeiter() {
		int tatsID = bueroArbeiter.getID();
		String tatsName = bueroArbeiter.getName();
		
		assertEquals(ID_INITIAL, tatsID);
		assertEquals(NAME_INITIAL, tatsName);
	}
	
	@Test
	@DisplayName("Konstruktor: Schlägt fehl, wenn die ID nicht mit 5 beginnt")
	void shouldNotCreateBueroArbeiterWhenIdOutOfRange() {
		assertThrows(InvalidInputException.class, () -> new BueroArbeiter(ID_ZU_TIEF, NAME_INITIAL, FESTGEHALT_INITIAL));
		assertThrows(InvalidInputException.class, () -> new BueroArbeiter(ID_ZU_HOCH, NAME_INITIAL, FESTGEHALT_INITIAL));
	}
	
	@Test
	@DisplayName("Konstruktor: Schlägt fehl, wenn Festgehalt negativ ist")
	void shouldNotCreateBueroArbeiterWhenFestgehaltNegative() {
		assertThrows(InvalidInputException.class, () -> new BueroArbeiter(ID_INITIAL, NAME_INITIAL, FESTGEHALT_NEGATIV));
	}
	
	@Test
	@DisplayName("einkommen: Berechnet das Einkommen korrekt")
	void shouldGetEinkommen() {
		double tatsEinkommen = bueroArbeiter.einkommen();
		
		assertEquals(FESTGEHALT_INITIAL, tatsEinkommen);
	}

}
