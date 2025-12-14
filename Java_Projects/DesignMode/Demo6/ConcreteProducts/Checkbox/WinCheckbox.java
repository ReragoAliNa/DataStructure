package Demo6.ConcreteProducts.Checkbox;

import Demo6.AbstractProducts.Checkbox;

public class WinCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Create a WinCheckbox.");
    }
    
}
