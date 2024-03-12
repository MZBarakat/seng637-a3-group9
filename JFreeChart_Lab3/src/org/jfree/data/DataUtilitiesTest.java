package org.jfree.data;

import static org.junit.Assert.*;


import java.security.InvalidParameterException;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Tests for the DataUtilities class.
 */
public class DataUtilitiesTest {
	
    /* The delta of error */
    private static final double DEFAULT_DELTA = 0.000000001d;
    
    /* The default timeout of test in milliseconds */
    private static final int DEFAULT_TIMEOUT = 2000;
    
    /**
     *	Sets up once prior to testing
     */
    @BeforeClass public static void setUpBeforeClass() throws Exception {
      
    }
 
    /**
     *	Sets up before each test method
     */
    @Before
    public void setUp() throws Exception { 
    	
    }
    
    /**
     *	ID: SECT33
     *  This test covers a E1 & E2 & LB for input variable column in method and a valid mocked data in
     *  calculateColumnTotal(Values2D data, int column)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateColumnTotalShouldBeTweleve() {
    	
    	// setup & mock
        /*
         {1,2,3
		  4,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        mockingContext.checking(new Expectations() {{
            oneOf(values1).getRowCount();
            will(returnValue(3));
            oneOf(values1).getValue(0, 0);
            will(returnValue(1));
            oneOf(values1).getValue(1, 0);
            will(returnValue(4));
            oneOf(values1).getValue(2, 0);
            will(returnValue(7));
        }});
        
        // exercise
        double result = DataUtilities.calculateColumnTotal(values1, 0);

        // verify
        assertEquals("Column total for column 0 (1,4,7) should be 12",
        12.0, result, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT34
     *  This test covers a E1 & E2 & UB for input variable column in method and a valid mocked data in
     *  calculateColumnTotal(Values2D data, int column)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateColumnTotalShouldBeEighteen() {
    	
    	// setup & mock
        /*
         {1,2,3
		  4,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        mockingContext.checking(new Expectations() {{
            oneOf(values1).getRowCount();
            will(returnValue(3));
            oneOf(values1).getValue(0, 2);
            will(returnValue(3));
            oneOf(values1).getValue(1, 2);
            will(returnValue(6));
            oneOf(values1).getValue(2, 2);
            will(returnValue(9));
        }});
        
        // exercise
        double result = DataUtilities.calculateColumnTotal(values1, 2);

        // verify
        assertEquals("Column total for column 2 (3,6,9) should be 18",
        18.0, result, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT35
     *  This test covers a E1 & E2 & NOM for input variable column in method and a valid mocked data in
     *  calculateColumnTotal(Values2D data, int column)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateColumnTotalShouldBeFifteen() {
    	
    	// setup & mock
        /*
         {1,2,3
		  4,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        mockingContext.checking(new Expectations() {{
            oneOf(values1).getRowCount();
            will(returnValue(3));
            oneOf(values1).getValue(0, 1);
            will(returnValue(2));
            oneOf(values1).getValue(1, 1);
            will(returnValue(5));
            oneOf(values1).getValue(2, 1);
            will(returnValue(8));
        }});
        
        // exercise
        double result = DataUtilities.calculateColumnTotal(values1, 1);

        // verify
        assertEquals("Column total for column 1 (2,5,8) should be 15",
        15.0, result, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT36
     *  This test covers a U1 for input variable column in method and a valid mocked data in
     *  calculateColumnTotal(Values2D data, int column)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateColumnTotalShouldBeZeroForColumnNegativeOne() {
    	
    	// setup & mock
        /*
         {1,2,3
		  4,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        mockingContext.checking(new Expectations() {{
            oneOf(values1).getRowCount();
            will(returnValue(3));
            oneOf(values1).getValue(0, -1);
            will(returnValue(null));
            oneOf(values1).getValue(1, -1);
            will(returnValue(null));
            oneOf(values1).getValue(2, -1);
            will(returnValue(null));
        }});
        
        // exercise
        double result = DataUtilities.calculateColumnTotal(values1, -1);

        // verify
        assertEquals("Column total for column -1 () should be 0",
        0.0, result, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT37
     *  This test covers a U2 for input variable column in method and a valid mocked data in
     *  calculateColumnTotal(Values2D data, int column)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateColumnTotalShouldBeZeroForColumnThree() {
    	
    	// setup & mock
        /*
         {1,2,3
		  4,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        mockingContext.checking(new Expectations() {{
            oneOf(values1).getRowCount();
            will(returnValue(3));
            oneOf(values1).getValue(0, 3);
            will(returnValue(null));
            oneOf(values1).getValue(1, 3);
            will(returnValue(null));
            oneOf(values1).getValue(2, 3);
            will(returnValue(null));
        }});
        
        // exercise
        double result = DataUtilities.calculateColumnTotal(values1, 3);

        // verify
        assertEquals("Column total for column 3 () should be 0",
        0.0, result, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT38
     *  This test covers a U3 for input variable column in method and an invalid mocked data in
     *  calculateColumnTotal(Values2D data, int column)
     */
    @Test(timeout = DEFAULT_TIMEOUT, expected = InvalidParameterException.class)
    public void calculateColumnTotalShouldRaiseInvalidParameterException() {
        
        // exercise
        try {
        	//should throw error
			DataUtilities.calculateColumnTotal(null, 0);
			
			//if it reaches here fail as it didnt throw error
			fail( "Should have thrown InvalidParameterException" );
		} catch (Exception e) {
			//e.printStackTrace();
		}

    }
    
