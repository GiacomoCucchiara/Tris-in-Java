package tris;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tris {
    static boolean take1;
    static String S1;
    static boolean a1 = true;
    static boolean someBodyWin = false;

    public static void main(String[] args) {
        List<Player> p = new ArrayList<Player>();
        System.out.println(
                "---------------------------" + "\n" + "--------T R I S--------   " + "\n"
                        + "---------------------------");

        createPlayer(p, 0);
        createPlayer(p, 1);
        controllPlayer(p);
        System.out.println(
                "--------- Player ---------" + "\n" + p.get(0).toString() + "\n"
                        + "----------------------------");
        System.out.println(
                "--------- Player ---------" + "\n" + p.get(1).toString() + "\n"
                        + "----------------------------");

        System.out.println("\n\n");

        System.out.println(
                "---------------------------" + "\n" + p.get(0).getName() + " " + "VS" + " " + p.get(1).getName() + "\n"
                        + "---------------------------");

        do {
            String[][] matrix = { { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " } };
            stampMatrix(matrix);
            for (int count = 0; count < 9;) {
                int playerturn = 0;
                if ((count % 2) == 0) {
                    playerturn = 1;
                } else {
                    playerturn = 0;
                }
                move(matrix, p, playerturn);
                stampMatrix(matrix);
                if (isWinner(matrix, p, playerturn) == true) {
                    System.out.println(p.get(playerturn).getName() + " Win");
                    p.get(playerturn).setScore(p.get(playerturn).getScore() + 1);
                    someBodyWin = true;
                    break;
                }
                count++;
            }
            if (someBodyWin == false) {
                System.out.println("Nobody Win");
            }

            System.out.println("\n\n\n\n");
            System.out.println("---------Score---------");
            System.out.println(p.get(0).toString());
            System.out.println(p.get(1).toString());

            System.out.println("\n\n\n\n");
            System.out.println("Play Again? Y/N");
            Scanner in = new Scanner(System.in);
            String again = in.nextLine();
            if (again.toUpperCase().equals("Y")) {
                System.out.println("New Player? Y/N");
                String np = in.nextLine();
                if (np.toUpperCase().equals("Y")) {
                    p.removeAll(p);
                    createPlayer(p, 0);
                    createPlayer(p, 1);
                }
            }
            if (again.toUpperCase().equals("N")) {
                a1 = false;
                in.close();
            }

        } while (a1);

        System.exit(0);

    }

    // Stampa Matrice
    public static void stampMatrix(String[][] matrix) {
        System.out.println("   " + "|" + "   " + "|" + "   ");
        System.out.println(" " + matrix[0][0] + " " + "|" + " " + matrix[0][1] + " " + "|" + " " + matrix[0][2] + " ");
        System.out.println("---" + "+" + "---" + "+" + "---");
        System.out.println("   " + "|" + "   " + "|" + "   ");
        System.out.println(" " + matrix[1][0] + " " + "|" + " " + matrix[1][1] + " " + "|" + " " + matrix[1][2] + " ");
        System.out.println("---" + "+" + "---" + "+" + "---");
        System.out.println("   " + "|" + "   " + "|" + "   ");
        System.out.println(" " + matrix[2][0] + " " + "|" + " " + matrix[2][1] + " " + "|" + " " + matrix[2][2] + " ");
    }

    // Funzione per la mossa
    public static void move(String[][] matrix, List<Player> p, Integer ID) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println(p.get(ID).getName() + " Move Ex.(0,0)");
            Integer x = in.nextInt();
            Integer y = in.nextInt();
            try {
                if (matrix[x][y].equals("O") || matrix[x][y].equals("X")) {
                    System.out.println("---------Error: Invalid Position, try again---------");
                    move(matrix, p, ID);
                } else {
                    matrix[x][y] = p.get(ID).getSign();

                }

            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                System.out.println("---------Error: Invalid Position, try again---------");
                move(matrix, p, ID);
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("---------Error: Invalid Imput, try again---------");
            move(matrix, p, ID);
        }
    }

    // Funzione per il controllo della vittoria
    public static boolean isWinner(String[][] matrix, List<Player> p, Integer ID) {
        if ((matrix[0][0].equals(p.get(ID).getSign())) && (matrix[0][1].equals(p.get(ID).getSign()))
                && (matrix[0][2].equals(p.get(ID).getSign()))) {
            return true;
        } else if ((matrix[1][0].equals(p.get(ID).getSign())) && (matrix[1][1].equals(p.get(ID).getSign()))
                && (matrix[1][2].equals(p.get(ID).getSign()))) {
            return true;
        } else if ((matrix[2][0].equals(p.get(ID).getSign())) && (matrix[2][1].equals(p.get(ID).getSign()))
                && (matrix[2][2].equals(p.get(ID).getSign()))) {
            return true;
        } else if ((matrix[0][0].equals(p.get(ID).getSign())) && (matrix[1][0].equals(p.get(ID).getSign()))
                && (matrix[2][0].equals(p.get(ID).getSign()))) {
            return true;
        } else if ((matrix[0][1].equals(p.get(ID).getSign())) && (matrix[1][1].equals(p.get(ID).getSign()))
                && (matrix[2][1].equals(p.get(ID).getSign()))) {
            return true;
        } else if ((matrix[0][2].equals(p.get(ID).getSign())) && (matrix[1][2].equals(p.get(ID).getSign()))
                && (matrix[2][2].equals(p.get(ID).getSign()))) {
            return true;
        } else if ((matrix[0][0].equals(p.get(ID).getSign())) && (matrix[1][1].equals(p.get(ID).getSign()))
                && (matrix[2][2].equals(p.get(ID).getSign()))) {
            return true;
        } else if ((matrix[0][2].equals(p.get(ID).getSign())) && (matrix[1][1].equals(p.get(ID).getSign()))
                && (matrix[2][0].equals(p.get(ID).getSign()))) {
            return true;
        } else {
            return false;
        }
    }

    // Funzione di creazione player
    public static void createPlayer(List<Player> p, Integer id) {
        Scanner in = new Scanner(System.in);
        System.out.println("Name Player?");
        String G1 = in.nextLine();
        System.out.println("Sign Player X/O?");
        String S1 = in.nextLine();
        if (!"O".equalsIgnoreCase(S1) && !"X".equalsIgnoreCase(S1)) {
            System.out.println("---------Error: Invalid sign---------");
            createPlayer(p, id);
        } else {
            Player player = new Player(id, G1, S1, 0);
            p.add(player);
        }
    }

    // Funzione di controllo sui players per il segno
    public static void controllPlayer(List<Player> p) {
        if (p.get(0).getSign().equalsIgnoreCase(p.get(1).getSign())) {
            p.removeAll(p);
            System.out.println("---------Error: Equal sign---------");
            createPlayer(p, 0);
            createPlayer(p, 1);
        }

    }
}
