import MenuAll.*;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Deque<Menu> menuList = new ArrayDeque<>();

        Menu menu = new Menu("Menu Main");

        LogIn logIn = new LogIn("Log In");
        SignUp signUp = new SignUp("Sign Up");
        menu.addMenuList(logIn);
        menu.addMenuList(signUp);


        menuList.addFirst(menu);

        while (menuList.isEmpty() == false)
        {
            menuList.getFirst().start();

            int selection =  menuList.getFirst().selection();;

            if (selection == -1)
            {
                menuList.removeFirst();
            }

            else
            {
                System.out.println("fads :"+selection);
                menuList.addFirst(menuList.getFirst().getMenuList().get(selection));
            }


        }
//        LogIn logIn = new LogIn("Log In");
//        SignUp signUp = new SignUp("Sign Up");
//
//        menu.addMenuList(logIn);
//        menu.addMenuList(signUp);
//
//        menu.showName();
//        menu.showMenu();
//        menu.selection();

















//

//        Shop shop = new Shop("Shop");
//        Library library = new Library("Library");

//        menu.addMenuList(logIn);
//        menu.addMenuList(signUp);

//        menu.start();

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