    /**
     *	ID: SECT39
     *  This test covers a E1 & E2 & LB for input variable row in method and a valid mocked data in
     *  calculateRowTotal(Values2D data, int row)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateRowTotalShouldBeSix() {
    	
    	// setup & mock
        /*
         {1,2,3
		  4,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        mockingContext.checking(new Expectations() {{
            oneOf(values1).getColumnCount();
            will(returnValue(3));
            oneOf(values1).getValue(0, 0);
            will(returnValue(1));
            oneOf(values1).getValue(0, 1);
            will(returnValue(2));
            oneOf(values1).getValue(0, 2);
            will(returnValue(3));
        }});
        
        // exercise
        double result = DataUtilities.calculateRowTotal(values1, 0);

        // verify
        assertEquals("Column total for row 0 (1,2,3) should be 6",
        6.0, result, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT40
     *  This test covers a E1 & E2 & UB for input variable row in method and a valid mocked data in
     *  calculateRowTotal(Values2D data, int row)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateRowTotalShouldBeTwentyFour() {
    	
    	// setup & mock
        /*
         {1,2,3
		  4,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        mockingContext.checking(new Expectations() {{
            oneOf(values1).getColumnCount();
            will(returnValue(3));
            oneOf(values1).getValue(2, 0);
            will(returnValue(7));
            oneOf(values1).getValue(2, 1);
            will(returnValue(8));
            oneOf(values1).getValue(2, 2);
            will(returnValue(9));
        }});
        
        // exercise
        double result = DataUtilities.calculateRowTotal(values1, 2);

        // verify
        assertEquals("Column total for row 2 (7,8,9) should be 24",
        24.0, result, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT41
     *  This test covers a E1 & E2 & NOM for input variable row in method and a valid mocked data in
     *  calculateRowTotal(Values2D data, int row)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateRowTotalShouldBeFifteen() {
    	
    	// setup & mock
        /*
         {1,2,3
		  4,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        mockingContext.checking(new Expectations() {{
            oneOf(values1).getColumnCount();
            will(returnValue(3));
            oneOf(values1).getValue(1, 0);
            will(returnValue(4));
            oneOf(values1).getValue(1, 1);
            will(returnValue(5));
            oneOf(values1).getValue(1, 2);
            will(returnValue(6));
        }});
        
        // exercise
        double result = DataUtilities.calculateRowTotal(values1, 1);

        // verify
        assertEquals("Column total for row 1 (4,5,6) should be 15",
        15.0, result, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT42
     *  This test covers a U1 for input variable row in method and a valid mocked data in
     *  calculateRowTotal(Values2D data, int row)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateRowTotalShouldBeZeroForRowNegativeOne() {
    	
    	// setup & mock
        /*
         {1,2,3
		  4,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        mockingContext.checking(new Expectations() {{
            oneOf(values1).getColumnCount();
            will(returnValue(3));
            oneOf(values1).getValue(-1, 0);
            will(returnValue(null));
            oneOf(values1).getValue(-1, 1);
            will(returnValue(null));
            oneOf(values1).getValue(-1, 2);
            will(returnValue(null));
        }});
        
        // exercise
        double result = DataUtilities.calculateRowTotal(values1, -1);

        // verify
        assertEquals("Column total for row -1 () should be 0",
        0.0, result, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT43
     *  This test covers a U2 for input variable row in method and a valid mocked data in
     *  calculateRowTotal(Values2D data, int row)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateRowTotalShouldBeZeroForRowThree() {
    	
    	// setup & mock
        /*
         {1,2,3
		  4,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        
        mockingContext.checking(new Expectations() {{
            oneOf(values1).getColumnCount();
            will(returnValue(3));
            oneOf(values1).getValue(3, 0);
            will(returnValue(null));
            oneOf(values1).getValue(3, 1);
            will(returnValue(null));
            oneOf(values1).getValue(3, 2);
            will(returnValue(null));
        }});
        
        // exercise
        double result = DataUtilities.calculateRowTotal(values1, 3);

        // verify
        assertEquals("Column total for row 3 () should be 0",
        0.0, result, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT44
     *  This test covers a U3 for input variable row in method and a invalid mocked data in
     *  calculateRowTotal(Values2D data, int row)
     */
    @Test(timeout = DEFAULT_TIMEOUT, expected = InvalidParameterException.class)
    public void calculateRowTotalShouldRaiseInvalidParameterException() {
        
        try {
        	//should throw error
			DataUtilities.calculateRowTotal(null, 0);
			
			//if it reaches here fail as it didnt throw error
			fail( "Should have thrown InvalidParameterException" );
		} catch (Exception e) {
			//e.printStackTrace();
		}

    }
    
