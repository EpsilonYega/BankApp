package com.bankClasses;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class EmployeeFilter {
    public void filterByName(EmployeeList list){
        Stream<Employee> eStream = list.employeeList.stream();
        Map<String, List<Employee>> employeesByName = eStream.collect(
                Collectors.groupingBy(Employee::getName));
        for(Map.Entry<String, List<Employee>> item : employeesByName.entrySet()){
            System.out.println(item.getKey());
            for(Employee employee : item.getValue()){
                employee.printInfo();
            }
            System.out.println();
        }
    }
    public void filterByLastName(EmployeeList list){
        Stream<Employee> eStream = list.employeeList.stream();
        Map<String, List<Employee>> employeesByLastName = eStream.collect(
                Collectors.groupingBy(Employee::getLastName));
        for(Map.Entry<String, List<Employee>> item : employeesByLastName.entrySet()){
            System.out.println(item.getKey());
            for(Employee employee : item.getValue()){
                employee.printInfo();
            }
            System.out.println();
        }
    }
    public void filterByPatronymic(EmployeeList list){
        Stream<Employee> eStream = list.employeeList.stream();
        Map<String, List<Employee>> employeesByPatronymic = eStream.collect(
                Collectors.groupingBy(Employee::getPatronymic));
        for(Map.Entry<String, List<Employee>> item : employeesByPatronymic.entrySet()){
            System.out.println(item.getKey());
            for(Employee employee : item.getValue()){
                employee.printInfo();
            }
            System.out.println();
        }
    }
    public void filterByAge(EmployeeList list){
        Stream<Employee> eStream = list.employeeList.stream();
        Map<Integer, List<Employee>> employeesByAge = eStream
                .collect(Collectors.groupingBy(Employee::getAge));
        for(Map.Entry<Integer, List<Employee>> item : employeesByAge.entrySet()){
            System.out.println(item.getKey());
            for(Employee employee : item.getValue()){
                employee.printInfo();
            }
            System.out.println();
        }
    }
    public void filterByDate(EmployeeList list){
        Stream<Employee> eStream = list.employeeList.stream();
        Map<String, List<Employee>> employeesByDate = eStream.collect(
                Collectors.groupingBy(Employee::getDateOfBirth));
        for(Map.Entry<String, List<Employee>> item : employeesByDate.entrySet()){
            System.out.println(item.getKey());
            for(Employee employee : item.getValue()){
                employee.printInfo();
            }
            System.out.println();
        }
    }
    public void filterByJobTitle(EmployeeList list){
        Stream<Employee> eStream = list.employeeList.stream();
        Map<String, List<Employee>> employeesByJobTitle = eStream.collect(
                Collectors.groupingBy(Employee::getJobTitle));
        for(Map.Entry<String, List<Employee>> item : employeesByJobTitle.entrySet()){
            System.out.println(item.getKey());
            for(Employee employee : item.getValue()){
                employee.printInfo();
            }
            System.out.println();
        }
    }
    public void filterBySalary(EmployeeList list){
        Stream<Employee> eStream = list.employeeList.stream();
        Map<Double, List<Employee>> employeesBySalary = eStream.collect(
                Collectors.groupingBy(Employee::getSalary));
        for(Map.Entry<Double, List<Employee>> item : employeesBySalary.entrySet()){
            System.out.println(item.getKey());
            for(Employee employee : item.getValue()){
                employee.printInfo();
            }
            System.out.println();
        }
    }
    public void filterByDateOfEmployment(EmployeeList list){
        Stream<Employee> eStream = list.employeeList.stream();
        Map<String, List<Employee>> employeesByDateOfEmployment = eStream.collect(
                Collectors.groupingBy(Employee::getDateOfEmployment));
        for(Map.Entry<String, List<Employee>> item : employeesByDateOfEmployment.entrySet()){
            System.out.println(item.getKey());
            for(Employee employee : item.getValue()){
                employee.printInfo();
            }
            System.out.println();
        }
    }
    public void filterByPhoneNumber(EmployeeList list){
        Stream<Employee> eStream = list.employeeList.stream();
        Map<String, List<Employee>> employeesByPhoneNumber = eStream.collect(
                Collectors.groupingBy(Employee::getPhoneNumber));
        for(Map.Entry<String, List<Employee>> item : employeesByPhoneNumber.entrySet()){
            System.out.println(item.getKey());
            for(Employee employee : item.getValue()){
                employee.printInfo();
            }
            System.out.println();
        }
    }
    public void filterByEmail(EmployeeList list){
        Stream<Employee> eStream = list.employeeList.stream();
        Map<String, List<Employee>> employeesByEmail = eStream.collect(
                Collectors.groupingBy(Employee::getEmail));
        for(Map.Entry<String, List<Employee>> item : employeesByEmail.entrySet()){
            System.out.println(item.getKey());
            for(Employee employee : item.getValue()){
                employee.printInfo();
            }
            System.out.println();
        }
    }
}
