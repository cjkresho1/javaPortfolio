import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SentimentAnalysis
{
    
    public static void main(String[] args) 
    {
        File sentiments = new File("sentiments.txt");
        if (!sentiments.exists())
        {
            System.out.println("sentimentx.txt not found! Exiting...");
            System.exit(0);
        }
        
        HashTable<String, Integer> table = new HashTable<String, Integer>(6997);
        
        try
        {
            Scanner fScan = new Scanner(sentiments);
            
            while(fScan.hasNext())
            {
                String line = fScan.nextLine();
                String[] lArray = line.split(",");
                
                table.insert(lArray[0], Integer.valueOf(lArray[1]));
            }
            
            fScan.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("There was a problem reading sentiments.txt");
            //This should never happen, we showed the file existed right before this.
        }
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter text:");
        
        String captured = scan.nextLine();
        int curSent = 0, totalSent = 0, words = 0;
        while (!captured.equals("END"))
        {
            captured = captured.toLowerCase();
            captured = captured.replaceAll("\\p{Punct}", "");
            String[] split = captured.split("\\s+");
            if (split.length > 0)
            {
                words += split.length;
                Integer val = table.lookup(split[0]);
                if (val != null)
                {
                    curSent = val.intValue();
                }
                for (int i = 1; i < split.length; i++)
                {
                    val = table.lookup(split[i - 1] + " " + split[i]);
                    if (val != null)
                    {
                        curSent = 0;
                        totalSent += val.intValue();
                    }
                    else
                    {
                        totalSent += curSent; 
                        val = table.lookup(split[i]);
                        if (val != null)
                        {
                            curSent = val.intValue();
                        }
                        else
                        {
                            curSent = 0;
                        }
                    }
                }
            }
            totalSent += curSent;
            captured = scan.nextLine();
        }
        
        scan.close();
        
        double overallSent = totalSent;
        overallSent = overallSent / words;
        
        System.out.println("Words : " + words);
        System.out.println("Sentiment: " + totalSent);
        System.out.printf("Overall: %.2f\n", overallSent);
    }
}
