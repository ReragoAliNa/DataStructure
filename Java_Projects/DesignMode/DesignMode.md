# Java常用设计模式
## 创建型模式
### Abstract Factory
**Abstract Factory** 能创建一系列相关的对象，而无需指定其具体类。
```Java
\*
Problem: 开发一款家具模拟器。
1. 一系列相关产品：Chair、Sofa和CoffeeTable
2. 系列产品的不同变体：Morden、Victorian和ArtDeco等
你需要设法单独生成每件家具对象，这样才能确保其风格一致。如果顾客收到的家具风格不一样，他们可不会开心。
此外，你也不希望在添加新产品或新风格时修改已有代码。家具供应商对于产品目录的更新非常频繁，你不会想在每次更新时都去修改核心代码的。
*\

\*
Solution:
首先，抽象工厂模式建议为系列中的每件产品明确声明接口（例如Chair、Sofa或CoffeeTable）。然后，确保所有产品变体都继承这些接口。例如，所有风格的椅子都实现Chair接口；所有风格的咖啡桌都实现CoffeeTable接口，以此类推。

接下来，我们需要声明Abstract Factory——包含系列中所有产品构造方法的接口。例如createChair、createSofa和createCoffeeTable。这些方法必须返回抽象产品类型，
即我们之前抽取的那些接口：Chair、Sofa和CoffeeTable。

那我们应该如何处理产品变体呢？对于系列产品的每个变体，我们都将基于Abstract Factory接口创建不同的工厂类。每个工厂类都只能返回特定类别的产品，例如，ModernFurnitureFactory只能创建ModernChair、ModernSofa和ModernCoffeeTable对象。

客户端代码可以通过相应的抽象接口调用工厂和产品类。你无需修改实际客户端代码，就能更改传递给客户端的工厂类，也能更改客户端代码接收的产品变体。

假设客户端想要工厂创建一把椅子。客户端无需了解工厂类，也不用管工厂类创建出的椅子类型。无论是现代风格，还是Vectorian风格的椅子，对于客户端来说没有分别，它只需调用抽象Chair接口就行。这样一来，客户端只需要知道椅子以某种方式实现了sitDown方法就足够了。此外无论工厂返回的是何种椅子变体，它都会由同一工厂对象创建的沙发或咖啡桌风格一致。

最后一点说明：如果客户端仅接触抽象接口，那么谁来创建实际的工厂对象呢？一般情况下，应用程序会在初始化阶段创建具体工厂对象。而在此之前，应用程序必须根据配置文件或环境设定选择工厂类别。

1. Abstract Product：为构成系列产品的一组不同但相关的产品接口声明
2. Concrete Product：是抽象产品的多种不同类型实现。所有变体（Vectorian/Modern）都必须实现相应的抽象产品（椅子/沙发）
3. Abstract Factory： 接口声明了一组创建各种抽象产品的方法
4. Concrete Factory：实现抽象工厂的构建方法。每个具体工厂都对应特定产品变体，且仅创建此种产品变体
5. 尽管具体工厂会对具体产品进行初始化，其构建方法签名必须返回相应的抽象产品。这样，使用工厂类的客户端代码就不会与工厂创建的特定产品变体耦合。客户端只需要通过抽象接口调用工厂和产品对象，就能与任何具体工厂/产品变体交互
*\

// Abstract Products
public interface Chair {
    public void sitdown();
}

public interface Sofa {
    public void sitdown();
}

public interface CoffeeTable {
    public void putCoffeeOn();
}

// Abstract Factory
public interface Factory {
    public Chair createChair();
    public Sofa createSofa();
    public CoffeeTable createCoffeeTable();
}

// Concrete Products
public class VictorianChair implements Chair {
    public void sitdown() {
        System.out.println("You can sit down on the VictorianChair.");
    }
}

public class VictorianSofa implements Sofa {
    public void sitdown() {
        System.out.println("You can sit down on the VictorianSofa.");
    }
}

public class VictorianCoffeeTable implements CoffeeTable {
    public void putCoffeeOn() {
        System.out.println("You can put a cup of coffee on the VictorianCoffeeTable.");
    }
}


public class ModernChair implements Chair {
    public void sitdown() {
        System.out.println("You can sit down on the ModernChair.");
    }
}

public class ModernSofa implements Sofa {
    public void sitdown() {
        System.out.println("You can sit down on the ModernSofa.");
    }
}

public class ModernCoffeeTable  implements CoffeeTable {
    public void putCoffeeOn() {
        System.out.println("You can put a cup of coffee on the ModernCoffeeTable.");
    }
}

public class ArtDecoChair implements Chair {
    public void sitdown() {
        System.out.println("You can sit down on the ArtDecoChair.");
    }
}

public class ArtDecoSofa implements Sofa {
    public void sitdown() {
        System.out.println("You can sit down on the ArtDecoSofa.");
    }
}

public class ArtDecoCoffeeTable  implements CoffeeTable {
    public void putCoffeeOn() {
        System.out.println("You can put a cup of coffee on the ArtDecoCoffeeTable.");
    }
}

// Concrete Factories
public class VictorianFactory implements Factory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new VictorianCoffeeTable();
    }
}

public class ModernFactory implements Factory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ModernCoffeeTable();
    }
}

public class ArtDecoFactory implements Factory {
    @Override
    public Chair createChair() {
        return new ArtDecoChair();
    }

    @Override
    public Sofa createSofa() {
        return new ArtDecoSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ArtDecoCoffeeTable();
    }
}

// Client
public Client {
    private Chair chair;
    private Sofa sofa;
    private CoffeeTable table;

    public Client(Factory factory) {
        chair = factory.createChair();
        sofa = factory.createSofa();
        table = factory.createCoffeeTable();
    }

    public void useFurniture() {
        chair.sitdown();
        sofa.sitdown();
        table.putCoffeeOn();
    }

    public static void main(String[] args) {
        Factory factory = new ArtDecoFactory();

        Client app = new Client(factory);
        app.useFurniture();
    }
}

```
### Builder
### Factory Method
**Factory Method** 在父类中提供一个创建对象的方法，允许子类决定实例化对象的类型
**Solution：** 开发一款物流管理应用。最初版本只能处理卡车运输，因此大部分代码都在位于名为`卡车`的类中。

