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