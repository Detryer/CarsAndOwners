package carsandowners.logic;

//import carsandowners.Main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarValidator {

    Scanner sc = new Scanner(System.in);
    public final String notValid = "Неверный формат ";
    public final String notEmpty = " не может быть пустым!";

//    public int validOwnerId(int input){
//        if(Main.ownerList.contains(input)){
//            return input;
//        } else {
//            System.out.println("Такого владельца не существует!");
//            validOwnerId(sc.nextInt());
//        }
//        return input;
//    }

    public String validCarVendor(String input) {
        if (!input.isEmpty()) {
            Pattern p = Pattern.compile("^[А-ЯA-Zа-яa-z]*\\s?-?[А-ЯA-Zа-яa-z]*");
            Matcher m = p.matcher(input);
            if (m.matches()) {
                input = (input.substring(0,1)).toUpperCase() + input.substring(1);
            } else {
                System.out.println(notValid + " названия модели автомобиля!");
                input = validCarVendor(sc.next());
            }
        } else {
            System.out.println("Поле производитель авто" + notEmpty);
            input = validCarVendor(sc.next());
        }
        return input;
    }

    public String validCarModel(String input) {
        if (!input.isEmpty()) {
            Pattern p = Pattern.compile("^[А-ЯA-Zа-яa-z0-9]*");
            Matcher m = p.matcher(input);
            if (m.matches()) {
                input = (input.substring(0,1)).toUpperCase() + input.substring(1);
            } else {
                System.out.println(notValid + " названия модели автомобиля!");
            }
        } else {
            System.out.println("Поле модель авто" + notEmpty);
        }
        return input;
    }

    public String validRegNumber(String input) {
        if (!input.isEmpty()) {
            switch (input) {
                case "rus":
                    input = input.toUpperCase();
                    System.out.println("Введите номер региона:");
                    String region = sc.next();
                    Pattern rusRegionP = Pattern.compile("^[1-9][0-9]?[0-9]?");
                    Matcher rusRegionM = rusRegionP.matcher(region);
                    if(rusRegionM.matches()) {
                        input = region + " " + input;
                    } else {
                        System.out.println("Введен неверный регион!");
                        input = validRegNumber(sc.next());
                    }
                    System.out.println("Введите регистрационный номер:");
                    String regNumberRus = sc.next();
                    Pattern rusNumberP = Pattern.compile("^[АВЕКМНОРСТУХавекмнорстух][0-9][0-9][0-9][АВЕКМНОРСТУХавекмнорстух][АВЕКМНОРСТУХавекмнорстух]");
                    Matcher rusNumberM = rusNumberP.matcher(regNumberRus);
                    if(rusNumberM.matches()) {
                        input = regNumberRus.toUpperCase() + " " + input;
                    } else {
                        System.out.println("Введен неверный регистрационный номер!");
                        input = validRegNumber(sc.next());
                    }
                    break;
                case "eu":
                    input = input.toUpperCase();
                    System.out.println("Какая именно страна ЕС?");
                    String country = sc.next();
                    Pattern euCountryP = Pattern.compile("^[A-Za-z][A-Za-z]?[A-Za-z]?");
                    Matcher euCountryM = euCountryP.matcher(country);
                    if(euCountryM.matches()){
                        input = country.toUpperCase() + " " + input;
                    } else {
                        System.out.println("Введено неправильное название страны!");
                        input = validRegNumber(sc.next());
                    }
                    System.out.println("Введите регистрационный номер:");
                    String regNumberEu = sc.next();
                    Pattern euNumberP = Pattern.compile("^[A-Za-z0-9]*\\S");
                    Matcher euNumberM = euNumberP.matcher(regNumberEu);
                    if(euNumberM.matches()) {
                        input = regNumberEu.toUpperCase() + " " + input;
                    } else {
                        System.out.println("Введен неверный регистрационный номер!");
                        input = validRegNumber(sc.next());
                    }
                    break;
                case "usa":
                    input = input.toUpperCase();
                    System.out.println("Введите регистрационный номер:");
                    String regNumberUsa = sc.next();
                    Pattern usaNumberP = Pattern.compile("^[A-Za-z0-9]*\\S");
                    Matcher usaNumberM = usaNumberP.matcher(regNumberUsa);
                    if(usaNumberM.matches()) {
                        input = regNumberUsa.toUpperCase() + " " + input;
                    } else {
                        System.out.println("Введен неверный регистрационный номер!");
                        input = validRegNumber(sc.next());
                    }
                    break;
                case "other":
                    System.out.println("Введите название страны:");
                    input = sc.next().toUpperCase();
                    System.out.println("Введите регистрационный номер:");
                    String regNumberOther = sc.next();
                    Pattern otherNumberP = Pattern.compile("^[A-Za-z0-9А-Яа-я]*\\S");
                    Matcher otherNumberM = otherNumberP.matcher(regNumberOther);
                    if(otherNumberM.matches()) {
                        input = regNumberOther.toUpperCase() + " " + input;
                    } else {
                        System.out.println("Введен неверный регистрационный номер!");
                        input = validRegNumber(sc.next());
                    }
                    break;
                default:
                    System.out.println("Вы ввели неверный код страны!");
                    input = validRegNumber(sc.next());
                    break;
            }
        } else {
            System.out.println("Поле регистрационный номер" + notEmpty);
            input = validRegNumber(sc.next());
        }
        return input;
    }
}
