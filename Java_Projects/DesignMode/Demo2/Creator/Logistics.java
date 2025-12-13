package Demo2.Creator;
import Demo2.Product.*;

public abstract class Logistics {
    public abstract Transport createTransport();

    public void planDelivery() {
        Transport transport = createTransport();

        System.out.println("物流中心：准备发货");
        transport.deliver();
    }
}