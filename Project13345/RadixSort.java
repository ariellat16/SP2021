package Project13345;
import java.util.*;

public class RadixSort {
    static int numberOfMovements = 0;

    static long getMax(long arr[], int n){
            long mx = arr[0];
            for (int i = 1; i < n; i++)
                if (arr[i] > mx)
                    mx = arr[i];
            return mx;
    }
    static void countSort(long arr[], int n, int exp) {
            //numberOfMovements = 0;
            long output[] = new long[n];
            int i;
            long count[] = new long[10];
            Arrays.fill(count,0);
            for (i = 0; i < n; i++)
                count[(int) ((arr[i]/exp)%10)]++;

            // Change count[i] so that it contains actual position of this digit in output[]
            for (i = 1; i < 10; i++){
                count[i] += count[i - 1];
            }

            // Build the output array
            for (i = n - 1; i >= 0; i--){
                output[(int) (count[(int) ((arr[i]/exp)%10)] - 1)] = arr[i]; // change made here
                count[(int) ((arr[i]/exp)%10)]--; // chnage
                numberOfMovements++;
            }
            for (i = 0; i < n; i++){
                arr[i] = output[i];}

    }
    static void radixsort(long arr[], int n)
    { // Find the maximum number to know number of digits
            numberOfMovements = 0;
            long m = getMax(arr, n);
            System.out.println("Radix Sort: ");
            for (int exp = 1; m/exp > 0; exp *= 10)
            {
                countSort(arr, n, exp);
            }
            System.out.println("Total Number of Movements: " + numberOfMovements);
            System.out.println("Total Number of Comparisons: N/A ");
    }


}
