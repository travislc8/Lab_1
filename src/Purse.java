import java.util.Map;
import java.util.TreeMap;

/**
 * Class to hold a set of denominations that can be added and removed from
 */
public class Purse {
    public Purse() {
        cash = new TreeMap<>();
        fillCashMap();

    }

    private Map<Denomination, Integer> cash;

    /**
     * Adds Specified number of a denomination to the purse
     *
     * @param denomination A Denomination object that specifies the desired
     *                     Denomination to add too
     * @param num          The number of the Denomination to add to the purse
     */
    public void add(Denomination denomination, int num) {
        int count = cash.get(denomination);

        // adds the requested amount to the purse
        count += num;
        cash.put(denomination, count);
    }

    /**
     * Adds Specified number of a denomination to the purse
     *
     * @param type The MoneyType that will be added to the purse
     * @param num  The number of the Denomination to add to the purse
     */
    public void add(MoneyType type, int num) {
        // gets the amount in the purse of the denomination
        var denomination = Denomination.NewInstance(type);
        int count = cash.get(denomination);

        // adds the requested amount to the purse
        count += num;
        cash.put(denomination, count);
    }

    /**
     * Removes the specified number of a denomination from the purse
     *
     * @param denomination A Denomination object that specifies the desired
     *                     Denomination to remove
     * @param num          The number of the Denomination to remove from the purse
     */
    public double remove(Denomination denomination, int num) {
        int count = cash.get(denomination);

        // if the remove request is greater than the amount in purse, set to
        // the amount in the purse
        if (count < num) {
            num = count;
        }
        double value = num * denomination.amount(); // value removed
        boolean check = cash.remove(denomination, num); // removes from map

        // returns value removed if removal was successful
        if (check)
            return value;
        else
            return 0;
    }

    /**
     * Removes the specified number of a denomination from the purse
     *
     * @param type The MoneyType that will be removed from the purse
     * @param num  The number of the Denomination to remove from the purse
     */
    public double remove(MoneyType type, int num) {
        var denomination = Denomination.NewInstance(type);
        if (denomination == null)
            return 0;
        int count = cash.get(denomination);

        // if the remove request is greater than the amount in purse, set to
        // the amount in the purse
        if (count < num) {
            num = count;
        }
        double value = num * denomination.amount(); // value removed
        boolean check = cash.remove(denomination, num); // removes from map

        // returns value removed if removal was successful
        if (check)
            return value;
        else
            return 0;
    }

    /**
     * Gets the total value in the purse
     *
     * @return value in the purse
     */
    public double getValue() {
        double value = 0;
        for (Map.Entry<Denomination, Integer> type : cash.entrySet()) {
            value += type.getKey().amount() * type.getValue();
        }
        return value;
    }

