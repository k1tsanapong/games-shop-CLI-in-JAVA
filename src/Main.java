import MenuAll.*;

public class Main {
    public static void main(String[] args) {

//        Menu menu = new Menu("Menu");
//        Menu logIn = new LogIn("LogIn");
        Shop shop = new Shop("Shop");
        Library library = new Library("Library");

//        menu.addMenuList(logIn);
//
//        menu.showName();
//        menu.showMenu();

        library.showName();
        library.showGame();
        library.playTest();


    }
}