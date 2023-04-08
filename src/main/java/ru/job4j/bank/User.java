package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных пользователя банка(клиента)
 *
 * @author PETROV
 * @version 1.0
 */
public class User {
    /**
     * Модель содержит 2 поля: серия-номер паспорта и ФИО клиента.
     * Поля не final - допускается изменение через setter
     * passport - является неявным ключом(см. далее)
     * {@link #equals}
     * {@link #hashCode}
     */
    private String passport;
    private String username;

    /**
     * Канонический конструктор
     *
     * @param passport - серия-номер паспорта
     * @param username - ФИО клиента
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * getter passport
     *
     * @return возвращает значение поля серия-номер паспорта(passport)
     */
    public String getPassport() {
        return passport;
    }

    /**
     * setter passport
     *
     * @param passport - устанавливаемое значение поля серия-номер паспорта(passport)
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * getter username
     *
     * @return возвращает значение поля ФИО клиента(username)
     */
    public String getUsername() {
        return username;
    }

    /**
     * setter username
     *
     * @param username - устанавливаемое значение поля ФИО клиента(username)
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Типовое переопределение метода equals
     *
     * @param o - объект, с которым сравнивают(another)
     * @return - сравнение ТОЛЬКО по passport
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Простое(примитивное) переопределение метода hashCode
     *
     * @return - определение ТОЛЬКО по passport
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
