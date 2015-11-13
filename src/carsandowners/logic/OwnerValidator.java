package carsandowners.logic;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OwnerValidator {

    Scanner sc = new Scanner(System.in);
    public final String notValid = "Неверный формат ";
    public final String notEmpty = " не может быть пустым!";

    public String validOwner(String input){
        if(!input.isEmpty()){
            Pattern p = Pattern.compile("^[А-Яа-я]*");
            Matcher m = p.matcher(input);
            if (m.matches()) {
                input = (input.substring(0,1)).toUpperCase() + input.substring(1);
            } else {
                System.out.println(notValid + "имени/фамилии владельца!");
                input = validOwner(sc.next());
            }
        } else {
            System.out.println("Поле имя/фамилия владельца" + notEmpty);
            input = validOwner(sc.next());
        }
        return input;
        }

    public String allValid(String input){
        switch(input) {
            case "Д":
            case "д":
            case "Y":
            case "y":
                input = "yes";
                break;
            case "Н":
            case "н":
            case "N":
            case "n":
                input = "no";
                break;
            default:
                System.out.println("Вы ввели неподходящий символ!");
                input = allValid(sc.next());
                break;
        }
        return input;
        }
    }
