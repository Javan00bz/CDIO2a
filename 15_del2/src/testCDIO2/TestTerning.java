package testCDIO2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CDIO2.Terning;

public class TestTerning {

	Terning ter1 = new Terning(6);
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTerning() {
		fail("Not yet implemented");
	}

	@Test
	public void testRulTerning() {
		int failures = 0;
		for (int i = 0; i < 10000; i++) {
			if (ter1.rulTerning() < 1 || ter1.rulTerning() > 6){
			failures++;
			}
		}
	}

	@Test
	public void testGetAntalØjne() {
		ter1.setAntalØjne(4);
		assertEquals(4, ter1.getAntalØjne());
	}

	@Test
	public void testSetAntalØjne() {
		ter1.setAntalØjne(6);
		assertEquals(6, ter1.getAntalØjne());
	}

}
