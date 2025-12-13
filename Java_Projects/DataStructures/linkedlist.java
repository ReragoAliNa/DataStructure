package DataStructure;

import java.util.LinkedList;
import java.util.Collections;

public class linkedlist {
    public static void main(String[] args) {
        LinkedList<String> cars = new LinkedList<String>();
        cars.add("Volvo");
        cars.add("BWM");
        cars.add("Ford");
        cars.add("Mazda");
        System.out.println(cars);
        for(String car : cars) {
            System.out.println(car);
        }
    } 
}
