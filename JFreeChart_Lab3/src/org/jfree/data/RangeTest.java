package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range; import org.junit.*;

/**
 * Tests for the Range class.
 */
public class RangeTest {
	
	/* An example range used in most test methods*/
    private static Range exampleRange1;
    
    /* The delta of error */
    private static final double DEFAULT_DELTA = 0.000000001d;
    
    /* The default timeout of test in milliseconds */
    private static final int DEFAULT_TIMEOUT = 2000;
    
    /**
     *	Sets up once prior to testing
     */
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    	//this range is the common test range for most tests
    	exampleRange1 = new Range(3.0, 7.0);
    }

    /**
     *	Sets up before each test method
     */
    @Before
    public void setUp() throws Exception { 
    
    }
    
    /**
     *	ID: SECT1
     *  This test covers a NOM value for input variable value in method constrain(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void constrainValueOfFiveShouldBeFive() {
    	//Verify expectations
        assertEquals("The constrain value 5 in range 3 and 7 should be 5",
        5.0, exampleRange1.constrain(5.0), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT2
     *  This test covers a E1 & LB value for input variable value in method constrain(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void constrainValueOfThreeShouldBeThree() {
    	//Verify expectations
        assertEquals("The constrain value 3 in range 3 and 7 should be 3",
        3.0, exampleRange1.constrain(3.0), DEFAULT_DELTA);
    }

    /**
     *	ID: SECT3
     *  This test covers a E1 & UB value for input variable value in method constrain(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void constrainValueOfSevenShouldBeSeven() {
    	//Verify expectations
        assertEquals("The constrain value 7 in range 3 and 7 should be 7",
        7.0, exampleRange1.constrain(7.0), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT4
     *  This test covers a E1 & BLB value for input variable value in method constrain(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void constrainValueOfTwoShouldBeThree() {
    	//Verify expectations
        assertEquals("The constrain value 2 in range 3 and 7 should be 3",
        3.0, exampleRange1.constrain(2.0), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT5
     *  This test covers a E1 & AUB value for input variable value in method constrain(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void constrainValueOfEightShouldBeSeven() {
    	//Verify expectations
        assertEquals("The constrain value 8 in range 3 and 7 should be 7",
        7.0, exampleRange1.constrain(8.0), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT6
     *  This test covers a E2 & BLB value for input variable value in method constrain(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void constrainValueOfDoubleMinValueShouldBeThree() {
    	//Verify expectations
        assertEquals("The constrain value Double.MIN_VALUE in range 3 and 7 should be 3",
        3.0, exampleRange1.constrain(Double.MIN_VALUE), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT7
     *  This test covers a E3 & AUB value for input variable value in method constrain(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void constrainValueOfDoubleMaxValueShouldBeSeven() {
    	//Verify expectations
        assertEquals("The constrain value Double.MAX_VALUE in range 3 and 7 should be 7",
        7.0, exampleRange1.constrain(Double.MAX_VALUE), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT8
     *  This test covers a U1 value for input variable value in method constrain(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void constrainValueOfDoubleNanShouldBeDoubleNan() {
    	
    	//Setup data
    	double result = exampleRange1.constrain(Double.NaN);
    	
    	//Verify expectations
        assertTrue("The constrain value Double.NaN in range 3 and 7 should be NaN",
        Double.isNaN(result));
    }
    
    /**
     *	ID: SECT9
     *  This test covers a E1 & Nom value for input variable value in method contains(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void containsValueOfFiveShouldBeTrue() {
    	
    	//Setup data
    	boolean result = exampleRange1.contains(5.0);
    	
    	//Verify expectations
        assertTrue("Contains value 5 in range 3 and 7 should be true",
        result);
    }
    
    /**
     *	ID: SECT10
     *  This test covers a E1 & LB value for input variable value in method contains(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void containsValueOfThreeShouldBeTrue() {
    	
    	//Setup data
    	boolean result = exampleRange1.contains(3.0);
    	
    	//Verify expectations
        assertTrue("Contains value 3 in range 3 and 7 should be true",
        result);
    }
    
    /**
     *	ID: SECT11
     *  This test covers a E1 & UB value for input variable value in method contains(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void containsValueOfSevenShouldBeTrue() {
    	
    	//Setup data
    	boolean result = exampleRange1.contains(7.0);
    	
    	//Verify expectations
        assertTrue("Contains value 3 in range 3 and 7 should be true",
        result);
    }
    
    /**
     *	ID: SECT12
     *  This test covers a E2 & BLB value for input variable value in method contains(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void containsValueOfTwoShouldBeFalse() {
    	
    	//Setup data
    	boolean result = exampleRange1.contains(2.0);
    	
    	//Verify expectations
        assertFalse("Contains value 2 in range 3 and 7 should be false",
        result);
    }
    
    /**
     *	ID: SECT13
     *  This test covers a E2 & AUB value for input variable value in method contains(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void containsValueOfEightShouldBeFalse() {
    	
    	//Setup data
    	boolean result = exampleRange1.contains(8.0);
    	
    	//Verify expectations
        assertFalse("Contains value 8 in range 3 and 7 should be false",
        result);
    }
    
    /**
     *	ID: SECT14
     *  This test covers a E2 & BLB value for input variable value in method contains(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void containsValueOfDoubleMinValueShouldBeFalse() {
    	
    	//Setup data
    	boolean result = exampleRange1.contains(Double.MIN_VALUE);
    	
    	//Verify expectations
        assertFalse("Contains value Double.MIN_VALUE in range 3 and 7 should be false",
        result);
    }
    
    /**
     *	ID: SECT15
     *  This test covers a E2 & AUB value for input variable value in method contains(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void containsValueOfDoubleMaxValueShouldBeFalse() {
    	
    	//Setup data
    	boolean result = exampleRange1.contains(Double.MAX_VALUE);
    	
    	//Verify expectations
        assertFalse("Contains value Double.MAX_VALUE in range 3 and 7 should be false",
        result);
    }
    
    /**
     *	ID: SECT16
     *  This test covers a U1 value for input variable value in method contains(double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void containsValueOfDoubleNanShouldBeFalse() {
    	
    	//Setup data
    	boolean result = exampleRange1.contains(Double.NaN);
    	
    	//Verify expectations
        assertFalse("Contains value Double.Nan in range 3 and 7 should be false",
        result);
    }
    
    /**
     *	ID: SECT17
     *  This test covers a E1 value for input variable obj in method equals(java.lang.Object obj)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void equalsSameRangeShouldBeTrue() {
    	
    	//Setup data
    	Range anotherRange = new Range(3,7);
    	boolean result = exampleRange1.equals(anotherRange);
    	
    	//Verify expectations
        assertTrue("Range(3,7) and Range(3,7) should be true",
        result);
    }
    
    /**
     *	ID: SECT18
     *  This test covers a E2 value for input variable obj in method equals(java.lang.Object obj)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void equalsDifferentUpperValuesShouldBeFalse() {
    	
    	//Setup data
    	Range anotherRange = new Range(3,10);
    	boolean result = exampleRange1.equals(anotherRange);
    	
    	//Verify expectations
        assertFalse("Range(3,7) and Range(3,10) should be equal (false)",
        result);
    }
    
    /**
     *	ID: SECT19
     *  This test covers a E2 value for input variable obj in method equals(java.lang.Object obj)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void equalsDifferentLowerValuesShouldBeFalse() {
    	
    	//Setup data
    	Range anotherRange = new Range(4,7);
    	boolean result = exampleRange1.equals(anotherRange);
    	
    	//Verify expectations
        assertFalse("Range(3,7) and Range(4,7) should not be equal (false)",
        result);
    }
    
    /**
     *	ID: SECT20
     *  This test covers a E2 value for input variable obj in method equals(java.lang.Object obj)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void equalsDifferentLowerAndUpperValuesShouldBeFalse() {
    	
    	//Setup data
    	Range anotherRange = new Range(1,10);
    	boolean result = exampleRange1.equals(anotherRange);
    	
    	//Verify expectations
        assertFalse("Range(3,7) and Range(1,10) should not be equal (false)",
        result);
    }
    
    /**
     *	ID: SECT21
     *  This test covers a E3 value for input variable obj in method equals(java.lang.Object obj)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void equalsDifferentObjectShouldBeFalse() {
    	
    	//Setup data
    	double another = 1.0;
    	boolean result = exampleRange1.equals(another);
    	
    	//Verify expectations
        assertFalse("Range(3,7) and a double should not be equal (false)",
        result);
    }
    
    /**
     *	ID: SECT22
     *  This test covers a E3 value for input variable obj in method equals(java.lang.Object obj)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void equalsNullRangeShouldBeFalse() {
    	
    	//Setup data
    	boolean result = exampleRange1.equals(null);
    	
    	//Verify expectations
        assertFalse("Range(3,7) and null should not be equal (false)",
        result);
    }
    
    /**
     *	ID: SECT23
     *  This test covers a E1 & Positive range for method getCentralValue()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void centralValueShouldBeFive() {
    	
    	//Verify expectations
        assertEquals("The central value in range 3 and 7 should be 5",
        5.0, exampleRange1.getCentralValue(), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT24
     *  This test covers a E1 & Negative range for method getCentralValue()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void centralValueShouldBeNegativeFive() {
    	
    	//Setup data
    	Range anotherRange = new Range(-7,-3);
    	
    	//Verify expectations
        assertEquals("The central value in range -7 and -3 should be -5",
        -5.0, anotherRange.getCentralValue(), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT25
     *  This test covers a E1 & Mixed range for method getCentralValue()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void centralValueShouldBeNegativeTwo() {
    	
    	//Setup data
    	Range anotherRange = new Range(-7,3);
    	
    	//Verify expectations
        assertEquals("The central value in range -7 and 3 should be -2",
        -2.0, anotherRange.getCentralValue(), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT26
     *  This test covers a E1 & Same range for method getCentralValue()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void centralValueShouldBeThree() {
    	
    	//Setup data
    	Range anotherRange = new Range(3,3);
    	
    	//Verify expectations
        assertEquals("The central value in range 3 and 3 should be 3",
        3.0, anotherRange.getCentralValue(), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT27
     *  This test covers a E1 & Extreme range for method getCentralValue()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void centralValueShouldBeZero() {
    	
    	//Setup data
    	Range anotherRange = new Range(-Double.MAX_VALUE,Double.MAX_VALUE);
    	
    	//Verify expectations
        assertEquals("The central value in range -Double.MAX_VALUE and Double.MAX_VALUE should be 0",
        0.0, anotherRange.getCentralValue(), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT28
     *  This test covers a E1 & Positive range for method getLength()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void lengthValueShouldBeFour() {
    	
    	//Verify expectations
        assertEquals("The length in range 3 and 7 should be 4",
        4.0, exampleRange1.getLength(), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT29
     *  This test covers a E1 & Negative range for method getLength()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void lengthValueShouldBeThree() {
    	
    	//Setup data
    	Range anotherRange = new Range(-7,-4);
    	
    	//Verify expectations
        assertEquals("The length in range -7 and -4 should be 3",
        3.0, anotherRange.getLength(), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT30
     *  This test covers a E1 & Mixed range for method getLength()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void lengthValueShouldBeTen() {
    	
    	//Setup data
    	Range anotherRange = new Range(-7,3);
    	
    	//Verify expectations
        assertEquals("The length in range -7 and 3 should be 10",
        10.0, anotherRange.getLength(), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT31
     *  This test covers a E1 & Same range for method getLength()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void lengthValueShouldBeZero() {
    	
    	//Setup data
    	Range anotherRange = new Range(3,3);
    	
    	//Verify expectations
        assertEquals("The length in range 3 and 3 should be 0",
        0.0, anotherRange.getLength(), DEFAULT_DELTA);
    }
    
    /**
     *	ID: SECT32
     *  This test covers a E1 & Extreme range for method getLength()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void lengthValueShouldBeDoubleMaxValue() {
    	
    	//Setup data
    	Range anotherRange = new Range(0,Double.MAX_VALUE);
    	
    	//Verify expectations
        assertEquals("The length in range 0 and Double.MAX_VALUE should be Double.MAX_VALUE",
        Double.MAX_VALUE, anotherRange.getLength(), DEFAULT_DELTA);
    }
    
    // ASSIGNMENT 3 Additions -------------------------------------------------------------   
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT16
     *  This test covers an invalid range (lower > upper) for initializing a range
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void rangeInitializationShouldFailWithInvalidRange() {
    	//Setup data
    	//Verify expectations
    	try {
          	//should throw error
    		Range exampleRange2 = new Range(7,3);
  			
  			//if it reaches here fail as it didnt throw error
  			fail( "Should have thrown an exception" );
  		} catch (Exception e) {
  			//e.printStackTrace();
  		}

    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT17
     *  This test covers instruction/branch coverage for getLowerBound()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void getLowerBoundShouldBeThree() {
    	//Setup data
    	//Verify expectations
        assertEquals("The lower bound value in range 3 and 7 should be 3",
        3.0, exampleRange1.getLowerBound(), DEFAULT_DELTA);
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT18
     *  This test covers instruction/branch coverage for getLowerBound()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void getupperBoundShouldBeSeven() {
    	//Setup data
    	//Verify expectations
        assertEquals("The upper bound value in range 3 and 7 should be 7",
        7.0, exampleRange1.getUpperBound(), DEFAULT_DELTA);
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT19
     *  This test covers instruction/branch coverage for first branch in 
     *  Intersects(double b0, double b1)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void intersectLowerRangeOfFirstShouldBeTrue() {
    	//Setup data
    	boolean result = exampleRange1.intersects(0,4);
    	
    	//Verify expectations
        assertTrue("Intersect Range(3,7) and Range(0,4) should be true",
        result);
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT20
     *  This test covers instruction/branch coverage for first branch in 
     *  intersects(double b0, double b1)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void intersectTwoIndependenttRangesShouldBeFalse() {
    	//Setup data
    	boolean result = exampleRange1.intersects(0,2);
    	
    	//Verify expectations
        assertFalse("Intersect Range(3,7) and Range(0,2) should be false",
        result);
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT21
     *  This test covers branch b0 < upper & b1>= b0 coverage for second branch in 
     *  intersects(double b0, double b1)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void intersectLowerRangeBranchOneShouldBeTrue() {
    	//Setup data
    	boolean result = exampleRange1.intersects(5,6);
    	
    	//Verify expectations
        assertTrue("Intesect Range(3,7) and Range(5,6) should be true",
        result);
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT22
     *  This test covers branch b0 < upper & b1 < b0 coverage for second branch in 
     *  intersects(double b0, double b1)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void intersectLowerRangeBranchTwoShouldBeFalse() {
    	//Setup data
    	boolean result = exampleRange1.intersects(5,4);
    	
    	//Verify expectations
        assertFalse("Intersect Range(3,7) and Range(5,4) should be false",
        result);
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT23
     *  This test covers branch b0 > upper & b1 < b0 coverage for second branch in 
     *  intersects(double b0, double b1)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void intersectLowerRangeBranchThreeShouldBeFalse() {
    	//Setup data
    	boolean result = exampleRange1.intersects(7,4);
    	
    	//Verify expectations
        assertFalse("Intersect Range(3,7) and Range(7,4) should be false",
        result);
    }

    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT24
     *  This test covers branch b0 > upper & b1 < b0 coverage for second branch in 
     *  intersects(double b0, double b1)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void intersectRangeOverloadingShouldBeTrue() {
    	//Setup data
    	Range anotherRange = new Range(1,5);
    	boolean result = exampleRange1.intersects(anotherRange);
    	
    	//Verify expectations
        assertTrue("Intersect Range(3,7) and Range(1,5) should be false",
        result);
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT25
     *  This test covers branch one with first Range null in 
     *  combine(Range range1, Range range2)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void combineRangeWithFirstRangeNullShouldBeSecondRange() {
    	//Setup data

    	Range result = Range.combine(null, exampleRange1);
    	
    	//Verify expectations
    	assertEquals("Combine null and Range(3,7) should have lower range 3",
    			exampleRange1.getLowerBound(), result.getLowerBound(), DEFAULT_DELTA);
    	//Verify expectations
    	assertEquals("Combine null and Range(3,7) should have upper range 7",
    			exampleRange1.getUpperBound(), result.getUpperBound(), DEFAULT_DELTA);
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT26
     *  This test covers branch one with second Range null in 
     *  combine(Range range1, Range range2)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void combineRangeWithSecondRangeNullShouldBeSecondRange() {
    	//Setup data

    	Range result = Range.combine(exampleRange1, null);
    	
    	//Verify expectations
    	assertEquals("Combine Range(3,7) and null should have lower range 3",
    			exampleRange1.getLowerBound(), result.getLowerBound(), DEFAULT_DELTA);
    	//Verify expectations
    	assertEquals("Combine Range(3,7) and null should have upper range 7",
    			exampleRange1.getUpperBound(), result.getUpperBound(), DEFAULT_DELTA);
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT27
     *  This test covers valid combination of two ranges in 
     *  combine(Range range1, Range range2)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void combineRangeWithSameRangeShouldBeSameRange() {
    	//Setup data

    	Range result = Range.combine(exampleRange1, exampleRange1);
    	
    	//Verify expectations
    	assertEquals("Combine Range(3,7) and Range(3,7) should have lower range 3",
    			exampleRange1.getLowerBound(), result.getLowerBound(), DEFAULT_DELTA);
    	//Verify expectations
    	assertEquals("Combine Range(3,7) and Range(3,7) should have upper range 7",
    			exampleRange1.getUpperBound(), result.getUpperBound(), DEFAULT_DELTA);
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT28
     *  This test covers branch one with first Range null in 
     *  combineIgnoringNaN(Range range1, Range range2)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void combineIgnoringNanRangeWithFirstRangeNullShouldBeSecondRange() {
    	//Setup data
    	Range result = Range.combineIgnoringNaN(null, exampleRange1);
    	
    	//Verify expectations
    	assertEquals("Combine null and Range(3,7) should have lower range 3",
    			exampleRange1.getLowerBound(), result.getLowerBound(), DEFAULT_DELTA);
    	//Verify expectations
    	assertEquals("Combine null and Range(3,7) should have upper range 7",
    			exampleRange1.getUpperBound(), result.getUpperBound(), DEFAULT_DELTA);

    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT29
     *  This test covers branch one with first Range null in 
     *  combineIgnoringNaN(Range range1, Range range2)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void combineIgnoringNanRangeWithSecondRangeNullShouldBeSecondRange() {
    	//Setup data

    	Range result = Range.combineIgnoringNaN(exampleRange1, null);
    	
    	//Verify expectations
    	assertEquals("Combine Range(3,7) and null should have lower range 3",
    			exampleRange1.getLowerBound(), result.getLowerBound(), DEFAULT_DELTA);
    	//Verify expectations
    	assertEquals("Combine Range(3,7) and null should have upper range 7",
    			exampleRange1.getUpperBound(), result.getUpperBound(), DEFAULT_DELTA);

    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT30
     *  This test covers valid combination of two ranges in 
     *  combineIgnoringNaN(Range range1, Range range2)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void combineIgnoringNanRangeWithSameRangeShouldBeSameRange() {
    	//Setup data

    	Range result = Range.combineIgnoringNaN(exampleRange1, exampleRange1);
    	
    	//Verify expectations
    	assertEquals("Combine Range(3,7) and Range(3,7) should have lower range 3",
    			exampleRange1.getLowerBound(), result.getLowerBound(), DEFAULT_DELTA);
    	//Verify expectations
    	assertEquals("Combine Range(3,7) and Range(3,7) should have upper range 7",
    			exampleRange1.getUpperBound(), result.getUpperBound(), DEFAULT_DELTA);
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT31
     *  This test covers null in first Range and NaN in Range two 
     *  combineIgnoringNaN(Range range1, Range range2)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void combineIgnoringNanRangeWithFirstRangeNullAndSecondNanShouldBeNull() {
    	//Setup data
    	Range anotherRange = new Range(Double.NaN, Double.NaN);
    	
    	Range result = Range.combineIgnoringNaN(null, anotherRange);
    	
    	boolean check = result == null;
    	
    	//Verify expectations
        assertTrue("null Range and Nan Range should be null",
        check);

    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT32
     *  This test covers null in first Range and NaN in Range two 
     *  combineIgnoringNaN(Range range1, Range range2)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void combineIgnoringNanRangeWithFirstRangeNanAndSecondNullShouldBeNull() {
    	//Setup data
    	Range anotherRange = new Range(Double.NaN, Double.NaN);
    	
    	Range result = Range.combineIgnoringNaN(anotherRange, null);
    	
    	boolean check = result == null;
    	
    	//Verify expectations
        assertTrue("Nan Range and null Range should be null",
        check);

    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT33
     *  This test covers null in first Range and NaN in Range two 
     *  combineIgnoringNaN(Range range1, Range range2)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void combineIgnoringNanRangeWithFirstRangeValidAndSecondUppperNan() {
    	//Setup data
    	Range anotherRange = new Range(3.0, Double.NaN);
    	
    	Range result = Range.combineIgnoringNaN(exampleRange1, anotherRange);
    	
    	
    	//Verify expectations
    	assertEquals("Combine Range(3,7) and Range(3,7) should have lower range 3",
    			exampleRange1.getLowerBound(), result.getLowerBound(), DEFAULT_DELTA);
    	//Verify expectations
    	assertEquals("Combine Range(3,7) and Range(3,7) should have upper range 7",
    			exampleRange1.getUpperBound(), result.getUpperBound(), DEFAULT_DELTA);

    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT34
     *  This test covers null in first Range and NaN in Range two 
     *  combineIgnoringNaN(Range range1, Range range2)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void combineIgnoringNanRangeWithFirstRangeLowerNanAndSecondValid() {
    	//Setup data
    	Range anotherRange = new Range(Double.NaN, 4.0);
    	
    	Range result = Range.combineIgnoringNaN(anotherRange, exampleRange1);
    	
     	
    	//Verify expectations
    	assertEquals("Combine Range(3,7) and Range(3,7) should have lower range 3",
    			exampleRange1.getLowerBound(), result.getLowerBound(), DEFAULT_DELTA);
    	//Verify expectations
    	assertEquals("Combine Range(3,7) and Range(3,7) should have upper range 7",
    			exampleRange1.getUpperBound(), result.getUpperBound(), DEFAULT_DELTA);

    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT35
     *  This test covers null in second Range and NaN in first Range  
     *  combineIgnoringNaN(Range range1, Range range2)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void combineIgnoringNanRangeWithFirstRangeUpperNanAndSecondValid() {
    	//Setup data
    	Range anotherRange = new Range(3.0, Double.NaN);
    	
    	Range result = Range.combineIgnoringNaN(anotherRange, exampleRange1);
    	
    	
    	//Verify expectations
    	assertEquals("Combine Range(3,7) and Range(3,7) should have lower range 3",
    			exampleRange1.getLowerBound(), result.getLowerBound(), DEFAULT_DELTA);
    	//Verify expectations
    	assertEquals("Combine Range(3,7) and Range(3,7) should have upper range 7",
    			exampleRange1.getUpperBound(), result.getUpperBound(), DEFAULT_DELTA);

    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT36
     *  This test covers null in second Range and NaN in first Range upper 
     *  combineIgnoringNaN(Range range1, Range range2)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void combineIgnoringNanRangeWithFirstRangeValidAndSecondLowerNan() {
    	//Setup data
    	Range anotherRange = new Range(Double.NaN, 4.0);
    	
    	Range result = Range.combineIgnoringNaN(exampleRange1, anotherRange);
    	
     	
    	//Verify expectations
    	assertEquals("Combine Range(3,7) and Range(3,7) should have lower range 3",
    			exampleRange1.getLowerBound(), result.getLowerBound(), DEFAULT_DELTA);
    	//Verify expectations
    	assertEquals("Combine Range(3,7) and Range(3,7) should have upper range 7",
    			exampleRange1.getUpperBound(), result.getUpperBound(), DEFAULT_DELTA);

    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT37
     *  This test covers two NaN Ranges 
     *  combineIgnoringNaN(Range range1, Range range2)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void combineIgnoringNanRangeWithTwoNanRanges() {
    	//Setup data
    	Range anotherRange = new Range(Double.NaN, Double.NaN);
    	
    	Range result = Range.combineIgnoringNaN(anotherRange, anotherRange);
    	
     	boolean check = result==null;
    	//Verify expectations
    	assertTrue("Combine ranges with Nan should be null",
    	check);

    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT38
     *  This test covers the expected string representation of a range
     *  toString()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void toStringShouldReturnSameRange() {
    	//Setup data

    	String expected =  "Range[" + exampleRange1.getLowerBound() + "," + exampleRange1.getUpperBound()  + "]";
    	
    	String result = exampleRange1.toString();
     	
    	//Verify expectations
    	assertEquals("Range to string should be Range[3,7] and should be same",
    			0, expected.compareTo(result), DEFAULT_DELTA);

    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT39
     *  This test covers the hashcode value of a range
     *  hashCode()
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void hasCodeOfSameRangeLimitedShouldReturnTrue() {
    	//Setup data
    	Range anotherRange = new Range(3,7);

    	int result1 = exampleRange1.hashCode();  
    	int result2 = anotherRange.hashCode();  
    	
    	//Verify expectations
    	assertEquals("Hashcode of two ranges with same bound should have same hashcode",
    			0, result1 - result2, DEFAULT_DELTA);

    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT40
     *  This test covers the expansion of a valid range by 0 in
     *  expand(Range range, double lowerMargin, double upperMargin)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void expandRangeByZeroShouldBeSameRange() {
    	//Setup data
    	Range result = Range.expand(exampleRange1, 0, 0);

    	
    	//Verify expectations
    	assertEquals("Expand Range(3,7) by 0 lower and 0 upper % should be Range(3,7)",
    			exampleRange1.getLowerBound(), result.getLowerBound(), DEFAULT_DELTA);
    	//Verify expectations
    	assertEquals("Expand Range(3,7) by 0 lower and 0 upper % should be Range(3,7)",
    			exampleRange1.getUpperBound(), result.getUpperBound(), DEFAULT_DELTA);

    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT41
     *  This test covers the expansion of a valid range by a positive lower and negative upper margin
     *  expand(Range range, double lowerMargin, double upperMargin)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void expandRangeByTwoValidMargins() {
    	//Setup data
    	Range result = Range.expand(exampleRange1, 0.3, -2.0);

    	
    	//Verify expectations
    	assertEquals("Expand Range(3,7) by 0.3 lower and -2.0 upper % should be Range(0.4,0.4)",
    			0.4, result.getLowerBound(), DEFAULT_DELTA);
    	//Verify expectations
    	assertEquals("Expand Range(3,7) by 0.3 lower and -2.0 upper % should be Range(0.4,0.4)",
    			0.4, result.getUpperBound(), DEFAULT_DELTA);

    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT42
     *  This test covers the shift of a positive range by 3 with zero crossing
     *  shift(Range base, double delta, boolean allowZeroCrossing)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void shiftRangeByThreeWithZeroCrossingOfPositiveRange() {
    	//Setup data
    	Range result = Range.shift(exampleRange1, 3, true);

    	
    	//Verify expectations
    	assertEquals("Shift Range(3,7) by 3 with Zero Crossing should be Range(6,10)",
    			6, result.getLowerBound(), DEFAULT_DELTA);
    	//Verify expectations
    	assertEquals("Shift Range(3,7) by 3 with Zero Crossing should be Range(6,10)",
    			10, result.getUpperBound(), DEFAULT_DELTA);

    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT43
     *  This test covers the shift of a mixed range by 3 without zero crossing
     *  shift(Range base, double delta, boolean allowZeroCrossing)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void shiftRangeByThreeWithoutZeroCrossingOfMixedRange() {
    	//Setup data
    	Range anotherRange = new Range(-1,4);
    	Range result = Range.shift(anotherRange, 3, false);

    	
    	//Verify expectations
    	assertEquals("Shift Range(-1,4) by 3 without Zero Crossing should be Range(0,7)",
    			0, result.getLowerBound(), DEFAULT_DELTA);
    	//Verify expectations
    	assertEquals("Shift Range(-1,4) by 3 without Zero Crossing should be Range(0,7)",
    			7, result.getUpperBound(), DEFAULT_DELTA);

    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT44
     *  This test covers the same bounded range by 0 without zero crossing
     *  shift(Range base, double delta, boolean allowZeroCrossing)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void shiftRangeByFiveWithoutZeroCrossingOfMixedRange() {
    	//Setup data
    	Range anotherRange = new Range(-1,0);
    	Range result = Range.shift(anotherRange, 5, false);

    	
    	//Verify expectations
    	assertEquals("Shift Range(-1,0) by 5 without Zero Crossing should be Range(0,5)",
    			0, result.getLowerBound(), DEFAULT_DELTA);
    	//Verify expectations
    	assertEquals("Shift Range(-1,0) by 5 without Zero Crossing should be Range(0,5)",
    			5, result.getUpperBound(), DEFAULT_DELTA);

    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT45
     *  This test covers the shift of the same range by zero in
     *  shift(Range base, double delta)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void shiftOverloadingRangeByZeroShouldBeSameRange() {
    	//Setup data
    	Range result = Range.shift(exampleRange1, 0);

    	//Verify expectations
    	assertEquals("Shift Range(3,7) by 0 should be Range(3,7)",
    			3, result.getLowerBound(), DEFAULT_DELTA);
    	//Verify expectations
    	assertEquals("Shift Range(3,7) by 0 should be Range(3,7)",
    			7, result.getUpperBound(), DEFAULT_DELTA);

    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT46
     *  This test covers the scale by a factor of two in
     *  scale(Range base, double factor)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void scaleByFactorTwo() {
    	//Setup data
    	Range result = Range.scale(exampleRange1, 2);

    	//Verify expectations
    	assertEquals("Scale Range(3,7) by 2 should be Range(6,14)",
    			6, result.getLowerBound(), DEFAULT_DELTA);
    	//Verify expectations
    	assertEquals("Scale Range(3,7) by 2 should be Range(6,14)",
    			14, result.getUpperBound(), DEFAULT_DELTA);

    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT47
     *  This test covers the scale by a factor of negative one in
     *  scale(Range base, double factor)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void scaleByFactorNegativeOneShouldThrowError() {
    	//Setup data
 
    	try {
          	//should throw error
    		Range result = Range.scale(exampleRange1, -1);
  			
  			//if it reaches here fail as it didnt throw error
  			fail( "Should have thrown IllegalArgumentException");
  		} catch (Exception e) {
  			//e.printStackTrace();
  		}
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT48
     *  This test covers the expansion of a null range by three in
     *  expandToInclude(Range range, double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void expandToInlcudeThreeOfNullRangeShouldBeThreeBounded() {
    	//Setup data
    	Range result = Range.expandToInclude(null, 3);

    	//Verify expectations
    	assertEquals("Expand to Include Range(null,null) by 3 should be Range(3,3)",
    			3, result.getLowerBound(), DEFAULT_DELTA);
    	//Verify expectations
    	assertEquals("Expand to Include Range(null,null) by 3 should be Range(3,3)",
    			3, result.getUpperBound(), DEFAULT_DELTA);
    	
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT49
     *  This test covers the expansion of a valid range to include two in
     *  expandToInclude(Range range, double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void expandToInlcudeTwoShouldIncludeTwo() {
    	//Setup data
    	Range result = Range.expandToInclude(exampleRange1, 2);

    	//Verify expectations
    	assertEquals("Expand to Include Range(3,7) by 2 should be Range(2,7)",
    			2, result.getLowerBound(), DEFAULT_DELTA);
    	//Verify expectations
    	assertEquals("Expand to Include Range(3,7) by 2 should be Range(2,7)",
    			7, result.getUpperBound(), DEFAULT_DELTA);
    	
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT50
     *  This test covers the expansion of a valid range to include eight in
     *  expandToInclude(Range range, double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void expandToInlcudeEightShouldIncludeEight() {
    	//Setup data
    	Range result = Range.expandToInclude(exampleRange1, 8);

    	//Verify expectations
    	assertEquals("Expand to Include Range(3,7) by 8 should be Range(3,8)",
    			3, result.getLowerBound(), DEFAULT_DELTA);
    	//Verify expectations
    	assertEquals("Expand to Include Range(3,7) by 8 should be Range(3,8)",
    			8, result.getUpperBound(), DEFAULT_DELTA);
    	
    }
    
    /**
     *	Assignment 3 additional coverage
     *	ID: A3SECT51
     *  This test covers the expansion of a same bounded range by zero
     *  expandToInclude(Range range, double value)
     */
    @Test(timeout = DEFAULT_TIMEOUT)
    public void expandToInlcudeRangeWithSameBoundShouldBeSameRange() {
    	//Setup data
    	Range anotherRange = new Range(5,5);
    	Range result = Range.expandToInclude(anotherRange, 5);

    	//Verify expectations
    	assertEquals("Expand to Include Range(5,5) by 5 should be Range(5,5)",
    			5, result.getLowerBound(), DEFAULT_DELTA);
    	//Verify expectations
    	assertEquals("Expand to Include Range(5,5) by 5 should be Range(5,5)",
    			5, result.getUpperBound(), DEFAULT_DELTA);
    	
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
    	exampleRange1 = null;
    }
}