package Demo6;

import Demo6.AbstractFactory.GUIFactory;
import Demo6.ConcreteFactories.MacFactory;
import Demo6.ConcreteFactories.WinFactory;

public class Config {
    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacFactory();
        } else {
            factory = new WinFactory();
        }
        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
    
}
