package MenuAll;

import GameAll.*;
import UserAll.User;

import java.io.IOException;

public class Library extends Menu{


    private static Game[] games = genGame();

    public Library(String name, User user) {
        super(name, user);
    }

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

    public void playTest() {
        int selection = selection();

        games[selection - 1].play();
    }


}
