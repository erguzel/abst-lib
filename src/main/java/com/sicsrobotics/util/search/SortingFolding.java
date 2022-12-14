package com.sicsrobotics.util.search;

public class SortingFolding {

    /**
     * sorts int array descending
     * @param intarray array to sort
     */
    public static void Sort(int[] intarray){

//TODO check sort algo
        //todo decimals doubles
        int idx = 0;
        int revidx = 0;
        boolean loop = true;
        int val = 0;

        while (loop){

            revidx = intarray.length - 1 - idx;


            if(intarray[idx+1] > intarray[idx]){

                val = intarray[idx];

                intarray[idx] = intarray[idx+1];

                intarray[idx+1] = val;

            }

            if(intarray[revidx] > intarray[revidx-1]){

                val = intarray[revidx];

                intarray[revidx] = intarray[revidx-1];

                intarray[revidx-1] = val;

            }


            if(idx < intarray.length-1){

                idx = idx +1;
            }

            loop = idx == intarray.length-1 ? false:true;

        }


    }

    public static void Sort(int[] intarray, boolean withFor){


        int idx = 0;
        int max = Integer.MIN_VALUE;
        int temp = 0;

        for (int i =0; i < intarray.length; i++){

            for (int h = i; h < intarray.length; h++ ){

                if(intarray[h] > max){

                    max = intarray[h];
                    idx = h;
                }


            }

            temp = intarray[i];
            intarray[i] = intarray[idx];
            intarray[idx] = temp;
            max = Integer.MIN_VALUE;


        }


    }

    /**
     * reverses given arra
     * @param array array to reverse
     * @param withWhile trivial boolean for method signature
     */
    public static void Reverse(Object[] array, boolean withWhile) {

        int idxn = 0;
        int didx = 0;
        Object var = 0;
        boolean sort = true;

        while (sort) {

            didx = array.length - idxn - 1;

            sort = didx - idxn <= 1 ? false : true;

            var = array[idxn];

            array[idxn] = array[didx];

            array[didx] = var;

            idxn = idxn + 1;

        }
    }

    /**
     * reverses given array
     * @param array array to reverse
     */
    public static void Reverse(Object[] array){

        Object tempVar = null;

        //current index
        int idx = 0;
        //reverse symmetric index
        int ridx = 0;

        boolean shouldEnd = false;


        for(int i = 0; i<array.length; i ++){

            idx = i;
            ridx = array.length-1-i;

            shouldEnd =  ridx - idx <= 1 ;

            tempVar = array[idx];

            array[idx] =  array[ridx];
            array[ridx] =  tempVar;

            if(shouldEnd)
                break;


        }

    }

    /**
     * Genedata sample interview question
     * @param input
     */
    public static void reversArray(int [] input) {
        if (input == null) {
            System.out.println("Input value can not be null!!");
            System.exit(0);
        }

        int indx = 0;
        int revIdx = 0;
        int temp = 0;

        for (int i = 0; i < input.length / 2; i++) {
            indx = i;
            revIdx = input.length - indx - 1;
            //swap correspondign values
            temp = input[indx];
            input[indx] = input[revIdx];
            input[revIdx] = temp;
            boolean isEnd = Math.abs(revIdx - indx) <= 1;
            if (isEnd) return;
        }
    }

    public static int[] reverseArray(int[] array){

        int idx = 0;
        int revidx = 0;
        int tempVal = 0;
        boolean shouldEnd = false;
        int halflength = array.length/2 + 1;

        for(int i = 0; i < halflength; i++){

            idx = i;
            revidx = array.length-1-idx;

            tempVal = array[idx];
            array[idx] = array[revidx];
            array[revidx] = tempVal;

            shouldEnd = Math.abs(revidx-idx)<= 1;

            if (shouldEnd)
                return array;


        }

        return new int[]{-1};
    }

    public static int[] sortArray(int[] array,boolean descending){

        int tempVal = 0;

        for(int i = 0; i<array.length; i++){

            for(int j = i+1; j<array.length; j++){

                if(descending){

                    boolean shouldSwap = array[j] > array[i];

                    if(shouldSwap){

                        tempVal = array[j];
                        array[j] = array[i];
                        array[i] = tempVal;
                    }

                }else {

                    boolean shouldSwap = array[i] > array[j];

                    if(shouldSwap){

                        tempVal = array[i];
                        array[i] = array[j];
                        array[j] = tempVal;
                    }
                }

            }

        }

        return array;
    }


}
