package Demo6.ConcreteProducts.Buttons;

import Demo6.AbstractProducts.Button;

public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Made a MacButton.");
    }
}
