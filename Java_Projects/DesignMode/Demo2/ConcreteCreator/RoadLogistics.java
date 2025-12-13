package Demo2.ConcreteCreator;
import Demo2.Creator.*;
import Demo2.Product.*;
import Demo2.ConcreteProduct.*;

public class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
