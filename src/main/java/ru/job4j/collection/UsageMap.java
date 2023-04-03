package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Pochta@yandex.ru", "PetrovAV");
        map.put("APochta@yandex.ru", "PetrovAV");
        map.put("zPochta@yandex.ru", "PetrovAV");
        map.put("0Pochta@yandex.ru", "PetrovAV");
        map.put("aPochta@yandex.ru", "PetrovAV");
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
    }
}
