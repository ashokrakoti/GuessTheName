package movienamegame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GuessMovieName {
    /**
     * declares a file object and a scanner object to read the file line by line separately.
     * @return a movie list read from a text file.
     * @throws FileNotFoundException if file mentioned is not found.
     */
    public List<String> readMovieList()  {
        File file = new File("movies.txt");
        Scanner s = null;
        try {
            s = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("file passed is not available. Please check the file location");
        }
        //declaring arraylist object to store individual lines
        List<String> movieTitles = new ArrayList<>();
        //reading each line separately into a arrayList
        while (s.hasNextLine()) {
            String title = s.nextLine();
            movieTitles.add(title);
        }
        return movieTitles;
    }

    /**
     * method to select a random line from the text array.
     * @param lines the movie title list.
     * @return a random movie name from the list.
     */
    public String getRandomElement(List<String> lines) {
        Random rand = new Random();
        return lines.get(rand.nextInt(lines.size()));
    }

    /**
     *takes the string title of the movie and returns a char array of masked title.
     * @return masked title with '_' character.
     */
    public char[] getCharArray(String randomMovName) {
        char[] maskedTitle = new char[randomMovName.length()];
        for (int i = 0; i < randomMovName.length(); i++) maskedTitle[i] = '_';
        System.out.print("you are guessing: ");
        System.out.println(maskedTitle);
        return maskedTitle;
    }

    /**
     * read input from the user iterates over a loop till the chances are complete
     * i.e, user looses all 10 points
     * @param randomMovName randomly chosen movie name form the list of names
     * @param maskedTitle takes the masked title of name by "_" character.
     * @return whether the guess for the title done is correct or not.
     */
    public boolean guessWork(String randomMovName,char [] maskedTitle){
        //wrong letters count tracker
        int wrongLetters = 0;
        List<Character> wrongLettersguessed = new ArrayList<>();
        boolean guessok = false;
        //looping for the chances until player uses 10 chances
        for (int j=0 ; j<10; j++) {
            //asking user to guess a letter and reading the guessed letter by scanner
            System.out.print("Guess a letter: ");
            var p = new Scanner(System.in);
            char guess = p.next().charAt(0);
            int count = 0;

            //updating the masked title after guess
            for (int i = 0; i < randomMovName.length(); i++) {
                if (guess == randomMovName.charAt(i)) {
                    maskedTitle[i] = guess;
                    count++;
                }
                else  if (randomMovName.charAt(i) == ' '){
                    maskedTitle[i] = ' ';
                }
            }
            //code to keep track of wrong letters guessed
            if (count == 0){
                wrongLetters++;
                wrongLettersguessed.add(guess);
            }
            System.out.print("you are guessing: ");
            System.out.println(maskedTitle);
            System.out.print("You have guessed ("+wrongLetters+") wrong letters: ");
            for(char i :wrongLettersguessed){
                System.out.print(i+" ");
            } System.out.print("\n");

            //check for the correct guess of title
            if(Arrays.equals(randomMovName.toCharArray(), maskedTitle)) {
                guessok = true;
                break;
            }
        }
        return guessok;
    }
}
