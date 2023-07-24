package com.bankClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientView {
    public ClientView() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ClientSerializer clientSerializer = new ClientSerializer();
        InputClientData input = new InputClientData();
        ClientList clients = new ClientList();
        ClientDataFrom cdf = new ClientDataFrom();

        clients = cdf.ClientDataFrom(br, clientSerializer, input, clients);
        System.out.println("Отлично, теперь выберите любое из предложенных действий:");
        while (true){
            System.out.println("""
                    1. Чтение всей базы клиентов
                    2. Фильтрация клиентов
                    3. Добавление клиента
                    4. Работа с данными клиента
                    0. Выход
                    """);
            int action = Integer.parseInt(br.readLine());
            if (action == 0) break;
            switch (action){
                case 1:
                    System.out.println("Вывод списка клиентов:");
                    clients.showAllClients();
                    break;
                case 2:
                    int filter;
                    ClientFilter clientFilter = new ClientFilter();
                    while (true){
                        System.out.println("""
                            Выберите параметр для фильтрации:
                            1. По имени
                            2. По фамилии
                            3. По отчеству
                            4. По возрасту
                            5. По дате рождения
                            6. По балансу на счету
                            7. ПО ЗП
                            8. По кредиту
                            9. По ИНН организации
                            0. Выход
                            """);
                        filter = Integer.parseInt(br.readLine());
                        if (filter == 0) break;
                        switch (filter) {
                            case 1:
                                clientFilter.filterByName(clients);
                                System.out.println("Нажмите любую клавишу чтобы продолжить.");
                                br.readLine();
                                break;
                            case 2:
                                clientFilter.filterByLastName(clients);
                                System.out.println("Нажмите любую клавишу чтобы продолжить.");
                                br.readLine();
                                break;
                            case 3:
                                clientFilter.filterByPatronymic(clients);
                                System.out.println("Нажмите любую клавишу чтобы продолжить.");
                                br.readLine();
                                break;
                            case 4:
                                clientFilter.filterByAge(clients);
                                System.out.println("Нажмите любую клавишу чтобы продолжить.");
                                br.readLine();
                                break;
                            case 5:
                                clientFilter.filterByDate(clients);
                                System.out.println("Нажмите любую клавишу чтобы продолжить.");
                                br.readLine();
                                break;
                            case 6:
                                clientFilter.filterByBalance(clients);
                                System.out.println("Нажмите любую клавишу чтобы продолжить.");
                                br.readLine();
                                break;
                            case 7:
                                clientFilter.filterBySalary(clients);
                                System.out.println("Нажмите любую клавишу чтобы продолжить.");
                                br.readLine();
                                break;
                            case 8:
                                clientFilter.filterByCredit(clients);
                                System.out.println("Нажмите любую клавишу чтобы продолжить.");
                                br.readLine();
                                break;
                            case 9:
                                clientFilter.filterByINN(clients);
                                System.out.println("Нажмите любую клавишу чтобы продолжить.");
                                br.readLine();
                                break;
                            default:
                                System.out.println("Вы не выбрали ни один из пунктов меню!");
                                break;
                        }
                    }
                    break;
                case 3:
                    int work;
                    while (true) {
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
                                System.out.println("Вы не указали уровень трудоустройства!");
                                clients = input.inputAndAddClient(clients);
                                break;
                        }
                        if (work == 1 || work == 2) break;
                    }
                    System.out.println("""
                        Желаете сохранить данные о клиентах?
                        1. Да
                        2. Нет""");
                    int save = Integer.parseInt(br.readLine());
                    if (save == 1) clientSerializer.clientsToDat(clients);
                    break;
                case 4:
                    System.out.println("""
                            На ваш выбор:
                            1. Получение данных
                            2. Изменение данных""");
                    int choice = Integer.parseInt(br.readLine());
                    switch (choice){
                        case 1:
                            getData(clients, br);
                            break;
                        case 2:
                            setData(clients, br);
                            break;
                        default:
                            System.out.println("Выберите что-нибудь!");
                            break;
                    }
                    break;
                default:
                    System.out.println("Некорректный ввод! Пожалуйста, попробуйте ещё раз.");
                    break;
            }
        }
    }
    public void getData(ClientList clients, BufferedReader br) throws IOException{
        System.out.print("Введите ID клиента: ");
        int id = Integer.parseInt(br.readLine());
        while(true){
            System.out.println("""
                Перечень доступных действий:
                1. Вся информация о клиенте
                2. ФИО
                3. Возраст
                4. Дата рождения
                5. Баланс
                6. Зарплата (если клиент трудоустроен)
                7. Наличие кредита (если есть, то его сумма)
                8. Личный ИНН
                9. ИНН организации (если клиент трудоустроен)
                0. Выход""");
            int action = Integer.parseInt(br.readLine());
            if (action == 0) break;
            switch (action){
                case 1:
                    clients.infoByID(id);
                    break;
                case 2:
                    System.out.println(clients.clientList.get(id).getLastName() + " " + clients.clientList.get(id).getName() + " " + clients.clientList.get(id).getPatronymic());
                    break;
                case 3:
                    System.out.println(clients.clientList.get(id).getAge());
                    break;
                case 4:
                    System.out.println(clients.clientList.get(id).getDateOfBirth());
                    break;
                case 5:
                    System.out.println(clients.clientList.get(id).getBalance());
                    break;
                case 6:
                    if (clients.clientList.get(id).getSalary() != 0) System.out.println(clients.clientList.get(id).getSalary());
                    else System.out.println("Нет информации по ЗП клиента. Возможно, он не трудоустроен.");
                    break;
                case 7:
                    System.out.println(clients.clientList.get(id).getCredit());
                    break;
                case 8:
                    System.out.println(clients.clientList.get(id).getPersonalINN());
                    break;
                case 9:
                    if (clients.clientList.get(id).getOrganizationINN() != 0) System.out.println(clients.clientList.get(id).getOrganizationINN());
                    else System.out.println("Нет информации по организации клиента. Возможно, он не трудоустроен.");
                    break;
                default:
                    System.out.println("Некорректный ввод! Пожалуйста, попробуйте ещё раз.");
                    break;
            }
        }
    }
    public ClientList setData(ClientList clients, BufferedReader br) throws  IOException{
        System.out.print("Введите ID клиента: ");
        int id = Integer.parseInt(br.readLine());
        while (true){
            System.out.println("""
                    Перечень доступных действий:
                    1. Изменить имя
                    2. Изменить фамилию
                    3. Изменить отчество
                    4. Изменить возраст
                    5. Изменить дату рождения
                    6. Изменить баланс
                    7. Изменить (или установить) ЗП
                    8. Поменять статус кредита
                    9. Изменить личный ИНН
                    10. Изменить ИНН организации
                    11. Оформить кредит
                    12. Пополнить баланс
                    13. Оплатить кредит (или его часть) средствами на балансе
                    0. Выход""");
            int action = Integer.parseInt(br.readLine());
            if (action == 0) break;
            switch (action){
                case 1:
                    System.out.print("Введите новое имя: ");
                    String newName = br.readLine();
                    clients.clientList.get(id).setName(newName);
                    break;
                case 2:
                    System.out.print("Введите новую фамилию: ");
                    String newLastName = br.readLine();
                    clients.clientList.get(id).setLastName(newLastName);
                    break;
                case 3:
                    System.out.print("Введите новое отчество: ");
                    String newPatronymic = br.readLine();
                    clients.clientList.get(id).setPatronymic(newPatronymic);
                    break;
                case 4:
                    System.out.print("Введите новый возраст: ");
                    int newAge = Integer.parseInt(br.readLine());
                    clients.clientList.get(id).setAge(newAge);
                    break;
                case 5:
                    System.out.print("Введите новую дату рождения: ");
                    String newDateOfBirth = br.readLine();
                    clients.clientList.get(id).setDateOfBirth(newDateOfBirth);
                    break;
                case 6:
                    System.out.print("Введите новый баланс: ");
                    double newBalance = Double.parseDouble(br.readLine());
                    clients.clientList.get(id).setBalance(newBalance);
                    break;
                case 7:
                    System.out.print("Введите новую зарплату: ");
                    double newSalary = Double.parseDouble(br.readLine());
                    clients.clientList.get(id).setSalary(newSalary);
                    break;
                case 8:
                    System.out.print("Введите новый статус кредита: ");
                    boolean newCredit = Boolean.parseBoolean(br.readLine());
                    clients.clientList.get(id).setCredit(newCredit);
                    break;
                case 9:
                    System.out.print("Введите новый ИНН: ");
                    long newINN = Long.parseLong(br.readLine());
                    clients.clientList.get(id).setPersonalINN(newINN);
                    break;
                case 10:
                    System.out.print("Введите новый ИНН организации: ");
                    long newOrgINN = Long.parseLong(br.readLine());
                    clients.clientList.get(id).setOrganizationINN(newOrgINN);
                    break;
                case 11:
                    System.out.print("Введите сумму кредита: ");
                    double newCred = Double.parseDouble(br.readLine());
                    clients.clientList.get(id).newCredit(newCred);
                    break;
                case 12:
                    System.out.print("Введите сумму: ");
                    double newBal = Double.parseDouble(br.readLine());
                    clients.clientList.get(id).addBalance(newBal);
                    break;
                case 13:
                    clients.clientList.get(id).repayCredit();
                    break;
                default:
                    System.out.println("Некорректный ввод! Пожалуйста, попробуйте ещё раз.");
                    break;
            }
        }
        return clients;
    }
}
