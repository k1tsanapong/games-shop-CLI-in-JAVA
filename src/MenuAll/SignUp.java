package MenuAll;

import UserAll.*;

import java.util.Objects;

public class SignUp extends Menu{
    public SignUp(String name) {
        super(name);
    }

    public int start() {

        showName();
        showMenu();

        User newUser = new User();


        System.out.print("User Name : ");
        newUser.setName(keyboard.next());

        if (newUser.getName().equals("0"))
        {
            return -1;
        }

        boolean again = false;

        do
        {
            if (again == true)
            {
                System.out.println("Not match");
            }

            if (newUser.getPassword().equals("0"))
            {
                return -1;
            }

            System.out.print("Password : ");
            newUser.setPassword(keyboard.next());

            again = true;

            System.out.print("Confirm Password : ");

        } while ( !newUser.getPassword().equals(keyboard.next()) );

        return -1;





    }




}
