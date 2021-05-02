package comp3111.popnames;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class T2NamesTest {
	@Test 
    public void testT2NamesCompareToGreater() {
		T2Names a = new T2Names("Ben", 500, 23);
		T2Names b = new T2Names("Dave", 300, 25);
    	int i = a.compareTo(b);
		assertEquals(i, -1);
    }
	
	@Test 
    public void testT2NamesCompareToLess() {
		T2Names a = new T2Names("Ben", 300, 23);
		T2Names b = new T2Names("Dave", 500, 25);
    	int i = a.compareTo(b);
		assertEquals(i, 1);
    }
	
	@Test 
    public void testT2NamesCompareToEqualsAplha() {
		T2Names a = new T2Names("Ben", 500, 23);
		T2Names b = new T2Names("Dave", 500, 25);
    	int i = a.compareTo(b);
		assertEquals(i, -1);
    }
	
	@Test 
	public void testT2NamesCompareToEqualsAlphaSwap() {
		T2Names a = new T2Names("Dave", 500, 23);
		T2Names b = new T2Names("Ben", 500, 25);
    	int i = a.compareTo(b);
		assertEquals(i, 1);
    }
}
