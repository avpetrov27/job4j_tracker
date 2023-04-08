package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных банковского счета
 *
 * @author PETROV
 * @version 1.0
 */
public class Account {
    /**
     * Модель содержит 2 поля: реквизиты и баланс.
     * Поля не final - допускается изменение через setter
     * requisite - является неявным ключом(см. далее)
     * {@link #equals}
     * {@link #hashCode}
     */
    private String requisite;
    private double balance;

    /**
     * Канонический конструктор
     *
     * @param requisite - реквизиты
     * @param balance   - баланс
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * getter requisite
     *
     * @return возвращает значение поля реквизиты(requisite)
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * setter requisite
     *
     * @param requisite - устанавливаемое значение поля реквизиты(requisite)
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * getter balance
     *
     * @return возвращает значение поля баланс(balance)
     */
    public double getBalance() {
        return balance;
    }

    /**
     * setter balance
     *
     * @param balance - устанавливаемое значение поля баланс(balance)
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Типовое переопределение метода equals
     *
     * @param o - объект, с которым сравнивают(another)
     * @return - сравнение ТОЛЬКО по requisite
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Простое(примитивное) переопределение метода hashCode
     *
     * @return - определение ТОЛЬКО по requisite
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
