import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
	
	Giocatore g = new Giocatore();
	
	@Test
	public void testGetCfuDefault() {
		assertEquals(20, g.getCfu());
	}
	
	@Test
	public void testSetCfu() {
		g.setCfu(4);
		assertEquals(4, g.getCfu());
	}

	@Test
	public void testGetBorsaDefault() {
		assertNotNull(g.getBorsa());
	}
	
	@Test
	public void testSetCfuZero() {
		g.setCfu(0);
		assertEquals(0, g.getCfu());
	}

	@Test
	public void testSetCfuNegativo() {
		g.setCfu(-5);
		assertEquals(-5, g.getCfu());
	}
	
	@Test
	public void testBorsaNonNullDopoSetCfu() {
		g.setCfu(10);
		assertNotNull(g.getBorsa());
	}
	
	@Test
	public void testGetBorsaIdenticaPerIstanza() {
		assertSame(g.getBorsa(), g.getBorsa());
	}
}
