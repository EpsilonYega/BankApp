package com.bankClasses;

import java.io.*;

public class EmployeeSerializer {
    public EmployeeSerializer(){
        File dir = new File(".\\data");
        if(!dir.exists()){
            dir.mkdir();
        }
    }
    public void employeesToDat(EmployeeList employeeList){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(".\\data\\employees.dat"))){
            oos.writeObject(employeeList);
            System.out.println("Файл успешно записан");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public EmployeeList readEmployeesDat(EmployeeList employeeList){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(".\\data\\employees.dat"))){
            employeeList = ((EmployeeList)ois.readObject());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return employeeList;
    }
}