一段时间后，这款应用变得极受欢迎。你每天都能收到十几次来自海运公司的请求，希望应用能够支持海上物流功能。

但是代码问题该如何处理呢？目前，大部分代码都与`卡车`类相关。在程序中添加`轮船`类需要修改全部代码。更糟糕的是，如果你以后需要在程序中支持另一种运输方式，很可能需要再次对这些代码进行大幅修改。

最后，你将不得不编写繁复的代码，根据不同的运输对象类，在应用中进行不同的处理。

**Problem：** Factory Method 建议使用特殊的工厂方法代替对于对象构造函数的直接调用（即使用`new`运算符，只是该运算符改在工厂方法中调用罢了。工厂方法返回的对象称作“产品”。

乍看之下，这种更改可能毫无意义：我们只是改变了程序中调用构造函数的位置而已。但是，仔细想一下，现在你可以在子类中重写工厂方法，从而改变其创建产品的类型。

但是有一点需要注意：仅当这些产品具有共同的基类或者接口时，子类才能返回不同类型的产品，同时基类中的工厂方法还应将其返回类型声明为这一共有接口。

举例来说，`卡车`和`轮船`类都必须实现`运输`接口，该接口声明了一个名为`deliver`的方法。每个类都将以不同的方式实现该方法：卡车走陆路交付货物，轮船走海路交付货物。`陆路运输`类中的工厂方法返回卡车对象，而`海路运输`类则返回轮船对象。

调用工厂方法的代码（客户端代码）无需了解子类返回实际对象之间的差别。客户端将所有产品视为抽象的`运输`。客户端知道所有运输对象都提供`交付`方法，但是并不关心其具体实现方式。

#### Factory Method 模式结构
1. Product
2. Concrete Product
3. Creator
4. Concrete Creators

- **当你在编写代码的过程中，如果无法预知对象确切类别及其依赖关系时，可使用Factory Method**
工厂方法将创建产品的代码与实际使用产品的代码分离，从而能在不影响其他代码的情况下扩展产品创建部分代码。
例如，如果需要向应用中添加一种新产品，你只需要开发新的创建者子类，然后重写其工厂方法即可。

- **如果你希望用户能扩展你软件库或框架的内部组件，可使用Factory Method**
继承可能是扩展软件库或框架默认行为的最简单方法。但是当你使用子类替代标准组件时，框架如何辨识出该子类？

解决方案时将各框架中构造组件的代码集中到单个工厂方法中，并继承该组件之外允许任何人对该方法进行重写。

具体实现：假设你使用开源UI框架编写自己的应用。你希望在应用中使用圆形按钮，但是原框架仅支持矩形按钮。你可以使用`圆形按钮`子类来继承标准的`按钮`类。但是，你需要告诉`UI框架`类使用新的子类按钮代替默认按钮。

