package bwv.itf.sud.formen.koerper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bwv.itf.sud.exceptions.InvalidInputException;

class KugelTest {
	
	private static final double RADIUS_INITIAL = 2.5;
	private static final double RADIUS_NULL = 0.;
	private static final double RADIUS_NEGATIV = -2.;
	
	private Kugel kugel;

	@BeforeEach
	void setUp() throws Exception {
		kugel = new Kugel(RADIUS_INITIAL);
	}

	@Test
	@DisplayName("Konstruktor: Funktioniert bei Radius > 0")
	void shouldCreateKugel() {
		double radius = kugel.getRadius();
		
		assertEquals(RADIUS_INITIAL, radius);
	}

	@Test
	@DisplayName("Konstruktor: Schlägt fehl bei Radius <= 0")
	void shouldNotCreateKugelWhenRadiusNegative() {
		assertThrows(InvalidInputException.class, () -> new Kugel(RADIUS_NULL));
		assertThrows(InvalidInputException.class, () -> new Kugel(RADIUS_NEGATIV));
	}

	@Test
	@DisplayName("volumen: Gibt das korrekte Volumen zurück")
	void shouldGetVolumen() {
		double erwVolumen = 4. / 3 * Math.PI * RADIUS_INITIAL * RADIUS_INITIAL * RADIUS_INITIAL;
		double tatsVolumen = kugel.volumen();
		
		assertEquals(erwVolumen, tatsVolumen);
	}

	@Test
	@DisplayName("oberflaeche: Gibt die korrekte Oberfläche zurück")
	void shouldGetOberflaeche() {
		double erwOberflaeche = 4 * Math.PI * RADIUS_INITIAL * RADIUS_INITIAL;
		double tatsOberflaeche = kugel.oberflaeche();
		
		assertEquals(erwOberflaeche, tatsOberflaeche);
	}

}
