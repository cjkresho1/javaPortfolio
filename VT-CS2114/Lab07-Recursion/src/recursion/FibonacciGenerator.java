/**
 * 
 */
package recursion;

/**
 * @author Charles Kresho
 * @version 2016.3.4
 */
public class FibonacciGenerator 
{
    
    /**
     * Generates the n't number in the Fibonacci sequence
     * @param n - index of the number in the Fibonacci sequence
     * @return the n't number in the Fibonacci sequence
     */
    public static int fib(int n)
    {
        if (n <= 2)
        {
            return 1;
        }
        else
        {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
