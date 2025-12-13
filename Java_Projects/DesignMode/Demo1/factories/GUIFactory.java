package factories;
import checkboxes.Checkbox;
import buttons.Button;


public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
