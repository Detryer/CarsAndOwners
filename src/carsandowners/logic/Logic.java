package carsandowners.logic;

import carsandowners.domain.Car;
import carsandowners.domain.Owner;
import carsandowners.Main;
import carsandowners.menu.Menu;

import java.util.Scanner;

public class Logic {

    OwnerValidator isValidOwner = new OwnerValidator();
    CarValidator isValidCar = new CarValidator();
    Scanner sc = new Scanner(System.in);
    final String delimiter = "------------------------------\n";

    public void addOwner(){
        System.out.println(delimiter + "Введите Имя:");
        String ownerName = isValidOwner.validOwner(sc.next());
        System.out.println(delimiter + "Введите Фамилию:");
        String ownerSurname = isValidOwner.validOwner(sc.next());

        System.out.println(delimiter + "Добавить автовладельца " + ownerSurname + " " + ownerName + "? Y/N или Д/Н");
        if(isValidOwner.allValid(sc.next()).equals("yes")){
            Owner newOwner = new Owner();
            newOwner.setOwnerId(Main.countIdOwner++);
            newOwner.setOwnerName(ownerName);
            newOwner.setOwnerSurname(ownerSurname);
            if(!Main.ownerList.equals(newOwner)){
                Main.ownerList.add(newOwner);
            } else {
                System.out.println(delimiter + "Данный автовладелец уже внесен в базу!" + delimiter);
                addOwner();
            }
            System.out.println(delimiter + "Автовладелец " + ownerSurname + " " + ownerName + " сохранён!" + delimiter);
        } else if(isValidOwner.allValid(sc.next()).equals("no")){
            Menu again = new Menu();
            try{
                again.newMenu();
            } catch(Exception e){
                e.printStackTrace();
                System.out.println(delimiter + "Произошел сбой в программе!" + delimiter);
            }
        } else {
            System.out.println(delimiter + "Произошёл сбой в программе!" + delimiter);
            addOwner();
        }
        }

    public void addCar(){
        System.out.println(delimiter + "Введите id владельца автомобиля:");
        int ownerId = sc.nextInt();
        System.out.println(delimiter + "Введите производителя автомобиля:");
        String vendorName = isValidCar.validCarVendor(sc.next());
        System.out.println("Введите модель автомобиля: " + delimiter);
        String modelName = isValidCar.validCarModel(sc.next());
        System.out.println(delimiter + "Где оформлен автомобиль?\nrus - Россия\neu - Европа\nusa - США\nother - Другие");
        String regNumber = isValidCar.validRegNumber(sc.next());

        System.out.println("Добавить автомобиль " + vendorName + " " + modelName + " " + regNumber + " для пользователя с id " + ownerId + "? Y/N или Д/Н");
        if(isValidOwner.allValid(sc.next()).equals("yes")){
            Car newCar = new Car();
            newCar.setCarId(Main.countIdCar++);
            newCar.setOwnerId(ownerId);
            newCar.setVendorName(vendorName);
            newCar.setModelName(modelName);
            newCar.setRegNumber(regNumber);
            if(!Main.carList.equals(newCar)){
                Main.carList.add(newCar);
            } else {
                System.out.println(delimiter + "Данный автомобиль уже внесен в базу!" + delimiter);
                addCar();
            }
            System.out.println(delimiter + "Автомобиль " + vendorName + " " + modelName + " " + regNumber + " сохранён для пользователя с id " + ownerId + "!");
        } else if(isValidOwner.allValid(sc.next()).equals("no")){
            Menu again = new Menu();
            try{
                again.newMenu();
            } catch(Exception e){
                e.printStackTrace();
                System.out.println(delimiter + "Произошел сбой в программе!" + delimiter);
            }
        } else {
            System.out.println(delimiter + "Произошёл сбой в программе!" + delimiter);
            addCar();
        }
    }
}
