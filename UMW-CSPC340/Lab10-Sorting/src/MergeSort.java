// MergeSort.java

import java.util.Random;

public class MergeSort
{
    public static void merge(int[] array, int start, int end)
    {
        int middle = (start + end) / 2;
        int temp_index = 0;

        // create a temporary array
        int[] temp = new int[end - start + 1];

        // merge in sorted data from the 2 halves
        int left = start;
        int right = middle + 1;

        // while both halves have data
        while ((left <= middle) && (right <= end))
        {
            // if the left half value is less than right
            if (array[left] < array[right])
            {
                // take from left
                temp[temp_index] = array[left];
                temp_index++;
                left++;
            }
            else
            {
                // take from right
                temp[temp_index] = array[right];
                temp_index++;
                right++;
            }
        }

        // add the remaining elements from the left half
        while (left <= middle)
        {
            temp[temp_index] = array[left];
            temp_index++;
            left++;
        }

        // add the remaining elements from the right half
        while (right <= end)
        {
            temp[temp_index] = array[right];
            temp_index++;
            right++;
        }

        // move from temp array to the original array
        for (int i = start; i <= end; i++)
        {
            array[i] = temp[i - start];
        }
    }

    // the actual merge sort method
    public static void mergeSort(int[] array, int start, int end)
    {
        if (start < end)
        {
            int middle = (start + end) / 2;

            // sort left half
            mergeSort(array, start, middle);

            // sort right half
            mergeSort(array, middle + 1, end);

            // merge the two halves
            merge(array, start, end);
        }
    }

    // helper method to sort a whole array
    public static void mergeSort(int[] array)
    {
        mergeSort(array, 0, array.length - 1);
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
                mergeSort(nums);
                long endTime = System.nanoTime();
        
                long elapsedMS = (endTime - startTime) / 1000000;
                totalMS += elapsedMS;
            }
            totalMS = totalMS / 3;
            System.out.println("Elapsed time = " + totalMS + " milliseconds.");
        }
    }
}