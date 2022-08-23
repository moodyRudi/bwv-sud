package bwv.itf.sud.formen.figur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GleichseitigesDreieckTest {

	private static final int ANZAHL_SEITEN = 3;
	private static final double LAENGE_INITIAL = 4.;

	private GleichseitigesDreieck dreieck;

	@BeforeEach
	void setUp() throws Exception {
		dreieck = new GleichseitigesDreieck(LAENGE_INITIAL);
	}

	@Test
	@DisplayName("Konstruktor: Erzeugt ein Polygon mit 3 Seiten")
	void shouldGetOctagon() {
		double tatsAnzahlSeiten = dreieck.getAnzahlSeiten();
		
		assertEquals(ANZAHL_SEITEN, tatsAnzahlSeiten);
	}

}
