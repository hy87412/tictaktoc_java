import java.util.Scanner;
/*
* 2 = null
* 1 = player o
* 2 = player x
*/
public class Main {
    static final int tttboard_size = 3;
    static int[][] tttboard = new int[3][3];

    public static void main(String[] args) {
        resettttboard();
        while (true) {
            printtttboard();
            userinputandchange(1);
            printtttboard();
            userinputandchange(0);

        }
    }
    static void gamemanager() {

    }

    static void resettttboard() {
        for (int row = 0; row <= tttboard_size - 1; row++) {
            for (int column = 0; column <= tttboard_size - 1; column++) {
                tttboard[row][column] = 2;
            }
        }
    }

    static void userinputandchange(int usertype) {
        Scanner scan = new Scanner(System.in);
        int row, column;
        while (true) {
            row = scan.nextInt();
            column = scan.nextInt();
            if ((row >= 1 && row <= 3) && (column >= 1 && column <= 3)) {
                if (2 == tttboard[row - 1][column - 1]) {
                    if (usertype == 1) {
                        tttboard[row - 1][column - 1] = 1;
                    }
                    else {
                        tttboard[row - 1][column - 1] = 0;
                    }
                    break;
                }
                else if (2 != tttboard[row - 1][column - 1]) {
                    System.out.println("빈칸에다 입력하세요");
                }
            }
            else {
                System.out.println("행 열 꼴로 1에서 3사이에 정수를 입력하세요");
            }
        }
    }

    static void printtttboard() {
        System.out.println("\t1\t2\t3");
        for (int row = 0; row <= tttboard_size - 1; row++) {
            System.out.print(row + 1);
            for (int column = 0; column <= tttboard_size - 1; column++) {
                if (tttboard[row][column] == 1) {
                    System.out.print("\tO");
                }
                else if (tttboard[row][column] == 0){
                    System.out.print("\tX");
                }
                else {
                    System.out.print("\tN");
                }
            }
            System.out.println();
        }
    }

    static int statuscheck() {
        int winner = 2;
        if (tttboard[1][1] != 2) {
            if (tttboard[1][1] == 1) {
                if (linechecker(tttboard[1][1], tttboard[1][2], tttboard[1][3]) == 1) {
                    winner = 1;
                }
                else if (linechecker(tttboard[1][1], tttboard[2][1], tttboard[3][1]) == 1) {
                    winner = 1;
                }
            }
            else if (tttboard[1][1] == 0) {
                if (linechecker(tttboard[1][1], tttboard[1][2], tttboard[1][3]) == 1) {
                    winner = 0;
                }
                else if (linechecker(tttboard[1][1], tttboard[2][1], tttboard[3][1]) == 1) {
                    winner = 0;
                }
            }
        }
        else if (tttboard[2][2] != 2) {
            if (tttboard[2][2] == 1) {
                if (linechecker(tttboard[1][1], tttboard[2][2], tttboard[3][3]) == 1) {
                    winner = 1;
                }
                else if (linechecker(tttboard[3][1], tttboard[2][2], tttboard[1][3]) == 1) {
                    winner = 1;
                }
                else if (linechecker(tttboard[1][2], tttboard[2][2], tttboard[3][2]) == 1) {
                    winner = 1;
                }
                else if (linechecker(tttboard[2][1], tttboard[2][2], tttboard[2][3]) == 1) {
                    winner = 1;
                }
            }
            else if (tttboard[2][2] == 0) {
               if (linechecker(tttboard[1][1], tttboard[2][2], tttboard[3][3]) == 1) {
                    winner = 0;
                }
                else if (linechecker(tttboard[3][1], tttboard[2][2], tttboard[1][3]) == 1) {
                    winner = 0;
                }
                else if (linechecker(tttboard[1][2], tttboard[2][2], tttboard[3][2]) == 1) {
                    winner = 0;
                }
                else if (linechecker(tttboard[2][1], tttboard[2][2], tttboard[2][3]) == 1) {
                    winner = 0;
                }
            }
        }
        else if (tttboard[3][3] != 2) {
            if (tttboard[3][3] == 1) {
                if (linechecker(tttboard[3][1], tttboard[3][2], tttboard[3][3]) == 1) {
                    winner = 1;
                }
                else if (linechecker(tttboard[1][3], tttboard[2][3], tttboard[3][3]) == 1) {
                    winner = 1;
                }
            }
            else if (tttboard[3][3] == 0) {
                if (linechecker(tttboard[3][1], tttboard[3][2], tttboard[3][3]) == 1) {
                    winner = 0;
                }
                else if (linechecker(tttboard[1][3], tttboard[2][3], tttboard[3][3]) == 1) {
                    winner = 0;
                }
            }
        }
        return winner;
    }

    static void needresetchecker() {
        int caser = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tttboard[i][j] != 2) {
                    caser++;
                }
            }
        }
        if (caser == 0) {
            resettttboard();
        }
    }

    static int linechecker(int A, int B, int C) {
        int result = 0;
        if ((A == B) && (B == C) && (C == A)) {
            result = 1;
        }
        return result;
    }
}