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

        do {

            System.out.print("Input : ");

            try
            {
                selection = Integer.parseInt(keyboard.nextLine());
                again = false;

            }

            catch (Exception e)
            {
                System.out.println("Error");
                System.out.println();

            }


        } while (again == true);

        return selection;

    }

    public void addMenuList (Menu menu) {
        menuList.add(menu);
    }

    public String toString() {

        return "kimerza";
    }

}
