package testCDIO2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CDIO2.Konto;

public class TestKonto {
	Konto konto1 = new Konto(1000);
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetVærdi() {
		assertEquals(1000, konto1.getVærdi());
	}

	@Test
	public void testSetVærdi() {
		konto1.setVærdi(10);
		assertEquals(10, konto1.getVærdi());
	}

	@Test
	public void testTilføjVærdi() {
		konto1.tilføjVærdi(20);
		assertEquals(1020, konto1.getVærdi());
	}

	@Test
	public void testHævVærdi() {
		konto1.hævVærdi(20);
		assertEquals(980, konto1.getVærdi());
	}
	
	@Test
	public void testKontoUnderNul() {
		konto1.hævVærdi(10000);
		assertEquals(0, konto1.getVærdi());
	}

}
