package com.bankClasses;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClientSerializer {
    public ClientSerializer(){
        File dir = new File(".\\data");
        if(!dir.exists()){
            dir.mkdir();
        }
    }
    public void clientsToDat(ClientList clientList){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(".\\data\\clients.dat"))){
            oos.writeObject(clientList);
            System.out.println("Файл успешно записан");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public ClientList readClientsDat(ClientList clientList){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(".\\data\\clients.dat"))){
            clientList = ((ClientList)ois.readObject());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return clientList;
    }
}
