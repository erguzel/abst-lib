package com.sicsrobotics.util.search;

/**
 * Numeric search
 */
public class Numeric {

    /**
     * finds max of a given integer array
     * @param integers given integer array
     * @return max of an int array
     */
    public static int max(int[] integers){


        int max = 0;

        for (int i = 0; i<integers.length; i++){

            max = integers[i]> max ? integers[i] : max;

        }

        return max;

    }

    /**
     * finds min of a given integer array
     * @param integers given integer array
     * @return min of an int array
     */
    public static int min(int[] integers){


        int min = 0;

        for (int i = 0; i<integers.length; i++){

            min = integers[i]< min ? integers[i] : min;
        }

        return min;

    }

    /**
     * Sorts integers
     * @param integers integers to sort
     * @return sorted integers
     */
    public static int[] SortAsc(int[] integers){

        int min = 0;
        int minId = 0;
        int temp = 0;
        for (int i=0; i<integers.length;i++){
            min = integers[i];
            minId = i;

            for(int j = i+1; j<integers.length; j++){

                if(integers[j] < min){
                    min = integers[j];
                    minId = j;
                }
            }

            temp = integers[i];
            integers[i] = min;
            integers[minId] = temp;
        }

        return integers;

    }
}
