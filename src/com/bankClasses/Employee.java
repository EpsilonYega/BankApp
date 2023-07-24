package com.bankClasses;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee extends Person implements Serializable {
    private String jobTitle;
    private double salary;
    private String dateOfEmployment;
    private String phoneNumber;
    private String email;
    public Employee(String lastName, String name, String patronymic, int age, String dateOfBirth, String jobTitle, double salary, String dateOfEmployment, String phoneNumber, String email){
        super(name, lastName, patronymic, age, dateOfBirth);
        this.setJobTitle(jobTitle);
        this.setSalary(salary);
        this.setDateOfEmployment(dateOfEmployment);
        this.setPhoneNumber(phoneNumber);
        this.setEmail(email);
    }
    public String getJobTitle(){
        return this.jobTitle;
    }
    public void setJobTitle(String jobTitle){
        this.jobTitle = jobTitle;
    }
    public double getSalary(){
        return this.salary;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public String getDateOfEmployment(){
        return this.dateOfEmployment;
    }
    public void setDateOfEmployment(String dateOfEmployment){
        Pattern pattern = Pattern.compile("(0[1-9]|[12][0-9]|3[01])[- /.:](0[1-9]|1[012])[- /.:](19|20)\\d\\d");
        Matcher matcher = pattern.matcher(dateOfEmployment);
        if (matcher.find())
            this.dateOfEmployment = dateOfEmployment.replace(dateOfEmployment.charAt(2),'/');
        else{
            try{
                throw new Exception("Невалидная дата! Установлено значение по умолчанию.\nПри необходимости дату можно изменить.");
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            finally {
                this.dateOfBirth = "10/07/2023";
                this.isValid = false;
            }
        }
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        Pattern pattern = Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.find())
            this.phoneNumber = phoneNumber;
        else{
            try{
                throw new Exception("Невалидный номер телефона! Установлено значение по умолчанию.\nПри необходимости поле можно изменить.");
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            finally {
                this.phoneNumber = "+79881622916";
                this.isValid = false;
            }
        }
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find())
            this.email = email;
        else{
            try{
                throw new Exception("Невалидная email адрес! Установлено значение по умолчанию.\nПри необходимости поле можно изменить.");
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            finally {
                this.email = "none123@none.com";
                this.isValid = false;
            }
        }
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Должность: " + this.jobTitle + ", Зарплата: " + this.salary + ", Работает с " + this.dateOfEmployment + ", Номер телефона: " + this.phoneNumber + ", Эл.почта: " + this.email);
    }

    public void work(){
        System.out.println(this.getName() + " работает.");
    }
    public void chill(){
        System.out.println(this.getName() + " отдыхает.");
    }
}
