package DataStructure;

import java.util.HashMap;

public class hashmap {
    public static void main(String[] args) {
        HashMap<String, String> capitalCities = new HashMap<String, String>();

        capitalCities.put("England", "London"); 
        capitalCities.put("Germany", "Berlin"); 
        capitalCities.put("Norway", "Oslo"); 
        capitalCities.put("USA", "Wahsington DC"); 
    
        System.out.println(capitalCities);
    }
}
