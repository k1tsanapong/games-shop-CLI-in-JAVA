package MenuAll;

import GameAll.*;
import UserAll.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class LogIn extends Menu {

    private User userNow = null;

    private boolean pass = false;

    public LogIn(String name)
    {
        super(name);
    }

    public boolean checkUserName()
    {
        boolean found = false;

        for (User each : loadUsers)
        {

            if (Objects.equals(userNow.getName(), each.getName()))
            {
//                System.out.println("Found");
                found = true;
                return true;
            }

        }

            System.out.println("Not Found");
            return false;

    }

    public boolean checkPassword()
    {
        boolean found = false;

        for (User each : loadUsers)
        {

            if (Objects.equals(userNow.getPassword(), each.getPassword()))
            {
//                System.out.println("Found");
                found = true;
                return true;
            }

        }

        System.out.println("Not Found");
        return false;

    }

    @Override
    public void setUpMenuList()
    {
        Shop shop = new Shop("Shop");
        Library library = new Library("Library");

        addMenuList(shop);
        addMenuList(library);
    }

    public User start(User user)
    {
        userNow = user;

        if (pass == false) {

            setUpMenuList();

            showName();

            do
            {
                System.out.print("User Name : ");
                userNow.setName(keyboard.nextLine());

                if ( Objects.equals(userNow.getName(), "0" ))
                {
                    backToThePast(userNow);
                }

            } while ( checkUserName() == false );


            do
            {
                System.out.print("Password : ");
                userNow.setPassword(keyboard.nextLine());

                if ( Objects.equals(userNow.getPassword(), "0" ))
                {
                    backToThePast(userNow);
                }

            } while ( checkPassword() == false );


        }

        pass = true;

        showName();
        showMenu();


        userNow.setSelection(selection());

        if (userNow.getSelection() == -1)
        {
            pass = false;
            clearMenuList();
            return new User();
        }



        return userNow;
    }

}
