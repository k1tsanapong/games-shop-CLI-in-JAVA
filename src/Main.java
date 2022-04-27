import MenuAll.*;
import UserAll.User;

import java.io.IOException;
import java.util.*;
import java.util.Objects;


public class Main {
    public static void main(String[] args) throws IOException {

        User user = new User();

        Deque<Menu> menuList = new ArrayDeque<>();

        Menu menu = new Menu("Menu Main");

        LogIn logIn = new LogIn("Log In");
        SignUp signUp = new SignUp("Sign Up");

        menu.addMenuList(logIn);
        menu.addMenuList(signUp);
        menuList.addFirst(menu);

        Shop shop = new Shop("Shop");
        Library library = new Library("Library");

        logIn.addMenuList(shop);
        logIn.addMenuList(library);



        while (menuList.isEmpty() == false)
        {

            user = menuList.getFirst().start(user);

            if (user.getSelection() == -1)
            {
                menuList.removeFirst();
            }


            else
            {
                menuList.addFirst(menuList.getFirst().getMenuList().get(user.getSelection()));
            }

        }






















//        menu.addMenuList(shop);
//        menu.addMenuList(library);



//        signUp.newUserName();

//        library.showName();
//        library.showGame();
//        library.playTest();

//        shop.showName();
//        shop.showGame();





    }
}