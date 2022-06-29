package com.company;
import java.util.Random;

public class Agent {
    private int startPositionX;
    private int startPositionY;
    private int numberOfCleanedItems;
    private int nextMove;
    private int numberOfSteps=0;


    public Agent(int startPositionX, int startPositionY) {
        if (startPositionX >= 0 && startPositionX < 4) {
            this.startPositionX = startPositionX;
        } else {
            this.startPositionX = (int) (Math.random() * (4));
        }

        if (startPositionY >= 0 && startPositionY < 4) {
            this.startPositionY = startPositionY;
        } else {
            this.startPositionY = (int) (Math.random() * (4));
        }
    }

    public void BeginCleaning(Environment e) {
        e.setPosition(e.getMatrix(), this.startPositionX, this.startPositionY);
        System.out.println("Start position is:" + this.startPositionX + "," + this.startPositionY);
        e.printMatrix(e.getMatrix(), this.startPositionX, this.startPositionY);
        System.out.println("Total number of ones " + e.countOnes(e.getMatrix()));
        System.out.println("******************");

        int row = this.startPositionX; //current row
        int column = this.startPositionY; //current column

        nextMove = new Random().nextInt(4) + 1;

        int totalDirt=e.countOnes(e.getMatrix());

        while(numberOfCleanedItems < totalDirt ){

            switch (nextMove){
                case 1: //move right
                    if(column == 3){ //if we cannot move right, select a new random position rather than move right
                        while(nextMove == 1) {
                            nextMove = new Random().nextInt(4) + 1;
                            break;
                        }
                    }
                    else{
                        column += 1;
                        if(e.isDirty(e.getMatrix(), row, column)){
                            e.clean(e.getMatrix(), row, column);
                            numberOfCleanedItems += 1;
                        }
                        System.out.println("Agent position is " + row + "-" + column);
                        e.printMatrix(e.getMatrix(), row, column);
                        e.setPosition(e.getMatrix(), row, column);
                        numberOfSteps += 1;
                        nextMove = new Random().nextInt(4) + 1;
                    }
                    break;

                case 2: //move left

                    if(column == 0){
                        while(nextMove == 2) {
                            nextMove =new Random().nextInt(4) + 1;
                            break;
                        }
                    }
                    else{
                        column -= 1;
                        if(e.isDirty(e.getMatrix(), row, column)){
                            e.clean(e.getMatrix(), row, column);
                            numberOfCleanedItems += 1;
                        }
                        System.out.println("Agent position is " + row + "-" + column);
                        e.printMatrix(e.getMatrix(), row, column);
                        e.setPosition(e.getMatrix(), row, column);
                        numberOfSteps += 1;
                        nextMove = new Random().nextInt(4) + 1;
                    }
                    break;

                case 3: //move up
                    if(row == 0){
                        while(nextMove == 3) {
                            nextMove = new Random().nextInt(4) + 1;
                            break;
                        }
                    }
                    else{
                        row -= 1;
                        if(e.isDirty(e.getMatrix(), row, column)){
                            e.clean(e.getMatrix(), row, column);
                            numberOfCleanedItems += 1;
                        }
                        System.out.println("Agent position is " + row + "-" + column);
                        e.printMatrix(e.getMatrix(), row, column);
                        e.setPosition(e.getMatrix(), row, column);
                        numberOfSteps += 1;
                        nextMove = new Random().nextInt(4) + 1;
                    }
                    break;

                case 4:
                    if(row == 3){ //move down
                        while(nextMove == 4) {
                            nextMove = new Random().nextInt(4) + 1;
                            break;
                        }
                    }
                    else{
                        row += 1;
                        if(e.isDirty(e.getMatrix(), row, column)){
                            e.clean(e.getMatrix(), row, column);
                            numberOfCleanedItems += 1;
                        }
                        System.out.println("Agent position is " + row + "-" + column);
                        e.printMatrix(e.getMatrix(), row, column);
                        e.setPosition(e.getMatrix(), row, column);
                        numberOfSteps += 1;
                        nextMove = new Random().nextInt(4) + 1;
                    }
                    break;

                default:
                    System.out.println("There is a problem about nextMove.");
                    break;
            }
        }
        System.out.println("Number of cleaned item " + numberOfCleanedItems);
        System.out.println("Total number of steps " + numberOfSteps);
    }
}
