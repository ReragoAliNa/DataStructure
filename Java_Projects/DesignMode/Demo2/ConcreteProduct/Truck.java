package Demo2.ConcreteProduct;
import Demo2.Product.*;

public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("卡车运输：在公路上送货");
    }
}
