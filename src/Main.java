import MenuAll.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Menu menu = new Menu("Menu Main");
        LogIn logIn = new LogIn("Log In");
        SignUp signUp = new SignUp("Sign Up");
        Shop shop = new Shop("Shop");
        Library library = new Library("Library");

        menu.addMenuList(logIn);
        menu.addMenuList(signUp);
//        menu.addMenuList(shop);
//        menu.addMenuList(library);

        menu.showName();
        menu.showMenu();

        library.showName();
        library.showGame();
        library.playTest();

//        shop.showName();
//        shop.showGame();

    }
}