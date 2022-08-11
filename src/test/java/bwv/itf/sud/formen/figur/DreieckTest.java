package bwv.itf.sud.formen.figur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bwv.itf.sud.exceptions.InvalidInputException;

class DreieckTest {
	
	private static final double SEITE_1_INITIAL = 3.;
	private static final double SEITE_2_INITIAL = 4.;
	private static final double SEITE_3_INITIAL = 5.;
	private static final double SEITE_NULL = 0.;
	private static final double SEITE_NEGATIV = -2.;
	private static final double SEITE_ZU_KURZ = .1;
	private static final double SEITE_ZU_LANG = 20.;
	
	private Dreieck dreieck;

	@BeforeEach
	void setUp() throws Exception {
		dreieck = new Dreieck(SEITE_1_INITIAL, SEITE_2_INITIAL, SEITE_3_INITIAL);
	}

	@Test
	@DisplayName("Konstruktor: Funktioniert bei positiven Seiten")
	void shouldCreateDreieck() {
		double tatsSeite1 = dreieck.getSeite1();
		double tatsSeite2 = dreieck.getSeite2();
		double tatsSeite3 = dreieck.getSeite3();
		
		assertEquals(SEITE_1_INITIAL, tatsSeite1);
		assertEquals(SEITE_2_INITIAL, tatsSeite2);
		assertEquals(SEITE_3_INITIAL, tatsSeite3);
	}
	
	@Test
	@DisplayName("Konstruktor: Schlägt fehl bei Seitenlänge 0")
	void shouldNotCreateDreieckWhenZero() {
		assertThrows(InvalidInputException.class, () -> new Dreieck(SEITE_NULL, SEITE_2_INITIAL, SEITE_3_INITIAL));
		assertThrows(InvalidInputException.class, () -> new Dreieck(SEITE_1_INITIAL, SEITE_NULL, SEITE_3_INITIAL));
		assertThrows(InvalidInputException.class, () -> new Dreieck(SEITE_1_INITIAL, SEITE_2_INITIAL, SEITE_NULL));
	}
	
	@Test
	@DisplayName("Konstruktor: Schlägt fehl bei negativer Seitenlänge")
	void shouldNotCreateDreieckWhenNegative() {
		assertThrows(InvalidInputException.class, () -> new Dreieck(SEITE_NEGATIV, SEITE_2_INITIAL, SEITE_3_INITIAL));
		assertThrows(InvalidInputException.class, () -> new Dreieck(SEITE_1_INITIAL, SEITE_NEGATIV, SEITE_3_INITIAL));
		assertThrows(InvalidInputException.class, () -> new Dreieck(SEITE_1_INITIAL, SEITE_2_INITIAL, SEITE_NEGATIV));
	}
	
	@Test
	@DisplayName("Konstruktor: Schlägt fehl, wenn eine Seite zu kurz ist")
	void shouldNotCreateDreieckWhenTooShort() {
		assertThrows(InvalidInputException.class, () -> new Dreieck(SEITE_ZU_KURZ, SEITE_2_INITIAL, SEITE_3_INITIAL));
		assertThrows(InvalidInputException.class, () -> new Dreieck(SEITE_1_INITIAL, SEITE_ZU_KURZ, SEITE_3_INITIAL));
		assertThrows(InvalidInputException.class, () -> new Dreieck(SEITE_1_INITIAL, SEITE_2_INITIAL, SEITE_ZU_KURZ));
	}
	
	@Test
	@DisplayName("Konstruktor: Schlägt fehl, wenn eine Seite zu lang ist")
	void shouldNotCreateDreieckWhenTooLarge() {
		assertThrows(InvalidInputException.class, () -> new Dreieck(SEITE_ZU_LANG, SEITE_2_INITIAL, SEITE_3_INITIAL));
		assertThrows(InvalidInputException.class, () -> new Dreieck(SEITE_1_INITIAL, SEITE_ZU_LANG, SEITE_3_INITIAL));
		assertThrows(InvalidInputException.class, () -> new Dreieck(SEITE_1_INITIAL, SEITE_2_INITIAL, SEITE_ZU_LANG));
	}
	
	@Test
	@DisplayName("umfang: Gibt den korrekten Umfang zurück")
	void shouldGetUmfang() {
		double erwUmfang = SEITE_1_INITIAL + SEITE_2_INITIAL + SEITE_3_INITIAL;
		double tatsUmfang = dreieck.umfang();
		
		assertEquals(erwUmfang, tatsUmfang);
	}
	
	@Test
	@DisplayName("flaeche: Gibt die korrekte Fläche zurück")
	void shouldGetFlaeche() {
		double s = (SEITE_1_INITIAL + SEITE_2_INITIAL + SEITE_3_INITIAL) / 2;
		double erwFlaeche = Math.sqrt(s * (s - SEITE_1_INITIAL) * (s - SEITE_2_INITIAL) * (s - SEITE_3_INITIAL));
		double tatsFlaeche = dreieck.flaeche();
		
		assertEquals(erwFlaeche, tatsFlaeche);
	}

}