    /**
     * Gets a string representing the contents of the purse
     *
     */
    public String toString() {
        String result = "";
        // checks if purse is empty
        if (this.getValue() <= 0)
            return "Empty Purse";

        result += "Value in the purse:\n";
        int denominationCount = cash.get(Denomination.NewInstance(MoneyType.OneHundredDollar));
        if (denominationCount > 1)
            result += denominationCount + " One Hundred Dollar Bills\n";
        else if (denominationCount == 1)
            result += denominationCount + " One Hundred Dollar Bill\n";

        denominationCount = cash.get(Denomination.NewInstance(MoneyType.FiftyDollar));
        if (denominationCount > 1)
            result += denominationCount + " Fifty Dollar Bills\n";
        else if (denominationCount == 1)
            result += denominationCount + " Fifty Dollar Bill\n";

        denominationCount = cash.get(Denomination.NewInstance(MoneyType.TwentyDollar));
        if (denominationCount > 1)
            result += denominationCount + " Twenty Dollar Bills\n";
        else if (denominationCount == 1)
            result += denominationCount + " Twenty Dollar Bill\n";

        denominationCount = cash.get(Denomination.NewInstance(MoneyType.TenDollar));
        if (denominationCount > 1)
            result += denominationCount + " Ten Dollar Bills\n";
        else if (denominationCount == 1)
            result += denominationCount + " Ten Dollar Bill\n";

        denominationCount = cash.get(Denomination.NewInstance(MoneyType.FiveDollar));
        if (denominationCount > 1)
            result += denominationCount + " Five Dollar Bills\n";
        else if (denominationCount == 1)
            result += denominationCount + " Five Dollar Bill\n";

        denominationCount = cash.get(Denomination.NewInstance(MoneyType.OneDollar));
        if (denominationCount > 1)
            result += denominationCount + " One Dollar Bills\n";
        else if (denominationCount == 1)
            result += denominationCount + " One Dollar Bill\n";

        denominationCount = cash.get(Denomination.NewInstance(MoneyType.Quarter));
        if (denominationCount > 1)
            result += denominationCount + " Quarters\n";
        else if (denominationCount == 1)
            result += denominationCount + " Quarter\n";

        denominationCount = cash.get(Denomination.NewInstance(MoneyType.Dime));
        if (denominationCount > 1)
            result += denominationCount + " Dimes\n";
        else if (denominationCount == 1)
            result += denominationCount + " Dime\n";

        denominationCount = cash.get(Denomination.NewInstance(MoneyType.Nickel));
        if (denominationCount > 1)
            result += denominationCount + " Nickels\n";
        else if (denominationCount == 1)
            result += denominationCount + " Nickel\n";

        denominationCount = cash.get(Denomination.NewInstance(MoneyType.Penny));
        if (denominationCount > 1)
            result += denominationCount + " Pennies\n";
        else if (denominationCount == 1)
            result += denominationCount + " Penny\n";

        return result;
    }

    /**
     * Gets the number of a denomination in the purse
     *
     * @param MoneyType to get the number of
     */
    public int getDenominationCount(MoneyType type) {
        return cash.get(Denomination.NewInstance(type));
    }

    /**
     * Fills the cash map with denominations with values of 0
     */
    private void fillCashMap() {
        cash.put(Denomination.NewInstance(MoneyType.Penny), 0);
        cash.put(Denomination.NewInstance(MoneyType.Nickel), 0);
        cash.put(Denomination.NewInstance(MoneyType.Dime), 0);
        cash.put(Denomination.NewInstance(MoneyType.Quarter), 0);
        cash.put(Denomination.NewInstance(MoneyType.OneDollar), 0);
        cash.put(Denomination.NewInstance(MoneyType.FiveDollar), 0);
        cash.put(Denomination.NewInstance(MoneyType.TenDollar), 0);
        cash.put(Denomination.NewInstance(MoneyType.TwentyDollar), 0);
        cash.put(Denomination.NewInstance(MoneyType.FiftyDollar), 0);
        cash.put(Denomination.NewInstance(MoneyType.OneHundredDollar), 0);
    }

    /**
     * Test driver for Denomination class
     */
    public static void main(String[] args) {
        var purse = new Purse();

        purse.add(MoneyType.Penny, 1);
        purse.add(MoneyType.Nickel, 1);
        purse.add(MoneyType.Dime, 1);
        purse.add(MoneyType.Quarter, 1);
        purse.add(MoneyType.OneDollar, 1);
        purse.add(MoneyType.FiveDollar, 1);
        purse.add(MoneyType.TenDollar, 1);
        purse.add(MoneyType.TwentyDollar, 1);
        purse.add(MoneyType.FiftyDollar, 1);
        purse.add(MoneyType.OneHundredDollar, 1);

        System.out.printf("166.41 = %.2f\n", purse.getValue());

        System.out.println("Removing one penny, Value removed = " + purse.remove(MoneyType.Penny, 1));
        System.out.printf("New Value %.2f \n", purse.getValue());

        purse.add(MoneyType.OneHundredDollar, 1);
        System.out.printf("266.40 = %.2f \n", purse.getValue());

    }
}
