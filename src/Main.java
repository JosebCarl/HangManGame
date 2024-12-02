import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Hangman!\nType 1 if you want to guess a randomly selected word, or type 2 if you want to use a word of your own!");
        Scanner user = new Scanner(System.in);
        int gameMode = user.nextInt();
        HangMan game = new HangMan();

        if (gameMode == 1) {
            String ListOfWords = ("Banana....Computer..President.Macaroni..Pokemon...Saxophone.McDonalds.Artichoke.Lollipop..Microwave.Snake.....Caution...Mouse.....Password..Chemistry.Awesome...");
            int randomNum = (int) (Math.random() * 15) * 10;
            String randomWord = (ListOfWords.substring(randomNum,randomNum + 10));
            int cutoff = 0;
            int letter = 0;
            while (cutoff == 0) {
                if (randomWord.substring(letter,letter+1).equals(".")) {
                    randomWord = randomWord.substring(0,letter);
                    cutoff = 1;
                }
                letter++;
            }
            game.insert(randomWord);
            System.out.println(game.humanoid(6));
            game.empty();
        } else {
            System.out.println("Type the word that will be guessed (Make sure its only 1 word!):");
            Scanner user2 = new Scanner(System.in);
            String userWord = user2.nextLine();
            game.insert(userWord);
            System.out.println(game.humanoid(6));
            game.empty();
        }

        int tries = 6;
        Boolean win = false;
        Scanner gameTime = new Scanner(System.in);
        while (tries != 0) {
            System.out.println("\n Guess a letter!" );
            String guess = gameTime.nextLine();
            game.check(guess);
            if (game.incorrect()) {
                tries--;
                System.out.println(game.humanoid(tries));
                System.out.println(guess + " is not in the word!");
            } else {
                System.out.println(game.humanoid(tries));
                System.out.println(guess + " is in the word!");
            }
            game.empty();
            if (game.win()) {
                win = true;
                tries = 0;
            }
        }

        if (win) {
            System.out.println("\n Congratulations! You have won!!!");
        } else {
            System.out.println("\nGame over... \nThe word was '" + game.answer() + "' \nBetter luck next time!");
        }
    }
}
