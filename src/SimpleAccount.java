public class SimpleAccount extends Account {

    public SimpleAccount(long balance) {
        super(balance);  // вызываем конструктор родителя
    }

    @Override
    public boolean add(long amount) {
        // Обычный счет можно пополнять всегда
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    @Override
    public boolean pay(long amount) {
        // Можно платить только если хватает денег
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}