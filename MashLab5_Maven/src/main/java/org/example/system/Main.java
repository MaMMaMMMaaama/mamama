package org.example.system;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        String path = System.getenv("lab5");
        if (path == null) {
            System.out.println("Что-то не так с переменной окружения");
            System.exit(1);
        }
        try {
            Console.setPath(path);
            Console console = new Console();
            console.start();
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
        }
    }
}