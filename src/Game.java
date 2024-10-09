import java.util.Scanner;

public class Game {

    /* char board makes a 2d arraylist with the use of 2 [][], one [] would be a regular arraylist
       Currentplayer is used to keep track of players turn. p1 and p2 is the different players, both player
       variables are collected from the Player class. */
    char[][] board;
    Player currentPlayer;
    Player p1, p2;

    // this is what starts the game and how it will look, currentPlayer is to decide who starts.
    public Game(Player p1, Player p2) {
        this.board = new char[][]{
                {' ', '║', ' ', '║', ' '},
                {'═', '╬', '═', '╬', '═'},
                {' ', '║', ' ', '║', ' '},
                {'═', '╬', '═', '╬', '═'},
                {' ', '║', ' ', '║', ' '}};

        this.p1 = p1;
        this.p2 = p2;
        this.currentPlayer = p1;
    }
        // Makes up the board as in the char list above
    public void boardPosition() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
        //Looping to see if a space is free for the taking
    public void placingMarker() {
        Scanner scanner = new Scanner(System.in);
        boolean validMove = false;
        while (!validMove) {
            System.out.println(currentPlayer.getName() + " (" + currentPlayer.getMarker() + "), enter a number 1-9");
            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    if (board[0][0] == ' ') {
                        board[0][0] = currentPlayer.getMarker();
                        validMove = true;
                    } else {
                        System.out.println("Place is occupied.");
                    }
                    break;
                case 2:
                    if (board[0][2] == ' ') {
                        board[0][2] = currentPlayer.getMarker();
                        validMove = true;
                    } else {
                        System.out.println("Place is occupied.");
                    }
                    break;
                case 3:
                    if (board[0][4] == ' ') {
                        board[0][4] = currentPlayer.getMarker();
                        validMove = true;
                    } else {
                        System.out.println("Place is occupied.");
                    }
                    break;
                case 4:
                    if (board[2][0] == ' ') {
                        board[2][0] = currentPlayer.getMarker();
                        validMove = true;
                    } else {
                        System.out.println("Place is occupied.");
                    }
                    break;
                case 5:
                    if (board[2][2] == ' ') {
                        board[2][2] = currentPlayer.getMarker();
                        validMove = true;
                    } else {
                        System.out.println("Place is occupied.");
                    }
                    break;
                case 6:
                    if (board[2][4] == ' ') {
                        board[2][4] = currentPlayer.getMarker();
                        validMove = true;
                    } else {
                        System.out.println("Place is occupied.");
                    }
                    break;
                case 7:
                    if (board[4][0] == ' ') {
                        board[4][0] = currentPlayer.getMarker();
                        validMove = true;
                    } else {
                        System.out.println("Place is occupied.");
                    }
                    break;
                case 8:
                    if (board[4][2] == ' ') {
                        board[4][2] = currentPlayer.getMarker();
                        validMove = true;
                    } else {
                        System.out.println("Place is occupied.");
                    }
                    break;
                case 9:
                    if (board[4][4] == ' ') {
                        board[4][4] = currentPlayer.getMarker();
                        validMove = true;
                    } else {
                        System.out.println("Place is occupied.");
                    }
                    break;

                default:
                    System.out.println("Number between 1-9.");
                    break;
            }
        }
    }

    // Checking who won
    public boolean checkWinner() {
        if      ((board[0][0] == currentPlayer.getMarker() && board[0][2] == currentPlayer.getMarker() && board[0][4] == currentPlayer.getMarker()) ||
                (board[2][0] == currentPlayer.getMarker() && board[2][2] == currentPlayer.getMarker() && board[2][4] == currentPlayer.getMarker()) ||
                (board[4][0] == currentPlayer.getMarker() && board[4][2] == currentPlayer.getMarker() && board[4][4] == currentPlayer.getMarker())) {
            return true;
        }

        if      ((board[0][0] == currentPlayer.getMarker() && board[2][0] == currentPlayer.getMarker() && board[4][0] == currentPlayer.getMarker()) ||
                (board[0][2] == currentPlayer.getMarker() && board[2][2] == currentPlayer.getMarker() && board[4][2] == currentPlayer.getMarker()) ||
                (board[0][4] == currentPlayer.getMarker() && board[2][4] == currentPlayer.getMarker() && board[4][4] == currentPlayer.getMarker())) {
            return true;
        }

        if      ((board[0][0] == currentPlayer.getMarker() && board[2][2] == currentPlayer.getMarker() && board[4][4] == currentPlayer.getMarker()) ||
                (board[0][4] == currentPlayer.getMarker() && board[2][2] == currentPlayer.getMarker() && board[4][0] == currentPlayer.getMarker())) {
            return true;
        }

        return false;
    }
    // This loop keeps going until someone has won or all 9 spaces are filled
    public void gameRound() {
        int totalMoves = 0;

        while (totalMoves < 9) {
            boardPosition();
            placingMarker();

            if (checkWinner()) {
                boardPosition();
                System.out.println(currentPlayer.getName() + " (" + currentPlayer.getMarker() + ") wins!");
                return;
            }

            currentPlayer = (currentPlayer == p1) ? p2 : p1;
            totalMoves++;
        }
        System.out.println("It's a tie!");
    }


    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            gameRound(); // Start another game

            System.out.println("Do you want to play again? (y/n)");
            String response = scanner.next();

            if (!response.equalsIgnoreCase("y")) {
                playAgain = false; // if player presses N/n the game closes
                System.out.println("Thanks for playing!");
            } else {
                resetBoard(); // reset board is below to get a new playboard
            }
        }
    }
    public void resetBoard() {
        this.board = new char[][]{
                {' ', '║', ' ', '║', ' '},
                {'═', '╬', '═', '╬', '═'},
                {' ', '║', ' ', '║', ' '},
                {'═', '╬', '═', '╬', '═'},
                {' ', '║', ' ', '║', ' '}};
        this.currentPlayer = p1; // needed to get player 1 as a starter
    }



}
