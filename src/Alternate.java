

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Alternate {

    public static void main(String[] args) {
        // write your code here
        int i=0;
        String[] movies=new String[50];
        try {
            File file = new File("movies.txt");
            Scanner scanner = new Scanner(file);
            for(int k=0;scanner.hasNextLine();k++) {
                movies[k]=scanner.nextLine();
            }
            double random= Math.random()*12;

            System.out.print("You are Guessing : ");
            for(int j=1;j<=movies[(int)random].length();j++){
                System.out.print("_");
            }

            System.out.println("\nYou have guessed ("+i+") wrong letters");

            int count=0,handle=0;

            Scanner sc=new Scanner(System.in);
            char[] guess2=new char[movies[(int)random].length()];
            char[] stringToCharArray=movies[(int)random].toCharArray();
            for(int repeat=0;  stringToCharArray.length>count   ;repeat++){                // Match number of character to string for win and loose condition
                System.out.println("Guess a letter : ");                                       // your input
                char guess = sc.next().charAt(0);
                handle=count;
                for(int l=0;l<= stringToCharArray.length-1;l++){
                    if(guess == stringToCharArray[l]){
                        count++;
                        guess2[l]=stringToCharArray[l];
                    }
                    else if(stringToCharArray[l]==' ' && repeat==0){
                        guess2[l]=' ';
                        count++;
                        handle++;
                    }
                    else if(guess2[l]=='_' || repeat==0){
                        guess2[l] = '_';
                    }
                }
                if(count-handle==0){
                    i++;
                }
                handle=count;
                System.out.print("\nYou are Guessing : ");
                for(int a=0;guess2.length>a;a++){
                    System.out.print(guess2[a]);
                }
                System.out.println("\nYou have guessed ("+i+") wrong letters");
                if(i<10 &&  stringToCharArray.length<=count ){
                    System.out.println("\nYOU WIN");
                }
                else if(i>=10) {
                    System.out.println("\nYOU LOSE");
                    break;
                }
            }
        }catch (FileNotFoundException e) {
            System.out.println("file not found exception");
        }

    }
}

