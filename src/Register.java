import java.util.Scanner;
import java.lang.Math;

public class Register {

    /**
     * Creates a Purse and fills it with the correct amount of bills based on input
     *
     * @param amount The amount of money to put in the purse
     * @return Purse structure containing the correct number of bills
     */
    public Purse makeChange(double amount) {
        var purse = new Purse();

        int oneHundredDollar = (int) (amount / 100);
        amount -= (oneHundredDollar * 100);
        purse.add(Denomination.NewInstance(MoneyType.OneHundredDollar), oneHundredDollar);

        int fiftyDollor = (int) (amount / 50);
        amount -= (fiftyDollor * 50);
        purse.add(Denomination.NewInstance(MoneyType.FiftyDollar), fiftyDollor);

        int tenDollar = (int) (amount / 10);
        amount -= (tenDollar * 10);
        purse.add(Denomination.NewInstance(MoneyType.TenDollar), tenDollar);

        int fiveDollar = (int) (amount / 5);
        amount -= (fiveDollar * 5);
        purse.add(Denomination.NewInstance(MoneyType.FiveDollar), fiveDollar);

        int oneDollar = (int) (amount / 1);
        amount -= (oneDollar * 1);
        purse.add(Denomination.NewInstance(MoneyType.OneDollar), oneDollar);

        int quarters = (int) (amount / .25);
        amount -= (quarters * .25);
        purse.add(Denomination.NewInstance(MoneyType.Quarter), quarters);

        int dimes = (int) (amount / .10);
        amount -= (dimes * .10);
        purse.add(Denomination.NewInstance(MoneyType.Dime), dimes);

        int nickels = (int) (amount / .05);
        amount -= (nickels * .05);
        purse.add(Denomination.NewInstance(MoneyType.Nickel), nickels);

        int penny = (int) Math.round(amount / .01);
        amount -= (penny * .01);
        purse.add(Denomination.NewInstance(MoneyType.Penny), penny);

        return purse;
    }

    /**
     * Test driver for Register class
     */
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        double amount = -1.0;
        System.out.println("Enter a dollar amount");
        try {
            System.out.print("Enter Dollar Amount $");
            amount = in.nextDouble();
        } catch (Exception e) {
            in.nextLine();
            System.out.println("Error: Could not read the input. Input must be a number.");
        }

        var register = new Register();
        var result = register.makeChange(amount);

        System.out.println();
        System.out.println(result.toString());

    }
}
