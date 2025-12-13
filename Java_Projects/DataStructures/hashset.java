package DataStructure;

import java.util.HashSet;

public class hashset{
    public static void main(String[] args){
        HashSet<String> cars = new HashSet<String>();
        cars.add("Volvo");
        cars.add ("BWM");
        cars.add("Ford");
        cars.add("BWM");
        cars.add("Mazda");
        System.out.println(cars);
    }
}