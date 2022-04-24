package MenuAll;

import UserAll.*;

import java.util.Objects;

public class SignUp extends Menu{
    public SignUp(String name) {
        super(name);
    }

    public void newUser() {

        User newUser = new User();

        do
        {
            String userName = keyboard.next();

            newUser.setName(userName);

        }while (Objects.equals(newUser.getName(), ""));

    }




}
