/**
 * 
 */
package collercoaster;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Charles Kresho
 * @version 2016.4.6
 */
public class QueueReader 
{
    /**
     * Creates a new QueueReader object
     * @param fileName - name of the file containing the parties
     */
    public QueueReader(String fileName)
    {
        new CoasterWindow(readQueueFile(fileName));
    }
    
    /**
     * Fills a RollerCoasterQueue with the parties from the input file
     * @param fileName - name of the file containing the parties
     * @return  RollerCoasterQueue with the parties from the input file
     */
    public RollerCoasterQueue readQueueFile(String fileName)
    {
        RollerCoasterQueue queue = new RollerCoasterQueue();
        Scanner scan = null;
        try 
        {
            scan = new Scanner(new File(fileName));
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
            System.exit(0);
        }
        boolean split;
        String name;
        int height;
        while (scan.hasNextLine())
        {
            split = scan.hasNextBoolean();
            WaitingParty newParty = new WaitingParty(split);
            scan.nextLine();
            Pattern p = Pattern.compile("$");
            Pattern s = Pattern.compile("[\\w]");
            while (!scan.hasNext(p))
            {
                name = "";
                while (!scan.hasNext("[,]") && !scan.hasNext(p))
                {
                    scan.next(s);
                }
                
                System.out.println(name);
                height = scan.nextInt();
                Person newPerson = new Person(name, height);
                newParty.add(newPerson);
            }
            queue.enqueueParty(newParty);
        }
        return queue;
    }
}
