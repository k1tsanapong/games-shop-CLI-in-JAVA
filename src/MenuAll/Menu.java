package MenuAll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {

    Scanner keyboard = new Scanner(System.in);

    private String name;

    private List<Menu> menuList = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    public void showMenu()
    {

        for (int i = 0; i < menuList.size(); i++)  {
            System.out.println( (i+1) + "." + menuList.get(i).getName());
        }
        System.out.println("0.Return");
    }

    public void showName()
    {
        System.out.println("--- " + name + " ---");

    }


    public String getName() {
        return name;
    }

    public int selection() {

        int selection = -1;
        boolean again = true;

        while(again)
        {
            try
            {
                System.out.print("Input : ");
                selection = Integer.parseInt(keyboard.nextLine());

                again = false;

            }
            catch (NumberFormatException e)
            {
                System.out.println("Error");
            }

        }

        return selection;
    }

    public void addMenuList (Menu menu) {
        menuList.add(menu);
    }



    public String toString() {

        return "kimerza";
    }


    public void start() {

        LogIn logIn = new LogIn("Log In");
        SignUp signUp = new SignUp("Sign Up");
        addMenuList(logIn);
        addMenuList(signUp);

        showName();
        showMenu();

    }

}
