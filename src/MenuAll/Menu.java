import java.util.Scanner;


public class Menu {

    Scanner keyboard = new Scanner(System.in);

    private String Name;

    public Menu(String name) {
        Name = name;
    }

    public void ShowName() {
        System.out.println("--- " + Name + " ---");
    }


    public String getName() {
        return Name;
    }

    public int Selection() {

        System.out.print("Enter : ");
        return keyboard.nextInt();

    }

}
