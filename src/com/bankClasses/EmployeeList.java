package com.bankClasses;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class EmployeeList implements Serializable {
    public List<Employee> employeeList = new LinkedList<Employee>();
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void showAllEmployees(){
        for (Employee employee : employeeList){
            employee.printInfo();
        }
    }
    public void infoByID(int id){
        employeeList.get(id).printInfo();
    }
}
