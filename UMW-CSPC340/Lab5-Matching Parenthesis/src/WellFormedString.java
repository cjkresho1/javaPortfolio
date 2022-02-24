import java.util.Scanner;
import java.util.Stack;

/**
 * Reports if a user inputed string, which uses only brackets and parentheses, is well formed.
 * @author Charles Kresho
 */
public class WellFormedString
{
    public static void main(String[] args) 
    {
        Stack<Character> cStack = new Stack<Character>();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter a string using [, (, ), or ]");
        String input = scan.nextLine();
        System.out.print("\n");
        char curChar;
        Character popChar;
        for (int i = 0; i < input.length(); i++)
        {
            curChar = input.charAt(i);
            if (curChar == '[')
            {
                cStack.push('[');
            }
            else if (curChar == '(')
            {
                cStack.push('(');
            }
            else if (curChar == ']')
            {
                if (cStack.size() == 0)
                {
                    System.out.println("This string is not well formed!");
                    scan.close();
                    System.exit(0);
                }
                
                popChar = cStack.pop();
                if (popChar.charValue() != '[')
                {
                    System.out.println("This string is not well formed!");
                    scan.close();
                    System.exit(0);
                }
            }
            else if (curChar == ')')
            {
                if (cStack.size() == 0)
                {
                    System.out.println("This string is not well formed!");
                    scan.close();
                    System.exit(0);
                }
                
                popChar = cStack.pop();
                if (popChar.charValue() != '(')
                {
                    System.out.println("This string is not well formed!");
                    scan.close();
                    System.exit(0);
                }
            }
            else if (Character.isWhitespace(curChar))
            {
                
            }
            else
            {
                System.out.println("This string has invalid characters in it. Please try again.");
                scan.close();
                System.exit(0);
            }
        }
        if (cStack.size() == 0)
        {
            System.out.println("This string is a well formed string.");
        }
        else 
        {
            System.out.println("This string is not well formed!");
        }
        scan.close();
    }
}
