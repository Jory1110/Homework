package Classes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSimple {

	@Test
	public void testConcatenate() {
		Simple s = new Simple();
		String result = s.concatonate("Tom", "Hanks");
		assertEquals(result,"TomHanks");
	}
	@Test
	public void testMultiply()
	{
		Simple s = new Simple();
		int result = s.multiply(3, 4);
		assertEquals(result,12);
	}
	
	@Test
	public void testBiggest()
	{
		Simple s = new Simple();
		boolean result = s.biggest(7, 8);
		assertEquals(result, false);
		
		boolean result2 = s.biggest(8, 7);
		assertEquals(result2, true);
	}

}
