package Game;

import java.util.Scanner;

public class Main {
    public static char[] board = new char[]{'0','1','2','3','4','5','6','7','8'};
    public static void showBoard(){
        for(int i = 0; i <= 7 ; i+=3){
            System.out.println("\t\t\t\t\t\t\t-------------");
            System.out.println("\t\t\t\t\t\t\t| " + board[i] +" | "+ board[i+1]+" | "+ board[i+2]+" |");
        }
        System.out.println("\t\t\t\t\t\t\t-------------");

    }
    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\t\t\t\t\t\t\tX     O");
        System.out.println("\t\t\t\t\t\t\t" + String.valueOf(X) + "  -  " + String.valueOf(O));
    }
    public static char player = 'X';
    public static void createPlayer(){
        while (true){
            try{
                Scanner sc = new Scanner(System.in);
                System.out.print("\t\t\t\t\t\t  Put the position Player " + player + ": ");
                int pos = sc.nextInt();
                if((pos >= 0 && pos<9) && board[pos] == Character.forDigit(pos,10)){
                    board[pos] = player;
                    if(player == 'X'){
                        player = 'O';
                        clearScreen();
                        break;
                    }
                    else if(player == 'O'){
                        player = 'X';
                        clearScreen();
                        break;
                    }
                }
                else if(board[pos] == 'X' || board[pos] == 'O'){
                    System.out.println("\t\t\t\t\t\t\tSame Position.");
                }

            }
            catch (Exception e){
                System.out.println("\t\t\t\t\t\t  Please put number only 0-8.");
            }
        }
    }
    public static  int X = 0 ,O = 0;
    public static  void checkWin(){
        for(int i = 0; i < 9; i++){
            showBoard();
            createPlayer();
            if (((board[0] == board[1]) && (board[1] == board[2])) ||
                    ((board[3] == board[4]) && (board[4] == board[5]))||
                    ((board[6] == board[7]) && (board[7] == board[8]))||
                    ((board[0] == board[3]) && (board[3] == board[6]))||
                    ((board[1] == board[4]) && (board[4] == board[7]))||
                    ((board[2] == board[5]) && (board[5] == board[8]))||
                    ((board[0] == board[4]) && (board[4] == board[8]))||
                    ((board[2] == board[4]) && (board[4] == board[6]))){
                if(player == 'X'){
                    O += 1;
                    clearScreen();
                    showBoard();
                    System.out.println("\t\t\t\t\t\t\tThis round Player O Win.");
                    break;
                }
                else{
                    X += 1;
                    clearScreen();
                    showBoard();
                    System.out.println("\t\t\t\t\t\t\tThis round Player X Win.");
                    break;
                }
            }
            else if(i == 8){
                showBoard();
                System.out.println("\t\t\t\t\t\t\tDraw");
            }
        }
    }
    public static void startGame(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\tWelcome to XO Game.");
        while(true){
            System.out.println("\t\t\t\t\t\t    Press 'S' to start the game.");
            char start =  sc.next().charAt(0);
            System.out.print("\033[H\033[2J");
            System.out.flush();
            if(start == 'S' || start == 's'){
                System.out.println("\t\t\t\t\t\t\tX     O");
                System.out.println("\t\t\t\t\t\t\t" + String.valueOf(X) + "  -  " + String.valueOf(O));
                checkWin();
                while (true){
                    System.out.print("\t\t\t\t\t\t\tDo you want to play again(Y/N): ");
                    char play_again = sc.next().charAt(0);
                    clearScreen();
                    if(play_again == 'Y' || play_again == 'y'){
                        board = new char[]{'0','1','2','3','4','5','6','7','8'};
                        player = 'X';
                        clearScreen();
                        checkWin();
                    }
                    else if(play_again == 'N' || play_again == 'n') {
                        clearScreen();
                        if (X > O) {
                            System.out.println("\t\t\t\t\t\t\tPlayer X Win.");
                        } else if (O > X) {
                            System.out.println("\t\t\t\t\t\t\tPlayer O Win.");
                        } else {
                            System.out.println("\t\t\t\t\t\t\tDraw");
                        }
                        System.out.println("\t\t\t\t\t\t\tThank for Playing.");
                        break;
                    }
                }
                break;
            }
            else{
                System.out.println("\t\t\t\t\t\t\tAre you ready?");
            }

        }
    }

    public static void main(String[] args) {
        startGame();
    }
}
