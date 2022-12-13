package com.sicsrobotics.util.linalg;

public class Vectors {
    /**
     * gets column of a matrix
     * @param mtx matrix
     * @param idx column id
     * @return column
     * @throws Exception
     */
    public static int[] getColumn(int[][] mtx, int idx) throws VectorDimensionsNotMatchedException {
        if(idx > mtx[0].length)
            throw new VectorDimensionsNotMatchedException("Desired column index must be less than number of columns");
        int[] res  =  new  int[mtx[0].length];
        for(int i = 0 ; i < mtx.length; i++){
            res[i] = mtx[i][idx];
        }
        return res;
    }

    public static int innerProduct(int[] vec1, int[] vec2) throws VectorDimensionsNotMatchedException {
        if(vec1 == null || vec2 == null)
            throw new NullPointerException("Vectors can not be null for inner product operatopn");
        if (vec1.length!=vec2.length)
            throw new VectorDimensionsNotMatchedException("Dimensions of given vectors do not match for vector inner product operaton");
        int res =  0;
        for(int i = 0; i<vec1.length; i++){
            res = res + vec1[i] * vec2[i];
        }
        return res;
    }

    public static int[][] resultant (int[][] m1, int [][] m2) throws VectorDimensionsNotMatchedException {
        if(m1 == null || m2 == null)
            throw new NullPointerException("Matrices can not be null for resultant product operatopn");
        if (m1.length!=m2[0].length)
            throw new IllegalArgumentException("Dimensions of given matrices do not match for vector resultant product operaton");
        int [] col ;
        int [] row;
        int res[][] = new int[m1.length][m2[0].length];
        for(int i = 0 ; i < m1.length; i ++){
            row = m1[i];
            for(int j = 0; j< m2[0].length; j++){
                col = getColumn(m2,j);
                res[i][j] = innerProduct(row,col);
            }
        }
        return res;
    }
}
