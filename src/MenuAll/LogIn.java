package MenuAll;

import UserAll.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class LogIn extends Menu {

    static User user = null;
    static boolean pass = false;

    static Deque<User> loadUser = loadUser();


    public LogIn(String name) {
        super(name);
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

    public int start()
    {
        if (pass == false)
        {
            showName();


            String userNameInput = "";
            String passwordNameInput = "";


            do {
                System.out.print("User Name : ");
                userNameInput = keyboard.nextLine();

                if (userNameInput.equals("0")) {
                    return -1;
                }

                for (User loopUser : loadUser) {
                    if (userNameInput.equals(loopUser.getName())) {
                        user = loopUser;
                        userNameInput = "Found";

                        break;
                    }

                    userNameInput = "Not Found";
                    System.out.println("Not Found");

                }

            } while (userNameInput.equals("Not Found"));

//
//
//
//
//        do
//        {
//            System.out.print("Password : ");
//            passwordNameInput = keyboard.nextLine();
//
//            if (passwordNameInput.equals("0"))
//            {
//                return -1;
//            }
//
//
//            else if (passwordNameInput.equals(User.getPassword()))
//            {
//                    passwordNameInput = "Match";
//                    break;
//            }
//
//                passwordNameInput = "Not Match";
//                System.out.println("Not Match");
//
//
//
//        } while (passwordNameInput.equals("Not Match"));
        }

        showName();
        showMenu();

        pass = true;

        int selection = selection();

        if (selection == -1) {
            pass = false;
        }

        return selection;
    }

}
