package MenuAll;

import UserAll.User;

public class TopUp extends LogIn{

    public TopUp(String name) {
        super(name);
    }

    public User start(User user)
    {
        System.out.println("----Your Wallet----");
        System.out.println("Current Wallet balance = " + user.getMoney() + " Baht");
        System.out.println("0.Return");
        System.out.println("1.Topup");

        int intInput = selectionYesNO("Input : ","Please select only 0 or 1",-1,0);

        if (intInput == -1)
        {
            return backToThePast(user);

        }

        else
        {
            System.out.println("Input your balance");
            int addMoney = tryNum();

            user.setMoney( user.getMoney() + addMoney);

            writeUser();
            return backToThePast(user);

        }

    }

}
