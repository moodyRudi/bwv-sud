package bwv.itf.sud.formen.figur;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SechseckTest {
	
	private static final int ANZAHL_SEITEN = 6;
	private static final double LAENGE_INITIAL = 4.;
	
	private Sechseck sechseck;

	@BeforeEach
	void setUp() throws Exception {
		sechseck = new Sechseck(LAENGE_INITIAL);
	}

	@Test
	@DisplayName("Konstruktor: Erzeugt ein Polygon mit 6 Seiten")
	void shouldGetHexagon() {
		double tatsAnzahlSeiten = sechseck.getAnzahlSeiten();
		
		assertEquals(ANZAHL_SEITEN, tatsAnzahlSeiten);
	}

}
