package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public boolean deleteUser(String passport) {
        return users.keySet().remove(new User(passport, "abracadabra"));
    }

    public void addAccount(String passport, Account account) {
        User currentUser = findByPassport(passport);
        if (currentUser != null) {
            if (!users.get(currentUser).contains(account)) {
                users.get(currentUser).add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

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

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
