package MenuAll;

import UserAll.*;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class SignUp extends LogIn{

    private User userNow = null;


    public SignUp(String name) {
        super(name);
    }


    private boolean checkUserName(User user) {

        for (User each : loadUsers)
        {

            if (Objects.equals(user.getName(), each.getName()))
            {
//                System.out.println("Found");
                return true;
            }

        }

        return false;
    }

    public User start(User user) {

        userNow = user;

        showName();

        boolean again = false;

        do
        {

            if (again == true)
            {
                System.out.println("Duplicate");
            }
            again = true;


            System.out.print("User Name : ");
            userNow.setName(keyboard.nextLine());

            if ( Objects.equals(userNow.getName(), "0" ))
            {
                return backToThePast(userNow);
            }

        } while ( checkUserName(userNow) == true );


        again = false;

        do
        {
            if (again == true)
            {
                System.out.println("Not match");
            }
            again = true;

            System.out.print("Password : ");
            userNow.setPassword(keyboard.nextLine());

            if ( Objects.equals(userNow.getPassword(), "0" ))
            {
                return backToThePast(userNow);
            }


            System.out.print("Confirm Password : ");

        } while ( userNow.getPassword().equals(keyboard.nextLine()) == false );



        loadUsers.add(userNow);

        writeUser();

        System.out.println("Sign Up Suc");
        return backToThePast(userNow);

    }
}
