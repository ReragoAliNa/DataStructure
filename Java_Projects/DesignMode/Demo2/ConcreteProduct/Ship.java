package Demo2.ConcreteProduct;
import Demo2.Product.*;

public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("轮船运输：在海运路线上送货");
    }
}