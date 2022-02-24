import java.util.Scanner;

public class Powers
{
    static int getRecursiveInt(Scanner scan)
    {
        System.out.print("Enter a positive number: ");
        int num = scan.nextInt();
        if (num > 0)
        {
            return num;
        }
        System.out.println("I said a positive number!");
        return getRecursiveInt(scan);
    }
    
    static int power(int base, int exp)
    {
        //Base case, base ^ 1 = base
        if (exp == 1)
        {
            return base;
        }
        //If even, base ^ (exp / 2) * base ^ (exp / 2)
        else if (exp % 2 == 0)
        {
            return ((power(base, exp / 2)) * (power(base, exp / 2)));
        }
        //If odd, base ^ (exp / 2) * base ^ (exp / 2) * base
        return ((power(base, exp / 2)) * (power(base, exp / 2)) * base);
    }
    
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        int base = getRecursiveInt(scan);
        int exp = getRecursiveInt(scan);
        scan.close();
        int result = power(base, exp);
        System.out.println("" + result);
    }
}
