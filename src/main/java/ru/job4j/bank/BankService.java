package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает модель данных банковской системы(BankService)
 * В системе можно производить следующие действия.
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
 * 4. Переводить деньги с одного банковского счета на другой счет.
 *
 * @author PETROV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных осуществляется в коллекции типа Map(HashMap)
     * User - Клиент банка{@link User}
     * List<Account> - список счетов клиента банка{@link Account}
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод создаёт в системе {@link #users} НОВОГО клиента {@link User}
     * Если такой клиент уже есть в {@link #users}, то добавление не производится
     * Сравнение клиентов осуществляется по {@link User#equals}
     *
     * @param user - клиент
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет клиента из {@link #users}
     * Удаление осуществляется по параметру passport - является уникальным
     * см. {@link User#equals}
     *
     * @param passport - серия-номер паспорта клиента(как идентификатор)
     * @return - Если клиент найден - true, если нет - false
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод добавляет НОВЫЙ банковский счёт {@link Account}
     * Добавление возможно только если:
     * 1)клиент уже заведён в {@link #users}. Проверка осуществляется по {@link User#equals}
     * 2)такого номера банковского счёта у клиента ещё нет. {@link Account#equals}
     *
     * @param passport - серия-номер паспорта клиента(как идентификатор)
     * @param account  - добавляемый банковский счёт
     */
    public void addAccount(String passport, Account account) {
        User currentUser = findByPassport(passport);
        if (currentUser != null) {
            if (!users.get(currentUser).contains(account)) {
                users.get(currentUser).add(account);
            }
        }
    }

    /**
     * Метод возвращает клиента {@link User} по его серии-номеру паспорта(passport)
     *
     * @param passport - серия-номер паспорта клиента(как идентификатор)
     * @return клиент {@link User}
     */
    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    /**
     * Метод возвращает банковский счёт {@link Account}
     * по серии-номеру паспорта(passport) и реквизитам(requisite)
     *
     * @param passport  - серия-номер паспорта клиента(как идентификатор)
     * @param requisite - реквизиты счёта(как идентификатор)
     * @return банковский счёт {@link Account}
     */
    public Account findByRequisite(String passport, String requisite) {
        User currentUser = findByPassport(passport);
        if (currentUser != null) {
            for (Account account : users.get(currentUser)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод осуществляет перевод со счёта на счёт
     *
     * @param srcPassport   - серия-номер паспорта клиента(как идентификатор) - ОТПРАВИТЕЛЬ
     * @param srcRequisite  - реквизиты счёта(как идентификатор) - ОТПРАВИТЕЛЬ
     * @param destPassport  - серия-номер паспорта клиента(как идентификатор) - ПОЛУЧАТЕЛЬ
     * @param destRequisite - реквизиты счёта(как идентификатор) - ПОЛУЧАТЕЛЬ
     * @param amount        - сумма перевода
     * @return - результат операции
     * Перевод возможен (true) только если одновременно выполняется:
     * 1)Найден банковский счёт {@link Account} отправителя
     * 2)Найден банковский счёт {@link Account} получателя
     * 3)Сумма перевода не превышает значение счёта отправителя
     * Если хотя бы одно из условий(1-3) не выполняется, то перевод не осуществляется(false)
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account source = findByRequisite(srcPassport, srcRequisite);
        Account destination = findByRequisite(destPassport, destRequisite);
        if (source == null || destination == null || source.getBalance() < amount) {
            return false;
        }
        source.setBalance(source.getBalance() - amount);
        destination.setBalance(destination.getBalance() + amount);
        return true;
    }

    /**
     * Метод возвращает список банковских счётов клиента
     *
     * @param user - клиент
     * @return - список счетов ist<Account>
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
