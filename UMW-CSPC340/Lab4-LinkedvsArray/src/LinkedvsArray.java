import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedvsArray
{
    public static void main(String[] args)
    {
        //Track time for adding elements to the end of an array list
        long arrayEndMS[] = new long[3];
        for (int i = 0; i < 3; i++)
        {
            long arrayStartTime = System.nanoTime();
            
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            for (int j = 0; j < 500000; j++)
            {
                arrayList.add(j);
            }
            
            long arrayEndTime = System.nanoTime();
            arrayEndMS[i] = (arrayEndTime - arrayStartTime) / 1000000;
        }
        
        //Track time for adding new elements to the beginning of an array list
        long arrayStartMS[] = new long[3];
        for (int i = 0; i < 3; i++)
        {
            long arrayStartTime = System.nanoTime();
            
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            for (int j = 0; j < 500000; j++)
            {
                arrayList.add(0, j);
            }
            
            long arrayEndTime = System.nanoTime();
            arrayStartMS[i] = (arrayEndTime - arrayStartTime) / 1000000;
        }
        
        long linkedEndMS[] = new long[3];
        for (int i = 0; i < 3; i++)
        {
            long linkedStartTime = System.nanoTime();
            
            LinkedList<Integer> linkedList = new LinkedList<Integer>();
            for (int j = 0; j < 500000; j++)
            {
                linkedList.add(j);
            }
            
            long linkedEndTime = System.nanoTime();
            linkedEndMS[i] = (linkedEndTime - linkedStartTime) / 1000000;
        }
        
        long linkedStartMS[] = new long[3];
        for (int i = 0; i < 3; i++)
        {
            long linkedStartTime = System.nanoTime();
            
            LinkedList<Integer> linkedList = new LinkedList<Integer>();
            for (int j = 0; j < 500000; j++)
            {
                linkedList.add(0, j);
            }
            
            long linkedEndTime = System.nanoTime();
            linkedStartMS[i] = (linkedEndTime - linkedStartTime) / 1000000;
        }
        long arrayEndAverageSec = 0, arrayStartAverageSec = 0, linkedEndAverageSec = 0, linkedStartAverageSec = 0;
        for (int i = 0; i < 3; i++)
        {
            arrayEndAverageSec += arrayEndMS[i];
            arrayStartAverageSec += arrayStartMS[i];
            linkedStartAverageSec += linkedStartMS[i];
            linkedEndAverageSec += linkedEndMS[i];
        }
        
        arrayEndAverageSec /= 3;
        arrayStartAverageSec /= 3;
        linkedStartAverageSec /= 3;
        linkedEndAverageSec /= 3;
        
        System.out.println("ArrayList adding to end:\t" + arrayEndAverageSec + " milliseconds.");
        System.out.println("ArrayList adding to start:\t" + arrayStartAverageSec + " milliseconds.");
        System.out.println("LinkedList adding to end:\t" + linkedEndAverageSec + " milliseconds");
        System.out.println("LinkedList adding to start:\t" + linkedStartAverageSec + " milliseconds");
    }
}
