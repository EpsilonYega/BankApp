package com.bankClasses;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClientFilter {
    public void filterByName(ClientList list){
        Stream<Client> cStream = list.clientList.stream();
        Map<String, List<Client>> clientsByName = cStream.collect(
                Collectors.groupingBy(Client::getName));
        for(Map.Entry<String, List<Client>> item : clientsByName.entrySet()){
            System.out.println(item.getKey());
            for(Client client : item.getValue()){
                client.printInfo();
            }
            System.out.println();
        }
    }
    public void filterByLastName(ClientList list){
        Stream<Client> cStream = list.clientList.stream();
        Map<String, List<Client>> clientsByLastName = cStream.collect(
                Collectors.groupingBy(Client::getLastName));
        for(Map.Entry<String, List<Client>> item : clientsByLastName.entrySet()){
            System.out.println(item.getKey());
            for(Client client : item.getValue()){
                client.printInfo();
            }
            System.out.println();
        }
    }
    public void filterByPatronymic(ClientList list){
        Stream<Client> cStream = list.clientList.stream();
        Map<String, List<Client>> clientsByPatronymic = cStream.collect(
                Collectors.groupingBy(Client::getPatronymic));
        for(Map.Entry<String, List<Client>> item : clientsByPatronymic.entrySet()){
            System.out.println(item.getKey());
            for(Client client : item.getValue()){
                client.printInfo();
            }
            System.out.println();
        }
    }
    public void filterByAge(ClientList list){
        Stream<Client> cStream = list.clientList.stream();
        Map<Integer, List<Client>> clientsByAge = cStream
                .collect(Collectors.groupingBy(Client::getAge));
        for(Map.Entry<Integer, List<Client>> item : clientsByAge.entrySet()){
            System.out.println(item.getKey());
            for(Client client : item.getValue()){
                client.printInfo();
            }
            System.out.println();
        }
    }
    public void filterByDate(ClientList list){
        Stream<Client> cStream = list.clientList.stream();
        Map<String, List<Client>> clientsByDate = cStream.collect(
                Collectors.groupingBy(Client::getDateOfBirth));
        for(Map.Entry<String, List<Client>> item : clientsByDate.entrySet()){
            System.out.println(item.getKey());
            for(Client client : item.getValue()){
                client.printInfo();
            }
            System.out.println();
        }
    }
    public void filterByBalance(ClientList list){
        Stream<Client> cStream = list.clientList.stream();
        Map<Double, List<Client>> clientsByBalance = cStream.collect(
                Collectors.groupingBy(Client::getBalance));
        for(Map.Entry<Double, List<Client>> item : clientsByBalance.entrySet()){
            System.out.println(item.getKey());
            for(Client client : item.getValue()){
                client.printInfo();
            }
            System.out.println();
        }
    }
    public void filterBySalary(ClientList list){
        Stream<Client> cStream = list.clientList.stream();
        Map<Double, List<Client>> clientsBySalary = cStream.collect(
                Collectors.groupingBy(Client::getSalary));
        for(Map.Entry<Double, List<Client>> item : clientsBySalary.entrySet()){
            System.out.println(item.getKey());
            for(Client client : item.getValue()){
                client.printInfo();
            }
            System.out.println();
        }
    }
    public void filterByCredit(ClientList list){
        Stream<Client> cStream = list.clientList.stream();
        Map<Boolean, List<Client>> clientsByCredit = cStream.collect(
                Collectors.groupingBy(Client::getCredit));
        for(Map.Entry<Boolean, List<Client>> item : clientsByCredit.entrySet()){
            System.out.println(item.getKey());
            for(Client client : item.getValue()){
                client.printInfo();
            }
            System.out.println();
        }
    }
    public void filterByINN(ClientList list){
        Stream<Client> cStream = list.clientList.stream();
        Map<Long, List<Client>> clientsByINN = cStream.collect(
                Collectors.groupingBy(Client::getOrganizationINN));
        for(Map.Entry<Long, List<Client>> item : clientsByINN.entrySet()){
            System.out.println(item.getKey());
            for(Client client : item.getValue()){
                client.printInfo();
            }
            System.out.println();
        }
    }
}
