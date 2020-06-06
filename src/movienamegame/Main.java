package movienamegame;

import java.util.List;

public class Main {
    //contains high level flow of the program
    public static void main(String [] args)  {
        //getting a reference of the guess movie class
        GuessMovieName g = new GuessMovieName ();

        // 1. to read the movie list from a text file
        List<String> movieTitles = g.readMovieList();

        // 2.select a random line by using the list
        String randomMovName = g.getRandomElement(movieTitles);

        // 3.converting the line of text(movie title) into a char array
        char[] maskedTitle = g.getCharArray(randomMovName);

        // 4.guessing of the title of movie
        boolean isGuessRight = g.guessWork(randomMovName,maskedTitle);
        if(isGuessRight){
            String title = new String(maskedTitle);
            System.out.println(title);
            System.out.println("You win! You have guessed the movie name of '" + title + "' correctly");
        }else{
            System.out.println("OOPS! you've lost. You have exhausted all your chances");
        }
    }
}
