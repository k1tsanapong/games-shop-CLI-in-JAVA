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

    Scanner keyboard = new Scanner(System.in);


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

    public int inNum() throws IndexTooLowException, ArithmeticException
    {

        int input = -1;
        boolean again = true;


        while(again)
        {
            String selectionStr = "";

            try
            {


                System.out.print("Input : ");
                selectionStr = keyboard.nextLine();




                input = getInputNum(selectionStr);

                again = false;

            }

            catch (NumberFormatException e)
            {

                System.out.println("Error : Only Number");

            }
            catch(ArithmeticException e) {
                System.out.println("it's over 9000 !!!");
            }

        }

        return input;
    }

    public int getInputNum(String selectionStr) throws IndexTooLowException, ArithmeticException
    {
        int select;

        try {
            select = Integer.parseInt(selectionStr);
            select = select - 1;

            if (select < -1) {
                throw new IndexTooLowException();
            }

        } catch (NumberFormatException e) {

            throw new NumberFormatException();
        }
        catch(ArithmeticException e) {
            throw new ArithmeticException();
        }

        return select;


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
            System.out.println("lol you have it");
            user.setSelection(-1);
            return user;

        }

        System.out.println("Would you like to buy " + getName() + "for " + getPrice() +" baht?");
        System.out.println("1.Yes   2.No");

        String inPutBuy = keyboard.nextLine();


        if (Objects.equals(inPutBuy, "1"))
        {
            if (user.getMoney()-getPrice() < 0)
            {
                System.out.println("You don't have enough money.");
                user.setSelection(-1);
                return user;
            }

            System.out.println("You have purchased " + getName()
                    + "\t Your remaining balance : " + ( user.getMoney()-getPrice() ) );

            System.out.println("Confirm purchase?");

            inPutBuy = keyboard.nextLine();

            if (Objects.equals(inPutBuy, "1"))
            {
                user.setMoney(user.getMoney()-getPrice());
                user.addGames(new Game(getName()));
                writeUser();
            }

            else if (Objects.equals(inPutBuy, "2"))
            {
            System.out.println("Purchase Failed.");

            user.setSelection(-1);
            return user;
            }

            else
            {
            System.out.println("Select only 1-2");
            user.setSelection(-1);
            return user;
            }



        }

        else if (Objects.equals(inPutBuy, "2"))
        {
            System.out.println("Purchase Failed.");

            user.setSelection(-1);
            return user;
        }

        else {

                System.out.println("Select only 1-2");
                user.setSelection(-1);
                return user;

        }

        user.setSelection(-1);
        return user;

    }


    public static void writeUser()
    {
        Deque<User> loadUser = loadUser();
        try(BufferedWriter bW = new BufferedWriter(new FileWriter(new File("src/UserAll/user.txt"))))

        {
            for (User loopUser: loadUser)
            {
                bW.write(loopUser.getName());
                bW.write(',');
                bW.write(loopUser.getPassword());
                bW.newLine();
            }

        }
        catch (IOException e)
        {
            System.out.println("Error" + e.getMessage());
        }

    }



}
