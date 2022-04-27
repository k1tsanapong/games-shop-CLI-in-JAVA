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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    private int money = 0;

    private  ArrayList<Game> games = new ArrayList<>();

    private int selection = -1;

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

    public  ArrayList<Game> getGames() {
        return games;
    }

    public  void addGames(Game games) {
        this.games.add(games);
    }

    public int getSelection() {
        return selection;
    }

    public void setSelection(int selection) {
        this.selection = selection;
    }



    public User()
    {
        this.name = "anonymous";
    }


    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
