package Demo1.factory;

import Demo1.buttons.Button;
import Demo1.buttons.WindowsButton;

public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
