import java.util.Scanner;
/*
* 2 = null
* 1 = player o
* 2 = player x
*/
public class Main {
    static final int tttboard_size = 3;
    static int[][] tttboard = new int[3][3];
    static int rounds = 1;
    static int breaktogle = 0;
    static int winner;

    public static void main(String[] args) {
        resettttboard();
        while (true) {
            gameoperate();
        }
    }
    static void gameoperate() {
        winner = 2;
        resettttboard();
        rounds = 1;
        breaktogle = 0;
        while (true) {
            printtttboard();
            System.out.println("player o's turn");
            userinputandchange(1);
            if (breaktogle == 1) {
                System.out.println("game was broken");
                break;
            }
            statuscheck();
            if (winner == 1) {
                System.out.println("player o win");
                break;
            }
            else if (winner == 0) {
                System.out.println("player x win");
                break;
            }
            needresetchecker();
            printtttboard();
            System.out.println("player x's turn");
            userinputandchange(0);
            if (breaktogle == 1) {
                System.out.println("game was broken");
                break;
            }
            statuscheck();
            if (winner == 1) {
                System.out.println("player o win");
                break;
            }
            else if (winner == 0) {
                System.out.println("player x win");
                break;
            }
            needresetchecker();
        }
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
            else if (row == 87412 || column == 87412) {
                breaktogle = 1;
            }
            else {
                System.out.println("행 열 꼴로 1에서 3사이에 정수를 입력하세요");
            }
        }
    }

    static void printtttboard() {
        System.out.printf("rounds [%d]\n", rounds);
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
                    System.out.print("\t▇");
                }
            }
            System.out.println();
        }
    }

    static int statuscheck() {
        if (tttboard[0][0] != 2) {
            if (tttboard[0][0] == 1) {
                if (linechecker(tttboard[0][0], tttboard[0][1], tttboard[0][2]) == 1) {
                    winner = 1;
                }
                else if (linechecker(tttboard[0][0], tttboard[1][0], tttboard[2][0]) == 1) {
                    winner = 1;
                }
            }
            else if (tttboard[0][0] == 0) {
                if (linechecker(tttboard[0][0], tttboard[0][1], tttboard[0][2]) == 1) {
                    winner = 0;
                }
                else if (linechecker(tttboard[0][0], tttboard[1][0], tttboard[2][0]) == 1) {
                    winner = 0;
                }
            }
        }
        if (tttboard[1][1] != 2) {
            if (tttboard[1][1] == 1) {
                if (linechecker(tttboard[0][0], tttboard[1][1], tttboard[2][2]) == 1) {
                    winner = 1;
                }
                else if (linechecker(tttboard[2][0], tttboard[1][1], tttboard[0][2]) == 1) {
                    winner = 1;
                }
                else if (linechecker(tttboard[0][1], tttboard[1][1], tttboard[2][1]) == 1) {
                    winner = 1;
                }
                else if (linechecker(tttboard[1][0], tttboard[1][1], tttboard[1][2]) == 1) {
                    winner = 1;
                }
            }
            else if (tttboard[1][1] == 0) {
               if (linechecker(tttboard[0][0], tttboard[1][1], tttboard[2][2]) == 1) {
                    winner = 0;
                }
                else if (linechecker(tttboard[2][0], tttboard[1][1], tttboard[0][2]) == 1) {
                    winner = 0;
                }
                else if (linechecker(tttboard[0][1], tttboard[1][1], tttboard[2][1]) == 1) {
                    winner = 0;
                }
                else if (linechecker(tttboard[1][0], tttboard[1][1], tttboard[1][2]) == 1) {
                    winner = 0;
                }
            }
        }
        if (tttboard[2][2] != 2) {
            if (tttboard[2][2] == 1) {
                if (linechecker(tttboard[2][0], tttboard[2][1], tttboard[2][2]) == 1) {
                    winner = 1;
                }
                else if (linechecker(tttboard[0][2], tttboard[1][2], tttboard[2][2]) == 1) {
                    winner = 1;
                }
            }
            else if (tttboard[2][2] == 0) {
                if (linechecker(tttboard[2][0], tttboard[2][1], tttboard[2][2]) == 1) {
                    winner = 0;
                }
                else if (linechecker(tttboard[0][2], tttboard[1][2], tttboard[2][2]) == 1) {
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
                if (tttboard[i][j] == 2) {
                    caser++;
                }
            }
        }
        if (caser == 0) {
            resettttboard();
            rounds ++;
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