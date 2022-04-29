package MenuAll;

import GameAll.*;
import UserAll.User;

import java.io.*;
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

    public static Deque<User> loadUsers = loadUser();

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
                user.setMoney(Integer.parseInt(fields[2]));

                if (fields.length-1 > 2)
                {
                    for (int j = 3; j < fields.length; j++)
                    {
                        Game game = new Game(String.valueOf(fields[j]));

                        user.addGames(game);

                    }
                }


                userList.addLast(user);

            }

        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }


        return userList;

    }

    public static void writeUser()
    {



        try(BufferedWriter bW = new BufferedWriter(new FileWriter(new File("src/UserAll/user.txt"))))

        {
            for (User loopUser: loadUsers)
            {
                bW.write(loopUser.getName());
                bW.write(',');
                bW.write(loopUser.getPassword());
                bW.write(',');
                bW.write(String.valueOf(loopUser.getMoney()));

                if (loopUser.getGames().isEmpty() == false)
                {

                    for (int j = 0; j < loopUser.getGames().size() ; j++)
                    {
                        bW.write(',');
                        bW.write(loopUser.getGames().get(j).getName());

                    }
                }

                bW.newLine();
            }

        }
        catch (IOException e)
        {
            System.out.println("Error" + e.getMessage());
        }

    }

    public boolean checkUserName(User user)
    {


        for (User each : loadUsers)
        {

            if (Objects.equals(user.getName(), each.getName()))
            {
//                System.out.println("Found");
                userNow = each;
                return true;
            }

        }

            return false;

    }

    public boolean checkPassword(User user)
    {


        //                System.out.println("Found");
        return Objects.equals(user.getPassword(), userNow.getPassword());

    }

    @Override
    public void setUpMenuList()
    {
        Shop shop = new Shop("Shop");
        Library library = new Library("Library");

        addMenuList(shop);
        addMenuList(library);
    }

    public User start(User userIn)
    {


        if (pass == false) {

            setUpMenuList();

            showName();

            do
            {
                System.out.print("User Name : ");
                userIn.setName(keyboard.nextLine());

                if ( Objects.equals(userIn.getName(), "0" ))
                {
                    return backToThePast(userIn);
                }

                else if ( checkUserName(userIn) == false )
                {
                System.out.println("Not Found");

                }

                else
                {
                    break;
                }

            } while ( true );


            do
            {
                System.out.print("Password : ");
                userIn.setPassword(keyboard.nextLine());

                if ( Objects.equals(userIn.getPassword(), "0" ))
                {
                    return backToThePast(userIn);
                }

                else if (checkPassword(userIn) == false)
                {
                System.out.println("Wrong Password");

                }

                else
                {
                    userIn = userNow;
                    break;
                }

            } while ( true );


        }

        pass = true;

        showName();
        showMenu();


        userIn.setSelection(selection());

        if (userIn.getSelection() == -1)
        {
            pass = false;
            clearMenuList();
            return new User();
        }



        return userIn;
    }

}
