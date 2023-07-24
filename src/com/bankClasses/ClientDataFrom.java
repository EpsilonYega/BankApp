package com.bankClasses;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientDataFrom {
    public ClientList ClientDataFrom(BufferedReader br, ClientSerializer clientSerializer, InputClientData input, ClientList clients) throws IOException {
        System.out.println("Перед началом работы выберите одно из двух действий: ");
        int action;
        while (true){
            System.out.println("""
                1. Считать данные о текущих клиентах из файла
                2. Создать новую базу клиентов
                """);
            action = Integer.parseInt(br.readLine());
            switch (action){
                case 1:
                    clients = clientSerializer.readClientsDat(clients);
                    System.out.println("Данные о клиентах успешно считаны!");
                    break;
                case 2:
                    System.out.println("Сколько клиентов вы хотите создать?");
                    int number = Integer.parseInt(br.readLine());
                    for (int i = 0; i < number; i++){
                        int work;
                        while (true){
                            System.out.println("""
                            Ваш клиент трудоустроен?
                            1. Да
                            2. Нет""");
                            work = Integer.parseInt(br.readLine());
                            switch (work){
                                case 1:
                                    clients = input.inputAndAddClientEXT(clients);
                                    break;
                                case 2:
                                    clients = input.inputAndAddClient(clients);
                                    break;
                                default:
                                    System.out.println("Вы не указали уровень трудоустройства. Попробуйте ещё раз.");
                                    break;
                            }
                            if (work == 1 || work == 2) break;
                        }
                    }
                    System.out.println("""
                        Желаете сохранить данные о клиентах?
                        1. Да
                        2. Нет""");
                    int save = Integer.parseInt(br.readLine());
                    if (save == 1) clientSerializer.clientsToDat(clients);
                    break;
                default:
                    System.out.println("Вы некорректно ввели данные. Попробуйте ещё раз.");
            }
            if (action == 1 || action == 2) break;
        }
        return clients;
    }
}
