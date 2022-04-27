package GameAll;

import MenuAll.Menu;

public class Game extends Menu {

    private String name = "";
    private int price = 0;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Game (String name, int price)
    {
        super(name);
        this.name = name;
        this.price = price;
    }

    public void play()
    {

        System.out.println(this.name);

        System.out.println("   _____ _             _      _____                      ");
        System.out.println("  / ____| |           | |    / ____|                     ");
        System.out.println(" | (___ | |_ __ _ _ __| |_  | |  __  __ _ _ __ ___   ___ ");
        System.out.println("  \\___ \\| __/ _` | '__| __| | | |_ |/ _` | '_ ` _ \\ / _ \\");
        System.out.println("  ____) | || (_| | |  | |_  | |__| | (_| | | | | | |  __/");
        System.out.println(" |_____/ \\__\\__,_|_|   \\__|  \\_____|\\__,_|_| |_| |_|\\___|");
        System.exit(0);

    }



}
