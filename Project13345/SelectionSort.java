package Project13345;

public class SelectionSort {
    public static  void selectionSort (long [] list){
        int numberOfComparisons = 0;
        int numberOfMovements = 0;
        for (int i = 0; i < list.length-1; i++){
            long currentMinimum = list [i];
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++){
                if(currentMinimum>list[j]){
                    currentMinimum = list[j];
                    currentMinIndex = j;
                }
                numberOfComparisons++;

            }
            if (currentMinIndex != i){
                //numberOfComparisons++;
                list[currentMinIndex] = list[i];
                list[i] = currentMinimum;
                numberOfMovements++;
            }
        }
        System.out.println("Selection Sort: ");
        System.out.println("Total Number of Movements: " + numberOfMovements);
        System.out.println("Total Number of Comparisons: " + (numberOfComparisons));
    }

}
