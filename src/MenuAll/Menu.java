package MenuAll;

import ExceptionAll.*;
import GameAll.Game;
import UserAll.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Menu {

    private String name;

    private boolean pass = false;

    private List<Menu> menuList = new ArrayList<>();
    static Scanner keyboard = new Scanner(System.in);


    public Menu(String name)
    {
        this.name = name;
    }


    public String getName() {
        return name;
    }



    public void showName()
    {
        System.out.println("--- " + name + " ---");

    }

    public void showMenu()
    {

        for (int i = 0; i < menuList.size(); i++)  {
            System.out.println( (i+1) + "." + menuList.get(i).getName());
        }
        System.out.println("0.Return");
    }

    public String toString() {

        return getName();
    }

    public int selection() {

        int selection = -1;
        boolean again = true;


        while(again)
        {
            String selectionStr = "";

            try
            {


                System.out.print("Input : ");
                selectionStr = keyboard.nextLine();




                selection = getInput(selectionStr);

                again = false;

            }

            catch (NumberFormatException e)
            {

                System.out.println("Error : Only Number");

            }

            catch (SelectToReturn e)
            {
                return 0;
            }

            catch(IndexTooLowException e)
            {
                System.out.println("Error : Index too low");
            }

            catch(IndexTooHighException e)
            {
                //System.out.println(">> "+index);
                System.out.println("Error : Index too high");
            }

        }

        return selection;
    }

    public int getInput(String selectionStr) throws IndexTooLowException, IndexTooHighException, SelectToReturn
    {
        int select;

        try {
            select = Integer.parseInt(selectionStr);
            select = select - 1;

            if (select < -1) {
                throw new IndexTooLowException();
            }

            else if (select > menuList.size()-1)
            {
                throw new IndexTooHighException();
            }


        } catch (NumberFormatException e) {

            throw new NumberFormatException();
        }

        return select;


    }

    public static int selectionYesNO(String inPutMessage, String showError, int low, int high) {

        int selection = -1;
        boolean again = true;


        while(again)
        {

            try
            {

                System.out.print(inPutMessage);
                selection = Integer.parseInt(keyboard.nextLine());

                selection = selection-1;

                if (selection < low || selection > high)
                    throw new NumberFormatException();

                again = false;

            }

            catch (NumberFormatException e)
            {
                System.out.println(showError);

            }

        }

        return selection;
    }

    public int tryNum() throws  ArithmeticException
    {

        int input = -1;
        boolean again = true;


        while(again)
        {

            try
            {

                System.out.print("Input : ");
                input = Integer.parseInt(keyboard.nextLine());

                again = false;

            }

            catch (ArithmeticException e)
            {
                System.out.println("it's over 9000 !!!");


            }
            catch(Exception e) {
                System.out.println("Error : Only Number");
            }

        }

        return input;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void addMenuList (Menu menu) {
        menuList.add(menu);
    }
    public void clearMenuList()
    {
        menuList.clear();
    }


    public User backToThePast(User user)
    {
        clearMenuList();
        user.setSelection(-1);
        return user;
    }

    public void setUpMenuList() {

        LogIn logIn = new LogIn("Log In");
        SignUp signUp = new SignUp("Sign Up");

        addMenuList(logIn);
        addMenuList(signUp);

    }


    public User start(User user) {

        if (pass == false)
        {
            setUpMenuList();
        }

        pass = true;


        showName();
        showMenu();

        user.setSelection(selection());

        return user;

    }


}
