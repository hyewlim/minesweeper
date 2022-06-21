package vtp2022.workshop.app;

import java.util.Random;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class App 
{

    private int[][] fieldHidden = new int[10][10];
    private int[][] fieldVisible = new int[10][10];
    public static void main( String[] args )
    {
        // start()
       
    }

    public void startGame() {
        System.out.println("Welcome to Minesweeper!");

        boolean flag = true;
        while (flag) {
            // display visible
        }
    }

    public void setupField(int diff) {
        int noOfMines = 0;
        while(noOfMines!=10) {
            Random random = new Random();
            int i = random.nextInt(10);
            int j = random.nextInt(10);
            fieldHidden[i][j] = 100; //100 is CHEEBABOMB
            noOfMines++;
        }
    }


    public void buildHidden() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int cnt = 0;
                if ((fieldHidden[i][j])!=100) {
                    if (i!=0) {
                        if(fieldHidden[i-1][j]==100) cnt++;
                        if(j!=0) {
                            if(fieldHidden[i-1][j-1]==100) cnt++;
                        }
                    }
                    if (i!=9) {
                        if(fieldHidden[i+1][j]==100) cnt++;
                        if(j!=9) {
                            if(fieldHidden[i+1][j+1]==100) cnt++;
                        }
                    }

                    if(j!=0)
                    {
                        if(fieldHidden[i][j-1]==100) cnt++;
                        if(i!=9)
                        {
                            if(fieldHidden[i+1][j-1]==100) cnt++;
                        }
                    }
                    if(j!=9)
                    {
                        if(fieldHidden[i][j+1]==100) cnt++;
                        if(i!=0)
                        {
                            if(fieldHidden[i-1][j+1]==100) cnt++;
                        }
                    }

                    fieldHidden[i][j] = cnt;
                }
            }
        }
    }

    public void displayVisible() {
        System.out.println("\t ");
        for (int i = 0; i < 10; i++) {
            System.out.println(" " + i + " ");
        }
        System.out.println("\n");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "\t| ");
            for (int j = 0; j < 10; j++) {
                if (fieldVisible[i][j] == 0) {
                    System.out.println("?");
                } else if (fieldVisible[i][j] == 50) {
                    System.out.println(" ");
                } else {
                    System.out.println(fieldVisible[i][j]);
                }
                System.out.println(" | ");

                
            } System.out.println("\n ");
        }
    }

    public boolean playMove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Row Number: ");
        int i = sc.nextInt();
        System.out.println("Enter Column Number: ");
        int j = sc.nextInt();

        if(i<0 || i> 9 || j<0 || j>9 || fieldVisible[i][j]!=0) {
            System.out.println("\nIncorrect Input!");
            return true;
        }

        if(fieldHidden[i][j]==100){
            displayHidden();
            System.out.print("Oops! You stepped on a mine! \n============GAME OVER=============");
            return false;
        }

        else if(fieldHidden[i][j]==0) {
            fixVisible(i,j);
        }

        else {
            fixNeighbours(i,j);
        }


    }
}
