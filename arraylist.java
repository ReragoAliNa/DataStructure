package DataStructure;

import java.util.ArrayList;
import java.util.Collections;

public class arraylist {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("BWM");
        cars.add("Volvo");
        cars.add("Mazda");
        cars.add("Ford");
        cars.add( "Tanking");

        cars.add(0, "XiaoMi");
        cars.add(1, "Tesla" );
        
        cars.add( "Tank");

        cars.set(0, "Mi");

        // cars.remove(0);
        cars.add(0, "start");
        cars.add(8, "end");
        // Collections.swap(cars, 8, 9);
        System.out.println(cars);
        int index1 = 8;
        int index2 = 9;
        String temp = cars.get(index1);
        cars.set(index1, cars.get(index2));
        cars.set(index2, temp);
        
        System.out.println(cars.get(2));
        System.out.println(cars.size());
        System.out.println(cars);
        Collections.sort(cars);
        System.out.println(cars);
        
        for (String car : cars) {
            System.out.println(car);
        }
    }
}