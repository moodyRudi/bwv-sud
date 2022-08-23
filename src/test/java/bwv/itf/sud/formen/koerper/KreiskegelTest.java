package bwv.itf.sud.formen.koerper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import bwv.itf.sud.exceptions.InvalidInputException;
import bwv.itf.sud.formen.figur.Kreis;

@ExtendWith(MockitoExtension.class)
class KreiskegelTest {
	
	private static final double HOEHE_INITIAL = 2.;
	private static final double HOEHE_NULL = 0.;
	private static final double HOEHE_NEGATIV = -2.;
	private static final double RADIUS_INITIAL = 3.;
	private static final double FLAECHE_INITIAL = Math.PI * RADIUS_INITIAL * RADIUS_INITIAL;
	
	private static final double MAX_ABWEICHUNG = .00001;
	
	private @Mock Kreis kreis;
	private Kreiskegel kegel;

	@BeforeEach
	void setUp() throws Exception {
		Mockito.when(kreis.flaeche()).thenReturn(FLAECHE_INITIAL);
		kegel = new Kreiskegel(kreis, HOEHE_INITIAL);
	}

	@Test
	@DisplayName("Konstruktor: Funktioniert")
	void shouldCreateKreiskegel() {
		assertEquals(kreis, kegel.getGrundflaeche());
		assertEquals(HOEHE_INITIAL, kegel.getHoehe());
	}

	@Test
	@DisplayName("Konstruktor: Schlägt fehl, wenn Grundfläche null ist")
	void shouldNotCreateKreiskegelWhenGrundflaecheNull() {
		assertThrows(NullPointerException.class, () -> new Kreiskegel(null, HOEHE_INITIAL));
	}

	@Test
	@DisplayName("Konstruktor: Schlägt fehl, wenn Höhe negativ ist")
	void shouldNotCreateKreiskegelWhenHoeheNegative() {
		assertThrows(InvalidInputException.class, () -> new Kreiskegel(kreis, HOEHE_NULL));
		assertThrows(InvalidInputException.class, () -> new Kreiskegel(kreis, HOEHE_NEGATIV));
	}

	@Test
	@DisplayName("oberflaeche: Gibt die korrekte Oberfläche zurück")
	void shouldGetOberflaeche() {
		Mockito.when(kreis.getRadius()).thenReturn(RADIUS_INITIAL);
		
		double seitenhoehe = Math.sqrt(RADIUS_INITIAL * RADIUS_INITIAL + HOEHE_INITIAL * HOEHE_INITIAL);
		double mantelflaeche = RADIUS_INITIAL * seitenhoehe * Math.PI;
		double erwOberflaeche = mantelflaeche + FLAECHE_INITIAL;
		double tatsOberflaeche = kegel.oberflaeche();
		
		assertEquals(erwOberflaeche, tatsOberflaeche, MAX_ABWEICHUNG);
	}

}