    /**
     *	ID: SECT45
     *  This test covers E1 for input variable data in method createNumberArray(double[] data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void createNumberArrayShouldHaveLengthThree() {
    	
    	//Setup data
    	double[] exampleArray = new double[] {1,2,3};
    	 
    	// exercise 
    	Number[] result = DataUtilities.createNumberArray(exampleArray);
    	
    	// verify
        assertEquals("The length of Number[] from double[3] is 3",
        3.0, result.length, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT46
     *  This test covers E1 for input variable data in method createNumberArray(double[] data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void createNumberArrayShouldHaveValueTwoInFirstIndex() {
    	
    	//Setup data
    	double[] exampleArray = new double[] {1,2,3};
    	 
    	// exercise 
    	Number[] result = DataUtilities.createNumberArray(exampleArray);
    	
    	// verify
        assertEquals("The length of Number[] from exampleArray[1] is 2",
        2.0, result[1].doubleValue(), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT47
     *  This test covers E1 for input variable data in method createNumberArray(double[] data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void createNumberArrayShouldHaveLengthZero() {
    	
    	//Setup data
    	double[] exampleArray = new double[] {};
    	 
    	// exercise
    	Number[] result = DataUtilities.createNumberArray(exampleArray);
    	
    	// verify
        assertEquals("The length of Number[] from double[0] is 0",
        0.0, result.length, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT48
     *  This test covers U1 for input variable data in method createNumberArray(double[] data)
     */
    @Test(timeout = DEFAULT_TIMEOUT, expected = InvalidParameterException.class)
    public void createNumberArrayShouldRaiseInvalidParameterException() {
    	 
    	 
         try {
        	// should throw error
        	DataUtilities.createNumberArray(null);
        	
        	//if it reaches here fail as it didnt throw error
 			fail( "Should have thrown InvalidParameterException" );
 		} catch (Exception e) {
 			//e.printStackTrace();
 		}

    }
    
