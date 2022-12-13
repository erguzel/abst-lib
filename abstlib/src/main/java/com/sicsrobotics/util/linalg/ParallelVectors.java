package com.sicsrobotics.util.linalg;

import com.sicsrobotics.util.exeption.SicsException;
import com.sicsrobotics.util.thread.SicsCallable;
import com.sicsrobotics.util.thread.SicsThread;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelVectors {

    private static Integer[][] _resultantMatrix = null;


    private class FillResultantMatrixThread extends SicsThread {

        private int _rowLength;
        private int _colLength;

        /**
         * Should get col and row indices or itself
         * Should decide which index pair is the inner product belong to
         * Should set the inner product to the index pair on that matrix
         *
         * @param pseudoId
         */
        public FillResultantMatrixThread(long pseudoId, int rowLentg, int colLength) {
            super(pseudoId);
            this._colLength = colLength;
            this._rowLength = rowLentg;
            LOGGER.info("colLenth"+colLength+"-"+pseudoId+"=="+Thread.currentThread().getName());
            LOGGER.info("rowLenth"+rowLentg+"-"+pseudoId+"=="+Thread.currentThread().getName());

        }

        @Override
        public void run() {
            LOGGER.info("Run method started::" +
                    "" + this.getPseudoId()+"="+Thread.currentThread().getName());

            int rowIndex = 0;
            int colIndex = 0;
            int[] row = {1, 2, 3};
            int[] col = {1, 2,3};
            int result = 0;
            try {
                LOGGER.info("Trying inner product:" +
                        "" + this.getPseudoId()+"="+Thread.currentThread().getName());
                result = Vectors.innerProduct(row, col);
            } catch (Throwable e) {
                SicsException.HandleSlient("FillResultantMatrix thread failed on" +
                                " inner product operation", false, true, e);

            }
            LOGGER.info("Catche passed:" + this.getPseudoId()+"="+Thread.currentThread().getName());
            _resultantMatrix[rowIndex][colIndex] = result;
        }
    }
    private class FillResultantMatrixTask extends SicsCallable<Integer[][]> {
        private final int _rowLength;

        public FillResultantMatrixTask(long pseudoId, int _rowLength, int _colLength) {
            super(pseudoId);
            this._rowLength = _rowLength;
            this._colLength = _colLength;

            LOGGER.info("Initialized fill resultant matrix"+"="+Thread.currentThread().getName());

        }

        private final int _colLength;



        @Override
        public Integer[][] call() throws Exception {
            int rowIndex = 0;
            int colIndex = 0;
            int[] row = {1, 2, 3};
            int[] col = {1, 2};
            int result = 0;
            try {
                result = Vectors.innerProduct(row, col);
            } catch (Throwable e) {
                SicsException.Handle("FillResultantMatrix thread failed on inner product " +
                        "operation",
                        false, false, true, e);

            }
            _resultantMatrix[rowIndex][colIndex] = result;
            return  _resultantMatrix;
        }
    }
    public Integer[][] resultant(int[][] matrix1, int[][] matrix2) throws Exception {
        _resultantMatrix = new Integer[matrix1.length][matrix2[0].length];
        int numOfThreads = matrix1.length * matrix2[0].length;

        Set<SicsThread> threads = IntStream.range(1, numOfThreads + 1)
                .mapToObj(a -> new FillResultantMatrixThread(a,
                        matrix1.length, matrix2[0].length))
                .collect(Collectors.toSet());

        threads.forEach(Thread::start);
     //   FillResultantMatrixTask ft = new FillResultantMatrixTask(1,2,3);
       // _resultantMatrix =  ft.call();

        try {
            Thread.sleep(3000);
        } catch (Throwable e) {
            SicsException.Handle("Resultant method failed",
                    false, true, false, e);

        }
        return _resultantMatrix;
    }

}
