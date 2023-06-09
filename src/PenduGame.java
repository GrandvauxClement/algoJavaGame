import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class PenduGame {

    public static String[] completeWord(String wordToFind, String[] completionWord, String letterEnter){
            String[] wordToFindSplit = wordToFind.split("");
            for (int i = 0; i < wordToFindSplit.length; i ++){
                if (!Objects.equals(completionWord[i], wordToFindSplit[i]) && Objects.equals(wordToFindSplit[i], letterEnter)){
                    completionWord[i] = letterEnter;
                }
            }

            return completionWord;
    }

    public static void displayActualWord(String[] actualWord){
        for (String word : actualWord){
            if (word == null){
                System.out.print(" _ ");
            } else {
                System.out.print(" " +word+ " ");
            }
        }
        System.out.println();
    }

    public static boolean checkIfGameFinish(String[] actualWord){
        for (String word : actualWord){
            if (word == null){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] arrayWord = {"salut", "test", "java", "amiltone", "intellij", "luffy", "shanks", "juninho"};
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int countError = 0;
        boolean wordFind = false;
        System.out.println("Welcome on pendu game, Find the secret word, you have right of 7 errors ");
        String wordSelected = arrayWord[rand.nextInt(arrayWord.length)];
        System.out.println("Game Begin !! ");
        String[] completionWord = new String[wordSelected.length()];
        displayActualWord(completionWord);
        while (countError < 7 && !wordFind){
            System.out.println("Please, choose a letter");
            String letterEnter = scanner.nextLine();

            if (wordSelected.contains(letterEnter)){
                completeWord(wordSelected, completionWord, letterEnter);
                System.out.println("Congratulations this letter is on word " + countError + " errors on 7");
                displayActualWord(completionWord);
                wordFind = checkIfGameFinish(completionWord);

            } else {
                countError ++;
                System.out.println("Don t give up !!! , "+ countError + " errors on 7");
                displayActualWord(completionWord);

            }
        }
        if (countError >= 7){
            System.out.println("Dommage you loose !! retry !! ;)");
        } else {
            System.out.println("Congratulation the word to find is --> "+ wordSelected);
        }
    }
}
