package Demo5;

interface Drink {
    double cost();
    String info();
}

class MilkTea implements Drink {
    public double cost() { return 10.0; }
    public String info() { return "原味奶茶"; }
}

abstract class Decorator implements Drink {
    protected Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }
}

class Pear1Decorator extends Decorator {
    public Pear1Decorator (Drink drink) { super(drink); }

    public double cost() {
        return super.drink.cost() + 2.0;
    }

    public String info() {
        return super.drink.info() + " + 珍珠";
    }
}

class PuddingDecorator extends Decorator {
    public PuddingDecorator(Drink drink) { super(drink); }

    public double cost() {
        return super.drink.cost() + 3.0;
    }

    public String info() {
        return super.drink.info() + " + 布丁";
    }
}

class Client {
    public static void main(String[] args) {
        Drink order = new MilkTea();

        order = new Pear1Decorator(order);

        order = new PuddingDecorator(order);

        System.out.println("账单：" + order.info());
        System.out.println("总价：" + order.cost());
    }
}
