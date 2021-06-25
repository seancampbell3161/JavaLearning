import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {

    ArrayList<String> wordBank = new ArrayList<>();

    public void addWords() {
        try {
            File file = new File("/home/sean/Documents/JavaCode/TestProjects/HangmanGame/src/words.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null) {
                wordBank.add(line);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public String pickWord(ArrayList<String> list) {
        return list.get((int) (Math.random() * list.size() - 1));
    }

    public String guess() {
        Scanner scan = new Scanner(System.in);
        String userGuess = scan.nextLine();
        return userGuess;
    }

    public boolean isGuessInWord(String guess, String word) {
        return (word.contains(guess));
    }

    public void run() {
        int boardState = 0;
        boolean isWordComplete = false;
        int numOfCorrectGuess = 0;
        ArrayList<String> spaces = new ArrayList<>();
        addWords();
        String word = pickWord(wordBank);
//        ArrayList<String> theWord = (ArrayList<String>) Arrays.asList(word.split(""));
        for(int i = 0; i < word.length(); i++) {
            spaces.add(" _ ");
        }

        while(!isWordComplete) {
            printBoard(boardState);
            if(boardState == 7) {
                System.out.println("Game Over! You lost. The word was " + word);
                break;
            }
            for(String s : spaces) {
                System.out.print(s + " ");
            }
            System.out.println();
            System.out.print("Take a guess: ");
            String userGuess = guess();
            System.out.println();
            if(isGuessInWord(userGuess, word)) {
                int index = word.indexOf(userGuess);
                while(index >= 0) {
                    spaces.set(index, userGuess);
                    index = word.indexOf(userGuess, index + 1);
                    numOfCorrectGuess++;
                }
                if(numOfCorrectGuess == spaces.size()) {
                    System.out.println();
                    System.out.println("Congratulations, you won! The word was " + word);
                    isWordComplete = true;
                }

            } else {
                boardState++;
            }
        }

    }

    public void printBoard(int boardState) {

        switch(boardState) {
            case 0:
                System.out.println("   ");
                System.out.println("   ");
                System.out.println("   ");
                System.out.println("   ");
                break;

            case 1:
                System.out.println("\t\t o ");
                System.out.println("   ");
                System.out.println("   ");
                System.out.println("   ");
                break;

            case 2:
                System.out.println("\t\t o ");
                System.out.println("\t\t | ");
                System.out.println("   ");
                System.out.println("   ");
                break;

            case 3:
                System.out.println("\t\t o ");
                System.out.println("\t\t/| ");
                System.out.println();
                System.out.println();
                break;

            case 4:
                System.out.println("\t\t o ");
                System.out.println("\t\t/|\\");
                System.out.println();
                System.out.println();
                break;

            case 5:
                System.out.println("\t\t o ");
                System.out.println("\t\t/|\\");
                System.out.println("\t\t | ");
                System.out.println();
                break;

            case 6:
                System.out.println("\t\t o ");
                System.out.println("\t\t/|\\");
                System.out.println("\t\t | ");
                System.out.println("\t\t/");
                break;

            case 7:
                System.out.println("\t\t o ");
                System.out.println("\t\t/|\\");
                System.out.println("\t\t | ");
                System.out.println("\t\t/ \\");
                break;
        }
    }
}
