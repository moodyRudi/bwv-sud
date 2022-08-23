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
import bwv.itf.sud.formen.figur.Figur;

@ExtendWith(MockitoExtension.class)
class GeradesPrismaTest {
	
	private static final double HOEHE_INITIAL = 3.;
	private static final double HOEHE_NULL = 0.;
	private static final double HOEHE_NEGATIV = -3.;
	private static final double FLAECHE_FIGUR = 4.;
	private static final double UMFANG_FIGUR = 2.5;
	
	private @Mock Figur figur;
	private GeradesPrisma<Figur> prisma;

	@BeforeEach
	void setUp() throws Exception {
		prisma = new GeradesPrisma<>(figur, HOEHE_INITIAL);
	}

	@Test
	@DisplayName("Konstruktor: Funktioniert")
	void shouldCreatePrisma() {
		assertEquals(figur, prisma.getGrundflaeche());
		assertEquals(HOEHE_INITIAL, prisma.getHoehe());
	}

	@Test
	@DisplayName("Konstruktor: Schlägt fehl, wenn Grundfläche null ist")
	void shouldNotCreatePrismaWhenGrundflaecheNull() {
		assertThrows(InvalidInputException.class, () -> new GeradesPrisma<>(null, HOEHE_INITIAL));
	}

	@Test
	@DisplayName("Konstruktor: Schlägt fehl, wenn Höhe negativ ist")
	void shouldNotCreatePrismaWhenHoeheNegative() {
		assertThrows(InvalidInputException.class, () -> new GeradesPrisma<>(figur, HOEHE_NULL));
		assertThrows(InvalidInputException.class, () -> new GeradesPrisma<>(figur, HOEHE_NEGATIV));
	}

	@Test
	@DisplayName("volumen: Gibt das korrekte Volumen zurück")
	void shouldGetVolumen() {
		Mockito.when(figur.flaeche()).thenReturn(FLAECHE_FIGUR);
		
		double erwVolumen = FLAECHE_FIGUR * HOEHE_INITIAL;
		double tatsVolumen = prisma.volumen();
		
		assertEquals(erwVolumen, tatsVolumen);
	}

	@Test
	@DisplayName("oberflaeche: Gibt die korrekte Oberfläche zurück")
	void shouldGetOberflaeche() {
		Mockito.when(figur.flaeche()).thenReturn(FLAECHE_FIGUR);
		Mockito.when(figur.umfang()).thenReturn(UMFANG_FIGUR);
		
		double erwOberflaeche = 2 * FLAECHE_FIGUR + UMFANG_FIGUR * HOEHE_INITIAL;
		double tatsOberflaeche = prisma.oberflaeche();
		
		assertEquals(erwOberflaeche, tatsOberflaeche);
	}

}
