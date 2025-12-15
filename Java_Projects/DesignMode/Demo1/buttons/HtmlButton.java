package Demo1.buttons;

public class HtmlButton implements Button {
    public void render() {
        System.out.println("<button>Html Button</button>");
        onClick();
    }

    public void onClick() {
        System.out.println("Click! Button says - 'Hello World!'");
    }
    
}