package fr.istic.sTanguy.Meth.TP.Test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import fr.istic.sTanguy.Meth.TP.Interface.Observer;
import fr.istic.sTanguy.Meth.TP.Interface.Subject;
import fr.istic.sTanguy.Meth.TP.classe.EngineImplement;
import fr.istic.sTanguy.Meth.TP.classe.*;
import static org.mockito.Mockito.*;



@RunWith(MockitoJUnitRunner.class)
public class Test_EditeurText {


	private EngineImplement subject;
	private Observer obs1;

	@BeforeEach
	public void setUp() {
		//possibilité de faire MockitoAnnotations.initMocks(this);
		subject = new EngineImplement();
		obs1 = mock(Observer.class);

	}

	@Test
	@DisplayName("test sur connection")
	public void testconnection() {
		Observer obs2 = mock(Observer.class);
		subject.recordNewOberver(obs1);
		subject.recordNewOberver(obs2);
		assertTrue(subject.isRecord(obs1));
		assertTrue(subject.isRecord(obs2));
	}
	@Test
	@DisplayName("test ou l'observer est deja enregistrer")
	public void testDejaEnregistre() {
		subject.recordNewOberver(obs1);
		//permet de verifier avec une lambda expression 
		assertThrows(IllegalArgumentException.class, ()->subject.recordNewOberver(obs1));
	}


	@Test
	@DisplayName("test de deconnection")
	public void testDeconnection() {
		subject.recordNewOberver(obs1);
		subject.removeObserver(obs1);
		assertFalse(subject.isRecord(obs1));
	}
	@Test
	@DisplayName("Supprime un observer qui n'est pas enregister")
	public void testPasPresent() {
		subject.recordNewOberver(obs1);
		subject.removeObserver(obs1);
		assertThrows(IllegalArgumentException.class, ()->subject.removeObserver(obs1));
	}

	@Test
	@DisplayName("test de notification de observer")
	public void testNotification() {
		Observer obs2 = mock(Observer.class);

		subject.recordNewOberver(obs1); 
		subject.recordNewOberver(obs2);
		subject.notifyListObservers();
		verify(obs1).doUpdate(subject);
		verify(obs2).doUpdate(subject);

	}
}
