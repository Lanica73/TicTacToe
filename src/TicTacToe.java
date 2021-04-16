import java.util.Scanner;

public class TicTacToe {
    public static class tictac {
        private String[][] board;
        private static final int rows = 3;
        private static final int cols = 3;
        private String regex = "\\s{3}";


        //creating board
        public tictac() {
            board = new String[rows][cols];
            this.initializeBoard();
        }
        public void initializeBoard() {
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    board[i][j] = "   ";
                }
            }
        }
        //gives players turn
        public void Play(int i, int j, String player) {
            if(board[i][j].matches(regex))
                board[i][j] = " "+player+" ";
        }

        //checks for winner or tie game
        public boolean Game() {
            //checks rows
            for(int i = 0; i < rows; i++) {
                if(!board[i][0].matches(regex) && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])) {
                    return true;
                }
            }
            for(int j = 0; j < cols; j++) {
                if(!board[0][j].matches(regex) && board[0][j].equals(board[1][j]) && board[1][j].equals(board[2][j]))
                    return true;
            }

            //checks diagonals
            if(!board[0][0].matches(regex) && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]))
                return true;
            if(!board[0][2].matches(regex) && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]))
                return true;
            return false;
        }

        // prints board according to player moves
        public String printBoard() {
            String strBoard = "";
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    if(j == rows-1)
                        strBoard += board[i][j];
                    else
                        strBoard += board[i][j] + "|";
                }
                if(i != rows-1)
                    strBoard += "\n---+---+---\n";
            }
            return strBoard;
        }
        public void test() {
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    if(j == 0)
                        board[i][j] = " X ";
                    else
                        board[i][j] = "   ";
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        tictac game = new tictac();
        String player = "X";

        do {
            System.out.println(game.printBoard());
            System.out.println("enter row for " + player + " or -1 to exit: ");
            int row = input.nextInt();
            if(row == -1)
                break;
            System.out.println("enter column for " + player + ": ");
            int column = input.nextInt();
            game.Play(row,  column, player);
            if(game.Game()) {
                System.out.println(game.printBoard() + "\n" + player +" wins!");
                break;
            }
            if(player == "X") {
                player = "O";
            }
            else {
                player = "X";
            }
        }while(true);

    }
}
