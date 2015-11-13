package carsandowners.menu;

import carsandowners.logic.Logic;

import java.io.IOException;

public class MenuLogic {

    Menu again = new Menu();

    public void runService(int key) throws IOException{
        if(key == 1){
            Logic l = new Logic();
            l.addOwner();
            again.newMenu();
        } else if(key == 2){
            Logic l = new Logic();
            l.addCar();
            again.newMenu();
        } else {
            System.out.println("Вы ввели неверное число!");
            again.newMenu();
        }
    }
}
