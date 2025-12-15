package Demo1.factory;

import Demo1.buttons.Button;
import Demo1.buttons.HtmlButton;

public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
