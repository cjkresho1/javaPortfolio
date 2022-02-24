import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Scheduler
{
    public static void main(String[] args)
    {
        String fileName = "fakeName";
        if (args.length >= 1)
        {
            fileName = args[0];
            schedule(fileName);
            System.exit(0);
        }
        
        //If no filename was passed on the arguments, attempt to read one from the user
        System.out.println("Please enter an input file for the scheduler: ");
        Scanner scan = new Scanner(System.in);
        
        fileName = scan.nextLine();
        schedule(fileName);
        
        scan.close();
    }
    
    private static void schedule(String fileName) 
    {
        File file = new File(fileName);
        if (!file.exists())
        {
            System.out.println("Input file doesn't exist!");
        }
        Graph<String> graph;
        try
        {
            Scanner fRead = new Scanner(file);
            String line;
            if (!fRead.hasNextLine())
            {
                System.out.println("No information in the file!");
                fRead.close();
                return;
            }
            
            //Create graph, add course names
            line = fRead.nextLine();
            int size = Integer.parseInt(line);
            graph = new Graph<String>(size);
            int i = 0;
            while(fRead.hasNextLine())
            {
                line = fRead.nextLine();
                if (i < size)
                {
                    String[] lineA = line.split(" ");
                    String courseName = lineA[0];
                    graph.setValue(i, courseName);
                }
                i++;
            }
            
            if(i != size)
            {
                System.out.println("An incorrect number of courses were specified in the file.\n" + size + " courses were "
                        + "specified, " + i + " courses were listed in the file.");
                fRead.close();
                return;
            }
            
            //Add edges...
            fRead.close();
            fRead = new Scanner(file);
            fRead.nextLine();  //Get rid of the number of entries on the first line
            line = fRead.nextLine();
            while(fRead.hasNextLine())
            {
                line = fRead.nextLine();
                    String[] lineA = line.split(" ");
                    for (int j = 2; j < lineA.length; j++)
                    {
                        graph.insertEdge(lineA[j], lineA[0]);
                    }
            }
            fRead.close();
            
            //Perform topological ordering...
            int cListIndex = 0, activeIndex = 0;
            String[] cList = new String[size];
            String[] active = new String[size];
            //Add active nodes to the list
            for (int j = 0; j < size; j++)
            {
                if (graph.getEdges(j) == 0)
                {
                    active[activeIndex] = graph.getValue(j);
                    activeIndex++;
                }
            }
            //While there are nodes in the active set...
            while (activeIndex > 0)
            {
                //Move the value from active to cList...
                activeIndex--;
                int index = graph.lookup(active[activeIndex]);
                cList[cListIndex] = active[activeIndex];
                cListIndex++;
                
                //Remove edges from the active node to other nodes
                for (int j = 0; j < size; j++)
                {
                    if (graph.removeEdge(index, j)) 
                    {
                        //If node at j has no edges now, add it to the active list
                        if (graph.getEdges(j) == 0)
                        {
                            active[activeIndex] = graph.getValue(j);
                            activeIndex++;
                        }
                    }
                }
            }
            //Check if there are any nodes left with edges...
            boolean completed = true;
            for (int j = 0; j < size; j++)
            {
                if (graph.getEdges(j) != 0)
                {
                    completed = false;
                    break;
                }
            }
            
            if (completed)
            {
                for (int j = 0; j < size; j++)
                {
                    System.out.println("" + (j + 1) + ". " + cList[j]);
                }
            }
            else
            {
                System.out.println("A topological ordering of the courses was not possible.");
            }
        }
        catch (IOException e)
        {
            System.out.println("The input file disapeared...");
        }
    }
}
