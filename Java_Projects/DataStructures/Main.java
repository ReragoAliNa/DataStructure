package DataStructure;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        var cars = new ArrayList<String>();
        
        cars.add("Volvo");
        cars.add("BWM");
        cars.add("Ford");
        cars.add("Mazda");

        Collections.sort(cars, Collections.reverseOrder());
        
        for (String car: cars) {
            System.out.println(car);
        }
    }
}