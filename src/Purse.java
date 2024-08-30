import java.util.Map;
import java.util.TreeMap;

public class Purse {
    public Purse() {
        cash = new TreeMap<>();
        this.fillCashMap();

    }
    private Map<Denomination, Integer> cash;

    public void add(Denomination type, int num) {
        cash.put(type,num);
    }

    public void remove(Denomination type, int num) {
        cash.remove(type,num);
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
        String rootAddress = "";
        var temp_denomination = new Denomination("Penney", .01, Denomination.Form.Coin, (rootAddress + "penny.png"));
        cash.put(temp_denomination,0);
        temp_denomination = new Denomination("Nickel", .05, Denomination.Form.Coin, (rootAddress + "nickel.png"));
        cash.put(temp_denomination,0);
        temp_denomination = new Denomination("Dime", .10, Denomination.Form.Coin, (rootAddress + "dime.png"));
        cash.put(temp_denomination,0);
        temp_denomination = new Denomination("Quarter", .25, Denomination.Form.Coin, (rootAddress + "quarter.png"));
        cash.put(temp_denomination,0);
        temp_denomination = new Denomination("One Dollar Bill", 1.0, Denomination.Form.Bill, (rootAddress + "1_dollar.png"));
        cash.put(temp_denomination,0);
        temp_denomination = new Denomination("Five Dollar Bill", 5.0, Denomination.Form.Bill, (rootAddress + "5_dollar.png"));
        cash.put(temp_denomination,0);
        temp_denomination = new Denomination("Ten Dollar Bill", 10.0, Denomination.Form.Bill, (rootAddress + "10_dollar.png"));
        cash.put(temp_denomination,0);
        temp_denomination = new Denomination("Fifty Dollar Bill", 50.0, Denomination.Form.Bill, (rootAddress + "50_dollar.png"));
        cash.put(temp_denomination,0);
        temp_denomination = new Denomination("One-Hundred Dollar Bill", 100.0, Denomination.Form.Bill, (rootAddress + "100_dollar.png"));
        cash.put(temp_denomination,0);
    }

    public static void main(String[] args) {
        var purse = new Purse();
        String rootAddress = "";
        var temp_denomination = new Denomination("Penney", .01, Denomination.Form.Coin, (rootAddress + "penny.png"));
        purse.cash.put(temp_denomination,1);
        temp_denomination = new Denomination("Nickel", .05, Denomination.Form.Coin, (rootAddress + "nickel.png"));
        purse.cash.put(temp_denomination,1);
        temp_denomination = new Denomination("Dime", .10, Denomination.Form.Coin, (rootAddress + "dime.png"));
        purse.cash.put(temp_denomination,1);
        temp_denomination = new Denomination("Quarter", .25, Denomination.Form.Coin, (rootAddress + "quarter.png"));
        purse.cash.put(temp_denomination,1);
        temp_denomination = new Denomination("One Dollar Bill", 1.0, Denomination.Form.Bill, (rootAddress + "1_dollar.png"));
        purse.cash.put(temp_denomination,1);
        temp_denomination = new Denomination("Five Dollar Bill", 5.0, Denomination.Form.Bill, (rootAddress + "5_dollar.png"));
        purse.cash.put(temp_denomination,1);
        temp_denomination = new Denomination("Ten Dollar Bill", 10.0, Denomination.Form.Bill, (rootAddress + "10_dollar.png"));
        purse.cash.put(temp_denomination,1);
        temp_denomination = new Denomination("Fifty Dollar Bill", 50.0, Denomination.Form.Bill, (rootAddress + "50_dollar.png"));
        purse.cash.put(temp_denomination,1);
        temp_denomination = new Denomination("One-Hundred Dollar Bill", 100.0, Denomination.Form.Bill, (rootAddress + "100_dollar.png"));
        purse.cash.put(temp_denomination,1);
        System.out.println("166.41 = " + purse.getValue());

    }
}
