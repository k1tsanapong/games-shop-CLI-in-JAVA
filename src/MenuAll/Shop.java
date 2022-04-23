package MenuAll;

import GameAll.*;

public class Shop extends Menu {
    public Shop(String name) {
        super(name);
    }

    private static Game[] games = genGame();

    public static Game[] genGame()
    {

        Game[] games = new Game[4];
        games[0] = new Game("GTA X",999);
        games[1] = new Game("Cyberpunk 1999",1299);
        games[2] = new Game("Old World",899);
        games[3] = new Game("Mario Car",299);

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

    public void playTest()
    {
        int selection = selection();

        games[selection - 1].play();
    }



}
