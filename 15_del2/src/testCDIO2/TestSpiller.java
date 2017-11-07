package testCDIO2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CDIO2.Konto;
import CDIO2.Spiller;

public class TestSpiller {
	Konto konto1 = new Konto(1000);
	Spiller spiller1= new Spiller("hej", 0, konto1);
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNavn() {
		spiller1.getNavn().equals("hej");
	}

	@Test
	public void testSetNavn() {
		spiller1.setNavn("test");
		spiller1.getNavn().equals("test");
		
	}

	@Test
	public void testGetPosition() {
		assertEquals(0, spiller1.getPosition());
	}

	@Test
	public void testSetPosition() {
		spiller1.setPosition(6);
		assertEquals(6, spiller1.getPosition());
	}

}
