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
    //Works only with 9x9 default grids at the moment
    public int[][] finishedGrid(int diffficulty,boolean useExisting, int[][] existingGrid){
        int[][] fullPuzzle;
        if(useExisting==true){
            fullPuzzle=existingGrid;
        }else{
            fullPuzzle=gridOut();
        }
        int numRemove=0;//Variable that decides which difficulty to use
        switch (diffficulty) {
            case 0://easy difficulty
                numRemove=(int)(Math.random()*30)+25;
                break;
            case 1://medium
                numRemove=(int)(Math.random()*45)+35;
                break;
            case 2://hard
                numRemove=(int)(Math.random()*55)+48;
                break;
            case 3://very hard
                numRemove=(int)(Math.random()*69)+57;
                break;
            default:
                System.err.println("Valid Difficult not entered");
                break;
        }
        int yesno=0;
        while(true){//keep 
            gridLoop:
            for(int i=0;i<size;i++){
                for(int j=0;j<size;j++){
                    yesno=(int)(Math.random()*2)+1;
                    if(yesno==2){
                        fullPuzzle[i][j]=0;
                        numRemove--;
                    }
                    if(numRemove<=0)
                        break gridLoop;
                }
            }
            if(numRemove<=0)
                break;

        }


        return fullPuzzle;
    }
}
