package bwv.itf.sud.formen.figur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bwv.itf.sud.exceptions.InvalidInputException;

class KreisTest {
	
	private static final double RADIUS_INITIAL = 3.;
	private static final double RADIUS_NULL = 0.;
	private static final double RADIUS_NEGATIV = -2.;
	
	private Kreis kreis;

	@BeforeEach
	void setUp() throws Exception {
		kreis = new Kreis(RADIUS_INITIAL);
	}

	@Test
	@DisplayName("Konstruktor: Funktioniert bei positivem Radius")
	void shouldCreateKreis() {
		double tatsRadius = kreis.getRadius();
		
		assertEquals(RADIUS_INITIAL, tatsRadius);
	}
	
	@Test
	@DisplayName("Konstruktor: Schlägt fehl bei Radius 0")
	void shouldNotCreateKreisWhenZero() {
		assertThrows(InvalidInputException.class, () -> new Kreis(RADIUS_NULL));
	}
	
	@Test
	@DisplayName("Konstruktor: Schlägt fehl bei negativem Radius")
	void shouldNotCreateKreisWhenNegative() {
		assertThrows(InvalidInputException.class, () -> new Kreis(RADIUS_NEGATIV));
	}
	
	@Test
	@DisplayName("umfang: Gibt den korrekten Umfang zurück")
	void shouldGetUmfang() {
		double erwUmfang = 2 * Math.PI * RADIUS_INITIAL;
		double tatsUmfang = kreis.umfang();
		
		assertEquals(erwUmfang, tatsUmfang);
	}
	
	@Test
	@DisplayName("flaeche: Gibt die korrekte Fläche zurück")
	void shouldGetFlaeche() {
		double erwFlaeche = Math.PI * RADIUS_INITIAL * RADIUS_INITIAL;
		double tatsFlaeche = kreis.flaeche();
		
		assertEquals(erwFlaeche, tatsFlaeche);
	}

}
