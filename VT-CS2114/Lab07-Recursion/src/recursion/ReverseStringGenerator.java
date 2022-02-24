package recursion;

/**
 * 
 * @author Charles Kresho
 * @version 2016.3.4
 */
public class ReverseStringGenerator 
{
    /**
     * Reverse a string
     * @param str - String to be reversed
     * @return the reverse String of str
     */
    public static String reverse(String str)
    {
        String reverseString = "";
        
        if (str.length() == 1)
        {
            return str;
        }
        
        String tempString = reverse(str.substring(1));
        reverseString = tempString.concat(str.substring(0, 1));
        return reverseString;
    }
}
