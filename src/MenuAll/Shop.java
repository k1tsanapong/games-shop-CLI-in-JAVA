package MenuAll;

import GameAll.*;
import UserAll.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Shop extends Menu {


    private  List<Game> games = loadGames();

    public Shop(String name) {
        super(name);
    }

    public void showGame()
    {

        for (int i = 0; i < games.size(); i++)
        {

            String prefix = (i+1) + "." + games.get(i).getName();
            int suffix = games.get(i).getPrice();


            System.out.printf("%-20s%5s%5s%n", prefix, suffix,"Baht");

        }

        System.out.println("0.Return");

    }

    private List<Game> loadGames()
    {
        List<Game> loadGames = new ArrayList<>();

        File myFile = new File("src/GameAll/games.txt");



        try (BufferedReader reader = new BufferedReader(new FileReader(myFile)))
        {
            String[] fields = null;
            String line = null;

            for (int i = 0 ; ((line = reader.readLine()) != null); i++) {
                fields = line.split(",");

                Game game = new Game(String.valueOf(fields[0]),Integer.parseInt(fields[1]));

                loadGames.add(game);
                addMenuList(game);
//                loadGames.set(i, game);

            }

        }

        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }



        return loadGames;

    }

    @Override
    public User start(User user) {

        showName();
        showMenu();

        user.setSelection(selection());

        System.out.println(user.getSelection());

        return user;

    }
}
