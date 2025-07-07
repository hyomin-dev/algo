package com.multi.knowledge.simulation;


import java.util.Arrays;

public class Rotation90 {
    static int[][] resultMatrix;
    public static void main(String[] args) {
        int[][] matrix3x3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("3x3 original:");
        for(int i=0;i<matrix3x3.length;i++)
            System.out.println(Arrays.toString(matrix3x3[i]));

        System.out.println("==============================================================");
        transpose(matrix3x3);
        reverseLeftRight(matrix3x3);
        System.out.println("오른쪽 90도 회전");
        for(int i=0;i<matrix3x3.length;i++)
            System.out.println(Arrays.toString(matrix3x3[i]));
        System.out.println("==============================================================");
        int[][] matrix3x3_2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        transpose(matrix3x3_2);
        reverseTopDown(matrix3x3_2);
        System.out.println("왼쪽 90도 회전");
        for(int i=0;i<matrix3x3_2.length;i++)
            System.out.println(Arrays.toString(matrix3x3_2[i]));
        System.out.println("==============================================================");


        int[][] matrix4x4 = {
                { 1,  2,  3,  4},
                { 5,  6,  7,  8},
                { 9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        System.out.println("4x4 original:");
        for(int i=0;i<matrix4x4.length;i++)
            System.out.println(Arrays.toString(matrix4x4[i]));
        System.out.println("==============================================================");
        transpose(matrix4x4);
        reverseLeftRight(matrix4x4);
        System.out.println("오른쪽 90도 회전");
        for(int i=0;i<matrix4x4.length;i++)
            System.out.println(Arrays.toString(matrix4x4[i]));
        System.out.println("==============================================================");
        int[][] matrix4x4_2 = {
                { 1,  2,  3,  4},
                { 5,  6,  7,  8},
                { 9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        transpose(matrix4x4_2);
        reverseTopDown(matrix4x4_2);
        System.out.println("왼쪽 90도 회전");
        for(int i=0;i<matrix4x4_2.length;i++)
            System.out.println(Arrays.toString(matrix4x4_2[i]));
        System.out.println("==============================================================");

        int[][] matrix3x5 = {
                { 1,  2,  3,  4,  5},
                { 6,  7,  8,  9, 10},
                {11, 12, 13, 14, 15}
        };
        System.out.println("3x5 original:");
        for(int i=0;i<matrix3x5.length;i++)
            System.out.println(Arrays.toString(matrix3x5[i]));
        System.out.println("==============================================================");

        transpose(matrix3x5);
        reverseLeftRight(resultMatrix);
        System.out.println("오른쪽 90도 회전");
        for(int i=0;i<resultMatrix.length;i++)
            System.out.println(Arrays.toString(resultMatrix[i]));
        System.out.println("==============================================================");
        int[][] matrix3x5_2 = {
                { 1,  2,  3,  4,  5},
                { 6,  7,  8,  9, 10},
                {11, 12, 13, 14, 15}
        };
        transpose(matrix3x5_2);
        reverseTopDown(resultMatrix);
        System.out.println("왼쪽 90도 회전");
        for(int i=0;i<resultMatrix.length;i++)
            System.out.println(Arrays.toString(resultMatrix[i]));
        System.out.println("==============================================================");


        int[][] matrix5x3 = {
                { 1,  2,  3},
                { 4,  5,  6},
                { 7,  8,  9},
                {10, 11, 12},
                {13, 14, 15}
        };

        System.out.println("5x3 original:");
        for(int i=0;i<matrix5x3.length;i++)
            System.out.println(Arrays.toString(matrix5x3[i]));
        System.out.println("==============================================================");

        transpose(matrix5x3);
        reverseLeftRight(resultMatrix);
        System.out.println("오른쪽 90도 회전");
        for(int i=0;i<resultMatrix.length;i++)
            System.out.println(Arrays.toString(resultMatrix[i]));
        System.out.println("==============================================================");
        int[][] matrix5x3_2 = {
                { 1,  2,  3},
                { 4,  5,  6},
                { 7,  8,  9},
                {10, 11, 12},
                {13, 14, 15}
        };
        transpose(matrix5x3_2);
        reverseTopDown(resultMatrix);
        System.out.println("왼쪽 90도 회전");
        for(int i=0;i<resultMatrix.length;i++)
            System.out.println(Arrays.toString(resultMatrix[i]));
        System.out.println("==============================================================");

    }

    static void transpose(int[][] matrix){

        int row = matrix.length;
        int col = matrix[0].length;

        if(row==col){
            for(int y=0;y<row;y++){
                for(int x=y+1;x<col;x++){
                    int tmp = matrix[y][x];
                    matrix[y][x] = matrix[x][y];
                    matrix[x][y] = tmp;
                }
            }
        }else{
            resultMatrix = new int[col][row];
            for(int y=0;y<row;y++){
                for(int x=0;x<col;x++){
                    resultMatrix[x][y] = matrix[y][x];
                }
            }
        }
    }

    static void reverseLeftRight(int[][] matrix){

        /*
           N = 4
        *  0 1 2 3
        *  3 2 1 0
        *  n-1, n-2, n-3 ,n-4

           N = 5
           0 1 2 3 4
           4 3 2 1 0
           n-1, n-2, n-3, n-4, n-5
        *
        * */

        int row = matrix.length;
        int col = matrix[0].length;

        for(int y=0;y<row;y++){
            for(int x=0;x<col/2;x++){

                int tmp = matrix[y][x];
                matrix[y][x] = matrix[y][col-x-1];
                matrix[y][col-x-1] = tmp;
            }
        }
    }

    static void reverseTopDown(int[][] matrix){

        /*
          N = 4
          0 - 0 --> n-4
          4 - 1 --> n-3
          8 - 2 --> n-2
          12 - 3 --> n-1

          12 - 3 --> n-1
          8 - 2 --> n-2
          4 - 1 --> n-3
          0 - 0 --> n-4

          N = 5
          0 - 0 --> n-5
          5 - 1 --> n-4
          10 - 2 --> n-3
          15 - 3 --> n-2
          20 - 4 --> n-1

          20 - 4 --> n-1
          15 - 3 --> n-2
          10 - 2 --> n-3
          5 - 1 --> n-4
          0 - 0 --> n-5

        *
        *
        * */

        int row = matrix.length;
        int col = matrix[0].length;

        for(int y=0;y<row/2;y++){
            for(int x=0;x<col;x++){

                int tmp = matrix[y][x];
                matrix[y][x] = matrix[row-y-1][x];
                matrix[row-y-1][x] = tmp;
            }
        }
    }


}
