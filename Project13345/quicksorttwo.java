package Project13345;


public class quicksorttwo {
    static int numberOfComparisons = 0;
    static int numberOfMovements = 0;

    // divide the array on the basis of pivot
    static int partition(long array[], int low, int high) {

        // select last element as pivot
        long pivot = array[high];

        // initialize the second pointer
        int i = (low - 1);

        // Put the elements smaller than pivot on the left and
        // greater than pivot on the right of pivot
        for (int j = low; j < high; j++) {

            // compare all elements with pivot
            // swap the element greater than pivot
            // with element smaller than pivot
            numberOfComparisons++;
            if (array[j] <= pivot) {
                //numberOfComparisons++;
                // increase the second pointer if
                // smaller element is swapped with greater
                i++;
                long temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                //numberOfMovements++;
            }
        }

        // put pivot in position so that element on left are smaller element on right are greater than pivot
        long temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        numberOfMovements++;

        //System.out.println("Total Number of Comparisons: " + (numberOfComparisons));
        return (i + 1);
    }

    public static void quickSort(long array[], int low, int high) {

        if (low < high) {

            // Select pivot position and put all the elements smaller
            // than pivot on the left and greater than pivot on right
            int pi = partition(array, low, high);

            // sort the elements on the left of the pivot
            quickSort(array, low, pi - 1);

            // sort the elements on the right of pivot
            quickSort(array, pi + 1, high);
        }
    }

}
