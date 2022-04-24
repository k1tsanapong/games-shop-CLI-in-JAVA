package MenuAll;

public class LogIn extends Menu {

    private String  name = "";
    private String password = "";


    public LogIn(String name) {
        super(name);
    }

    public Menu start() {

        showName();
        showMenu();

        int selection = selection();


        if (selection == -1)
        {

            return new Menu("Return");
        }

        return new Menu("Return");

    }


}
