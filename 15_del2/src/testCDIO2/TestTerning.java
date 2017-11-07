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
	public void testRulTerning() {
		int failures = 0;
		for (int i = 0; i < 10000; i++) {
			if (ter1.rulTerning() < 1 || ter1.rulTerning() > 6){
			failures++;
			}
		assertEquals(0, failures);
			
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
	
	@Test
	public void TestRandomnessDice()
	{
		int amount6 = 0;
		System.out.println("");
		for(int o = 0 ; o<1000;o++) {
			int a1 = ter1.rulTerning();
			int actual = a1;
			if (actual == 6)
				amount6++;
		}
		System.out.println(amount6);
		assertTrue("Error, random is too high", 185 >= amount6);
		assertTrue("Error, random is too low",  148  <= amount6);
	}
	
		
	public void TestResponseTid() {
		long l = System.currentTimeMillis();
		System.out.println(System.currentTimeMillis());
		for(int o = 0 ; o<1000;o++) {
			int actual = ter1.rulTerning();
			}
		long k = System.currentTimeMillis();
		assertTrue(k-l<333000);
		System.out.println(k-l);
	}

}
