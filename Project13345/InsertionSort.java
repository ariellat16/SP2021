package Project13345;

public class InsertionSort {
    public static void insertionSort(long [] list){
        int numberOfComparisons = 0;
        int numberOfMovements = 0;
        for(int i = 0; i < list.length; i++){
            numberOfComparisons++;
            long current  = list[i]; // current element
            int k; // comparison element

            /*System.out.println("Debug Now At:  " + current);
            System.out.println("Debug: Current list: ");
            for(int a = 0; a < list.length; a++){
                System.out.printf(list[a] + " ");
            }
            System.out.printf("\n");*/

            for (k = i - 1; k >= 0 && list [k] > current; k--){ // swapping the element

                list[k+1] = list [k];
                //System.out.println("A swap has been made:  " + current + " and " + list[k]);
                //System.out.println("Debug: " + list[k]);
                numberOfMovements++;
                numberOfComparisons++;

            }
            //System.out.println("Number of Comparisons: " + numberOfComparisons);
            list[k+1] = current;
            /*System.out.println("Debug: Updated list: ");
            for(int a = 0; a < list.length; a++){
                System.out.printf(list[a] + " ");
            }
            System.out.printf("\n\n");*/

        }
        System.out.println("Insertion Sort: ");
        System.out.println("Total Number of Movements: " + numberOfMovements);
        System.out.println("Total Number of Comparisons: " + (numberOfComparisons - 1));
    }
}
