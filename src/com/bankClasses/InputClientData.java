package com.bankClasses;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputClientData {
    public ClientList inputAndAddClient(ClientList clients) throws java.io.IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Фамилия клиента: ");
        String lastName = br.readLine();
        System.out.print("Имя клиента: ");
        String name = br.readLine();
        System.out.print("Отчество: ");
        String patronymic = br.readLine();
        System.out.print("Возраст: ");
        int age = Integer.parseInt(br.readLine());
        System.out.print("Дата рождения: ");
        String dateOfBirth = br.readLine();
        System.out.print("Баланс: ");
        double balance = Double.parseDouble(br.readLine());
        System.out.print("Наличие кредита (true/false): ");
        boolean hasCredit = Boolean.parseBoolean(br.readLine());
        System.out.print("Личный ИНН (12 чисел): ");
        long personalINN = Long.parseLong(br.readLine());
        clients.addClient(new Client(lastName, name, patronymic, age, dateOfBirth, balance, hasCredit, personalINN));
//        clients.addClient(new Client("Орлов", "Владислав", "Сергеевич", 18, "29.12.2004", 0, false, 366406939713L));
        return clients;
    }
    public ClientList inputAndAddClientEXT(ClientList clients) throws java.io.IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Фамилия клиента: ");
        String lastName = br.readLine();
        System.out.print("Имя клиента: ");
        String name = br.readLine();
        System.out.print("Отчество: ");
        String patronymic = br.readLine();
        System.out.print("Возраст: ");
        int age = Integer.parseInt(br.readLine());
        System.out.print("Дата рождения: ");
        String dateOfBirth = br.readLine();
        System.out.print("Баланс: ");
        double balance = Double.parseDouble(br.readLine());
        System.out.print("Зарплата: ");
        double salary = Double.parseDouble(br.readLine());
        System.out.print("Наличие кредита (true/false): ");
        boolean hasCredit = Boolean.parseBoolean(br.readLine());
        System.out.print("Личный ИНН (12 чисел): ");
        long personalINN = Long.parseLong(br.readLine());
        System.out.print("ИНН организации (10 чисел): ");
        long organizationINN = Long.parseLong(br.readLine());
        clients.addClient(new Client(lastName, name, patronymic, age, dateOfBirth, balance, salary, hasCredit, personalINN, organizationINN));
//        clients.addClient(new Client("Пестов", "Артём", "Юрьевич", 18, "20.03.2005", 5000, 40000, false, 366406939814L, 3664069398L));
        return clients;
    }
}

