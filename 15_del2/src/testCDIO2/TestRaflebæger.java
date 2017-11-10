package testCDIO2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CDIO2.Raflebæger;
import CDIO2.Terning;

public class TestRaflebæger {
	Raflebæger cup = new Raflebæger(2);
	Terning ter1 = new Terning(6);
	Terning ter2 = new Terning(6);
	Terning ter3 = new Terning(6);
	

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSum() {
		int sum = 0;
		ter1.setAntalØjne(1);
		ter2.setAntalØjne(6);
		ter3.setAntalØjne(4);
		Terning[] dice = {ter1, ter2, ter3};
		cup.setTerninger(dice);
		for (int i = 0; i<3; i++)
			sum = sum + cup.getTerninger()[i].getAntalØjne();
		assertEquals(11, sum);
		
		cup.setTerninger(dice);
	}

}
