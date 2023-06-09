import model.Player;

import java.util.Objects;
import java.util.Scanner;

public class Morpion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Init player
        System.out.println("Welcome to morpion game !! :) ");
        System.out.println("Begin to start game please give name of player");
        System.out.println("Name of player 1 : ");
        String nameplayer1 = scanner.nextLine();
        System.out.println(nameplayer1 + ", please choose your symbole");
        String symbolePlayer1 = scanner.nextLine();
        Player player1 = new Player(nameplayer1, symbolePlayer1);

        System.out.println("Name of player 2 : ");
        String namePlayer2 = scanner.nextLine();
        System.out.println(namePlayer2 + ", please choose your symbole");
        String symbolePlayer2 = scanner.nextLine();
        Player player2 = new Player(namePlayer2, symbolePlayer2);

        System.out.println("On how many turn you xant to play ? ");
        int numTotalTurn = scanner.nextInt();
        boolean gameFinish = false;
        String[][] morpion = new String[3][3];
        int countTurn = 0;
        System.out.println("Le jeu peut commencer");
        System.out.println(player1.getName() + " avec le symbole " + player1.getSymbole() + " vs " + player2.getName() + " with "+ player2.getSymbole());

        while (!gameFinish){
            countTurn ++;
            makeATurn(morpion, player1);

            if (countTurn >= 3){
               gameFinish = checkIfPlayerWin(morpion, player1);
               if (gameFinish){
                   break;
               }
            }

            makeATurn(morpion, player2);

            if (countTurn >= 3){
                gameFinish = checkIfPlayerWin(morpion, player2);
            }
        }

    }

    public static String[][] makeATurn(String[][] morpion, Player player){
        Scanner scanner = new Scanner(System.in);
        boolean turnDone = false;
        System.out.println("Player : " + player.getName());
        while (!turnDone){
            System.out.println("Enter num of line");
            int line = scanner.nextInt();

            System.out.println("Enter num of columns");
            int columns = scanner.nextInt();

            if (morpion[line][columns] == null){
                morpion[line][columns] = player.getSymbole();
                turnDone = true;
            } else {
                System.out.println("You selecte a case already use or you enter value outside range !! :( RETRYYY");
            }
        }
        displayMorpion(morpion);
        return  morpion;
    }

    public static boolean checkIfPlayerWin(String[][] morpion, Player player){
        // First check if has a line
        System.out.println("########## I check If player win");
        for (String[] line : morpion){
            if ( Objects.equals(player.getSymbole(), line[0]) && Objects.equals(player.getSymbole(), line[1]) && Objects.equals(player.getSymbole(), line[2])){
                // ITS WIN !!
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!! Well play ");
                System.out.println(player.getName() + "WIN THE GAME !! :)");
                return true;
            }
        }

        // After check if as a column
        for (int i =0; i<3; i++){
            if ( Objects.equals(player.getSymbole(), morpion[0][i]) && Objects.equals(player.getSymbole(), morpion[1][i]) && Objects.equals(player.getSymbole(), morpion[2][i])){
                // ITS WIN !!
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!! Well play ");
                System.out.println(player.getName() + "WIN THE GAME !! :)");
                return true;
            }
        }

        // last we need to check diagonale

        if ( Objects.equals(player.getSymbole(), morpion[0][0]) && Objects.equals(player.getSymbole(), morpion[1][1]) && Objects.equals(player.getSymbole(), morpion[2][2])){
            // ITS WIN !!
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!! Well play ");
            System.out.println(player.getName() + "WIN THE GAME !! :)");
            return true;
        }

        if ( Objects.equals(player.getSymbole(), morpion[0][2]) && Objects.equals(player.getSymbole(), morpion[1][1]) && Objects.equals(player.getSymbole(), morpion[2][0])){
            // ITS WIN !!
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!! Well play ");
            System.out.println(player.getName() + "WIN THE GAME !! :)");
            return true;
        }
        return false;
    }


    public static void displayMorpion(String[][] morpion){
        for (String[] line: morpion){
            for (String column: line){
                System.out.print(" " + column + " |");
            }
            System.out.println();
            System.out.println("-----------");
        }
    }
}