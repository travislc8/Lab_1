public record Denomination(String name,
                           Double amount,
                           Form form,
                           String pictureAddress) implements Comparable<Denomination> {
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
    public enum Form {Bill, Coin}
}
