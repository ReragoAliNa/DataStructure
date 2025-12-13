package Demo2.Client;
import Demo2.ConcreteCreator.*;
import Demo2.Creator.*;


public class Client {
    public static void main(String[] args) {
        Logistics roadLogistics = new RoadLogistics();
        roadLogistics.planDelivery();
        System.out.println("-------------");

        Logistics seaLogistics = new SeaLogistics();
        seaLogistics.planDelivery();
    }
}
