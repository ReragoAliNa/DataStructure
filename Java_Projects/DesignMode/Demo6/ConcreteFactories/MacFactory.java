package Demo6.ConcreteFactories;

import Demo6.AbstractFactory.GUIFactory;
// import Demo6.AbstractProducts.*;
import Demo6.AbstractProducts.Button;
import Demo6.AbstractProducts.Checkbox;
import Demo6.ConcreteProducts.Buttons.MacButton;
import Demo6.ConcreteProducts.Checkbox.MacCheckbox;

public class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
