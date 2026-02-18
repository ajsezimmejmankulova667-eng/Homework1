public class CreditAccount extends Account {
    private long creditLimit;  // кредитный лимит

    public CreditAccount(long balance, long creditLimit) {
        super(balance);
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean add(long amount) {
        // Кредитный счет нельзя пополнять выше 0
        if (amount > 0 && balance + amount <= 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    @Override
    public boolean pay(long amount) {
        // Можно платить до кредитного лимита
        if (amount > 0 && balance - amount >= -creditLimit) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Геттер для кредитного лимита (опционально)
    public long getCreditLimit() {
        return creditLimit;
    }
}