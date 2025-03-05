package SudokuJava;

import java.util.ArrayList;
import java.util.List;

public class PuzzleGenerator {
    int [][] grid;
    int size;
    Validator v;
    public PuzzleGenerator(int size){
        
        
        this.size=size;
        grid =emptyGrid();
        v= new Validator(size);
    }


    public int[][] gridOut(){
        int[][] grid0 =grid;
        List<Integer> nums= new ArrayList<>();
        int currentTry=0;
        while(true){
            grid0=emptyGrid();
            for(int i=0;i<size;i++){
                for(int j=0;j<size;j++){

                    while(true){
                        currentTry=(int)(Math.random()*size)+1;
                        grid0[i][j]=currentTry;
                        if(nums.contains(currentTry)==false)
                            nums.add(currentTry);

                        if(v.checkPuzzle(grid0)){
                            break;
                        }

                        if(nums.size()==size)
                            break;

                    }
                    nums.clear();
                }
            }
            if(v.isFull(grid0)&&v.checkPuzzle(grid0))
                break;
        }

        return grid0;
    }

    public void gridPrint(int[][] grid){
         //print grid
       for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid.length;j++){
            System.out.print(grid[i][j]);
        }
        System.out.println();
       }
    }
    public int[][] emptyGrid(){
        int[][] empty= new int[size][size];
        for(int i=0;i<size;i++)
            for(int j=0;j<size;j++)
                empty[i][j]=0;
        
        return empty;
    }
}
