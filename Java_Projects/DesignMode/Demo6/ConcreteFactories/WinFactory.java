package Demo6.ConcreteFactories;

import Demo6.AbstractFactory.GUIFactory;
import Demo6.AbstractProducts.Button;
import Demo6.AbstractProducts.Checkbox;
import Demo6.ConcreteProducts.Buttons.WinButton;
import Demo6.ConcreteProducts.Checkbox.WinCheckbox;

public class WinFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
    
}
