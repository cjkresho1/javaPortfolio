/**
 * 
 */
package recursion;

import student.TestCase;

/**
 * @author Charles Kresho
 * @version 2016.3.4
 */
public class PalindromeCheckerTest extends TestCase 
{
    private PalindromeChecker checker;
    
    /**
     * Sets up the variables for each method
     */
    public void setUp()
    {
        checker = new PalindromeChecker();
    }
    
    /**
     * Tests the isPalindrome method
     */
    public void testIsPalindrome()
    {
        setUp();
        checker = new PalindromeChecker();
        assertNotNull(checker);
        assertTrue(PalindromeChecker.isPalindrome("a"));
        assertTrue(PalindromeChecker.isPalindrome("aa"));
        assertFalse(PalindromeChecker.isPalindrome("ab"));
        assertFalse(PalindromeChecker.isPalindrome("abcd"));
        assertFalse(PalindromeChecker.isPalindrome("abca"));
        assertTrue(PalindromeChecker.isPalindrome("racecar"));
        assertTrue(PalindromeChecker.isPalindrome("Go hang a salami, "
                + "I’m a lasagna hog."));
        assertTrue(PalindromeChecker.isPalindrome("A Toyota! Race fast, safe "
                + "car. A Toyota."));
        assertTrue(PalindromeChecker.isPalindrome("“Tie Mandie,” I’d name "
                + "it."));
        assertTrue(PalindromeChecker.isPalindrome("Wonton? Not now."));
        
    }
}
