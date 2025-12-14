package Demo6.AbstractFactory;

import Demo6.AbstractProducts.Button;
import Demo6.AbstractProducts.Checkbox;


public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();    
}
