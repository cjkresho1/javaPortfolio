/**
 * 
 */
package collercoaster;

/**
 * @author Charles Kresho
 * @version 2016.4.6
 */
public class ProjectRunner 
{
    /**
     * Runs the program
     * @param args - possibly contains the name of the input file
     */
    public static void main(String[] args)
    {
        String input = "input.txt";
        if (args.length == 1)
        {
            input = args[0];
        }
        new QueueReader(input);
    }
}
