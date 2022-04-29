package MenuAll;

import GameAll.*;
import UserAll.User;

public class Library extends LogIn{


    public Library(String name) {
        super(name);
    }

    public void showMenu(User user)
    {

        for (int i = 0; i < user.getGames().size(); i++)
        {
            System.out.println( (i+1) + "."+user.getGames().get(i).getName());
            addMenuList(user.getGames().get(i));
        }

        System.out.println("0.Return");

    }


    public User start(User user) {

        showName();
        showMenu(user);

        user.setSelection(selection());

        if (user.getSelection() == -1)
        {
            return user;
        }

        user.getGames().get(user.getSelection()).play();
        return user;

    }


}
