package bwv.itf.sud.formen.koerper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bwv.itf.sud.exceptions.InvalidInputException;

class PyramidenArtigeTest {
	
	private static final double FLAECHE_INITIAL = 5.;
	private static final double HOEHE_INITIAL = 3.;
	private static final double INPUT_NULL = 0.;
	private static final double INPUT_NEGATIV = -2.;
	
	private PyramidenArtigeTestKlasse pyramide;

	@BeforeEach
	void setUp() throws Exception {
		pyramide = new PyramidenArtigeTestKlasse(FLAECHE_INITIAL, HOEHE_INITIAL);
	}

	@Test
	@DisplayName("Konstruktor: Funktioniert")
	void shouldCreatePyramidenArtige() {
		assertEquals(HOEHE_INITIAL, pyramide.getHoehe());
	}

	@Test
	@DisplayName("Konstruktor: Schlägt fehl, wenn Flächeninhalt negativ ist")
	void shouldNotCreatePyramidenArtigeWhenFlaecheNegative() {
		assertThrows(InvalidInputException.class, () -> new PyramidenArtigeTestKlasse(INPUT_NULL, HOEHE_INITIAL));
		assertThrows(InvalidInputException.class, () -> new PyramidenArtigeTestKlasse(INPUT_NEGATIV, HOEHE_INITIAL));
	}

	@Test
	@DisplayName("Konstruktor: Schlägt fehl, wenn Höhe negativ ist")
	void shouldNotCreatePyramidenArtigeWhenHoeheNegative() {
		assertThrows(InvalidInputException.class, () -> new PyramidenArtigeTestKlasse(FLAECHE_INITIAL, INPUT_NULL));
		assertThrows(InvalidInputException.class, () -> new PyramidenArtigeTestKlasse(FLAECHE_INITIAL, INPUT_NEGATIV));
	}

	@Test
	@DisplayName("volumen: Gibt das korrekte Volumen zurück")
	void shouldGetVolumen() {
		double erwVolumen = FLAECHE_INITIAL * HOEHE_INITIAL / 3;
		double tatsVolumen = pyramide.volumen();
		
		assertEquals(erwVolumen, tatsVolumen);
	}

	@Test
	@DisplayName("oberflaeche: Gibt die korrekte Oberfläche zurück")
	void shouldGetOberflaeche() {
		double erwOberflaeche = FLAECHE_INITIAL + pyramide.MANTELFLAECHE_INITIAL;
		double tatsOberflaeche = pyramide.oberflaeche();
		
		assertEquals(erwOberflaeche, tatsOberflaeche);
	}
	
	
	private class PyramidenArtigeTestKlasse extends PyramidenArtige {
		
		public final double MANTELFLAECHE_INITIAL = 10.;
		
		public PyramidenArtigeTestKlasse(double flaechenInhaltGrundflaeche, double hoehe) throws InvalidInputException {
			super(flaechenInhaltGrundflaeche, hoehe);
		}
		
		@Override
		protected double mantelflaeche() {
			return MANTELFLAECHE_INITIAL;
		}
		
	}

}
