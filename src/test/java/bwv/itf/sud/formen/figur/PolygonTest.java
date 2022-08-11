package bwv.itf.sud.formen.figur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bwv.itf.sud.exceptions.InvalidInputException;

class PolygonTest {
	
	private static final int ANZAHL_SEITEN_INITIAL = 5;
	private static final int ANZAHL_SEITEN_GERING = 2;
	private static final double LAENGE_INITIAL = 3.;
	private static final double LAENGE_NULL = 0.;
	private static final double LAENGE_NEGATIV = -2.;
	
	private static final double MAX_ABWEICHUNG = .00001;
	
	private PolygonTestKlasse polygon;

	@BeforeEach
	void setUp() throws Exception {
		polygon = new PolygonTestKlasse(ANZAHL_SEITEN_INITIAL, LAENGE_INITIAL);
	}

	@Test
	@DisplayName("Konstruktor: Funktioniert bei positiver Seitenlänge")
	void shouldCreatePolygon() {
		int tatsAnzahlSeiten = polygon.getAnzahlSeiten();
		double tatsLaenge = polygon.getLaenge();
		
		assertEquals(ANZAHL_SEITEN_INITIAL, tatsAnzahlSeiten);
		assertEquals(LAENGE_INITIAL, tatsLaenge);
	}
	
	@Test
	@DisplayName("Konstruktor: Schlägt fehl bei Seitenlänge 0")
	void shouldNotCreatePolygonWhenZero() {
		assertThrows(InvalidInputException.class, () -> new PolygonTestKlasse(ANZAHL_SEITEN_INITIAL, LAENGE_NULL));
	}
	
	@Test
	@DisplayName("Konstruktor: Schlägt fehl bei negativer Seitenlänge")
	void shouldNotCreatePolygonWhenNegative() {
		assertThrows(InvalidInputException.class, () -> new PolygonTestKlasse(ANZAHL_SEITEN_INITIAL, LAENGE_NEGATIV));
	}
	
	@Test
	@DisplayName("Konstruktor: Schlägt fehl bei weniger als 3 Seiten")
	void shouldNotCreatePolygonWhenTooFewVertices() {
		assertThrows(InvalidInputException.class, () -> new PolygonTestKlasse(ANZAHL_SEITEN_GERING, LAENGE_INITIAL));
	}
	
	@Test
	@DisplayName("umfang: Gibt den korrekten Umfang zurück")
	void shouldGetUmfang() {
		double erwUmfang = ANZAHL_SEITEN_INITIAL * LAENGE_INITIAL;
		double tatsUmfang = polygon.umfang();
		
		assertEquals(erwUmfang, tatsUmfang);
	}
	
	@Test
	@DisplayName("flaeche: Gibt die korrekte Flaeche zurück")
	void shouldGetFlaeche() {
		double inkreisRadius = LAENGE_INITIAL / (2 * Math.tan(Math.PI / ANZAHL_SEITEN_INITIAL));
		double flaecheDreieck = LAENGE_INITIAL * inkreisRadius / 2;
		double erwFlaeche = ANZAHL_SEITEN_INITIAL * flaecheDreieck;
		double tatsFlaeche = polygon.flaeche();
		
		assertEquals(erwFlaeche, tatsFlaeche, MAX_ABWEICHUNG);
	}
	
	private class PolygonTestKlasse extends Polygon {
		
		public PolygonTestKlasse(int anzahlSeiten, double laenge) {
			super(anzahlSeiten, laenge);
		}
		
	}

}
