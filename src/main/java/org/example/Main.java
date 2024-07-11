package org.example;

public class Main {

    public static void main(String[] args) {

        String[] name = {"Ivan", "Petya", "Vova", "Alex"};
        System.out.println(name[1]);
        System.out.println(name[0]);
        System.out.println(name.length);

        for (int i = 0; i < name.length; i++){
            System.out.println(name[i]);
        }
    }
}