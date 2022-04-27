package GameAll;

import ExceptionAll.IndexTooHighException;
import ExceptionAll.IndexTooLowException;
import ExceptionAll.SelectToReturn;
import MenuAll.Menu;
import UserAll.User;

import java.util.Scanner;

public class Game extends Menu {

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
    public void showName() {

    }

    @Override
    public void showMenu() {

    }



    @Override
    public User start(User user) {

        showName();
        showMenu();

        System.out.println("Do you want to buy?");

        user.setSelection(selection());

        return user;

    }



}