为了实现这个功能，你可以根据基础框架类开发子类`圆形按钮UI`，并且重写其`createButton`方法。基类中的该方法返回`按钮`对象，而你开发的子类返回`圆形按钮`对象。现在，你就可以使用`圆形按钮UI`类代替`UI框架`类。
- **如果你希望复用现有对象来节省系统资源，而不是每次都重新创建对象，可使用Factory Method**
在处理大型资源密集型对象（比如数据库、文件系统和网络资源）时，你会经常碰到这种资源需求。
让我们思考复用现有对象的方法：
1. 首先，你需要创建存储空间来存放所有已经创建的对象。
2. 当他人请求一个对象时，程序将在对象池中搜索可用对象。
3. ...然后将其返回给客户端代码。
4. 如果没有可用对象，程序则创建一个新对象（并将其添加到对象池中）。
这些代码可不少，而且它们必须位于同一处，这样才能确保重复代码不会污染程序。

可能最显而易见，也是最方便的方式，就是将这些代码放置在我们视图重用的对象类的构造函数中。但是从定义上来讲，构造函数始终返回的是**新对象**，其无法返回现有实例。

因此，你需要有一个既能创建新对象，又可以重用现有对象的普通方法。

#### 实现方式
1. 让所有产品都遵循同一接口。该接口必须声明对所有产品都有意义的方法。
2. 在创建类中添加一个空的工厂方法。该方法的返回类型必须遵循通用的产品接口。
3. 在创建者代码中找到对于产品构造函数的引用。将它们依次替换为对工厂方法的调用，同时将创建产品的代码移入工厂方法。

你可能需要在工厂方法中添加临时参数来控制返回的产品类型。

工厂方法的代码看上去非常糟糕。其中可能会有复杂的`switch`运算符，用于选择各种需要实例化的产品类。但是不要担心，我们很快就会修复这个问题。

4. 现在，为工厂方法中的每种产品编写一个创建者子类，然后在子类中重写工厂方法，并将基本方法中的相关创建代码移动到工厂方法中。
5. 如果应用中的产品类型太多，那么为每个产品创建子类并无太大必要，这时你也可以在子类中复用基类中的控制参数。
6. 如果代码经过上述移动后，基础工厂方法中已经没有任何代码，你可以将其转变为抽象类。如果基础工厂方法中还有其他语句，你可以将其设置为该方法的默认行为。
```Java
// 使用工厂方法开发跨平台UI组件，同时避免客户代码与具体UI类之间的耦合
public interface Button {
    void render();
    void onClick();
}

public class HtmlButton implements Button {
    public void render() {
        System.out.println("<button>Test Button</button>");
        onClick();
    }

    public void onClick() {
        System.out.println("Click! Button says - 'Hello World!' ");
    }
}

public class WindowsButton implements Button {
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    JButton button;

    public void render() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Hello World!");
        label.setOpaque(true);
        label.setBackground(new Color(235,233,126));
        label.setFont(new Font("Dialog", Font.BOLD, 44));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.getContentPane().add(panel);
        panel.add(label);
        onClick();
        panel.add(button);

        frame.setSize(320, 200);
        frame.setVisible(true);
        onClick();
    }

    public void onClick() {
        button = new JButton("Exit");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Sysetem.exit(0);
            }
        });
    }
}

public abstract class Dialog {
    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
    }

    public abstract Button createButton();
}

public class HtmlDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}

public class WindowsDialog extend Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

public class Demo {
    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    static void configure() {
        if (System.getProperty(os.name).equals("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    static void runBusinessLogic() {
        dialog.renderWindow();
    }
}
```
#### Factory Method 比较
**1. 工厂**
可以创建一些东西的函数、方法或类。
创建的是对象、文件和数据库记录等东西。

e.g.（工厂）
- 创建程序GUI的函数或方法
- 创建用户的类
- 以特定方式调用类构造函数的静态方法
- 一种创建型设计模式

**2. 构建方法**
创建对象的方法
构造函数调用的封装器
```java
class Number {
    private $value;

    public function __construct($value) {
        $this->value = $value;
    }

    public function next() {
        return new Number ($thi->value + 1);
    }
}
```
### Prototype

### Singleton
## 结构型模式
### Adapter
### Bridge
### Composite
### Decorator
### Facade

### Flywight

### Proxy

## 行为模式
### Chain of Responsibility

### Command

### Iterator 

### Mediator

### Memento

### Observer

### State

### Strategy

### Template Method

### Visitor