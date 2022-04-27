package MenuAll;

import ExceptionAll.*;
import UserAll.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {

    Scanner keyboard = new Scanner(System.in);

    private String name;



    private List<Menu> menuList = new ArrayList<>();

    public List<Menu> getMenuList() {
        return menuList;
    }

    public String getName() {
        return name;
    }

    public Menu(String name) {
        this.name = name;
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

    public void addMenuList (Menu menu) {
        menuList.add(menu);
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



    public String toString() {

        return getName();
    }


    public User start(User user) {

        showName();
        showMenu();

        user.setSelection(selection());

        return user;

    }


}
