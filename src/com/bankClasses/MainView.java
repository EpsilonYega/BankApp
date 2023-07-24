package com.bankClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainView {
    public MainView() throws InterruptedException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Добро пожаловать!");
        Thread.sleep(1000);
        System.out.println("Для продолжения нажмите любую клавишу.");
        br.readLine();
        int action;
        while (true){
            System.out.println("""
                    Что желаете сделать?
                    1. Работа с базой клиентов 
                    2. Работа с базой сотрудников 
                    0. Выход""");
            action = Integer.parseInt(br.readLine());
            if (action == 0) break;
            switch (action){
                case 1:
                    System.out.println("Вы выбрали работу с базой клиентов!");
                    ClientView cv = new ClientView();
                    break;
                case 2:
                    System.out.println("Вы выбрали работу с базой сотрудников!");
                    EmployeeView ev = new EmployeeView();
                    break;
                default:
                    System.out.println("Некорректный ввод! Пожалуйста, попробуйте ещё раз.");
                    break;
            }
        }
        System.out.println("До скорой встречи!");
    }
}
