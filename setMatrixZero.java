public class Solution {

    public void setZeroes(int[][] matrix) {

        if(matrix == null || matrix.length == 0)

            return;

        // use two arrays to store whether this row/column should be set to zero

        boolean row[] = new boolean[matrix.length];

        boolean column[] = new boolean[matrix[0].length];

        for(int i = 0; i < matrix.length; i++)

            for(int j = 0; j < matrix[0].length; j++){

                if(matrix[i][j] == 0){

                    row[i] = true;

                    column[j] = true;

                }

            }

        // then set corresponding row/column to zero

        // every row/column only needs to be set once

        for(int i = 0; i < matrix.length; i++){

            if(row[i])

                setToZero(matrix, i, true);

        }

        for(int j = 0; j < matrix[0].length; j++){

            if(column[j])

                setToZero(matrix, j, false);        

        }

    }

    public void setToZero(int[][] matrix, int num, boolean row){

        if(row){

            for(int j = 0; j < matrix[0].length; j++)

                matrix[num][j] = 0;

        }

        else {

            for(int i = 0; i < matrix.length; i++)

                matrix[i][num] = 0;

        }

    }

}
