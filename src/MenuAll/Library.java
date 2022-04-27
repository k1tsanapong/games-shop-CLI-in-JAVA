package MenuAll;

import GameAll.*;
import UserAll.User;

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

    public void playTest() {
        int selection = selection();

        games[selection - 1].play();
    }

    public void showGame()
    {

        for (int i = 0; i < games.length; i++)
        {
            System.out.print( (i+1) + ".");
            System.out.println(games[i].getName());
        }
    }

    public void showMenu(User user)
    {

        for (int i = 0; i < user.getGames().size(); i++)
        {
            System.out.println( (i+1) + "."+user.getGames().get(i).getName());
            addMenuList(user.getGames().get(i));
        }

        System.out.println("0.Return");

    }


    public User start(User user) {

        showName();
        showMenu(user);

        user.setSelection(selection());

        if (user.getSelection() == -1)
        {
            return user;
        }

        user.getGames().get(user.getSelection()).play();
        return user;

    }


}
