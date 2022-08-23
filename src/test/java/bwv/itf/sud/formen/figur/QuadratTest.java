package bwv.itf.sud.formen.figur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuadratTest {
	
	private static final int ANZAHL_SEITEN = 4;
	private static final double LAENGE_INITIAL = 4.;

	private Quadrat quadrat;

	@BeforeEach
	void setUp() throws Exception {
		quadrat = new Quadrat(LAENGE_INITIAL);
	}

	@Test
	@DisplayName("Konstruktor: Erzeugt ein Polygon mit 4 Seiten")
	void shouldGetOctagon() {
		double tatsAnzahlSeiten = quadrat.getAnzahlSeiten();
		
		assertEquals(ANZAHL_SEITEN, tatsAnzahlSeiten);
	}

}
