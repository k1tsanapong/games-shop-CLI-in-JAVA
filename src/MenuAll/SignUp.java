package MenuAll;

import UserAll.*;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class SignUp extends Menu{
    public SignUp(String name) {
        super(name);
    }

        static User newUser = new User();

        static Deque<User> loadUser = loadUser();

    public static void writeUser()
    {
        try(BufferedWriter bW = new BufferedWriter(new FileWriter(new File("src/UserAll/user.txt"))))

        {
            for (User loopUser: loadUser)
            {
                bW.write(loopUser.getName());
                bW.write(',');
                bW.write(loopUser.getPassword());
                bW.newLine();
            }

            bW.write(newUser.getName());
            bW.write(',');
            bW.write(newUser.getPassword());
            bW.newLine();



        }
        catch (IOException e)
        {
            System.out.println("Error" + e.getMessage());
        }
    }

    public static Deque<User> loadUser()
    {
        Deque<User> userList = new ArrayDeque<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/UserAll/user.txt"))))
        {
            String[] fields = null;
            String line = null;

            for (int i = 0 ; ((line = reader.readLine()) != null); i++) {
                fields = line.split(",");

                User user = new User();

                user.setName(fields[0]);
                user.setPassword(fields[1]);

                userList.addLast(user);

            }

    }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }


        return userList;

    }


    public int start() {

        showName();
        showMenu();

        boolean again_1 = false;

        do
        {
            System.out.print("User Name : ");
            newUser.setName(keyboard.next());

            if (newUser.getName().equals("0"))
            {
                return -1;
            }

            for (User loopUser : loadUser)
            {
                if (newUser.getName().equals(loopUser.getName()))
                {
                    newUser.setName("Duplicate");
                    System.out.println("Duplicate");

                    break;
                }
            }




        }while (newUser.getName().equals("Duplicate"));


        boolean again_2 = false;

        do
        {
            if (again_2 == true)
            {
                System.out.println("Not match");
            }

            if (newUser.getPassword().equals("0"))
            {
                return -1;
            }

            System.out.print("Password : ");
            newUser.setPassword(keyboard.next());

            again_2 = true;

            System.out.print("Confirm Password : ");

        } while ( !newUser.getPassword().equals(keyboard.next()) );


        writeUser();
        System.out.println("Sign Up Suc");

        return -1;

    }
}
