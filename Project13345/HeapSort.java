package Project13345;

public class HeapSort {

    static int numberOfMovements = 0;
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    public static long heapify(long arr[], int n, int i)
    {
        long count =0;

        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest]){
            largest = l;
            //count++;
        }


        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
            //count++;
        }
        // If largest is not root
        if (largest != i) {
            count+=1;
            long swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            numberOfMovements++;

            // Recursively heapify the affected sub-tree
            count += heapify(arr, n, largest);
        }
        return count;
    }
    public static long sort(long arr[])
    {
        long numberOfComaprisons = 0;
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
            numberOfComaprisons += heapify(arr, n, 0);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            long temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            numberOfMovements++;

            // call max heapify on the reduced heap
            numberOfComaprisons +=heapify(arr, i, 0);
        }
        System.out.println("Heap Sort:");
        System.out.println("Total Number of Movements: " + numberOfMovements);
        System.out.println("Total Number of Comparisons: " + numberOfComaprisons);
        return numberOfComaprisons;
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
    public static void main(String args[])
    {
        //long arr[] = { 12, 11, 13, 5, 6, 7 };
        long arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        long start = System.nanoTime();
        long numberofcomps = ob.sort(arr);
        long elapsedTime = System.nanoTime() - start;
        //ob.sort(arr);

        System.out.println("Heap Sort:");
        System.out.println("Time elapsed: " + elapsedTime);
        System.out.println("Total Number of Comparisons: " + numberofcomps);

        printArray(arr);
    }
}
