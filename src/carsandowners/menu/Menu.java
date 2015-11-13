package carsandowners.menu;

import java.io.IOException;
import java.util.Scanner;

public class Menu {


    public void newMenu() throws IOException{
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите номер действия: ");
            System.out.println();
            System.out.println("1. Добавить владельца");
            System.out.println("2. Добавить машину");

            int key = sc.nextInt();

            MenuLogic ml = new MenuLogic();
            ml.runService(key);

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Введено неверное значение. Попробуйте еще раз!");
        }
    }
}
