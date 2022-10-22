import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;


public class Battleship
{
    //Create 2 dimensional array that represents the board.
    private String board[][];
    public Battleship(){
        //Create 7 by 7 array for the game-board.
        this.board = new String [7][7];

        //Assign all values in the array to be equal to 0.
        for (int p = 0; p < 7; p++) {
            for (int i = 0; i < 7; i++) {
                board[p][i] = "O";
            }
        }



        //Generate random numbers to decide where to put the ship.
        Random random = new Random();
        int shipy = random.nextInt(7)+1;
        int shipx = random.nextInt(7)+1;


        //Determine where to put the ship in array bounds.
        if(shipx <= 3){
            board[shipy - 1][shipx] = "0";
            board[shipy - 1][shipx + 1] = "0";
            board[shipy - 1][shipx + 2] = "0";
            board[shipy - 1][shipx + 3] = "0";
        }
        //Determine where to put the ship in array bounds.
        if (shipx >= 4) {
            board[shipy - 1][shipx - 1] = "0";
            board[shipy - 1][shipx - 2] = "0";
            board[shipy - 1][shipx - 3] = "0";
            board[shipy - 1][shipx - 4] = "0";
        }



    }

    /**
     * Gathers visual display of the game-board.
     */
    public void display() {
        //Get values from each line of game-board.
        String line1 = Arrays.toString(board[0]);
        String line2 = Arrays.toString(board[1]);
        String line3 = Arrays.toString(board[2]);
        String line4 = Arrays.toString(board[3]);
        String line5 = Arrays.toString(board[4]);
        String line6 = Arrays.toString(board[5]);
        String line7 = Arrays.toString(board[6]);


        //make the game-board one variable so its more accessible
        String gameboard = ("1 " + line1 + "\n" + "2 " + line2 + "\n" + "3 " + line3 + "\n" + "4 " + line4 + "\n" + "5 " +line5 + "\n" + "6 " +line6 + "\n" + "7 " + line7);
        //displays the game-board
        System.out.println(gameboard);
    }


    /**
     * The guess method gets the users guess and displays it on the board. If the user lands a hit, an X is displayed where
     * they guessed on the board. If the ship is sunk, the game is over. If the user makes over 20 guesses, the game is
     * over.
     */
    public void guess(){
        System.out.println("Welcome to Battleship! Can you find the hidden ship in time?");
        System.out.println("*note that there is one horizontal ship");
        Scanner scanner = new Scanner(System.in);
        String userguessLetter;
        int userguessNum;
        int conv = 0;
        int count = 0;
        int moveCount = 0;
        //Display how many moves the user has left.
        System.out.println("You have " + (20 - moveCount) + " moves left!");

        //Condition for game to continue. While the ship has not sunk and the user has not had over 20 guesses.
        while ((count != 4) && (moveCount <= 20)){
            //User makes a guess A - G (the first 7 letters of the alphabet)
            System.out.print("Make a guess. Enter a letter (A-G): ");
            userguessLetter = scanner.next();

            //user makes a guess 1 - 7
            do{
                System.out.print("Enter a number (1-7): ");
                userguessNum = scanner.nextInt();
            }while(userguessNum > 7 || userguessNum < 1);

            userguessNum -= 1;

            //Set the letter to its corresponding location as an int in the array.
            if (userguessLetter.equals("A")) {
                conv = 0;
            }
            if (userguessLetter.equals("B")) {
                conv = 1;
            }
            if (userguessLetter.equals("C")) {
                conv = 2;
            }
            if (userguessLetter.equals("D")) {
                conv = 3;
            }
            if (userguessLetter.equals("E")) {
                conv = 4;
            }
            if (userguessLetter.equals("F")) {
                conv = 5;
            }
            if (userguessLetter.equals("G")) {
                conv = 6;
            }


            //If the user lands a hit, display that the user landed a hit and increase the hit counter by 1.
            if (board[userguessNum][conv].equals("0")){
                System.out.println("HIT!!!");
                count += 1; //increase count
            }
            //if the user misses, display that they missed.
            else{
                System.out.println("MISS!");
            }
            //Place an X where the user guessed
            board[userguessNum][conv] = "X";
            //Display the game-board
            System.out.println("-----------------------");
            System.out.println("   A  B  C  D  E  F  G");
            System.out.println("-----------------------");
            display();
            System.out.println("-----------------------");
            //Display what the user guessed
            System.out.println("GUESS: " + userguessLetter + (userguessNum + 1));
            //If the user sunk the ship, display that they won.
            if (count == 4){
                System.out.println("YOU WIN!!!");
            }
            //Increment total moves.
            moveCount += 1;
            //Display the amount of moves the user has left.
            System.out.println("You have " + (20 - moveCount) + " moves left!");

        }

    }

}