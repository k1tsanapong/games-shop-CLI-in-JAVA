package GameAll;

import ExceptionAll.IndexTooHighException;
import ExceptionAll.IndexTooLowException;
import ExceptionAll.SelectToReturn;
import MenuAll.LogIn;
import MenuAll.Menu;
import UserAll.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Deque;
import java.util.Objects;
import java.util.Scanner;

public class Game extends LogIn {

    private String name = "";
    private int price = 0;

    static Scanner keyboard = new Scanner(System.in);


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Game(String name)
    {
        super(name);
        this.name = name;
    }

    public Game (String name, int price)
    {
        super(name);
        this.name = name;
        this.price = price;
    }

    public void play()
    {

        System.out.println(this.name);

        System.out.println("   _____ _             _      _____                      ");
        System.out.println("  / ____| |           | |    / ____|                     ");
        System.out.println(" | (___ | |_ __ _ _ __| |_  | |  __  __ _ _ __ ___   ___ ");
        System.out.println("  \\___ \\| __/ _` | '__| __| | | |_ |/ _` | '_ ` _ \\ / _ \\");
        System.out.println("  ____) | || (_| | |  | |_  | |__| | (_| | | | | | |  __/");
        System.out.println(" |_____/ \\__\\__,_|_|   \\__|  \\_____|\\__,_|_| |_| |_|\\___|");
        System.exit(0);

    }



    @Override
    public void showMenu() {



    }

    public boolean doesUserHas(User user)
    {

        for (Game game : user.getGames())
        {
            if (getName().equals(game.getName()))
            {
                return true;
            }

        }

        return false;
    }



    @Override
    public User start(User user) {

        showName();

        if (doesUserHas(user))
        {
            System.out.println("You have it already.");
            return backToThePast(user);

        }

        System.out.println("Would you like to buy " + getName() + "for " + getPrice() +" baht?");
        System.out.println("1.Yes   2.No");

        int inPutBuy = selectionYesNO("Input : ","Select only 1-2",0,1);


        if (inPutBuy == 0)
        {

            if (user.getMoney()-getPrice() < 0)
            {
                System.out.println("You don't have enough money.");
                return backToThePast(user);
            }

            System.out.println("You have purchased " + getName()
                    + "\t Your remaining balance : " + ( user.getMoney()-getPrice() ) );

            System.out.println("Confirm purchase?");
            System.out.println("1.Yes   2.No");

            inPutBuy = selectionYesNO("Input : ","Select only 1-2",0,1);

            if (inPutBuy == 0)
            {
                user.setMoney(user.getMoney()-getPrice());
                user.addGames(new Game(getName()));
                writeUser();
            }

            else if (inPutBuy == 1)
            {
            System.out.println("Purchase Failed.");

                return backToThePast(user);
            }

        }

        else if (inPutBuy == 1)
        {
            System.out.println("Purchase Failed.");

            return backToThePast(user);
        }

        return backToThePast(user);

    }

}
