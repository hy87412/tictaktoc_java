import java.util.Scanner;
public class Main {
    //board
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

    static void tttgameplay() {

    }
}