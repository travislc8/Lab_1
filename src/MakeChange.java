import java.util.Scanner;

public class MakeChange {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        double amount = -1.0;
        try {
            System.out.print("Enter Dollar Amount $");
            amount = in.nextDouble();
        }
        catch (Exception e) {
            System.out.println("Error: Could not read the input.");
        }

        if (amount >= 0)
            Main.makeChange(amount);

    }

    /**
     * Prints to console the change required for the given dollar amount.
     *
     * @param amount double value containing the dollar amount to find change for
     */
    public static void makeChange(double amount) {
        /*
         * Converts the amount to a string then parses to find the number of cents.
         * String parsing done to prevent floating point rounding errors giving
         * incorrect change values
         */

        var amount_string = Double.toString(amount);
        // creates string containing dollar amount
        int char_index = 0;
        String dollar_string = "";
        while (amount_string.charAt(char_index) != ('.')) {
            dollar_string = dollar_string.concat((amount_string.charAt(char_index) + ""));
            char_index++;
        }
        char_index++;
        // creates string containing number of cents
        String cent_string = "";
        for (int i = 0; i < 2; i++) {
            if (char_index < amount_string.length()) {
                cent_string = cent_string.concat((amount_string.charAt(char_index) + ""));
            } else {
                cent_string = cent_string.concat("0");
            }
            char_index++;
        }

        // converts strings to number of cents as an integer
        int dollars = Integer.parseInt(dollar_string);
        int cents = Integer.parseInt(cent_string);
        cents += (dollars * 100);

        // finds change
        int quarters = cents / 25;
        cents = cents % 25;

        int dimes = cents / 10;
        cents = cents % 10;

        int nickels = cents / 5;
        cents = cents % 5;

        int pennies = cents;

        // prints output
        System.out.println("Change Required for $" + dollar_string + "." + cent_string);
        System.out.println("Quarters = " + quarters);
        System.out.println("Dimes = " + dimes);
        System.out.println("Nickels = " + nickels);
        System.out.println("Pennies = " + pennies);

    }

}
