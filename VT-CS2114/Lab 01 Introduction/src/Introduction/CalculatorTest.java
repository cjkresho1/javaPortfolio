package Introduction;
import student.TestCase;


/**
 *  CalculatorTest will test all of the methods in Calculator to make
 *  sure that they run and perform as expected
 *
 * @author  Charles Kresho  cjkresho
 * @version 2016.1.23
 */

public class CalculatorTest extends TestCase
{
    
    private Calculator calc1;
    private Calculator calc2;
    private Calculator calc3;
    
    /**
     * sets up each test method before it runs
     */
    public void setUp()
    {
        calc1 = new Calculator(17, 6);
        calc2 = new Calculator(0, 9);
        calc3 = new Calculator(9, 0);
        
    }

    /**
     * Tests to make sure the method getFirstInput() works as intended.
     */
    public void testGetFirstInput()
    {
        setUp();
        assertEquals(17, calc1.getFirstInput(), .1);
        assertEquals(0, calc2.getFirstInput(), .1);
        assertEquals(9, calc3.getFirstInput(), .1);
    }
    
    /**
     * Tests to make sure the method getSecondInput() works as intended.
     */
    public void testGetSecondInput()
    {
        setUp();
        assertEquals(6, calc1.getSecondInput(), .1);
        assertEquals(9, calc2.getSecondInput(), .1);
        assertEquals(0, calc3.getSecondInput(), .1);
    }
    
    /**
     * Tests to make sure the method multiply() works as intended.
     */
    public void testMultiply()
    {
        setUp();
        assertEquals(102, calc1.multiply(), .01);
        assertEquals(0, calc2.multiply(), .01);
        assertEquals(0, calc3.multiply(), .01);
    }
    
    /**
     * Tests to make sure the method divide() works as intended.
     */
    public void testDivide()
    {
        setUp();
        assertEquals(2.8, calc1.divide(), .1);
        assertEquals(0, calc2.divide(), .1);
        assertEquals(Double.NaN, calc3.divide(), .1);
    }
    
    /**
     * Tests to make sure the method add() works as intended.
     */
    public void testAdd()
    {
        setUp();
        assertEquals(23, calc1.add(), .1);
        assertEquals(9, calc2.add(), .1);
        assertEquals(9, calc3.add(), .1);
    }
    
    /**
     * Tests to make sure the method subtract() works as intended.
     */
    public void testSubtract()
    {
        setUp();
        assertEquals(11, calc1.subtract(), .1);
        assertEquals(-9, calc2.subtract(), .1);
        assertEquals(9, calc3.subtract(), .1);
    }
    
    /**
     * Tests to make sure the method power() works as intended.
     */
    public void testPower()
    {
        setUp();
        assertEquals(24137569, calc1.power(), .1);
        assertEquals(0, calc2.power(), .1);
        assertEquals(1, calc3.power(), .1);
    }
}
