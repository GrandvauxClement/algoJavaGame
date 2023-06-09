import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Application {

    // inferior or superior game
    public static void main(String[] args) {
        System.out.println("Enter a number of line");
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        boolean endGame = false;
        while (!endGame){
            int random = rand.nextInt(100);
            boolean numberFind = false;
            int countNumberTry = 0;
            while (!numberFind){
                countNumberTry ++;
                System.out.println("Enter a number between 1 and 100");
                int numEnter = scanner.nextInt();

                if (random == numEnter){
                    System.out.println("Bien joué ! le nombre a trouvé était : " + random + ", trouvé en " + countNumberTry + " coups");
                    numberFind = true;
                } else if (random < numEnter){
                    System.out.println("Le chiffre recherché is more small");
                } else {
                    System.out.println("Le chiffre recherché est more big");
                }
            }
            System.out.println("Voulez-vous refaire une partie ? (0 pour recommencer et 1 pour arreter ! :) ");
            int response = scanner.nextInt();
            if (response != 0){
                endGame = true;
            }
        }

    }
}