    /**
     *	ID: SECT49
     *  This test covers E1 for input variable data in method createNumberArray2D(double[][] data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void createNumberArray2DShouldHaveLengthTwoRows() {
    	
    	//Setup data
    	double[][] exampleArray = new double[2][];
    	exampleArray[0] = new double[] {1, 2, 3};
    	exampleArray[1] = new double[] {4, 5, 6};
    	 
    	// exercise
    	Number[][] result = DataUtilities.createNumberArray2D(exampleArray);
    	
    	// verify
        assertEquals("The length of Number[] from double[2][3] is 2",
        2.0, result.length, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT50
     *  This test covers E1 for input variable data in method createNumberArray2D(double[][] data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void createNumberArray2DShouldHaveLengthThreeColumns() {
    	
    	//Setup data
    	double[][] exampleArray = new double[2][];
    	exampleArray[0] = new double[] {1, 2, 3};
    	exampleArray[1] = new double[] {4, 5, 6};
    	
    	// exercise
    	Number[][] result = DataUtilities.createNumberArray2D(exampleArray);
    	
    	// verify
        assertEquals("The length of Number[] from double[2][3] is 3",
        3.0, result[0].length, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT51
     *  This test covers E1 for input variable data in method createNumberArray2D(double[][] data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void createNumberArray2DShouldHaveValueFive() {
    	
    	//Setup data
    	double[][] exampleArray = new double[2][];
    	exampleArray[0] = new double[] {1, 2, 3};
    	exampleArray[1] = new double[] {4, 5, 6};
    	 
    	// exercise  
    	Number[][] result = DataUtilities.createNumberArray2D(exampleArray);
    	
    	// verify
        assertEquals("The value of Number[] from exampleArray[1][1] is 5",
        5.0, result[1][1].doubleValue(), DEFAULT_DELTA);
    }
	
    /**
     *	ID: SECT52
     *  This test covers E1 for input variable data in method createNumberArray2D(double[][] data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void createNumberArray2DShouldHaveLengthZeroRows() {
    	
    	//Setup data
    	double[][] exampleArray = new double[][] {};

    	// exercise 
    	Number[][] result = DataUtilities.createNumberArray2D(exampleArray);
    	
    	// verify
        assertEquals("The length of Number[][] from double[0][0] is 0",
        0.0, result.length, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT53
     *  This test covers E1 for input variable data in method createNumberArray2D(double[][] data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void createNumberArray2DShouldHaveLengthZeroColumns() {
    	
    	//Setup data
    	double[][] exampleArray = new double[][] {};

    	// exercise  
    	Number[][] result = DataUtilities.createNumberArray2D(exampleArray);
    	
    	// verify
        assertEquals("The length of Number[][] from double[0][0] is 0",
        0.0, result.length, DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT54
     *  This test covers U1 for input variable data in method createNumberArray2D(double[][] data)
     */
    @Test(timeout = DEFAULT_TIMEOUT, expected = InvalidParameterException.class)
    public void createNumberArray2DShouldRaiseInvalidParameterException() {
    	 
         try {
        	// should throw error
        	DataUtilities.createNumberArray2D(null);
        	
        	//if it reaches here fail as it didnt throw error
 			fail( "Should have thrown InvalidParameterException" );
 		} catch (Exception e) {
 			//e.printStackTrace();
 		}

    }
    
    /**
     *	ID: SECT55
     *  This test covers a E1 input variable data which is a valid mocked data in
     *  getCumulativePercentages(KeyedValues data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void getCumulativePercentagesShouldHaveThreeKeys() {
    	
    	// setup & mock
        /*
      {0, 1
	   1, 5
	   2, 9
	   }
        */

    	//Setup data
        Mockery mockingContext = new Mockery();
        final KeyedValues keyedValues1 = mockingContext.mock(KeyedValues.class);
        
        
        mockingContext.checking(new Expectations() {{
        	atLeast(1).of(keyedValues1).getItemCount();
        	will(returnValue(3));
        	atLeast(1).of(keyedValues1).getValue(0);
        	will(returnValue(1));
        	atLeast(1).of(keyedValues1).getValue(1);
        	will(returnValue(5));
        	atLeast(1).of(keyedValues1).getValue(2);
        	will(returnValue(9));
        	atLeast(1).of(keyedValues1).getKey(0);
        	will(returnValue(0));
        	atLeast(1).of(keyedValues1).getKey(1);
        	will(returnValue(1));
        	atLeast(1).of(keyedValues1).getKey(2);
        	will(returnValue(2));
           
        }});
        
