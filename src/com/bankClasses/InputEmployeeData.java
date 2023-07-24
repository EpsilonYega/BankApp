package com.bankClasses;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputEmployeeData {
    public EmployeeList inputEmployee(EmployeeList employees) throws java.io.IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Фамилия сотрудника: ");
        String lastName = br.readLine();
        System.out.print("Имя сотрудника: ");
        String name = br.readLine();
        System.out.print("Отчество: ");
        String patronymic = br.readLine();
        System.out.print("Возраст: ");
        int age = Integer.parseInt(br.readLine());
        System.out.print("Дата рождения: ");
        String dateOfBirth = br.readLine();
        System.out.print("Должность: ");
        String jobTitle = br.readLine();
        System.out.print("Зарплата: ");
        double salary = Double.parseDouble(br.readLine());
        System.out.print("Работает с: ");
        String dateOfEmployment = br.readLine();
        System.out.print("Номер телефона: ");
        String phoneNumber = br.readLine();
        System.out.print("Эл. почта: ");
        String email = br.readLine();
        employees.addEmployee(new Employee(lastName, name, patronymic, age, dateOfBirth, jobTitle, salary, dateOfEmployment, phoneNumber, email));
        return employees;
    }
}
