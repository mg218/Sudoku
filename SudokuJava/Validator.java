package SudokuJava;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    
    int size;
    int matriceSize;
    public Validator(int size){
        
        this.size=size;
        double s = size;
        matriceSize=(int)Math.sqrt(s);
    }
    //does the other 3 methods to check puzzle's correctness.
    public boolean checkPuzzle(int[][] grid){

        if(checkCols(grid)==true&&checkRows(grid)==true&&checkMatrices(grid)==true)
            return true;
        else
            return false;
    }
    //check horizontally for no repeats
    public boolean checkRows(int[][] grid){
        List<Integer> nums = new ArrayList<>();
        //cycles through each row
        for(int i=0;i<grid[0].length;i++){
            for(int j=0;j<grid.length;j++){
                int curNum=grid[i][j];
                if(curNum!=0){
                    if(nums.contains(curNum))
                        return false;
                    else
                        nums.add(curNum);
                }
            }
            //clear the list of numbers for the next pass through
            nums.clear();
        }
        //if the pass through did not detect a duplicate in any of the rows return true
        return true;
    }
    //Check vertical columns 
    public boolean checkCols(int[][] grid){
        List<Integer> nums = new ArrayList<>();
        for(int j=0; j<grid[0].length; j++){  // Iterate through columns
            for(int i=0; i<grid.length; i++){ // Iterate through rows
                int curNum = grid[i][j];  // Now correctly accessing columns
                if(curNum != 0){
                    if(nums.contains(curNum))
                        return false;
                    else
                        nums.add(curNum);
                }
            }
            nums.clear(); // Clear after checking each column
        }
        return true;
    }
    

    //checks the square matrices to make sure there are no repeats
    public boolean checkMatrices(int[][] grid){
        List<Integer> nums = new ArrayList<>();
        //outer 2 nested loops cycle through the different matrices
        for(int i=0;i<matriceSize;i++){
            for(int j=0;j<matriceSize;j++){
                //inner 2 cycle through the spots in each matrice
                
                for(int k=i*matriceSize;k<(i+1)*matriceSize;k++){
                    for(int l=j*matriceSize;l<(j+1)*matriceSize;l++){
                        if(grid[k][l]!=0){
                            if(nums.contains(grid[k][l])){
                                return false;
                            }
                            else{
                                nums.add(grid[k][l]);
                            }
                        }
                    }
                }
                nums.clear();
            }
        }

        return true;
    }

    public boolean isFull(int[][] grid){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j]==0)
                    return false;
            }
        }
        return true;
    }
}
