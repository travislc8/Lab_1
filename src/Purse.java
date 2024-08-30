import java.util.Map;
import java.util.TreeMap;

public class Purse {
    public Purse() {
        cash = new TreeMap<>();
        this.fillCashMap();

    }

    private Map<Denomination, Integer> cash;

    public void add(Denomination denomination, int num) {
        int count = cash.get(denomination);

        // adds the requested amount to the purse
        count += num;
        cash.put(denomination, count);
    }

    public void add(MoneyType type, int num) {
        // gets the amount in the purse of the denomination
        var denomination = Denomination.NewInstance(type);
        int count = cash.get(denomination);

        // adds the requested amount to the purse
        count += num;
        cash.put(denomination, count);
    }

    public double remove(Denomination denomination, int num) {
        int count = cash.get(denomination);

        // if the remove request is greater than the amount in purse, set to
        // the amount in the purse
        if (count < num) {
            num = count;
        }
        double value = num * denomination.amount(); // value removed
        boolean check = cash.remove(denomination, num); // removes from map

        // returns value removed if removal was successfull
        if (check)
            return value;
        else
            return 0;
    }

    public double remove(MoneyType type, int num) {
        var denomination = Denomination.NewInstance(type);
        int count = cash.get(denomination);

        // if the remove request is greater than the amount in purse, set to
        // the amount in the purse
        if (count < num) {
            num = count;
        }
        double value = num * denomination.amount(); // value removed
        boolean check = cash.remove(denomination, num); // removes from map

        // returns value removed if removal was successfull
        if (check)
            return value;
        else
            return 0;
    }

    public double getValue() {
        double value = 0;
        for (Map.Entry<Denomination, Integer> type : cash.entrySet()) {
            value += type.getKey().amount() * type.getValue();
        }
        return value;
    }

    public String toString() {
        String result = "";

        return result;
    }

    private void fillCashMap() {
        cash.put(Denomination.NewInstance(MoneyType.Penny), 0);
        cash.put(Denomination.NewInstance(MoneyType.Nickel), 0);
        cash.put(Denomination.NewInstance(MoneyType.Dime), 0);
        cash.put(Denomination.NewInstance(MoneyType.Quarter), 0);
        cash.put(Denomination.NewInstance(MoneyType.OneDollar), 0);
        cash.put(Denomination.NewInstance(MoneyType.FiveDollar), 0);
        cash.put(Denomination.NewInstance(MoneyType.TenDollar), 0);
        cash.put(Denomination.NewInstance(MoneyType.FiftyDollar), 0);
        cash.put(Denomination.NewInstance(MoneyType.OneHundredDollar), 0);
    }

    public static void main(String[] args) {
        var purse = new Purse();

        purse.add(MoneyType.Penny, 1);
        purse.add(MoneyType.Nickel, 1);
        purse.add(MoneyType.Dime, 1);
        purse.add(MoneyType.Quarter, 1);
        purse.add(MoneyType.OneDollar, 1);
        purse.add(MoneyType.FiveDollar, 1);
        purse.add(MoneyType.TenDollar, 1);
        purse.add(MoneyType.FiftyDollar, 1);
        purse.add(MoneyType.OneHundredDollar, 1);

        System.out.printf("166.41 = %.2f\n", purse.getValue());

        System.out.println("Removing one penny, Value removed = " + purse.remove(MoneyType.Penny, 1));
        System.out.printf("New Value %.2f \n", purse.getValue());

        purse.add(MoneyType.OneHundredDollar, 1);
        System.out.printf("266.40 = %.2f \n", purse.getValue());

    }
}
