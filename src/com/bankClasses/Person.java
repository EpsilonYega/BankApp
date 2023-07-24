package com.bankClasses;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Person implements IBreathable, Serializable {
    protected String name;
    protected String lastName;
    protected String patronymic;
    protected int age;
    protected String dateOfBirth;
    public boolean isValid = true;
    public Person(String name, String lastName, String patronymic, int age, String dateOfBirth){
        this.setName(name);
        this.setLastName(lastName);
        this.setPatronymic(patronymic);
        this.setAge(age);
        this.setDateOfBirth(dateOfBirth);
    }
    public void printInfo(){
        System.out.println("Имя: " + this.name + ", Фамилия: " + this.lastName + ", Отчество: " + this.patronymic + ", Возраст: " + this.age + ", Дата рождения: " + this.dateOfBirth);
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getPatronymic(){
        return this.patronymic;
    }
    public void setPatronymic(String patronymic){
        this.patronymic = patronymic;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        if (age >= 18 && age < 120){
            this.age = age;
        }
        else{
            try{
                throw new Exception("Невалидный возраст. Установлено значение по умолчанию.\nПри необъодимости возраст можно изменить.");
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            finally {
                this.age = 18;
                this.isValid = false;
            }
        }
    }
    public String getDateOfBirth(){
        return this.dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth){
        Pattern pattern = Pattern.compile("(0[1-9]|[12][0-9]|3[01])[- /.:](0[1-9]|1[012])[- /.:](19|20)\\d\\d");
        Matcher matcher = pattern.matcher(dateOfBirth);
        if (matcher.find())
            this.dateOfBirth = dateOfBirth.replace(dateOfBirth.charAt(2),'/');
        else{
            try{
                throw new Exception("Невалидная дата рождения! Установлено значение по умолчанию.\nПри необходимости дату можно изменить.");
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            finally {
                this.dateOfBirth = "10/07/2005";
                this.isValid = false;
            }
        }
    }
}
