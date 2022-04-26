import MenuAll.*;
import UserAll.User;

import java.io.IOException;
import java.util.*;
import java.util.Objects;


public class Main {
    public static void main(String[] args) throws IOException {

        User user = new User();

        Deque<Menu> menuList = new ArrayDeque<>();

        Menu menu = new Menu("Menu Main",user);

        LogIn logIn = new LogIn("Log In",user);
        SignUp signUp = new SignUp("Sign Up",user);

        menu.addMenuList(logIn);
        menu.addMenuList(signUp);
        menuList.addFirst(menu);

        Shop shop = new Shop("Shop",user);
        Library library = new Library("Library",user);

        logIn.addMenuList(shop);
        logIn.addMenuList(library);



        while (menuList.isEmpty() == false)
        {

            user = menuList.getFirst().start();

            if (user.getSelection() == -1)
            {
                menuList.removeFirst();
            }

//            if(Objects.equals(menuList.getFirst().getName(),"Return"))
//            {
//                menuList.removeFirst();
//            }


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