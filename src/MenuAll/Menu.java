package MenuAll;

import ExceptionAll.*;

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
            try
            {
                System.out.print("Input : ");
                String selectionStr = keyboard.nextLine();

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
                //System.out.println(">> "+index);
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

            // TODO: check index value and return proper exception

//            if (select == -1)
//            {
//                throw new SelectToReturn();
//            }


            if (select < -1) {
                throw new IndexTooLowException();
            }

            else if (select > menuList.size())
            {
                throw new IndexTooHighException();
            }


        } catch (NumberFormatException e) {

            // TODO: remove below return, throw the proper exception
            throw new NumberFormatException();
        }

        return select;


    }



    public String toString() {

        return getName();
    }


    public int start() {

        showName();
        showMenu();

        return selection();

    }

}
