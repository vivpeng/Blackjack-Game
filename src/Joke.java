import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

class Joke {
    static ArrayList <String> jokesList = new ArrayList<String>();
    static int jokeNum = 0;

    public static void nextJoke() throws FileNotFoundException{
        try {
            if (jokesList.size() == 0)
                loadJokes();

            System.out.println(jokesList.get(jokeNum));
            jokesList.remove(jokeNum);
            jokeNum++;
        }

        catch (Exception FileNotFoundException) {
            System.out.println("we do not have a joke right now!");
        }
    }
    public static void loadJokes() throws FileNotFoundException {
        Scanner scFile = new Scanner(new File("jokes.txt"));
        for (int i = 0; i < 12; i++)
            jokesList.add(scFile.nextLine());

        //shuffle jokes
        String placeholder;
        int randomIndex;

        for (int i = 0; i < 12; i++) {
            randomIndex = (int) (Math.random() * 12);
            placeholder = jokesList.get(i);

            jokesList.set(i, jokesList.get(randomIndex));
            jokesList.set(randomIndex, placeholder);
        }
    }
}
