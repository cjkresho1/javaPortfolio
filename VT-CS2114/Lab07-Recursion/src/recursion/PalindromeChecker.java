/**
 * 
 */
package recursion;

/**
 * @author Charles Kresho
 * @version 2016.3.4
 */
public class PalindromeChecker 
{
    
    /**
     * Determines if a string is a palindrome, meaning that it can be spelled 
     * the same forward and backwards
     * @param str - string to be tested
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String str)
    {
        str = str.toLowerCase();
        
        while (!Character.isAlphabetic(str.charAt(0)) && str.length() > 1)
        {
            str = str.substring(1);
        }
        
        while (!Character.isAlphabetic(str.charAt(str.length() - 1)) && 
                str.length() > 1)
        {
            str = str.substring(0, str.length() - 1);
        }
        
        if (str.length() == 1)
        {
            return true;
        }
        else if (str.length() == 2)
        {
            return (str.charAt(0) == str.charAt(1));
        }
        
        return (str.charAt(0) == str.charAt(str.length() - 1)) && 
                isPalindrome(str.substring(1, str.length() - 1));
    }
}
