public class Main {
    public static void main(String[] args) {
        // Создаем обычный счет с 1000 рублей
        SimpleAccount simple = new SimpleAccount(1000);

        // Создаем кредитный счет с балансом 0 и лимитом 5000
        CreditAccount credit = new CreditAccount(0, 5000);

        // Тестируем операции
        System.out.println("Баланс обычного счета: " + simple.getBalance());
        System.out.println("Баланс кредитного счета: " + credit.getBalance());

        // Перевод с обычного на кредитный
        boolean success = simple.transfer(credit, 500);
        System.out.println("Перевод 500 рублей: " + (success ? "успешно" : "не удался"));

        System.out.println("Баланс обычного счета после перевода: " + simple.getBalance());
        System.out.println("Баланс кредитного счета после перевода: " + credit.getBalance());
    }
}