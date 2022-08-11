package bwv.itf.sud.formen.figur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bwv.itf.sud.exceptions.InvalidInputException;

class RechteckTest {
	
	private static final double LAENGE_INITIAL = 3.;
	private static final double LAENGE_NEGATIV = -2.;
	private static final double LAENGE_BREITE_NULL = 0.;
	private static final double BREITE_INITIAL = 4.;
	private static final double BREITE_NEGATIV = -1.;
	
	private Rechteck rechteck;

	@BeforeEach
	void setUp() throws Exception {
		rechteck = new Rechteck(LAENGE_INITIAL, BREITE_INITIAL);
	}

	@Test
	@DisplayName("Konstruktor: Funktioniert bei positiven Werten")
	void shouldCreateRechteck() {
		double tatsLaenge = rechteck.getLaenge();
		double tatsBreite = rechteck.getBreite();
		
		assertEquals(LAENGE_INITIAL, tatsLaenge);
		assertEquals(BREITE_INITIAL, tatsBreite);
	}
	
	@Test
	@DisplayName("Konstruktor: Schlägt fehl bei 0-Werten")
	void shouldNotCreateRechteckWhenZero() {
		assertThrows(InvalidInputException.class, () -> new Rechteck(LAENGE_BREITE_NULL, BREITE_INITIAL));
		assertThrows(InvalidInputException.class, () -> new Rechteck(LAENGE_INITIAL, LAENGE_BREITE_NULL));
	}
	
	@Test
	@DisplayName("Konstruktor: Schlägt fehl bei negativen Werten")
	void shouldNotCreateRechteckWhenNegative() {
		assertThrows(InvalidInputException.class, () -> new Rechteck(LAENGE_NEGATIV, BREITE_INITIAL));
		assertThrows(InvalidInputException.class, () -> new Rechteck(LAENGE_INITIAL, BREITE_NEGATIV));
	}
	
	@Test
	@DisplayName("umfang: Gibt den korrekten Umfang zurück")
	void shouldGetUmfang() {
		double erwUmfang = 2 * LAENGE_INITIAL + 2 * BREITE_INITIAL;
		double tatsUmfang = rechteck.umfang();
		
		assertEquals(erwUmfang, tatsUmfang);
	}
	
	@Test
	@DisplayName("flaeche: Gibt die korrekte Fläche zurück")
	void shouldGetFlaeche() {
		double erwFlaeche = LAENGE_INITIAL * BREITE_INITIAL;
		double tatsFlaeche = rechteck.flaeche();
		
		assertEquals(erwFlaeche, tatsFlaeche);
	}

}
