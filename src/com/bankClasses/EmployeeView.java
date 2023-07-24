package com.bankClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmployeeView {
    public EmployeeView() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        EmployeeSerializer employeeSerializer = new EmployeeSerializer();
        InputEmployeeData input = new InputEmployeeData();
        EmployeeList employees = new EmployeeList();
        EmployeeDataFrom edf = new EmployeeDataFrom();

        employees = edf.EmployeeDataFrom(br, employeeSerializer, input, employees);
        System.out.println("Отлично, теперь выберите любое из предложенных действий:");
        while (true) {
            System.out.println("""
                    1. Чтение всей базы сотрудников
                    2. Фильтрация сотрудников
                    3. Добавление сотрудника
                    4. Работа с данными сотрудника
                    0. Выход
                    """);
            int action = Integer.parseInt(br.readLine());
            if (action == 0) break;
            switch (action) {
                case 1:
                    System.out.println("Вывод списка сотрудников:");
                    employees.showAllEmployees();
                    break;
                case 2:
                    int filter;
                    EmployeeFilter employeeFilter = new EmployeeFilter();
                    while (true) {
                        System.out.println("""
                            Выберите параметр для фильтрации:
                            1. По имени
                            2. По фамилии
                            3. По отчеству
                            4. По возрасту
                            5. По дате рождения
                            6. По должности
                            7. По ЗП
                            8. По дате трудоустройства
                            9. По номеру телефона
                            10. По email
                            0. Выход
                            """);
                        filter = Integer.parseInt(br.readLine());
                        if (filter == 0) break;
                        switch (filter) {
                            case 1:
                                employeeFilter.filterByName(employees);
                                System.out.println("Нажмите любую клавишу чтобы продолжить.");
                                br.readLine();
                                break;
                            case 2:
                                employeeFilter.filterByLastName(employees);
                                System.out.println("Нажмите любую клавишу чтобы продолжить.");
                                br.readLine();
                                break;
                            case 3:
                                employeeFilter.filterByPatronymic(employees);
                                System.out.println("Нажмите любую клавишу чтобы продолжить.");
                                br.readLine();
                                break;
                            case 4:
                                employeeFilter.filterByAge(employees);
                                System.out.println("Нажмите любую клавишу чтобы продолжить.");
                                br.readLine();
                                break;
                            case 5:
                                employeeFilter.filterByDate(employees);
                                System.out.println("Нажмите любую клавишу чтобы продолжить.");
                                br.readLine();
                                break;
                            case 6:
                                employeeFilter.filterByJobTitle(employees);
                                System.out.println("Нажмите любую клавишу чтобы продолжить.");
                                br.readLine();
                                break;
                            case 7:
                                employeeFilter.filterBySalary(employees);
                                System.out.println("Нажмите любую клавишу чтобы продолжить.");
                                br.readLine();
                                break;
                            case 8:
                                employeeFilter.filterByDateOfEmployment(employees);
                                System.out.println("Нажмите любую клавишу чтобы продолжить.");
                                br.readLine();
                                break;
                            case 9:
                                employeeFilter.filterByPhoneNumber(employees);
                                System.out.println("Нажмите любую клавишу чтобы продолжить.");
                                br.readLine();
                                break;
                            case 10:
                                employeeFilter.filterByEmail(employees);
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
                    employees = input.inputEmployee(employees);
                    System.out.println("""
                            Желаете сохранить данные о сотрудниках?
                            1. Да
                            2. Нет""");
                    int save = Integer.parseInt(br.readLine());
                    if (save == 1) employeeSerializer.employeesToDat(employees);
                    break;
                case 4:
                    System.out.println("""
                            На ваш выбор:
                            1. Получение данных
                            2. Изменение данных""");
                    int choice = Integer.parseInt(br.readLine());
                    switch (choice) {
                        case 1:
                            getData(employees, br);
                            break;
                        case 2:
                            setData(employees, br);
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
    public void getData(EmployeeList employees, BufferedReader br) throws IOException{
        System.out.print("Введите ID сотрудника: ");
        int id = Integer.parseInt(br.readLine());
        while(true){
            System.out.println("""
                Перечень доступных действий:
                1. Вся информация о сотруднике
                2. ФИО
                3. Возраст
                4. Дата рождения
                5. Должность
                6. Зарплата 
                7. Дата трудоустройства
                8. Телефон
                9. Эл. почта
                0. Выход""");
            int action = Integer.parseInt(br.readLine());
            if (action == 0) break;
            switch (action){
                case 1:
                    employees.infoByID(id);
                    break;
                case 2:
                    System.out.println(employees.employeeList.get(id).getLastName() + " " + employees.employeeList.get(id).getName() + " " + employees.employeeList.get(id).getPatronymic());
                    break;
                case 3:
                    System.out.println(employees.employeeList.get(id).getAge());
                    break;
                case 4:
                    System.out.println(employees.employeeList.get(id).getDateOfBirth());
                    break;
                case 5:
                    System.out.println(employees.employeeList.get(id).getJobTitle());
                    break;
                case 6:
                    System.out.println(employees.employeeList.get(id).getSalary());
                    break;
                case 7:
                    System.out.println(employees.employeeList.get(id).getDateOfEmployment());
                    break;
                case 8:
                    System.out.println(employees.employeeList.get(id).getPhoneNumber());
                    break;
                case 9:
                    System.out.println(employees.employeeList.get(id).getEmail());
                    break;
                default:
                    System.out.println("Некорректный ввод! Пожалуйста, попробуйте ещё раз.");
                    break;
            }
        }
    }
    public EmployeeList setData(EmployeeList employees, BufferedReader br) throws IOException{
        System.out.print("Введите ID сотрудника: ");
        int id = Integer.parseInt(br.readLine());
        while (true){
            System.out.println("""
                    Перечень доступных действий:
                    1. Изменить имя
                    2. Изменить фамилию
                    3. Изменить отчество
                    4. Изменить возраст
                    5. Изменить дату рождения
                    6. Изменить должность
                    7. Изменить ЗП
                    8. Изменить телефонный номер
                    9. Изменить email
                    10. Назначить работу
                    11. Назначить отдых
                    0. Выход""");
            int action = Integer.parseInt(br.readLine());
            if (action == 0) break;
            switch (action){
                case 1:
                    System.out.print("Введите новое имя: ");
                    String newName = br.readLine();
                    employees.employeeList.get(id).setName(newName);
                    break;
                case 2:
                    System.out.print("Введите новую фамилию: ");
                    String newLastName = br.readLine();
                    employees.employeeList.get(id).setLastName(newLastName);
                    break;
                case 3:
                    System.out.print("Введите новое отчество: ");
                    String newPatronymic = br.readLine();
                    employees.employeeList.get(id).setPatronymic(newPatronymic);
                    break;
                case 4:
                    System.out.print("Введите новый возраст: ");
                    int newAge = Integer.parseInt(br.readLine());
                    employees.employeeList.get(id).setAge(newAge);
                    break;
                case 5:
                    System.out.print("Введите новую дату рождения: ");
                    String newDateOfBirth = br.readLine();
                    employees.employeeList.get(id).setDateOfBirth(newDateOfBirth);
                    break;
                case 6:
                    System.out.print("Введите новую должность: ");
                    String newJT = br.readLine();
                    employees.employeeList.get(id).setJobTitle(newJT);
                    break;
                case 7:
                    System.out.print("Введите новую зарплату: ");
                    double newSalary = Double.parseDouble(br.readLine());
                    employees.employeeList.get(id).setSalary(newSalary);
                    break;
                case 8:
                    System.out.print("Введите новый телефонный номер: ");
                    String newNumber = br.readLine();
                    employees.employeeList.get(id).setPhoneNumber(newNumber);
                    break;
                case 9:
                    System.out.print("Введите новый email: ");
                    String newEmail = br.readLine();
                    employees.employeeList.get(id).setEmail(newEmail);
                    break;
                case 10:
                    employees.employeeList.get(id).work();
                    break;
                case 11:
                    employees.employeeList.get(id).chill();
                    break;
                default:
                    System.out.println("Некорректный ввод! Пожалуйста, попробуйте ещё раз.");
                    break;
            }
        }
        return employees;
    }
}