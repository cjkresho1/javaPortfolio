
public class ListMain
{
    public static void main(String args[])
    {
        //make a linked list of the letters A-Z
        LinkedList<Character> letters = new LinkedList<Character>();
        for (char c = 'A'; c <= 'Z'; c++) 
        {
            letters.append(c);;
        }
        
        //test the size
        System.out.println("There are " + letters.size() + " letters.");
        
        //test contains
        System.out.println("B: " + letters.contains('B'));
        System.out.println("X: " + letters.contains('X'));
        System.out.println("*: " + letters.contains('*'));
        
        //test get
        System.out.println("4 " + letters.get(4));
        System.out.println("15 " + letters.get(15));
        System.out.println("24 " + letters.get(24));
    }
}
