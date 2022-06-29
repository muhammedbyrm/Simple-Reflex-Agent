package com.company;

public class Environment {


    private final int[][] matrix = randomMatrixGenerator();

    public int[][] getMatrix() {
        return matrix;
    }

    public void setPosition(int[][] matrix, int row, int column){
        matrix[row][column] = 0;
    }


    private int[][] randomMatrixGenerator(){
        int[][] a=new int[4][4];
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                a[i][j]= (int)Math.round(Math.random());
            }
        }
        return a;
    }

    public boolean isDirty(int[][] matrix, int row, int column){
        if(matrix[row][column] == 1){
            return true;
        }
        else {
            return false;
        }
    }

    public void clean(int[][] matrix, int row, int column){
        matrix[row][column] = 0;
    }

    public int countOnes(int[][] matrix){
        int count=0;

        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++){
                if(matrix[i][j] == 1)
                    count += 1;
            }
        }
        return count;
    }

    public void printMatrix(int[][] arr, int row , int column){

        char[][] charArray = convertIntArrToChar(arr); //in order to put 'x' for current position

        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(i == row &&  j == column){
                    charArray[i][j] = 'x';
                }
                System.out.print(charArray[i][j]+"\t");
            }
            System.out.print("\n");
        }
    }

    private char[][] convertIntArrToChar(int[][] arr){
        char[][] charArray = new char[4][4];

        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(arr[i][j] == 0 )
                    charArray[i][j] = '0';
                else
                    charArray[i][j] = '1';
            }
        }
        return charArray;
    }
}
