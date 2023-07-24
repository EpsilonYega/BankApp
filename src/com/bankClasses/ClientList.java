package com.bankClasses;

import java.io.Serializable;
import java.util.*;

public class ClientList implements Serializable {
    public List<Client> clientList= new ArrayList<Client>();
    public void addClient(Client client){
        clientList.add(client);
    }
    public void showAllClients(){
        for (Client client : clientList){
            client.printInfo();
        }
    }
    public void infoByID(int id){
        if (id <= clientList.size()-1)
            clientList.get(id).printInfo();
        else
            System.out.println("На введённый вами id не закреплён ни один клиент!");
    }
}
