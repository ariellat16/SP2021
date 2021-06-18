package Project13345; // 01/21/2021

/*TIME COMPLEXITY NOTES:
    Some function that takes input, performs steps, and returns some output.
    How are the number of steps related to the input
    1 to 1 increase = linear growth. Linear graph
    T(n) (growth rate) = O(n).
    The number of times a function needs to be repeated
    Abstraction: not worried about the intrinsic details of a function.
    Black Box = not to worry about how it happens
*/

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main (String [] args) throws IOException {

        Scanner input = new Scanner(System.in);
        int exitbutton =0;
        boolean gooddata;
        do{
            System.out.println("Please choose from the following data types \n" + "1. InOrder \n" + "2. RandomOrder \n" + "3. ReverseOrder \n"+ "4. AlmostOrder \n" + "5. Exit \n");
            System.out.println("\n\nEnter the menu option to view the corresponding analysis: \n");
            gooddata = false;
            while (!gooddata) { // assuming the data is bad right of the bat,
                try {// try catch to capture invalid data
                    exitbutton = input.nextInt(); // get input
                    if(exitbutton == 1 || exitbutton == 2 || exitbutton == 3 || exitbutton == 4) { gooddata = true; } // if input is correct, then the data is good
                    else if (exitbutton == 5){ // if the input is 5, exit the menu
                        System.out.println("Exiting the menu...Please visit the corresponding EXCEL FILE to view the fastest sort in detail");
                        return;}
                    else{ // any other inout will prompt an error message to choose between the menu options
                        System.out.println("Make sure to enter either 1, 2, 3, or 4, to view the analysis"); // if it's the wrong input display an error message
                    }
                } catch (InputMismatchException ex) { // if it's not an integer, display an error message
                    System.out.println("Please make sure to enter an integer number to represent the appropriate menu option");
                    String flush = input.next();
                } // try again
            }
            if(exitbutton == 1){
                System.out.println("**********NOW SHOWING ANALYSIS FOR InOrder Data: **********");
                Scanner InOrder = new Scanner(new File("src/Project13345/InOrder.txt")); // open the Inorder T-TIN number data set
                long dataList [] = getList(InOrder);
                long start = System.nanoTime();
                InsertionSort.insertionSort(dataList);
                long elapsedTime = System.nanoTime() - start;
                System.out.println("Time elapsed: " + elapsedTime + "\n");

                // SELECTION SORT---------------------------------------------------------------------------------------------------------
                start = System.nanoTime();
                SelectionSort.selectionSort(dataList);
                elapsedTime = System.nanoTime() - start;
                System.out.println("Time elapsed: " + elapsedTime + "\n");

                // RADIX SORT---------------------------------------------------------------------------------------------------------
                start = System.nanoTime();
                RadixSort.radixsort(dataList, dataList.length);
                elapsedTime = System.nanoTime() - start;
                System.out.println("Time elapsed: " + elapsedTime + "\n");

                // QUICK SORT---------------------------------------------------------------------------------------------------------
                start = System.nanoTime();
                long[] data = { 0, 1, 2, 6, 7, 8, 9, 10};
                int size = data.length;
                quicksorttwo.numberOfMovements =0;
                quicksorttwo.numberOfComparisons =0;
                quicksorttwo.quickSort(data, 0, size - 1); //use dataList here to sort a datafile with less than 50000 I-TINS
                elapsedTime = System.nanoTime() - start;
                System.out.println("SAMPLE Quick Sort implementing a smaller array because 50000 elements array cannot implement a recursive solution: { 0, 1, 2, 6, 7, 8, 9, 10}  ");
                printList(data);
                System.out.println("Total Number of Movements: " + quicksorttwo.numberOfMovements);
                System.out.println("Total Number of Comparisons: " + (quicksorttwo.numberOfComparisons));
                System.out.println("Time elapsed: " + elapsedTime + "\n");


                MergeSort ob = new MergeSort();
                MergeSort.numberOfComparisons =0;
                start = System.nanoTime();
                ob.sort(dataList, 0, dataList.length - 1);
                elapsedTime = System.nanoTime() - start;

                System.out.println("Merge Sort: ");
                System.out.println("Total Number of Movements: N/A ");
                System.out.println("Total Number of Comparisons: " + MergeSort.numberOfComparisons);
                System.out.println("Time elapsed: " + elapsedTime + "\n");


                // HEAP SORT---------------------------------------------------------------------------------------------------------
                HeapSort.numberOfMovements =0;
                start = System.nanoTime();
                HeapSort.sort(dataList);
                elapsedTime = System.nanoTime() - start;
                System.out.println("Time elapsed: " + elapsedTime + "\n");

                System.out.println("FASTEST SORT FOR INORDER: INSERTION SORT" );
                System.out.println("\n\n");

            } else if (exitbutton == 2){
                System.out.println("**********NOW SHOWING ANALYSIS FOR RandomOrder Data: **********");

                // INSERTION SORT---------------------------------------------------------------------------------------------------------
                Scanner RandomOrder = new Scanner(new File("src/Project13345/RandomOrder.txt")); // open the RandomOrder T-TIN number data set
                long[] dataList = getList(RandomOrder);
                long start = System.nanoTime();
                InsertionSort.insertionSort(dataList);
                long elapsedTime = System.nanoTime() - start;
                System.out.println("Time elapsed: " + elapsedTime + "\n");

                // SELECTION SORT---------------------------------------------------------------------------------------------------------
                RandomOrder = new Scanner(new File("src/Project13345/RandomOrder.txt")); // open the RandomOrder T-TIN number data set
                dataList = getList(RandomOrder);
                start = System.nanoTime();
                SelectionSort.selectionSort(dataList);
                elapsedTime = System.nanoTime() - start;
                System.out.println("Time elapsed: " + elapsedTime + "\n");

                // RADIX SORT---------------------------------------------------------------------------------------------------------
                RandomOrder = new Scanner(new File("src/Project13345/RandomOrder.txt")); // open the RandomOrder T-TIN number data set
                dataList = getList(RandomOrder);
                RadixSort.numberOfMovements =0;
                start = System.nanoTime();
                RadixSort.radixsort(dataList, dataList.length);
                elapsedTime = System.nanoTime() - start;
                System.out.println("Time elapsed: " + elapsedTime + "\n");


                // HEAP SORT---------------------------------------------------------------------------------------------------------
                RandomOrder = new Scanner(new File("src/Project13345/RandomOrder.txt")); // open the RandomOrder T-TIN number data set
                dataList = getList(RandomOrder);
                HeapSort.numberOfMovements =0;
                start = System.nanoTime();
                HeapSort.sort(dataList);
                elapsedTime = System.nanoTime() - start;
                System.out.println("Time elapsed: " + elapsedTime + "\n");

                // MERGE SORT---------------------------------------------------------------------------------------------------------
                RandomOrder = new Scanner(new File("src/Project13345/RandomOrder.txt")); // open the RandomOrder T-TIN number data set
                dataList = getList(RandomOrder);
                MergeSort ob = new MergeSort();
                MergeSort.numberOfComparisons =0;
                start = System.nanoTime();
                ob.sort(dataList, 0, dataList.length - 1);
                elapsedTime = System.nanoTime() - start;

                System.out.println("Merge Sort: ");
                System.out.println("Total Number of Movements: N/A ");
                System.out.println("Total Number of Comparisons: " + MergeSort.numberOfComparisons);
                System.out.println("Time elapsed: " + elapsedTime + "\n");

                // QUICK SORT---------------------------------------------------------------------------------------------------------
                RandomOrder = new Scanner(new File("src/Project13345/RandomOrder.txt")); // open the RandomOrder T-TIN number data set
                dataList = getList(RandomOrder);
                start = System.nanoTime();
                long[] list = { 1, 10, 0, 9, 2, 7, 6, 8};
                quicksorttwo.numberOfMovements =0;
                quicksorttwo.numberOfComparisons =0;
                quicksorttwo.quickSort(list, 0, list.length - 1); //use dataList here to sort a datafile with less than 50000 I-TINS
                elapsedTime = System.nanoTime() - start;
                System.out.println("SAMPLE Quick Sort implementing a smaller array because 50000 elements array cannot implement a recursive solution:  { 1, 10, 0, 9, 2, 7, 6, 8}");
                System.out.println("Total Number of Movements: " + quicksorttwo.numberOfMovements);
                System.out.println("Total Number of Comparisons: " + (quicksorttwo.numberOfComparisons));
                printList(list);
                System.out.println("Time elapsed: " + elapsedTime + "\n");

                System.out.println("FASTEST SORT FOR Random Order: MERGE SORT" );
                System.out.println("\n\n");

            }else if (exitbutton == 3){
                System.out.println("**********NOW SHOWING ANALYSIS FOR ReverseOrder Data: ***************");

                // INSERTION SORT---------------------------------------------------------------------------------------------------------
                Scanner ReverseOrder = new Scanner(new File("src/Project13345/ReverseOrder.txt")); // open the ReverseOrder T-TIN number data set
                long [] dataList = getList(ReverseOrder);
                long start = System.nanoTime();
                InsertionSort.insertionSort(dataList);
                long elapsedTime = System.nanoTime() - start;
                System.out.println("Time elapsed: " + elapsedTime + "\n");

                // SELECTION SORT---------------------------------------------------------------------------------------------------------
                ReverseOrder = new Scanner(new File("src/Project13345/ReverseOrder.txt")); // open the ReverseOrder T-TIN number data set
                dataList = getList(ReverseOrder);
                start = System.nanoTime();
                SelectionSort.selectionSort(dataList);
                elapsedTime = System.nanoTime() - start;
                System.out.println("Time elapsed: " + elapsedTime + "\n");

                // RADIX SORT---------------------------------------------------------------------------------------------------------
                ReverseOrder = new Scanner(new File("src/Project13345/ReverseOrder.txt")); // open the ReverseOrder T-TIN number data set
                dataList = getList(ReverseOrder);
                //printList(dataList);
                RadixSort.numberOfMovements =0;
                start = System.nanoTime();
                RadixSort.radixsort(dataList, dataList.length);
                elapsedTime = System.nanoTime() - start;
                System.out.println("Time elapsed: " + elapsedTime + "\n");


                // HEAP SORT---------------------------------------------------------------------------------------------------------
                ReverseOrder = new Scanner(new File("src/Project13345/ReverseOrder.txt")); // open the ReverseOrder T-TIN number data set
                dataList = getList(ReverseOrder);
                HeapSort.numberOfMovements =0;
                start = System.nanoTime();
                HeapSort.sort(dataList);
                elapsedTime = System.nanoTime() - start;
                System.out.println("Time elapsed: " + elapsedTime + "\n");

                // MERGE SORT---------------------------------------------------------------------------------------------------------
                ReverseOrder = new Scanner(new File("src/Project13345/ReverseOrder.txt")); // open the ReverseOrder T-TIN number data set
                dataList = getList(ReverseOrder);
                MergeSort ob = new MergeSort();
                MergeSort.numberOfComparisons =0;
                start = System.nanoTime();
                ob.sort(dataList, 0, dataList.length - 1);
                elapsedTime = System.nanoTime() - start;

                System.out.println("Merge Sort: ");
                System.out.println("Total Number of Movements: N/A ");
                System.out.println("Total Number of Comparisons: " + MergeSort.numberOfComparisons);
                System.out.println("Time elapsed: " + elapsedTime + "\n");

                // QUICK SORT---------------------------------------------------------------------------------------------------------
                ReverseOrder = new Scanner(new File("src/Project13345/ReverseOrder.txt")); // open the ReverseOrder T-TIN number data set
                start = System.nanoTime();
                long[] list2 = { 10, 9, 8, 7, 6, 2, 1, 0};
                quicksorttwo.numberOfMovements =0;
                quicksorttwo.numberOfComparisons =0;
                quicksorttwo.quickSort(list2, 0, list2.length - 1);//use dataList here to sort a datafile with less than 50000 I-TINS
                elapsedTime = System.nanoTime() - start;
                System.out.println("SAMPLE Quick Sort implementing a smaller array because 50000 elements array cannot implement a recursive solution: { 10, 9, 8, 7, 6, 2, 1, 0}");
                System.out.println("Total Number of Movements: " + quicksorttwo.numberOfMovements);
                System.out.println("Total Number of Comparisons: " + (quicksorttwo.numberOfComparisons));
                printList(list2);
                System.out.println("Time elapsed: " + elapsedTime + "\n");

                System.out.println("FASTEST SORT FOR Reverse Order: MERGE SORT" );
                System.out.println("\n\n");

            } else if(exitbutton == 4){
                System.out.println("**********NOW SHOWING ANALYSIS FOR AlmostOrder Data: ***************");

                // INSERTION SORT---------------------------------------------------------------------------------------------------------
                Scanner AlmostOrder = new Scanner(new File("src/Project13345/AlmostOrder.txt")); // open the AlmostOrder T-TIN number data set
                long[]dataList = getList(AlmostOrder);
                long start = System.nanoTime();
                InsertionSort.insertionSort(dataList);
                long elapsedTime = System.nanoTime() - start;
                System.out.println("Time elapsed: " + elapsedTime + "\n");

                // SELECTION SORT---------------------------------------------------------------------------------------------------------
                AlmostOrder = new Scanner(new File("src/Project13345/AlmostOrder.txt")); // open the AlmostOrder T-TIN number data set
                dataList = getList(AlmostOrder);
                start = System.nanoTime();
                SelectionSort.selectionSort(dataList);
                elapsedTime = System.nanoTime() - start;
                System.out.println("Time elapsed: " + elapsedTime + "\n");

                // RADIX SORT---------------------------------------------------------------------------------------------------------
                AlmostOrder = new Scanner(new File("src/Project13345/AlmostOrder.txt")); // open the AlmostOrder T-TIN number data set
                dataList = getList(AlmostOrder);
                //printList(dataList);
                RadixSort.numberOfMovements =0;
                start = System.nanoTime();
                RadixSort.radixsort(dataList, dataList.length);
                elapsedTime = System.nanoTime() - start;
                System.out.println("Time elapsed: " + elapsedTime + "\n");


                // HEAP SORT---------------------------------------------------------------------------------------------------------
                AlmostOrder = new Scanner(new File("src/Project13345/AlmostOrder.txt")); // open the AlmostOrder T-TIN number data set
                dataList = getList(AlmostOrder);
                HeapSort.numberOfMovements =0;
                start = System.nanoTime();
                HeapSort.sort(dataList);
                elapsedTime = System.nanoTime() - start;
                System.out.println("Time elapsed: " + elapsedTime + "\n");

                // MERGE SORT---------------------------------------------------------------------------------------------------------
                AlmostOrder = new Scanner(new File("src/Project13345/AlmostOrder.txt")); // open the AlmostOrder T-TIN number data set
                dataList = getList(AlmostOrder);
                MergeSort ob = new MergeSort();
                MergeSort.numberOfComparisons =0;
                start = System.nanoTime();
                ob.sort(dataList, 0, dataList.length - 1);
                elapsedTime = System.nanoTime() - start;

                System.out.println("Merge Sort: ");
                System.out.println("Total Number of Movements: N/A ");
                System.out.println("Total Number of Comparisons: " + MergeSort.numberOfComparisons);
                System.out.println("Time elapsed: " + elapsedTime + "\n");

                // QUICK SORT---------------------------------------------------------------------------------------------------------
                AlmostOrder = new Scanner(new File("src/Project13345/AlmostOrder.txt")); // open the AlmostOrder T-TIN number data set
                dataList = getList(AlmostOrder);
                start = System.nanoTime();
                long[] list3 = { 1, 0, 2, 6, 7, 8, 9, 10 }; // almost order
                quicksorttwo.numberOfMovements =0;
                quicksorttwo.numberOfComparisons =0;
                quicksorttwo.quickSort(list3, 0, list3.length - 1); // use dataList here to sort a datafile with less than 50000 I-TINS
                elapsedTime = System.nanoTime() - start;
                System.out.println("Quick Sort: ");
                System.out.println("Total Number of Movements: " + quicksorttwo.numberOfMovements);
                System.out.println("Total Number of Comparisons: " + (quicksorttwo.numberOfComparisons));
                printList(list3);
                System.out.println("Time elapsed: " + elapsedTime + "\n");

                System.out.println("FASTEST SORT FOR ALMOST: INSERTION SORT" );
                System.out.println("\n\n");
            }
        }while(exitbutton != 5);

    }

    public static void printList(long[] list){ // method for printing the array --- USED FOR DEBUGGING PURPOSES ONLY
        for(int i = 0; i < list.length; i++){
            System.out.println(list[i]);
        }
        System.out.printf("\n");
    }

    public static long[] getList(Scanner dataFile){ // read the data file and create and array

        String inputline; // read the input line
        long value; // long variable for storing the I-TIN number
        long[] list = new long[52768]; // create an array of size 52768 to hold 52768 unique I-TIN numbers
        int i = 0; // element position

        while(dataFile.hasNextLine()){ // while there is a number on the next line
            inputline = dataFile.nextLine(); // read the line
            try{
                value = Long.parseLong(inputline); // convert the line into a number
                list[i] = value; // store the number into the array
                i++; // increment array index
            }catch(NumberFormatException e){ // exception handling, incase the file is corrupt or contains anything other than nnumbers
                System.out.println("Please make sure the data exists");
            }
        }
        return list;
    }
}
