import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class SpellCheck
{
    public static void main(String[] args)
    {
        if (args.length < 1)
        {
            System.out.println("No dictionary file added!");
            System.exit(0);
        }
        String fileName = args[0];
        File file = new File(fileName);
        if (!file.exists())
        {
            System.out.println("Dictionary file doesn't exist!");
            System.exit(0);
        }
        BinarySearchTree<String> dict = new BinarySearchTree<String>();
        try
        {
            Scanner fRead = new Scanner(file);
            String line;
            while(fRead.hasNextLine())
            {
                line = fRead.nextLine();
                dict.insert(line);
            }
            
            fRead.close();
        }
        catch (IOException e)
        {
            System.out.println("The dictionary disapeared...");
            System.exit(0);
        }
        
        System.out.println("Loaded the words into a tree with height = " + dict.height());
        
        Scanner scan = new Scanner(System.in);
        
        String input = "not-END";
        input = scan.nextLine();
        while(!input.equals("END"))
        {
            input = input.replaceAll("\\p{Punct}&&[^']", "");
            String[] inArray = input.split(" ");
            for(int i = 0; i < inArray.length; i++)
            {
                if (dict.search(inArray[i]) == null)
                {
                    System.out.println(inArray[i] + " is spelled wrong!");
                }
            }
            input = scan.nextLine();
        }
        
        scan.close();
    }
}
