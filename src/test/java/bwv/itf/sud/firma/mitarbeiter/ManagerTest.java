package bwv.itf.sud.firma.mitarbeiter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bwv.itf.sud.exceptions.InvalidInputException;

class ManagerTest {
	
	private static final int ID_INITIAL = 5000;
	private static final int ID_ZU_TIEF = 4999;
	private static final int ID_ZU_HOCH = 5100;
	private static final String NAME_INITIAL = "John";
	private static final double FESTGEHALT_INITIAL = 3000.;
	private static final double FESTGEHALT_NEGATIV = -800;
	private static final double BONUSSATZ_INITIAL = 5.;
	private static final double BONUSSATZ_NEGATIV = -1.;
	
	private static final double MAX_ABWEICHUNG = .00001;
	
	private Manager manager;

	@BeforeEach
	void setUp() throws Exception {
		manager = new Manager(ID_INITIAL, NAME_INITIAL, FESTGEHALT_INITIAL, BONUSSATZ_INITIAL);
	}

	@Test
	@DisplayName("Konstruktor: Funktioniert bei ID, die mit 50 beginnt")
	void shouldCreateManager() {
		int tatsID = manager.getID();
		String tatsName = manager.getName();
		double tatsBonusSatz = manager.getBonusSatz();
		
		assertEquals(ID_INITIAL, tatsID);
		assertEquals(NAME_INITIAL, tatsName);
		assertEquals(BONUSSATZ_INITIAL, tatsBonusSatz);
	}
	
	@Test
	@DisplayName("Konstruktor: Schlägt fehl, wenn die ID nicht mit 50 beginnt")
	void shouldNotCreateManagerWhenIdOutOfRange() {
		assertThrows(InvalidInputException.class, () -> new Manager(ID_ZU_TIEF, NAME_INITIAL, FESTGEHALT_INITIAL, BONUSSATZ_INITIAL));
		assertThrows(InvalidInputException.class, () -> new Manager(ID_ZU_HOCH, NAME_INITIAL, FESTGEHALT_INITIAL, BONUSSATZ_INITIAL));
	}
	
	@Test
	@DisplayName("Konstruktor: Schlägt fehl, wenn Festgehalt negativ ist")
	void shouldNotCreateManagerWhenFestgehaltNegative() {
		assertThrows(InvalidInputException.class, () -> new Manager(ID_INITIAL, NAME_INITIAL, FESTGEHALT_NEGATIV, BONUSSATZ_INITIAL));
	}
	
	@Test
	@DisplayName("Konstruktor: Schlägt fehl, wenn Bonussatz negativ ist")
	void shouldNotCreateManagerWhenBonusSatzNegative() {
		assertThrows(InvalidInputException.class, () -> new Manager(ID_INITIAL, NAME_INITIAL, FESTGEHALT_INITIAL, BONUSSATZ_NEGATIV));
	}
	
	@Test
	@DisplayName("einkommen: Berechnet das Einkommen korrekt")
	void shouldGetEinkommen() {
		double erwEinkommen = FESTGEHALT_INITIAL * (1 + BONUSSATZ_INITIAL / 100);
		double tatsEinkommen = manager.einkommen();
		
		assertEquals(erwEinkommen, tatsEinkommen, MAX_ABWEICHUNG);
	}
	
	@Test
	@DisplayName("berechneBonus: Berechnet den korrekten Bonus")
	void shouldGetBonus() {
		double erwBonus = FESTGEHALT_INITIAL * BONUSSATZ_INITIAL / 100.;
		double tatsBonus = manager.berechneBonus();
		
		assertEquals(erwBonus, tatsBonus, MAX_ABWEICHUNG);
	}

}
