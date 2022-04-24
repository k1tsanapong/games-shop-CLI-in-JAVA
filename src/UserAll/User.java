package UserAll;

import GameAll.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class User {

    private String name = "";
    private String password = "";

    private static ArrayList<Game> games = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static ArrayList<Game> getGames() {
        return games;
    }

    public static void setGames(ArrayList<Game> games) {
        User.games = games;
    }

    public User()
    {

    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
