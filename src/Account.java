public abstract class Account {
    protected long balance;  // текущий баланс

    public Account(long balance) {
        this.balance = balance;
    }

    // Абстрактные методы (должны быть реализованы в наследниках)
    public abstract boolean add(long amount);
    public abstract boolean pay(long amount);

    // Общий метод для всех счетов
    public boolean transfer(Account account, long amount) {
        // 1. Пытаемся снять деньги с текущего счета
        if (this.pay(amount)) {
            // 2. Если сняли успешно, пытаемся положить на другой счет
            if (account.add(amount)) {
                return true;  // перевод успешен
            } else {
                // 3. Если не удалось положить на другой счет, возвращаем деньги обратно
                this.add(amount);  // возвращаем деньги
                return false;  // перевод не удался
            }
        }
        return false;  // не удалось снять деньги
    }

    public long getBalance() {
        return balance;
    }
}