package MenuAll;

import GameAll.*;

import java.io.IOException;

public class Library extends Menu{
    public Library(String name) {
        super(name);
    }

    private static Game[] games = genGame();

    public static Game[] genGame()
    {

        Game[] games = new Game[1];
        games[0] = new Game("Mario Car",299);

        return games;
    }

    public void showGame()
    {

        for (int i = 0; i < games.length; i++)
        {
            System.out.print( (i+1) + ".");
            System.out.println(games[i].getName());
        }
    }

    public void playTest() throws IOException {
        int selection = selection();

        games[selection - 1].play();
    }


}
