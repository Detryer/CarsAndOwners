package carsandowners;

import carsandowners.domain.Car;
import carsandowners.domain.Owner;
import carsandowners.menu.Menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Owner> ownerList = new ArrayList<Owner>();
    public static List<Car> carList = new ArrayList<Car>();
    public static Integer countIdOwner = 0;
    public static Integer countIdCar = 0;

    public static void main(String[] args) throws IOException{
        Menu menu = new Menu();
        menu.newMenu();
    }

}