        // exercise
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues1);

        // verify
        assertEquals("The item count for this should have three keys",
        3, result.getKeys().size(), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT56
     *  This test covers a E1 input variable data which is a valid mocked data in
     *  getCumulativePercentages(KeyedValues data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void getCumulativePercentagesSameLengthShouldBeTrue() {
    	
    	// setup & mock
        /*
      {0, 1
	   1, 5
	   2, 9
	   }
        */

    	//Setup data
        Mockery mockingContext = new Mockery();
        final KeyedValues keyedValues1 = mockingContext.mock(KeyedValues.class);
        
        
        mockingContext.checking(new Expectations() {{
        	atLeast(1).of(keyedValues1).getItemCount();
        	will(returnValue(3));
        	atLeast(1).of(keyedValues1).getValue(0);
        	will(returnValue(1));
        	atLeast(1).of(keyedValues1).getValue(1);
        	will(returnValue(5));
        	atLeast(1).of(keyedValues1).getValue(2);
        	will(returnValue(9));
        	atLeast(1).of(keyedValues1).getKey(0);
        	will(returnValue(0));
        	atLeast(1).of(keyedValues1).getKey(1);
        	will(returnValue(1));
        	atLeast(1).of(keyedValues1).getKey(2);
        	will(returnValue(2));
           
        }});
        
        // exercise
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues1);
        Boolean checkLength = result.getItemCount() == 3; 
     
        // verify
        assertTrue("The item count for result should have three counts",
        		checkLength);
    }
    
    /**
     *	ID: SECT57
     *  This test covers a E1 input variable data which is a valid mocked data in
     *  getCumulativePercentages(KeyedValues data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void getCumulativePercentagesShouldHaveLastValueOne() {
    	
    	// setup & mock
        /*
      {0, 1
	   1, null
	   2, 9
	   }
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final KeyedValues keyedValues1 = mockingContext.mock(KeyedValues.class);
        
        mockingContext.checking(new Expectations() {{
        	atLeast(1).of(keyedValues1).getItemCount();
        	will(returnValue(3));
        	atLeast(1).of(keyedValues1).getValue(0);
        	will(returnValue(1));
        	atLeast(1).of(keyedValues1).getValue(1);
        	will(returnValue(5));
        	atLeast(1).of(keyedValues1).getValue(2);
        	will(returnValue(9));
        	atLeast(1).of(keyedValues1).getKey(0);
        	will(returnValue(0));
        	atLeast(1).of(keyedValues1).getKey(1);
        	will(returnValue(1));
        	atLeast(1).of(keyedValues1).getKey(2);
        	will(returnValue(2));
           
        }});
        
        // exercise
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues1);

        // verify
        assertEquals("The item count for this should have three keys",
        1.0, result.getValue(2).doubleValue(), DEFAULT_DELTA);
    }
    
	
    /**
     *	ID: SECT58
     *  This test covers a E1 input variable data which is a valid mocked data in
     *  getCumulativePercentages(KeyedValues data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void getCumulativePercentagesShouldHaveZeroKeys() {
    	
    	// setup & mock
        /*
      {
	   }
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final KeyedValues keyedValues1 = mockingContext.mock(KeyedValues.class);
        
        mockingContext.checking(new Expectations() {{
        	atLeast(1).of(keyedValues1).getItemCount();
            will(returnValue(0));
        }});
        
        // exercise
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues1);

        // verify
        assertEquals("The item count for this should have zero keys",
        0.0, result.getKeys().size(), DEFAULT_DELTA);
    }
	
    /**
     *	ID: SECT59
     *  This test covers a U1 input variable data which is a valid mocked data in
     *  getCumulativePercentages(KeyedValues data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void getCumulativePercentagesShouldRaiseInvalidParameterException() {
    	
    	// setup & mock
        /*
      {
	   }
        */
        
        try {
        	
        	// should throw error
			DataUtilities.getCumulativePercentages(null);
			
			//if it reaches here fail as it didnt throw error
			fail( "Should have thrown InvalidParameterException" );
		} catch (Exception e) {
			//e.printStackTrace();
		}
    }
    
    // ASSIGNMENT 3 Additions -------------------------------------------------------------   
    
    /**
     *  Assignment 3 additional coverage
     *	ID: A3SECT1
     *  This test will check output for -1 rows which increases instruction and branch coverage for
     *  calculateColumnTotal(Values2D data, int column). Expectation is an error for this test case. 
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateColumnTotalShouldHaveErrorForNegativeOneRows() {
    	
    	// setup & mock
        /*
         {3.5,2,3
		  null,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        mockingContext.checking(new Expectations() {
            {
                one(values1).getRowCount();
                will(returnValue(-1)); // negative number of rows
                one(values1).getValue(0, 0);
                will(returnValue(3.5));
                one(values1).getValue(1, 0);
                will(returnValue(null));
        
            }
        });
        

        
        double result = DataUtilities.calculateColumnTotal(values1, 0);
        fail("Fail should never reach here");
        assertEquals("The total value of the first column with negative number of rows is 0.0 ", 0.0, result, DEFAULT_DELTA);
    }

    /**
     *  Assignment 3 additional coverage
     *	ID: A3SECT2
     *  This test will check output for 0 rows which increases instruction and branch coverage for
     *  calculateColumnTotal(Values2D data, int column). 
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateColumnTotalShouldBeZeroForZeroRows() {
    	
    	// setup & mock
        /*
         {1,2,3
		  4,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        mockingContext.checking(new Expectations() {
            {
                one(values1).getRowCount();
                will(returnValue(0)); // negative number of rows
            }
        });
        

        // exercise
        double result = DataUtilities.calculateColumnTotal(values1, 0);
        
        // verify
        assertEquals("The total value of the first column with 0 number of rows is 0.0 ", 0.0, result, DEFAULT_DELTA);
    }
    
    
    /**
     *  Assignment 3 additional coverage
     *	ID: A3SECT3
     *  This test will check output for -1 columns which increases instruction and branch coverage for
     *  calculateRowTotal(Values2D data, int row). Expectation is an error for this test case. 
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateRowTotalShouldHaveErrorForNegativeOneColumns() {
    	
    	// setup & mock
        /*
         {1,2,3
		  4,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        mockingContext.checking(new Expectations() {
            {
                one(values1).getColumnCount();
                will(returnValue(-1)); // negative number of rows
                one(values1).getValue(0, 0);
                will(returnValue(3.5));
                one(values1).getValue(0, 1);
                will(returnValue(null));
        
            }
        });
        

        // exercise
        double result = DataUtilities.calculateRowTotal(values1, 0);
        fail("Fail should never reach here");
        
        //assert here is never reached but is there for when the infinite loop is fixed
        assertEquals("The total value of the first row with negative number of column is 0.0 ", 0.0, result, DEFAULT_DELTA);
    }

    /**
     *  Assignment 3 additional coverage
     *	ID: A3SECT4
     *  This test will check output for 0 columns which increases instruction and branch coverage for
     *  calculateRowTotal(Values2D data, int row). 
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateRowTotalShouldBeZeroForZeroColumns() {
    	
    	// setup & mock
        /*
         {1,2,3
		  4,5,6
		  7,8,9}:
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        
        mockingContext.checking(new Expectations() {
            {
                one(values1).getColumnCount();
                will(returnValue(0)); // negative number of rows
            }
        });
        

        // exercise
        double result = DataUtilities.calculateRowTotal(values1, 0);
        
      //assert here is never reached but is there for when the infinite loop is fixed
       assertEquals("The total value of the first row with 0 number of colunms is 0.0 ", 0.0, result, DEFAULT_DELTA);
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT5
     *  This test covers a negative item count value for 
     *  getCumulativePercentages(KeyedValues data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void getCumulativePercentagesShouldHaveErrorForNegativeCount() {
    	
    	// setup & mock
        /*
      {0, 1
	   1, 5
	   2, 9
	   }
        */

    	//Setup data
        Mockery mockingContext = new Mockery();
        final KeyedValues keyedValues1 = mockingContext.mock(KeyedValues.class);
        
        
        mockingContext.checking(new Expectations() {{
        	atLeast(1).of(keyedValues1).getItemCount();
        	will(returnValue(-1));
        	atLeast(1).of(keyedValues1).getValue(0);
        	will(returnValue(1));
        	atLeast(1).of(keyedValues1).getValue(1);
        	will(returnValue(null));
        	atLeast(1).of(keyedValues1).getKey(0);
        	will(returnValue(0));
        	atLeast(1).of(keyedValues1).getKey(1);
        	will(returnValue(1));
           
        }});
        
        // exercise
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues1);
        fail("Fail should never reach here");
        Boolean checkLength = result.getItemCount() == 3; 
     
        //assert here is never reached but is there for when the infinite loop is fixed
        assertTrue("The item count for result should have three counts",
        		checkLength);
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT6
     *   This test covers a null item inclusion in KeyedValues input for 
     *  getCumulativePercentages(KeyedValues data)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void getCumulativePercentagesSameLengthWithNullShouldBeTrue() {
    	
    	// setup & mock
        /*
      {0, 1
	   1, null -> changed
	   2, 9
	   }
        */

    	//Setup data
        Mockery mockingContext = new Mockery();
        final KeyedValues keyedValues1 = mockingContext.mock(KeyedValues.class);
        
        
        mockingContext.checking(new Expectations() {{
        	atLeast(1).of(keyedValues1).getItemCount();
        	will(returnValue(3));
        	atLeast(1).of(keyedValues1).getValue(0);
        	will(returnValue(1));
        	atLeast(1).of(keyedValues1).getValue(1);
        	will(returnValue(null)); //changed
        	atLeast(1).of(keyedValues1).getValue(2);
        	will(returnValue(9));
        	atLeast(1).of(keyedValues1).getKey(0);
        	will(returnValue(0));
        	atLeast(1).of(keyedValues1).getKey(1);
        	will(returnValue(1));
        	atLeast(1).of(keyedValues1).getKey(2);
        	will(returnValue(2));
           
        }});
        
        // exercise
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues1);
        Boolean checkLength = result.getItemCount() == 3; 
     
        // verify
        assertTrue("The item count for result should have three counts with a null item",
        		checkLength);
    }
    
    /**
     *  Assignment 3 additional coverage
     *	ID: A3SECT7
     *  This test will check output for a valid input data with selected validRows and a null value in
     *  calculateRowTotal(Values2D data, int column, int[] validCols). 
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateColumnTotalWithValidRowsShouldBeThreePointFive() {
    	
    	// setup & mock
        /*
         {3.5,2,3
		  -,5,6
		  null,8,9}
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        int[] validRows = new int[]{0,2,4};
        
        mockingContext.checking(new Expectations() {
            {
                one(values1).getRowCount();
                will(returnValue(3)); // negative number of rows
                one(values1).getValue(0, 0);
                will(returnValue(3.5));
                one(values1).getValue(2, 0);
                will(returnValue(null));
        
            }
        });
        

        // exercise
        double result = DataUtilities.calculateColumnTotal(values1, 0, validRows);
        
        // verify
        assertEquals("The total value of the first column with 1 valid number in rows is 3.5 ", 3.5, result, DEFAULT_DELTA);
    }
    
    /**
     *  Assignment 3 additional coverage
     *	ID: A3SECT8
     *  This test will check output for a valid input data with selected validCols and a null value in
     *  calculateRowTotal(Values2D data, int row, int[] validCols). 
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void calculateRowTotalWithValidColumnShouldBeThreePointFive() {
    	
    	// setup & mock
        /*
         {3.5,2,3
		  -,5,6
		  null,8,9}
        */
    	
    	//Setup data
        Mockery mockingContext = new Mockery();
        final Values2D values1 = mockingContext.mock(Values2D.class);
        int[] validCols = new int[]{0,2,4};
        
        mockingContext.checking(new Expectations() {
            {
                one(values1).getColumnCount();
                will(returnValue(3)); // negative number of rows
                one(values1).getValue(0, 0);
                will(returnValue(3.5));
                one(values1).getValue(0, 2);
                will(returnValue(null));
        
            }
        });
        

        double result = DataUtilities.calculateRowTotal(values1, 0, validCols);
        assertEquals("The total value of the first row with 1 valid number in column is 3.5 ", 3.5, result, DEFAULT_DELTA);
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT9
     *  This test covers two null arrays in equals(double[][] a, double[][] b)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void equalWithTwoNullsShouldBeTrue() {

    	// exercise 
    	boolean result = DataUtilities.equal(null, null);
    	
    	// verify
    	 assertTrue("Equals of two null arrays should be true",
    	result);
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT10
     *  This test covers first null array and one valid array in equals(double[][] a, double[][] b)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void equalWithFirstNullandSecondValidShouldBeFalse() {
    	
    	//Setup data
    	double[][] exampleArray = new double[2][];
    	exampleArray[0] = new double[] {1, 2, 3};
    	exampleArray[1] = new double[] {4, 5, 6};

    	 
    	// exercise 
    	boolean result = DataUtilities.equal(null, exampleArray);
    	
    	// verify
    	 assertFalse("Equal of first null array and second valid should be false",
    	result);
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT11
     *  This test covers first valid array and one valid array in equals(double[][] a, double[][] b)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void equalWithFirstValidandSecondNullShouldBeFalse() {
    	
    	//Setup data
    	double[][] exampleArray = new double[2][];
    	exampleArray[0] = new double[] {1, 2, 3};
    	exampleArray[1] = new double[] {4, 5, 6};

    	 
    	// exercise 
    	boolean result = DataUtilities.equal(exampleArray, null);
    	
    	// verify
    	 assertFalse("Equal of first valid array and second null should be false",
    	result);
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT12
     *  This test covers different valid arrays in equals(double[][] a, double[][] b)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void equalWithDifferentArraysShouldBeFalse() {
    	
    	//Setup data
    	double[][] exampleArray = new double[2][];
    	exampleArray[0] = new double[] {1, 2, 3};
    	exampleArray[1] = new double[] {4, 5, 6};

    	double[][] exampleArray2 = new double[2][];
    	exampleArray2[0] = new double[] {1, 3, 3};
    	exampleArray2[1] = new double[] {4, 5, 6};
    	// exercise 
    	boolean result = DataUtilities.equal(exampleArray, exampleArray2);
    	
    	// verify
    	assertFalse("Equal of two valid but different arrays be false",
    	result);
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT13
     *  This test covers two valid but different length arrays in equals(double[][] a, double[][] b)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void equalWithDifferentLengthArraysShouldBeFalse() {
    	
    	//Setup data
    	double[][] exampleArray = new double[2][];
    	exampleArray[0] = new double[] {1, 2, 3};
    	exampleArray[1] = new double[] {4, 5, 6};
    	
    	double[][] exampleArray2 = new double[1][];
    	exampleArray[0] = new double[] {1, 2, 3};

    	 
    	// exercise 
    	boolean result = DataUtilities.equal(exampleArray, exampleArray2);
    	
    	// verify
    	assertFalse("Equal of same arrays be true",
    	result);
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT14
     *  This test covers the same valid arrays in equals(double[][] a, double[][] b)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void equalofSameArrayShouldBeTrue() {
    	
    	//Setup data
    	double[][] exampleArray = new double[2][];
    	exampleArray[0] = new double[] {1, 2, 3};
    	exampleArray[1] = new double[] {4, 5, 6};
    	 
    	// exercise 
    	boolean result = DataUtilities.equal(exampleArray, exampleArray);
    	
    	// verify
    	assertTrue("Equal of same arrays be true",
    	result);
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT15
     *  This test covers the cloning of a valid array in clone(double[][] a)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void cloneOfArrayShouldBeSameLength() {
    	
    	//Setup data
    	double[][] exampleArray = new double[2][];
    	exampleArray[0] = new double[] {1, 2, 3};
    	 
    	// exercise 
    	double[][] result = DataUtilities.clone(exampleArray);
    	
    	// verify
    	 assertEquals("The length of the original and cloned array should be 2 ", 
    	2, result.length, DEFAULT_DELTA);
    }
    
	  /**
     *	Tear down after each test method
     */
    @After
    public void tearDown() throws Exception {
    	
    }

    /**
     *	Tear down once after all tests
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    	
    }
	
}
