package bwv.itf.sud.firma.mitarbeiter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import bwv.itf.sud.exceptions.InvalidInputException;

@ExtendWith(MockitoExtension.class)
class AbteilungTest {

	private static final String NAME_INITIAL = "Bob";

	private @Mock Manager LEITER_INITIAL;
	private @Mock Manager LEITER_2;
	private @Mock Mitarbeiter MITARBEITER_INITIAL;
	private @Mock Mitarbeiter MITARBEITER_2;

	private Abteilung abteilung;

	@BeforeEach
	void setUp() throws Exception {
		abteilung = new Abteilung(NAME_INITIAL, LEITER_INITIAL);
	}

	@Test
	@DisplayName("Konstruktor: Erzeugt eine Abteilung")
	void shouldCreateAbteilung() {
		String tatsName = abteilung.getName();
		Mitarbeiter tatsLeiter = abteilung.getLeiter();

		assertEquals(NAME_INITIAL, tatsName);
		assertEquals(LEITER_INITIAL, tatsLeiter);
	}

	@Test
	@DisplayName("Konstruktor: Schlägt fehl, wenn Leiter null ist")
	void shouldNotCreateAbteilungWhenLeiterNull() {
		assertThrows(InvalidInputException.class, () -> new Abteilung(NAME_INITIAL, null));
	}

	@Test
	@DisplayName("add: Fügt neuen Mitarbeiter hinzu")
	void shouldAddMitarbeiter() {
		abteilung.add(MITARBEITER_INITIAL);
		abteilung.add(MITARBEITER_2);
		boolean mitarbeiterHinzugefuegt = abteilung.containsMitarbeiter(MITARBEITER_INITIAL)
				&& abteilung.containsMitarbeiter(MITARBEITER_2);

		assertTrue(mitarbeiterHinzugefuegt);
	}

	@Test
	@DisplayName("add: Fügt keinen null-Mitarbeiter hinzu")
	void shouldNotAddMitarbeiterWhenNull() {
		assertThrows(InvalidInputException.class, () -> abteilung.add(null));
	}

	@Test
	@DisplayName("add: Fügt keinen Mitarbeiter ein, der bereits in der Abteilung ist")
	void shouldNotAddMitarbeiterWhenAlreadyExists() {
		abteilung.add(MITARBEITER_INITIAL);

		assertThrows(InvalidInputException.class, () -> abteilung.add(MITARBEITER_INITIAL));
	}

	@Test
	@DisplayName("remove: Entfernt Mitarbeiter aus der Abteilung")
	void shouldRemoveMitarbeiter() {
		abteilung.add(MITARBEITER_INITIAL);
		abteilung.remove(MITARBEITER_INITIAL);
		boolean mitarbeiterEntfernt = abteilung.containsMitarbeiter(MITARBEITER_INITIAL);

		assertFalse(mitarbeiterEntfernt);
	}

	@Test
	@DisplayName("remove: Entfernt keinen null-Mitarbeiter")
	void shouldNotRemoveMitarbeiterWhenNull() {
		assertThrows(InvalidInputException.class, () -> abteilung.remove(null));
	}

	@Test
	@DisplayName("remove: Entfernt keinen Mitarbeiter, der nicht in der Liste ist")
	void shouldNotRemoveMitarbeiterWhenNotExists() {
		assertThrows(InvalidInputException.class, () -> abteilung.remove(MITARBEITER_INITIAL));
	}

	@Test
	@DisplayName("changeLeiter: Wechselt den Leiter")
	void shouldChangeLeiter() {
		Manager alterLeiter = abteilung.changeLeiter(LEITER_2);
		Manager tatsLeiter = abteilung.getLeiter();
		
		assertEquals(LEITER_INITIAL, alterLeiter);
		assertEquals(LEITER_2, tatsLeiter);
	}

	@Test
	@DisplayName("changeLeiter: Wechselt den Leiter nicht gegen null aus")
	void shouldNotChangeLeiterWhenNull() {
		assertThrows(InvalidInputException.class, () -> abteilung.changeLeiter(null));
	}

	@Test
	@DisplayName("changeLeiter: Wechselt nicht den Leiter gegen den gleichen")
	void shoulNotChangeLeiterWhenSame() {
		assertThrows(InvalidInputException.class, () -> abteilung.changeLeiter(LEITER_INITIAL));
	}

	@Test
	@DisplayName("gehaltsliste: Gibt einen gültigen String zurück")
	void shouldGetGehaltsliste() {
		abteilung.add(MITARBEITER_INITIAL);
		String gehaltsListe = abteilung.gehaltsliste();
		
		assertNotNull(gehaltsListe);
		assertFalse(gehaltsListe.isEmpty());
	}

}
