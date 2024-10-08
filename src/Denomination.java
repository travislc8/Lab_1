/**
 * Record class for money denomination
 *
 * @param name           name of the denomination as a MoneyType enumerator
 * @param amount         the value of the denomination
 * @param form           the form of the denomination as a Form enumerator
 * @param pictureAddress a String to the address of a picture of the
 *                       denomination
 */
public record Denomination(MoneyType name,
        Double amount,
        Form form,
        String pictureAddress) implements Comparable<Denomination> {

    /**
     * Static method that creates a new Denomination of the MoneyType specified
     *
     * @param name a member MoneyType to specify the denomination to be made
     * @return new Denomination instance of specified MoneyType
     */
    public static Denomination NewInstance(MoneyType name) {
        Denomination temp_denomination;
        switch (name) {
            case MoneyType.Penny: {
                temp_denomination = new Denomination(MoneyType.Penny, .01, Denomination.Form.Coin,
                        ("penny.png"));
                return temp_denomination;
            }
            case MoneyType.Nickel: {
                temp_denomination = new Denomination(MoneyType.Nickel, .05, Denomination.Form.Coin,
                        ("nickel.png"));
                return temp_denomination;
            }
            case MoneyType.Dime: {
                temp_denomination = new Denomination(MoneyType.Dime, .10, Denomination.Form.Coin,
                        ("dime.png"));
                return temp_denomination;
            }
            case MoneyType.Quarter: {
                temp_denomination = new Denomination(MoneyType.Quarter, .25, Denomination.Form.Coin,
                        ("quarter.png"));
                return temp_denomination;
            }
            case MoneyType.OneDollar: {
                temp_denomination = new Denomination(MoneyType.OneDollar, 1.0, Denomination.Form.Bill,
                        ("1_dollar.png"));
                return temp_denomination;
            }
            case MoneyType.FiveDollar: {
                temp_denomination = new Denomination(MoneyType.FiveDollar, 5.0, Denomination.Form.Bill,
                        ("5_dollar.png"));
                return temp_denomination;
            }
            case MoneyType.TenDollar: {
                temp_denomination = new Denomination(MoneyType.TenDollar, 10.0, Denomination.Form.Bill,
                        ("10_dollar.png"));
                return temp_denomination;
            }
            case MoneyType.TwentyDollar: {
                temp_denomination = new Denomination(MoneyType.TwentyDollar, 20.0, Denomination.Form.Bill,
                        ("20_dollar.png"));
                return temp_denomination;
            }
            case MoneyType.FiftyDollar: {
                temp_denomination = new Denomination(MoneyType.FiftyDollar, 50.0, Denomination.Form.Bill,
                        ("50_dollar.png"));
                return temp_denomination;
            }
            case MoneyType.OneHundredDollar: {
                temp_denomination = new Denomination(MoneyType.OneHundredDollar, 100.0, Denomination.Form.Bill,
                        ("100_dollar.png"));
                return temp_denomination;
            }
            default:
                return null;
        }
    }

    /**
     * Implementation for compare for Comparable interface
     *
     * @param other Denomination to compare to
     */
    public int compareTo(Denomination other) {
        if (this.name.compareTo(other.name) != 0)
            return this.name.compareTo(other.name);
        if (this.amount.compareTo(other.amount) != 0)
            return this.amount.compareTo(other.amount);
        if (this.form.compareTo(other.form) != 0)
            return this.form.compareTo(other.form);
        if (this.pictureAddress.compareTo(other.pictureAddress) != 0)
            return this.pictureAddress.compareTo(other.pictureAddress);

        return 0;
    }

    /**
     * Enumeration for the form of the denomination
     *
     */
    public enum Form {
        Bill, Coin
    }
}
