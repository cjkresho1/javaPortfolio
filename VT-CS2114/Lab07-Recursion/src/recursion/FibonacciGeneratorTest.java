/**
 * 
 */
package recursion;

import student.TestCase;

/**
 * @author Charles Kresho
 * @version 2016.3.4
 */
public class FibonacciGeneratorTest extends TestCase 
{
    private FibonacciGenerator fiber;
    
    /**
     * Sets up the 
     */
    public void setUp()
    {
        fiber = new FibonacciGenerator();
    }
    
    /**
     * Tests the method fib
     */
    public void testFib()
    {
        setUp();
        fiber = new FibonacciGenerator();
        assertNotNull(fiber);
        assertEquals(FibonacciGenerator.fib(1), 1);
        assertEquals(FibonacciGenerator.fib(2), 1);
        assertEquals(FibonacciGenerator.fib(3), 2);
        assertEquals(FibonacciGenerator.fib(4), 3);
        assertEquals(FibonacciGenerator.fib(5), 5);
        assertEquals(FibonacciGenerator.fib(6), 8);
        assertEquals(FibonacciGenerator.fib(7), 13);
        assertEquals(FibonacciGenerator.fib(8), 21);
        assertEquals(FibonacciGenerator.fib(9), 34);
    }
}
