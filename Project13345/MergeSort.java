package Project13345;

public class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static int numberOfComparisons = 0;
    //static int numberOfMovements;
    void merge(long arr[], int l, int m, int r)
    {
        //numberOfComparisons = 0;

        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        long L[] = new long[n1];
        long R[] = new long[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second sub arrays
        int i = 0, j = 0;

        // Initial index of merged sub array array
        int k = l;
        while (i < n1 && j < n2) {
            numberOfComparisons++;
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                //numberOfMovements+=1;
                arr[k] = R[j];
                j++;
                //System.out.println("Debug: " + numberOfMovements);
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(long arr[], int l, int r)
    {
        //numberOfComparisons = 0;
        if (l < r) {
            numberOfComparisons++;
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(long arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    /*public static void main(String args[])
    {


    }*/
}

