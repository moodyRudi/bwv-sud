package bwv.itf.sud.formen.figur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AchteckTest {

	private static final int ANZAHL_SEITEN = 8;
	private static final double LAENGE_INITIAL = 4.;
	
	private Achteck achteck;

	@BeforeEach
	void setUp() throws Exception {
		achteck = new Achteck(LAENGE_INITIAL);
	}

	@Test
	@DisplayName("Konstruktor: Erzeugt ein Polygon mit 8 Seiten")
	void shouldGetOctagon() {
		double tatsAnzahlSeiten = achteck.getAnzahlSeiten();
		
		assertEquals(ANZAHL_SEITEN, tatsAnzahlSeiten);
	}

}
