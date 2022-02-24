// BubbleSort.java

import java.util.Random;

public class OptimizedBubbleSort
{
    public static void optimizedBubbleSort(int[] array)
    {
        boolean changed = true;

        while (changed)
        {
            int endVal = 2;
            changed = false;
            for (int i = 0; i <= array.length - endVal; i++)
            {
                if (array[i] > array[i + 1])
                {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    changed = true;
                }
                endVal++;
            }
        }
    }

    public static void main(String args[])
    {
        if (args.length < 1)
        {
            System.out.println("Did you forget the size?");
            System.exit(0);
        }
        for (int k = 0; k < args.length; k++)
        {
            int size = Integer.parseInt(args[k]);
    
            long totalMS = 0;
            System.out.print("Array size = " + size + "\t");
            for (int j = 0; j < 3; j++)
            {
                // put in random numbers
                int[] nums = new int[size];
                Random rng = new Random();
                for (int i = 0; i < size; i++)
                {
                    nums[i] = rng.nextInt(size);
                }
        
                // sort them
                long startTime = System.nanoTime();
                optimizedBubbleSort(nums);
                long endTime = System.nanoTime();
        
                long elapsedMS = (endTime - startTime) / 1000000;
                totalMS += elapsedMS;
            }
            totalMS = totalMS / 3;
            System.out.println("Elapsed time = " + totalMS + " milliseconds.");
        }
    }
}