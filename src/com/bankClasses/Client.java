package com.bankClasses;

import java.io.Serializable;

public class Client extends Person implements Serializable {
    private static int count = 0;
    private int id;
    private double balance;
    private double salary = 0;
    private boolean hasCredit;
    private long personalINN;
    private double sumOfCredit = 0;
    private long organizationINN = 0;

    public Client(String lastName, String name, String patronymic, int age, String dateOfBirth, double balance, boolean hasCredit, long personalINN){
        super(name, lastName, patronymic, age, dateOfBirth);
        this.setBalance(balance);
        this.setCredit(hasCredit);
        this.setPersonalINN(personalINN);
        count++;
        this.id = count;
    }
    public Client(String lastName, String name, String patronymic, int age, String dateOfBirth, double balance, double salary, boolean hasCredit, long personalINN, long organizationINN){
        super(name, lastName, patronymic, age, dateOfBirth);
        this.setBalance(balance);
        this.setSalary(salary);
        this.setCredit(hasCredit);
        this.setPersonalINN(personalINN);
        this.setOrganizationINN(organizationINN);
        count++;
        this.id = count;
    }
    @Override
    public void printInfo() {
        if (this.salary == 0 || this.personalINN == 0){
            System.out.println("Имя: " + this.name + ", Фамилия: " + this.lastName + ", Отчество: " + this.patronymic + ", Возраст: " + this.age + ", Дата рождения: " + this.dateOfBirth
                    + "\nБаланс на счету: " + this.balance + ", Кредит: " + this.hasCredit + ", Сумма текущего кредита: " + this.sumOfCredit + ", Личный ИНН: " + this.personalINN);
        }
        else {
            System.out.println("Имя: " + this.name + ", Фамилия: " + this.lastName + ", Отчество: " + this.patronymic + ", Возраст: " + this.age + ", Дата рождения: " + this.dateOfBirth
                    + "\nБаланс на счету: " + this.balance + ", Зарплата: " + this.salary + ", Кредит: " + this.hasCredit + ", Личный ИНН: " + this.personalINN + ", ИНН организации: " + this.organizationINN);
        }
    }
    public double getBalance(){
        return this.balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public double getSalary(){
        return this.salary;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public boolean getCredit(){
        return this.hasCredit;
    }
    public void setCredit(boolean hasCredit){
        this.hasCredit = hasCredit;
    }
    public long getPersonalINN(){
        return this.personalINN;
    }
    public void setPersonalINN(long personalINN){
        if(Long.toString(personalINN).length() == 12){
            this.personalINN = personalINN;
        }
        else{
            try{
                throw new Exception("Неверный формат ИНН");
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            finally{
                this.isValid = false;
                this.personalINN = 0;
            }
        }
    }
    public long getOrganizationINN(){
        return this.organizationINN;
    }
    public void setOrganizationINN(long organizationINN){
        if(Long.toString(organizationINN).length() == 10){
            this.organizationINN = organizationINN;
        }
        else{
            try{
                throw new Exception("Неверный формат ИНН");
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            finally{
                this.isValid = false;
                this.organizationINN = 0;
            }
        }
    }
    public int getId(){
        return id;
    }
    public void newCredit(double sumOfCredit){
        if (this.isValid == true && this.hasCredit == false){
            this.hasCredit = true;
            this.sumOfCredit = sumOfCredit;
            System.out.printf("Кредит на сумму %f успешно оформлен!\n", this.sumOfCredit);
        }
        else{
            System.out.println("К сожалению, мы не можем выдать вам кредит. Проверьте корректность ваших данных и активные кредиты.");
        }
    }
    public void addBalance(double balance){
        this.balance += balance;
        System.out.printf("Вы пополнили свой баланс на %f\n", this.balance);
    }
    public void repayCredit(){
        this.sumOfCredit = this.sumOfCredit - this.balance;
        System.out.printf("Вы оплатили кредит с имеющейся суммы на счету. Ваш текущий кредит составляет: %f\n", this.sumOfCredit);
    }
}
