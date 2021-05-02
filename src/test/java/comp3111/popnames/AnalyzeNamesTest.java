package comp3111.popnames;

import org.junit.Test;
import static org.junit.Assert.*;

public class AnalyzeNamesTest {
	
    @Test 
    public void testGetRankNotFound() {
    	AnalyzeNames a = new AnalyzeNames();
    	int i = a.getRank(2019, "XXX", "M");
		assertEquals(i, -1);
    }
    
    @Test 
    public void testGetRankMale() {
    	AnalyzeNames a = new AnalyzeNames();
    	int i = a.getRank(2019, "David", "M");
    	assertTrue(i==27);
    }
    
    @Test 
    public void testGetRankFemale() {
    	AnalyzeNames a = new AnalyzeNames();
    	int i = a.getRank(2019, "Desire", "F");
    	assertTrue(i==2192);
    }
    	
    @Test 
    public void testGetNameMale() {
    	AnalyzeNames a = new AnalyzeNames();
    	String name = a.getName(2019, 27, "M");
    	assertTrue(name.equals("David"));
    }
    
    @Test 
    public void testGetNameFemale() {
    	AnalyzeNames a = new AnalyzeNames();
    	String name = a.getName(2019, 2192, "F");
    	assertTrue(name.equals("Desire"));
    }
    
    @Test 
    public void testGetNameNotFound() {
    	AnalyzeNames a = new AnalyzeNames();
    	String name = a.getName(2010, 500000, "F");
    	assertTrue(name.equals("information on the name at the specified rank is not available"));
    }
    
    @Test 
    public void testGetOccuranceNotFound() {
    	AnalyzeNames a = new AnalyzeNames();
    	int i = a.getOccurance(2019, "XXX", "M");
		assertEquals(i, -1);
    }
    
    @Test 
    public void testGetOccuranceMale() {
    	AnalyzeNames a = new AnalyzeNames();
    	int i = a.getOccurance(2007, "Jacob", "M");
		assertEquals(i, 24252);
    }
    
    @Test 
    public void testGetOccuranceFemale() {
    	AnalyzeNames a = new AnalyzeNames();
    	int i = a.getOccurance(2007, "Emily", "F");
		assertEquals(i, 19345);
    }

    
    @Test 
    public void testgetKthPopularNamesF() {
    	AnalyzeNames a = new AnalyzeNames();
    	T2Names [] result = null;
    	result = a.getKthPopularNames(2000, 2010, 8, "F");
		assertTrue(result[0].getName().equals("Abigail"));
    }
    
    @Test 
    public void testgetKthPopularNamesM() {
    	AnalyzeNames a = new AnalyzeNames();
    	T2Names [] result = null;
    	result = a.getKthPopularNames(2000, 2010, 8, "M");
		assertTrue(result[0].getName().equals("Joseph"));
    }
    

}
