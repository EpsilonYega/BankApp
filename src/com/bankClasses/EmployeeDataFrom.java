package com.bankClasses;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;

public class EmployeeDataFrom {
    public EmployeeList EmployeeDataFrom(BufferedReader br, EmployeeSerializer employeeSerializer, InputEmployeeData input, EmployeeList employees) throws IOException {
        System.out.println("Перед началом работы выберите одно из двух действий: ");
        int action;
        while(true){
            System.out.println("""
                1. Считать данные о текущих сотрудниках из файла
                2. Создать новую базу сотрудников
                """);
            action = Integer.parseInt(br.readLine());
            switch (action) {
                case 1:
                    employees = employeeSerializer.readEmployeesDat(employees);
                    System.out.println("Данные о сотрудниках успешно считаны!");
                    break;
                case 2:
                    System.out.println("Сколько сотрудников вы хотите создать?");
                    int number = Integer.parseInt(br.readLine());
                    for (int i = 0; i < number; i++) {
                        employees = input.inputEmployee(employees);
                    }
                    System.out.println("""
                        Желаете сохранить данные о сотрудниках?
                        1. Да
                        2. Нет""");
                    int save = Integer.parseInt(br.readLine());
                    if (save == 1) employeeSerializer.employeesToDat(employees);
                    break;
                default:
                    System.out.println("Вы некорректно ввели данные. Попробуйте ещё раз.");
            }
            if (action == 1 || action == 2) break;
        }
        return employees;
    }
}
